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
    private static d eWZ = null;
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
    private Object eXa = new Object();
    private Map<String, a> eXb = null;
    private a eXc = null;
    private boolean eXd = false;

    public static final d bcV() {
        if (eWZ == null) {
            synchronized (d.class) {
                if (eWZ == null) {
                    eWZ = new d();
                }
            }
        }
        return eWZ;
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
        if (!this.eXd) {
            c.bcR().a(new j<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.j
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bcI().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eXa) {
                                if (d.this.eXb == null) {
                                    d.this.eXb = new ConcurrentHashMap();
                                }
                                d.this.eXb.clear();
                                d.this.eXb.putAll(hashMap);
                            }
                            d.this.eXd = true;
                            d.this.bcX();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eXb.entrySet()) {
                                if (d.this.eXc != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eWN > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bcH().U("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eXb.remove(aVar.name);
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

    public void bcW() {
        bcX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcX() {
        if (this.eXd) {
            String bcQ = a.bcQ();
            if (!TextUtils.isEmpty(bcQ)) {
                if (!this.eXb.containsKey(bcQ)) {
                    e.bcI().iZ(false);
                    return;
                }
                this.eXc = this.eXb.get(bcQ);
                if (this.eXc == null) {
                    e.bcI().iZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eXc.eWO > BdKVCache.MILLS_1Hour && currentTimeMillis - this.eXc.eWN < BdKVCache.MILLS_1Hour) {
                    e.bcI().iZ(false);
                }
            }
        }
    }

    public float cz(String str, String str2) {
        if (!this.eXd || this.eXc == null) {
            return 0.0f;
        }
        b bVar = this.eXc.eWL.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eWP;
    }

    public float cA(String str, String str2) {
        if (!this.eXd || this.eXc == null) {
            return 10000.0f;
        }
        b bVar = this.eXc.eWM.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eWP;
    }

    public void ad(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.eXd && !TextUtils.isEmpty(str)) {
            e.bcI().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eXc != null) {
                        b bVar = d.this.eXc.eWL.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eXc.eWL.put(str, bVar);
                        }
                        bVar.ph(z ? 1 : 0);
                        synchronized (d.this.eXa) {
                            hashMap = new HashMap(d.this.eXb);
                        }
                        c.bcR().u(hashMap);
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
        if (this.eXd && !TextUtils.isEmpty(str)) {
            e.bcI().m(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eXc == null) {
                        String bcQ = a.bcQ();
                        if (!TextUtils.isEmpty(bcQ)) {
                            a aVar = new a();
                            aVar.name = bcQ;
                            d.this.eXc = aVar;
                            d.this.eXb.put(bcQ, aVar);
                        }
                    }
                    if (d.this.eXc != null) {
                        b bVar = d.this.eXc.eWL.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eXc.eWL.put(str, bVar);
                        }
                        bVar.ph(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eXc.eWM.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eXc.eWM.put(str, bVar2);
                            }
                            bVar2.ph(i);
                        }
                        synchronized (d.this.eXa) {
                            hashMap = new HashMap(d.this.eXb);
                        }
                        c.bcR().u(hashMap);
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
