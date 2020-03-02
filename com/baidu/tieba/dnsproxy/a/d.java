package com.baidu.tieba.dnsproxy.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.baidu.adp.lib.f.f;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes6.dex */
public class d {
    private static d fRo = null;
    private BroadcastReceiver receiver = new BroadcastReceiver() { // from class: com.baidu.tieba.dnsproxy.a.d.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TableDefine.UserInfoColumns.COLUMN_IP);
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
    private Object fRp = new Object();
    private Map<String, a> fRq = null;
    private a fRr = null;
    private boolean fRs = false;

    public static final d bxa() {
        if (fRo == null) {
            synchronized (d.class) {
                if (fRo == null) {
                    fRo = new d();
                }
            }
        }
        return fRo;
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
        if (!this.fRs) {
            c.bwW().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bwN().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.fRp) {
                                if (d.this.fRq == null) {
                                    d.this.fRq = new ConcurrentHashMap();
                                }
                                d.this.fRq.clear();
                                d.this.fRq.putAll(hashMap);
                            }
                            d.this.fRs = true;
                            d.this.bxc();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.fRq.entrySet()) {
                                if (d.this.fRr != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).fRc > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bwM().aj("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.fRq.remove(aVar.name);
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

    public void bxb() {
        bxc();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxc() {
        if (this.fRs) {
            String bwV = a.bwV();
            if (!TextUtils.isEmpty(bwV)) {
                if (!this.fRq.containsKey(bwV)) {
                    e.bwN().ky(false);
                    return;
                }
                this.fRr = this.fRq.get(bwV);
                if (this.fRr == null) {
                    e.bwN().ky(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fRr.fRd > BdKVCache.MILLS_1Hour && currentTimeMillis - this.fRr.fRc < BdKVCache.MILLS_1Hour) {
                    e.bwN().ky(false);
                }
            }
        }
    }

    public float de(String str, String str2) {
        if (!this.fRs || this.fRr == null) {
            return 0.0f;
        }
        b bVar = this.fRr.fRa.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.fRe;
    }

    public float df(String str, String str2) {
        if (!this.fRs || this.fRr == null) {
            return 10000.0f;
        }
        b bVar = this.fRr.fRb.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.fRe;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.fRs && !TextUtils.isEmpty(str)) {
            e.bwN().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fRr != null) {
                        b bVar = d.this.fRr.fRa.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fRr.fRa.put(str, bVar);
                        }
                        bVar.rA(z ? 1 : 0);
                        synchronized (d.this.fRp) {
                            hashMap = new HashMap(d.this.fRq);
                        }
                        c.bwW().v(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
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
        if (this.fRs && !TextUtils.isEmpty(str)) {
            e.bwN().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fRr == null) {
                        String bwV = a.bwV();
                        if (!TextUtils.isEmpty(bwV)) {
                            a aVar = new a();
                            aVar.name = bwV;
                            d.this.fRr = aVar;
                            d.this.fRq.put(bwV, aVar);
                        }
                    }
                    if (d.this.fRr != null) {
                        b bVar = d.this.fRr.fRa.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fRr.fRa.put(str, bVar);
                        }
                        bVar.rA(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.fRr.fRb.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.fRr.fRb.put(str, bVar2);
                            }
                            bVar2.rA(i);
                        }
                        synchronized (d.this.fRp) {
                            hashMap = new HashMap(d.this.fRq);
                        }
                        c.bwW().v(hashMap);
                    }
                    if (z2) {
                        Intent intent = new Intent(TbadkCoreApplication.getInst().isMainProcess(false) ? "action_main_process_ip_data_change" : "action_sub_process_ip_data_change");
                        intent.setPackage(TbadkCoreApplication.getInst().getApp().getPackageName());
                        intent.putExtra(TableDefine.UserInfoColumns.COLUMN_IP, str);
                        intent.putExtra("result", z);
                        intent.putExtra("speed", i);
                        f.sendBroadcast(TbadkCoreApplication.getInst().getContext(), intent);
                    }
                }
            });
        }
    }
}
