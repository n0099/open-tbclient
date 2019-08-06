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
    private static d eTu = null;
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
    private Object eTv = new Object();
    private Map<String, a> eTw = null;
    private a eTx = null;
    private boolean eTy = false;

    public static final d bey() {
        if (eTu == null) {
            synchronized (d.class) {
                if (eTu == null) {
                    eTu = new d();
                }
            }
        }
        return eTu;
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
        if (!this.eTy) {
            c.beu().a(new k<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.k
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bel().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.eTv) {
                                if (d.this.eTw == null) {
                                    d.this.eTw = new ConcurrentHashMap();
                                }
                                d.this.eTw.clear();
                                d.this.eTw.putAll(hashMap);
                            }
                            d.this.eTy = true;
                            d.this.beA();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.eTw.entrySet()) {
                                if (d.this.eTx != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).eTi > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bek().R("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.eTw.remove(aVar.name);
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

    public void bez() {
        beA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void beA() {
        if (this.eTy) {
            String bet = a.bet();
            if (!TextUtils.isEmpty(bet)) {
                if (!this.eTw.containsKey(bet)) {
                    e.bel().jg(false);
                    return;
                }
                this.eTx = this.eTw.get(bet);
                if (this.eTx == null) {
                    e.bel().jg(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.eTx.eTj > 3600000 && currentTimeMillis - this.eTx.eTi < 3600000) {
                    e.bel().jg(false);
                }
            }
        }
    }

    public float cK(String str, String str2) {
        if (!this.eTy || this.eTx == null) {
            return 0.0f;
        }
        b bVar = this.eTx.eTg.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.eTk;
    }

    public float cL(String str, String str2) {
        if (!this.eTy || this.eTx == null) {
            return 10000.0f;
        }
        b bVar = this.eTx.eTh.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.eTk;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.eTy && !TextUtils.isEmpty(str)) {
            e.bel().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eTx != null) {
                        b bVar = d.this.eTx.eTg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eTx.eTg.put(str, bVar);
                        }
                        bVar.qk(z ? 1 : 0);
                        synchronized (d.this.eTv) {
                            hashMap = new HashMap(d.this.eTw);
                        }
                        c.beu().v(hashMap);
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
        if (this.eTy && !TextUtils.isEmpty(str)) {
            e.bel().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.eTx == null) {
                        String bet = a.bet();
                        if (!TextUtils.isEmpty(bet)) {
                            a aVar = new a();
                            aVar.name = bet;
                            d.this.eTx = aVar;
                            d.this.eTw.put(bet, aVar);
                        }
                    }
                    if (d.this.eTx != null) {
                        b bVar = d.this.eTx.eTg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.eTx.eTg.put(str, bVar);
                        }
                        bVar.qk(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.eTx.eTh.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.eTx.eTh.put(str, bVar2);
                            }
                            bVar2.qk(i);
                        }
                        synchronized (d.this.eTv) {
                            hashMap = new HashMap(d.this.eTw);
                        }
                        c.beu().v(hashMap);
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
