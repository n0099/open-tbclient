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
    private static d dnl = null;
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
    private Object dnm = new Object();
    private Map<String, a> dnn = null;
    private a dno = null;
    private boolean dnp = false;

    public static final d apM() {
        if (dnl == null) {
            synchronized (d.class) {
                if (dnl == null) {
                    dnl = new d();
                }
            }
        }
        return dnl;
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
        if (!this.dnp) {
            c.apI().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.apz().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.dnm) {
                                if (d.this.dnn == null) {
                                    d.this.dnn = new ConcurrentHashMap();
                                }
                                d.this.dnn.clear();
                                d.this.dnn.putAll(hashMap);
                            }
                            d.this.dnp = true;
                            d.this.apO();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.dnn.entrySet()) {
                                if (d.this.dno != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).dmZ > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.apy().A("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.dnn.remove(aVar.name);
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

    public void apN() {
        apO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apO() {
        if (this.dnp) {
            String apH = a.apH();
            if (!TextUtils.isEmpty(apH)) {
                if (!this.dnn.containsKey(apH)) {
                    e.apz().fp(false);
                    return;
                }
                this.dno = this.dnn.get(apH);
                if (this.dno == null) {
                    e.apz().fp(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.dno.dna > 3600000 && currentTimeMillis - this.dno.dmZ < 3600000) {
                    e.apz().fp(false);
                }
            }
        }
    }

    public float aM(String str, String str2) {
        if (!this.dnp || this.dno == null) {
            return 0.0f;
        }
        b bVar = this.dno.dmX.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.dnb;
    }

    public float aN(String str, String str2) {
        if (!this.dnp || this.dno == null) {
            return 10000.0f;
        }
        b bVar = this.dno.dmY.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.dnb;
    }

    public void C(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.dnp && !TextUtils.isEmpty(str)) {
            e.apz().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dno != null) {
                        b bVar = d.this.dno.dmX.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dno.dmX.put(str, bVar);
                        }
                        bVar.mb(z ? 1 : 0);
                        synchronized (d.this.dnm) {
                            hashMap = new HashMap(d.this.dnn);
                        }
                        c.apI().h(hashMap);
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
        if (this.dnp && !TextUtils.isEmpty(str)) {
            e.apz().i(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.dno == null) {
                        String apH = a.apH();
                        if (!TextUtils.isEmpty(apH)) {
                            a aVar = new a();
                            aVar.name = apH;
                            d.this.dno = aVar;
                            d.this.dnn.put(apH, aVar);
                        }
                    }
                    if (d.this.dno != null) {
                        b bVar = d.this.dno.dmX.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.dno.dmX.put(str, bVar);
                        }
                        bVar.mb(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.dno.dmY.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.dno.dmY.put(str, bVar2);
                            }
                            bVar2.mb(i);
                        }
                        synchronized (d.this.dnm) {
                            hashMap = new HashMap(d.this.dnn);
                        }
                        c.apI().h(hashMap);
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
