package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.g.f;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class d {
    private static d eTn = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
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
    private Object eTo = new Object();
    private Map<String, a> eTp = null;
    private a eTq = null;
    private boolean eTr = false;

    public static final d bew() {
        if (eTn == null) {
            synchronized (d.class) {
                if (eTn == null) {
                    eTn = new d();
                }
            }
        }
        return eTn;
    }

    private d() {
    }

    public void ZP() {
        if (TbadkCoreApplication.getInst().isMainProcess(true)) {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_sub_process_ip_data_change"));
        } else {
            TbadkCoreApplication.getInst().unregisterReceiver(this.receiver);
            TbadkCoreApplication.getInst().registerReceiver(this.receiver, new IntentFilter("action_main_process_ip_data_change"));
        }
        if (!this.eTr) {
            c.bes().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bej().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eTo) {
                                if (d.this.eTp == null) {
                                    d.this.eTp = new ConcurrentHashMap();
                                }
                                d.this.eTp.clear();
                                d.this.eTp.putAll(hashMap);
                            }
                            d.this.eTr = true;
                            d.this.bey();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eTp.entrySet()) {
                                if (d.this.eTq != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eTb > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bei().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eTp.remove(aVar.name);
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

    public void bex() {
        bey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bey() {
        if (this.eTr) {
            String ber = a.ber();
            if (!TextUtils.isEmpty(ber)) {
                if (!this.eTp.containsKey(ber)) {
                    e.bej().jg(false);
                    return;
                }
                this.eTq = this.eTp.get(ber);
                if (this.eTq == null) {
                    e.bej().jg(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eTq.eTc > 3600000 && currentTimeMillis - this.eTq.eTb < 3600000) {
                    e.bej().jg(false);
                }
            }
        }
    }

    public float cK(String str, String str2) {
        if (!this.eTr || this.eTq == null) {
            return 0.0f;
        }
        b bVar = this.eTq.eSZ.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eTd;
    }

    public float cL(String str, String str2) {
        if (!this.eTr || this.eTq == null) {
            return 10000.0f;
        }
        b bVar = this.eTq.eTa.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eTd;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.eTr && !TextUtils.isEmpty(str)) {
            e.bej().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eTq != null) {
                        b bVar = d.this.eTq.eSZ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eTq.eSZ.put(str, bVar);
                        }
                        bVar.qj(z ? 1 : 0);
                        synchronized (d.this.eTo) {
                            hashMap = new HashMap(d.this.eTp);
                        }
                        c.bes().v(hashMap);
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
        if (this.eTr && !TextUtils.isEmpty(str)) {
            e.bej().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eTq == null) {
                        String ber = a.ber();
                        if (!TextUtils.isEmpty(ber)) {
                            a aVar = new a();
                            aVar.name = ber;
                            d.this.eTq = aVar;
                            d.this.eTp.put(ber, aVar);
                        }
                    }
                    if (d.this.eTq != null) {
                        b bVar = d.this.eTq.eSZ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eTq.eSZ.put(str, bVar);
                        }
                        bVar.qj(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eTq.eTa.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eTq.eTa.put(str, bVar2);
                            }
                            bVar2.qj(i);
                        }
                        synchronized (d.this.eTo) {
                            hashMap = new HashMap(d.this.eTp);
                        }
                        c.bes().v(hashMap);
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
