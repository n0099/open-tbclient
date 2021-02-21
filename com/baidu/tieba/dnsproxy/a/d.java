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
import com.baidu.tbadk.util.m;
import com.baidu.tieba.dnsproxy.e;
import com.baidu.tieba.dnsproxy.pbdata.ConnectPointData;
import com.baidu.tieba.dnsproxy.pbdata.WriteHistroyDataReqIdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class d {
    private static d iFh = null;
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
    private Object iFi = new Object();
    private Map<String, a> iFj = null;
    private a iFk = null;
    private boolean iFl = false;

    public static final d cuu() {
        if (iFh == null) {
            synchronized (d.class) {
                if (iFh == null) {
                    iFh = new d();
                }
            }
        }
        return iFh;
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
        if (!this.iFl) {
            c.cuq().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cuh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            HashMap hashMap = new HashMap();
                            if (writeHistroyDataReqIdl != null) {
                                for (ConnectPointData connectPointData : writeHistroyDataReqIdl.connect_point_list) {
                                    a a2 = a.a(connectPointData);
                                    if (a2 != null) {
                                        hashMap.put(a2.name, a2);
                                    }
                                }
                            }
                            synchronized (d.this.iFi) {
                                if (d.this.iFj == null) {
                                    d.this.iFj = new ConcurrentHashMap();
                                }
                                d.this.iFj.clear();
                                d.this.iFj.putAll(hashMap);
                            }
                            d.this.iFl = true;
                            d.this.cuw();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.iFj.entrySet()) {
                                if (d.this.iFk != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).iEV > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cug().aD("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.iFj.remove(aVar.name);
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

    public void cuv() {
        cuw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuw() {
        if (this.iFl) {
            String cup = a.cup();
            if (!TextUtils.isEmpty(cup)) {
                if (!this.iFj.containsKey(cup)) {
                    e.cuh().pM(false);
                    return;
                }
                this.iFk = this.iFj.get(cup);
                if (this.iFk == null) {
                    e.cuh().pM(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.iFk.iEW > BdKVCache.MILLS_1Hour && currentTimeMillis - this.iFk.iEV < BdKVCache.MILLS_1Hour) {
                    e.cuh().pM(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.iFl || this.iFk == null) {
            return 0.0f;
        }
        b bVar = this.iFk.iET.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.iEX;
    }

    public float eN(String str, String str2) {
        if (!this.iFl || this.iFk == null) {
            return 10000.0f;
        }
        b bVar = this.iFk.iEU.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.iEX;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.iFl && !TextUtils.isEmpty(str)) {
            e.cuh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iFk != null) {
                        b bVar = d.this.iFk.iET.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iFk.iET.put(str, bVar);
                        }
                        bVar.xn(z ? 1 : 0);
                        synchronized (d.this.iFi) {
                            hashMap = new HashMap(d.this.iFj);
                        }
                        c.cuq().G(hashMap);
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
        if (this.iFl && !TextUtils.isEmpty(str)) {
            e.cuh().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iFk == null) {
                        String cup = a.cup();
                        if (!TextUtils.isEmpty(cup)) {
                            a aVar = new a();
                            aVar.name = cup;
                            d.this.iFk = aVar;
                            d.this.iFj.put(cup, aVar);
                        }
                    }
                    if (d.this.iFk != null) {
                        b bVar = d.this.iFk.iET.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iFk.iET.put(str, bVar);
                        }
                        bVar.xn(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.iFk.iEU.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.iFk.iEU.put(str, bVar2);
                            }
                            bVar2.xn(i);
                        }
                        synchronized (d.this.iFi) {
                            hashMap = new HashMap(d.this.iFj);
                        }
                        c.cuq().G(hashMap);
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
