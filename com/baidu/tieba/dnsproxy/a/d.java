package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes3.dex */
public class d {
    private static d cPE = null;
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
    private Object cPF = new Object();
    private Map<String, a> cPG = null;
    private a cPH = null;
    private boolean cPI = false;

    public static final d anM() {
        if (cPE == null) {
            synchronized (d.class) {
                if (cPE == null) {
                    cPE = new d();
                }
            }
        }
        return cPE;
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
        if (!this.cPI) {
            c.anI().a(new g<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.anz().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cPF) {
                                if (d.this.cPG == null) {
                                    d.this.cPG = new ConcurrentHashMap();
                                }
                                d.this.cPG.clear();
                                d.this.cPG.putAll(hashMap);
                            }
                            d.this.cPI = true;
                            d.this.anO();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cPG.entrySet()) {
                                if (d.this.cPH != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cPs > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.any().y("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cPG.remove(aVar.name);
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

    public void anN() {
        anO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anO() {
        if (this.cPI) {
            String anH = a.anH();
            if (!TextUtils.isEmpty(anH)) {
                if (!this.cPG.containsKey(anH)) {
                    e.anz().fa(false);
                    return;
                }
                this.cPH = this.cPG.get(anH);
                if (this.cPH == null) {
                    e.anz().fa(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cPH.cPt > 3600000 && currentTimeMillis - this.cPH.cPs < 3600000) {
                    e.anz().fa(false);
                }
            }
        }
    }

    public float aR(String str, String str2) {
        if (!this.cPI || this.cPH == null) {
            return 0.0f;
        }
        b bVar = this.cPH.cPq.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cPu;
    }

    public float aS(String str, String str2) {
        if (!this.cPI || this.cPH == null) {
            return 10000.0f;
        }
        b bVar = this.cPH.cPr.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cPu;
    }

    public void x(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cPI && !TextUtils.isEmpty(str)) {
            e.anz().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPH != null) {
                        b bVar = d.this.cPH.cPq.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPH.cPq.put(str, bVar);
                        }
                        bVar.jx(z ? 1 : 0);
                        synchronized (d.this.cPF) {
                            hashMap = new HashMap(d.this.cPG);
                        }
                        c.anI().m(hashMap);
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
        if (this.cPI && !TextUtils.isEmpty(str)) {
            e.anz().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPH == null) {
                        String anH = a.anH();
                        if (!TextUtils.isEmpty(anH)) {
                            a aVar = new a();
                            aVar.name = anH;
                            d.this.cPH = aVar;
                            d.this.cPG.put(anH, aVar);
                        }
                    }
                    if (d.this.cPH != null) {
                        b bVar = d.this.cPH.cPq.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPH.cPq.put(str, bVar);
                        }
                        bVar.jx(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cPH.cPr.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cPH.cPr.put(str, bVar2);
                            }
                            bVar2.jx(i);
                        }
                        synchronized (d.this.cPF) {
                            hashMap = new HashMap(d.this.cPG);
                        }
                        c.anI().m(hashMap);
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
