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
    private static d eOn = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra("ip");
                boolean booleanExtra = intent.getBooleanExtra("result", false);
                int intExtra = intent.getIntExtra("speed", -1);
                if (!TextUtils.isEmpty(stringExtra)) {
                    if (intExtra == -1) {
                        d.this.h(stringExtra, booleanExtra, false);
                    } else {
                        d.this.a(stringExtra, intExtra, booleanExtra, false);
                    }
                }
            }
        }
    };
    private Object eOo = new Object();
    private Map<String, a> eOp = null;
    private a eOq = null;
    private boolean eOr = false;

    public static final d bcv() {
        if (eOn == null) {
            synchronized (d.class) {
                if (eOn == null) {
                    eOn = new d();
                }
            }
        }
        return eOn;
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
        if (!this.eOr) {
            c.bcr().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bci().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eOo) {
                                if (d.this.eOp == null) {
                                    d.this.eOp = new ConcurrentHashMap();
                                }
                                d.this.eOp.clear();
                                d.this.eOp.putAll(hashMap);
                            }
                            d.this.eOr = true;
                            d.this.bcx();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eOp.entrySet()) {
                                if (d.this.eOq != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eOb > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bch().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eOp.remove(aVar.name);
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

    public void bcw() {
        bcx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bcx() {
        if (this.eOr) {
            String bcq = a.bcq();
            if (!TextUtils.isEmpty(bcq)) {
                if (!this.eOp.containsKey(bcq)) {
                    e.bci().iW(false);
                    return;
                }
                this.eOq = this.eOp.get(bcq);
                if (this.eOq == null) {
                    e.bci().iW(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eOq.eOc > 3600000 && currentTimeMillis - this.eOq.eOb < 3600000) {
                    e.bci().iW(false);
                }
            }
        }
    }

    public float cJ(String str, String str2) {
        if (!this.eOr || this.eOq == null) {
            return 0.0f;
        }
        b bVar = this.eOq.eNZ.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eOd;
    }

    public float cK(String str, String str2) {
        if (!this.eOr || this.eOq == null) {
            return 10000.0f;
        }
        b bVar = this.eOq.eOa.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eOd;
    }

    public void ad(String str, boolean z) {
        h(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(final String str, final boolean z, final boolean z2) {
        if (this.eOr && !TextUtils.isEmpty(str)) {
            e.bci().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eOq != null) {
                        b bVar = d.this.eOq.eNZ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eOq.eNZ.put(str, bVar);
                        }
                        bVar.pS(z ? 1 : 0);
                        synchronized (d.this.eOo) {
                            hashMap = new HashMap(d.this.eOp);
                        }
                        c.bcr().v(hashMap);
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
        if (this.eOr && !TextUtils.isEmpty(str)) {
            e.bci().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eOq == null) {
                        String bcq = a.bcq();
                        if (!TextUtils.isEmpty(bcq)) {
                            a aVar = new a();
                            aVar.name = bcq;
                            d.this.eOq = aVar;
                            d.this.eOp.put(bcq, aVar);
                        }
                    }
                    if (d.this.eOq != null) {
                        b bVar = d.this.eOq.eNZ.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eOq.eNZ.put(str, bVar);
                        }
                        bVar.pS(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eOq.eOa.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eOq.eOa.put(str, bVar2);
                            }
                            bVar2.pS(i);
                        }
                        synchronized (d.this.eOo) {
                            hashMap = new HashMap(d.this.eOp);
                        }
                        c.bcr().v(hashMap);
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
