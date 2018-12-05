package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.h;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {
    private static d dlA = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.e(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object dlB = new Object();
    private Map<String, a> dlC = null;
    private a dlD = null;
    private boolean dlE = false;

    public static final d aui() {
        if (dlA == null) {
            synchronized (d.class) {
                if (dlA == null) {
                    dlA = new d();
                }
            }
        }
        return dlA;
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
        if (!this.dlE) {
            c.aue().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.atV().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.dlB) {
                                if (d.this.dlC == null) {
                                    d.this.dlC = new ConcurrentHashMap();
                                }
                                d.this.dlC.clear();
                                d.this.dlC.putAll(hashMap);
                            }
                            d.this.dlE = true;
                            d.this.auk();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dlC.entrySet()) {
                                if (d.this.dlD != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).dlo > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.atU().G("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dlC.remove(aVar.name);
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

    public void auj() {
        auk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auk() {
        if (this.dlE) {
            String aud = a.aud();
            if (!TextUtils.isEmpty(aud)) {
                if (!this.dlC.containsKey(aud)) {
                    e.atV().fU(false);
                    return;
                }
                this.dlD = this.dlC.get(aud);
                if (this.dlD == null) {
                    e.atV().fU(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dlD.dlp > 3600000 && currentTimeMillis - this.dlD.dlo < 3600000) {
                    e.atV().fU(false);
                }
            }
        }
    }

    public float bq(String str, String str2) {
        if (!this.dlE || this.dlD == null) {
            return 0.0f;
        }
        b bVar = this.dlD.dlm.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.dlq;
    }

    public float br(String str, String str2) {
        if (!this.dlE || this.dlD == null) {
            return 10000.0f;
        }
        b bVar = this.dlD.dln.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.dlq;
    }

    public void H(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dlE && !TextUtils.isEmpty(str)) {
            e.atV().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dlD != null) {
                        b bVar = d.this.dlD.dlm.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dlD.dlm.put(str, bVar);
                        }
                        bVar.lc(z ? 1 : 0);
                        synchronized (d.this.dlB) {
                            hashMap = new HashMap(d.this.dlC);
                        }
                        c.aue().t(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra("ip", str);
                        intent.putExtra("result", z);
                        f.g(TbadkCoreApplication.getInst().getContext(), intent);
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
        if (this.dlE && !TextUtils.isEmpty(str)) {
            e.atV().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dlD == null) {
                        String aud = a.aud();
                        if (!TextUtils.isEmpty(aud)) {
                            a aVar = new a();
                            aVar.name = aud;
                            d.this.dlD = aVar;
                            d.this.dlC.put(aud, aVar);
                        }
                    }
                    if (d.this.dlD != null) {
                        b bVar = d.this.dlD.dlm.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dlD.dlm.put(str, bVar);
                        }
                        bVar.lc(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dlD.dln.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dlD.dln.put(str, bVar2);
                            }
                            bVar2.lc(i);
                        }
                        synchronized (d.this.dlB) {
                            hashMap = new HashMap(d.this.dlC);
                        }
                        c.aue().t(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra("ip", str);
                        intent.putExtra("result", z);
                        intent.putExtra("speed", i);
                        f.g(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }
}
