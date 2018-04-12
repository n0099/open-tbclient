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
    private static d cFi = null;
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
    private Object cFj = new Object();
    private Map<String, a> cFk = null;
    private a cFl = null;
    private boolean cFm = false;

    public static final d ajU() {
        if (cFi == null) {
            synchronized (d.class) {
                if (cFi == null) {
                    cFi = new d();
                }
            }
        }
        return cFi;
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
        if (!this.cFm) {
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
                            synchronized (d.this.cFj) {
                                if (d.this.cFk == null) {
                                    d.this.cFk = new ConcurrentHashMap();
                                }
                                d.this.cFk.clear();
                                d.this.cFk.putAll(hashMap);
                            }
                            d.this.cFm = true;
                            d.this.ajW();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.cFk.entrySet()) {
                                if (d.this.cFl != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).cEW > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ajG().z("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.cFk.remove(aVar.name);
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
        if (this.cFm) {
            String ajP = a.ajP();
            if (!TextUtils.isEmpty(ajP)) {
                if (!this.cFk.containsKey(ajP)) {
                    e.ajH().eU(false);
                    return;
                }
                this.cFl = this.cFk.get(ajP);
                if (this.cFl == null) {
                    e.ajH().eU(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.cFl.cEX > 3600000 && currentTimeMillis - this.cFl.cEW < 3600000) {
                    e.ajH().eU(false);
                }
            }
        }
    }

    public float aL(String str, String str2) {
        if (!this.cFm || this.cFl == null) {
            return 0.0f;
        }
        b bVar = this.cFl.cEU.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.cEY;
    }

    public float aM(String str, String str2) {
        if (!this.cFm || this.cFl == null) {
            return 10000.0f;
        }
        b bVar = this.cFl.cEV.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.cEY;
    }

    public void y(String str, boolean z) {
        e(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(final String str, final boolean z, final boolean z2) {
        if (this.cFm && !TextUtils.isEmpty(str)) {
            e.ajH().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cFl != null) {
                        b bVar = d.this.cFl.cEU.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cFl.cEU.put(str, bVar);
                        }
                        bVar.jn(z ? 1 : 0);
                        synchronized (d.this.cFj) {
                            hashMap = new HashMap(d.this.cFk);
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
        if (this.cFm && !TextUtils.isEmpty(str)) {
            e.ajH().h(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.cFl == null) {
                        String ajP = a.ajP();
                        if (!TextUtils.isEmpty(ajP)) {
                            a aVar = new a();
                            aVar.name = ajP;
                            d.this.cFl = aVar;
                            d.this.cFk.put(ajP, aVar);
                        }
                    }
                    if (d.this.cFl != null) {
                        b bVar = d.this.cFl.cEU.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.cFl.cEU.put(str, bVar);
                        }
                        bVar.jn(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.cFl.cEV.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.cFl.cEV.put(str, bVar2);
                            }
                            bVar2.jn(i);
                        }
                        synchronized (d.this.cFj) {
                            hashMap = new HashMap(d.this.cFk);
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
