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
    private static d cPe = null;
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
    private Object cPf = new Object();
    private Map<String, a> cPg = null;
    private a cPh = null;
    private boolean cPi = false;

    public static final d anR() {
        if (cPe == null) {
            synchronized (d.class) {
                if (cPe == null) {
                    cPe = new d();
                }
            }
        }
        return cPe;
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
        if (!this.cPi) {
            c.anN().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.anE().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cPf) {
                                if (d.this.cPg == null) {
                                    d.this.cPg = new ConcurrentHashMap();
                                }
                                d.this.cPg.clear();
                                d.this.cPg.putAll(hashMap);
                            }
                            d.this.cPi = true;
                            d.this.anT();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cPg.entrySet()) {
                                if (d.this.cPh != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cOS > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.anD().z("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cPg.remove(aVar.name);
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

    public void anS() {
        anT();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anT() {
        if (this.cPi) {
            String anM = a.anM();
            if (!TextUtils.isEmpty(anM)) {
                if (!this.cPg.containsKey(anM)) {
                    e.anE().eZ(false);
                    return;
                }
                this.cPh = this.cPg.get(anM);
                if (this.cPh == null) {
                    e.anE().eZ(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cPh.cOT > 3600000 && currentTimeMillis - this.cPh.cOS < 3600000) {
                    e.anE().eZ(false);
                }
            }
        }
    }

    public float aT(String str, String str2) {
        if (!this.cPi || this.cPh == null) {
            return 0.0f;
        }
        b bVar = this.cPh.cOQ.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cOU;
    }

    public float aU(String str, String str2) {
        if (!this.cPi || this.cPh == null) {
            return 10000.0f;
        }
        b bVar = this.cPh.cOR.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cOU;
    }

    public void y(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cPi && !TextUtils.isEmpty(str)) {
            e.anE().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPh != null) {
                        b bVar = d.this.cPh.cOQ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPh.cOQ.put(str, bVar);
                        }
                        bVar.jo(z ? 1 : 0);
                        synchronized (d.this.cPf) {
                            hashMap = new HashMap(d.this.cPg);
                        }
                        c.anN().m(hashMap);
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
        if (this.cPi && !TextUtils.isEmpty(str)) {
            e.anE().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPh == null) {
                        String anM = a.anM();
                        if (!TextUtils.isEmpty(anM)) {
                            a aVar = new a();
                            aVar.name = anM;
                            d.this.cPh = aVar;
                            d.this.cPg.put(anM, aVar);
                        }
                    }
                    if (d.this.cPh != null) {
                        b bVar = d.this.cPh.cOQ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPh.cOQ.put(str, bVar);
                        }
                        bVar.jo(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cPh.cOR.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cPh.cOR.put(str, bVar2);
                            }
                            bVar2.jo(i);
                        }
                        synchronized (d.this.cPf) {
                            hashMap = new HashMap(d.this.cPg);
                        }
                        c.anN().m(hashMap);
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
