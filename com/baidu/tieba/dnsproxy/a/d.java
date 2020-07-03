package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.f.f;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class d {
    private static d gYQ = null;
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
    private Object gYR = new Object();
    private Map<String, a> gYS = null;
    private a gYT = null;
    private boolean gYU = false;

    public static final d bQr() {
        if (gYQ == null) {
            synchronized (d.class) {
                if (gYQ == null) {
                    gYQ = new d();
                }
            }
        }
        return gYQ;
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
        if (!this.gYU) {
            c.bQn().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bQe().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.gYR) {
                                if (d.this.gYS == null) {
                                    d.this.gYS = new ConcurrentHashMap();
                                }
                                d.this.gYS.clear();
                                d.this.gYS.putAll(hashMap);
                            }
                            d.this.gYU = true;
                            d.this.bQt();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.gYS.entrySet()) {
                                if (d.this.gYT != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).gYE > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bQd().an("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.gYS.remove(aVar.name);
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

    public void bQs() {
        bQt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQt() {
        if (this.gYU) {
            String bQm = a.bQm();
            if (!TextUtils.isEmpty(bQm)) {
                if (!this.gYS.containsKey(bQm)) {
                    e.bQe().mn(false);
                    return;
                }
                this.gYT = this.gYS.get(bQm);
                if (this.gYT == null) {
                    e.bQe().mn(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gYT.gYF > BdKVCache.MILLS_1Hour && currentTimeMillis - this.gYT.gYE < BdKVCache.MILLS_1Hour) {
                    e.bQe().mn(false);
                }
            }
        }
    }

    public float dX(String str, String str2) {
        if (!this.gYU || this.gYT == null) {
            return 0.0f;
        }
        b bVar = this.gYT.gYC.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.gYG;
    }

    public float dY(String str, String str2) {
        if (!this.gYU || this.gYT == null) {
            return 10000.0f;
        }
        b bVar = this.gYT.gYD.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.gYG;
    }

    public void aC(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.gYU && !TextUtils.isEmpty(str)) {
            e.bQe().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gYT != null) {
                        b bVar = d.this.gYT.gYC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gYT.gYC.put(str, bVar);
                        }
                        bVar.tb(z ? 1 : 0);
                        synchronized (d.this.gYR) {
                            hashMap = new HashMap(d.this.gYS);
                        }
                        c.bQn().t(hashMap);
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

    public void c(String str, int i, boolean z) {
        a(str, i, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final String str, final int i, final boolean z, final boolean z2) {
        if (this.gYU && !TextUtils.isEmpty(str)) {
            e.bQe().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gYT == null) {
                        String bQm = a.bQm();
                        if (!TextUtils.isEmpty(bQm)) {
                            a aVar = new a();
                            aVar.name = bQm;
                            d.this.gYT = aVar;
                            d.this.gYS.put(bQm, aVar);
                        }
                    }
                    if (d.this.gYT != null) {
                        b bVar = d.this.gYT.gYC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gYT.gYC.put(str, bVar);
                        }
                        bVar.tb(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.gYT.gYD.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.gYT.gYD.put(str, bVar2);
                            }
                            bVar2.tb(i);
                        }
                        synchronized (d.this.gYR) {
                            hashMap = new HashMap(d.this.gYS);
                        }
                        c.bQn().t(hashMap);
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
