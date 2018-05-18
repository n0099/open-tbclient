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
    private static d cGo = null;
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
    private Object cGp = new Object();
    private Map<String, a> cGq = null;
    private a cGr = null;
    private boolean cGs = false;

    public static final d ajU() {
        if (cGo == null) {
            synchronized (d.class) {
                if (cGo == null) {
                    cGo = new d();
                }
            }
        }
        return cGo;
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
        if (!this.cGs) {
            c.ajQ().a(new h<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.h
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.ajH().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.cGp) {
                                if (d.this.cGq == null) {
                                    d.this.cGq = new ConcurrentHashMap();
                                }
                                d.this.cGq.clear();
                                d.this.cGq.putAll(hashMap);
                            }
                            d.this.cGs = true;
                            d.this.ajW();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cGq.entrySet()) {
                                if (d.this.cGr != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cGc > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ajG().z("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cGq.remove(aVar.name);
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

    public void ajV() {
        ajW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajW() {
        if (this.cGs) {
            String ajP = a.ajP();
            if (!TextUtils.isEmpty(ajP)) {
                if (!this.cGq.containsKey(ajP)) {
                    e.ajH().eV(false);
                    return;
                }
                this.cGr = this.cGq.get(ajP);
                if (this.cGr == null) {
                    e.ajH().eV(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cGr.cGd > 3600000 && currentTimeMillis - this.cGr.cGc < 3600000) {
                    e.ajH().eV(false);
                }
            }
        }
    }

    public float aL(String str, String str2) {
        if (!this.cGs || this.cGr == null) {
            return 0.0f;
        }
        b bVar = this.cGr.cGa.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cGe;
    }

    public float aM(String str, String str2) {
        if (!this.cGs || this.cGr == null) {
            return 10000.0f;
        }
        b bVar = this.cGr.cGb.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cGe;
    }

    public void y(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cGs && !TextUtils.isEmpty(str)) {
            e.ajH().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cGr != null) {
                        b bVar = d.this.cGr.cGa.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cGr.cGa.put(str, bVar);
                        }
                        bVar.jl(z ? 1 : 0);
                        synchronized (d.this.cGp) {
                            hashMap = new HashMap(d.this.cGq);
                        }
                        c.ajQ().h(hashMap);
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
        if (this.cGs && !TextUtils.isEmpty(str)) {
            e.ajH().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cGr == null) {
                        String ajP = a.ajP();
                        if (!TextUtils.isEmpty(ajP)) {
                            a aVar = new a();
                            aVar.name = ajP;
                            d.this.cGr = aVar;
                            d.this.cGq.put(ajP, aVar);
                        }
                    }
                    if (d.this.cGr != null) {
                        b bVar = d.this.cGr.cGa.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cGr.cGa.put(str, bVar);
                        }
                        bVar.jl(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cGr.cGb.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cGr.cGb.put(str, bVar2);
                            }
                            bVar2.jl(i);
                        }
                        synchronized (d.this.cGp) {
                            hashMap = new HashMap(d.this.cGq);
                        }
                        c.ajQ().h(hashMap);
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
