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
/* loaded from: classes13.dex */
public class d {
    private static d ifS = null;
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
    private Object ifT = new Object();
    private Map<String, a> ifU = null;
    private a ifV = null;
    private boolean ifW = false;

    public static final d cqj() {
        if (ifS == null) {
            synchronized (d.class) {
                if (ifS == null) {
                    ifS = new d();
                }
            }
        }
        return ifS;
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
        if (!this.ifW) {
            c.cqf().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cpW().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.ifT) {
                                if (d.this.ifU == null) {
                                    d.this.ifU = new ConcurrentHashMap();
                                }
                                d.this.ifU.clear();
                                d.this.ifU.putAll(hashMap);
                            }
                            d.this.ifW = true;
                            d.this.cql();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.ifU.entrySet()) {
                                if (d.this.ifV != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).ifG > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cpV().ay("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.ifU.remove(aVar.name);
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

    public void cqk() {
        cql();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cql() {
        if (this.ifW) {
            String cqe = a.cqe();
            if (!TextUtils.isEmpty(cqe)) {
                if (!this.ifU.containsKey(cqe)) {
                    e.cpW().oK(false);
                    return;
                }
                this.ifV = this.ifU.get(cqe);
                if (this.ifV == null) {
                    e.cpW().oK(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.ifV.ifH > BdKVCache.MILLS_1Hour && currentTimeMillis - this.ifV.ifG < BdKVCache.MILLS_1Hour) {
                    e.cpW().oK(false);
                }
            }
        }
    }

    public float eH(String str, String str2) {
        if (!this.ifW || this.ifV == null) {
            return 0.0f;
        }
        b bVar = this.ifV.ifE.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.ifI;
    }

    public float eI(String str, String str2) {
        if (!this.ifW || this.ifV == null) {
            return 10000.0f;
        }
        b bVar = this.ifV.ifF.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.ifI;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.ifW && !TextUtils.isEmpty(str)) {
            e.cpW().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ifV != null) {
                        b bVar = d.this.ifV.ifE.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ifV.ifE.put(str, bVar);
                        }
                        bVar.xt(z ? 1 : 0);
                        synchronized (d.this.ifT) {
                            hashMap = new HashMap(d.this.ifU);
                        }
                        c.cqf().D(hashMap);
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
        if (this.ifW && !TextUtils.isEmpty(str)) {
            e.cpW().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.ifV == null) {
                        String cqe = a.cqe();
                        if (!TextUtils.isEmpty(cqe)) {
                            a aVar = new a();
                            aVar.name = cqe;
                            d.this.ifV = aVar;
                            d.this.ifU.put(cqe, aVar);
                        }
                    }
                    if (d.this.ifV != null) {
                        b bVar = d.this.ifV.ifE.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.ifV.ifE.put(str, bVar);
                        }
                        bVar.xt(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.ifV.ifF.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.ifV.ifF.put(str, bVar2);
                            }
                            bVar2.xt(i);
                        }
                        synchronized (d.this.ifT) {
                            hashMap = new HashMap(d.this.ifU);
                        }
                        c.cqf().D(hashMap);
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
