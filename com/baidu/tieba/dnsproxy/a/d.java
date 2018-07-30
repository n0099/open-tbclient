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
    private static d cPH = null;
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
    private Object cPI = new Object();
    private Map<String, a> cPJ = null;
    private a cPK = null;
    private boolean cPL = false;

    public static final d anK() {
        if (cPH == null) {
            synchronized (d.class) {
                if (cPH == null) {
                    cPH = new d();
                }
            }
        }
        return cPH;
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
        if (!this.cPL) {
            c.anG().a(new g<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.g
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.anx().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cPI) {
                                if (d.this.cPJ == null) {
                                    d.this.cPJ = new ConcurrentHashMap();
                                }
                                d.this.cPJ.clear();
                                d.this.cPJ.putAll(hashMap);
                            }
                            d.this.cPL = true;
                            d.this.anM();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cPJ.entrySet()) {
                                if (d.this.cPK != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cPv > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.anw().y("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cPJ.remove(aVar.name);
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

    public void anL() {
        anM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        if (this.cPL) {
            String anF = a.anF();
            if (!TextUtils.isEmpty(anF)) {
                if (!this.cPJ.containsKey(anF)) {
                    e.anx().fa(false);
                    return;
                }
                this.cPK = this.cPJ.get(anF);
                if (this.cPK == null) {
                    e.anx().fa(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cPK.cPw > 3600000 && currentTimeMillis - this.cPK.cPv < 3600000) {
                    e.anx().fa(false);
                }
            }
        }
    }

    public float aR(String str, String str2) {
        if (!this.cPL || this.cPK == null) {
            return 0.0f;
        }
        b bVar = this.cPK.cPt.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cPx;
    }

    public float aS(String str, String str2) {
        if (!this.cPL || this.cPK == null) {
            return 10000.0f;
        }
        b bVar = this.cPK.cPu.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cPx;
    }

    public void x(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cPL && !TextUtils.isEmpty(str)) {
            e.anx().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPK != null) {
                        b bVar = d.this.cPK.cPt.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPK.cPt.put(str, bVar);
                        }
                        bVar.jy(z ? 1 : 0);
                        synchronized (d.this.cPI) {
                            hashMap = new HashMap(d.this.cPJ);
                        }
                        c.anG().m(hashMap);
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
        if (this.cPL && !TextUtils.isEmpty(str)) {
            e.anx().g(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cPK == null) {
                        String anF = a.anF();
                        if (!TextUtils.isEmpty(anF)) {
                            a aVar = new a();
                            aVar.name = anF;
                            d.this.cPK = aVar;
                            d.this.cPJ.put(anF, aVar);
                        }
                    }
                    if (d.this.cPK != null) {
                        b bVar = d.this.cPK.cPt.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cPK.cPt.put(str, bVar);
                        }
                        bVar.jy(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cPK.cPu.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cPK.cPu.put(str, bVar2);
                            }
                            bVar2.jy(i);
                        }
                        synchronized (d.this.cPI) {
                            hashMap = new HashMap(d.this.cPJ);
                        }
                        c.anG().m(hashMap);
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
