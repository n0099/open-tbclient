package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.j;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {
    private static d eXQ = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TableDefine.UserInfoColumns.COLUMN_IP);
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.i(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object eXR = new Object();
    private Map<String, a> eXS = null;
    private a eXT = null;
    private boolean eXU = false;

    public static final d bcX() {
        if (eXQ == null) {
            synchronized (d.class) {
                if (eXQ == null) {
                    eXQ = new d();
                }
            }
        }
        return eXQ;
    }

    private d() {
    }

    public void open() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (!this.eXU) {
            c.bcT().a(new j<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bcK().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap hashMap = new HashMap();
                            if (writeHistroyDataReqIdl != null) {
                                for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                                    a a = a.a(connectPointData);
                                    if (a != null) {
                                        hashMap.put(a.name, a);
                                    }
                                }
                            }
                            synchronized (d.this.eXR) {
                                if (d.this.eXS == null) {
                                    d.this.eXS = new ConcurrentHashMap();
                                }
                                d.this.eXS.clear();
                                d.this.eXS.putAll(hashMap);
                            }
                            d.this.eXU = true;
                            d.this.bcZ();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eXS.entrySet()) {
                                if (d.this.eXT != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eXE > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bcJ().U("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eXS.remove(aVar.name);
                            }
                        }
                    });
                }
            });
        }
    }

    public void close() {
        TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
    }

    public void bcY() {
        bcZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcZ() {
        if (this.eXU) {
            String bcS = a.bcS();
            if (!TextUtils.isEmpty(bcS)) {
                if (!this.eXS.containsKey(bcS)) {
                    e.bcK().iZ(false);
                    return;
                }
                this.eXT = this.eXS.get(bcS);
                if (this.eXT == null) {
                    e.bcK().iZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eXT.eXF > BdKVCache.MILLS_1Hour && currentTimeMillis - this.eXT.eXE < BdKVCache.MILLS_1Hour) {
                    e.bcK().iZ(false);
                }
            }
        }
    }

    public float cz(String str, String str2) {
        if (!this.eXU || this.eXT == null) {
            return 0.0f;
        }
        b bVar = this.eXT.eXC.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eXG;
    }

    public float cA(String str, String str2) {
        if (!this.eXU || this.eXT == null) {
            return 10000.0f;
        }
        b bVar = this.eXT.eXD.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eXG;
    }

    public void ad(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.eXU && !TextUtils.isEmpty(str)) {
            e.bcK().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eXT != null) {
                        b bVar = d.this.eXT.eXC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eXT.eXC.put(str, bVar);
                        }
                        bVar.pi(z ? 1 : 0);
                        synchronized (d.this.eXR) {
                            hashMap = new HashMap(d.this.eXS);
                        }
                        c.bcT().u(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }

    public void b(String str, int i, boolean z) {
        a(str, i, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i, final boolean z, final boolean z2) {
        if (this.eXU && !TextUtils.isEmpty(str)) {
            e.bcK().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eXT == null) {
                        String bcS = a.bcS();
                        if (!TextUtils.isEmpty(bcS)) {
                            a aVar = new a();
                            aVar.name = bcS;
                            d.this.eXT = aVar;
                            d.this.eXS.put(bcS, aVar);
                        }
                    }
                    if (d.this.eXT != null) {
                        b bVar = d.this.eXT.eXC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eXT.eXC.put(str, bVar);
                        }
                        bVar.pi(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eXT.eXD.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eXT.eXD.put(str, bVar2);
                            }
                            bVar2.pi(i);
                        }
                        synchronized (d.this.eXR) {
                            hashMap = new HashMap(d.this.eXS);
                        }
                        c.bcT().u(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        intent.putExtra("speed", i);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }
}
