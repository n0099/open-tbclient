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
/* loaded from: classes7.dex */
public class d {
    private static d iGQ = null;
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
    private Object iGR = new Object();
    private Map<String, a> iGS = null;
    private a iGT = null;
    private boolean iGU = false;

    public static final d cuA() {
        if (iGQ == null) {
            synchronized (d.class) {
                if (iGQ == null) {
                    iGQ = new d();
                }
            }
        }
        return iGQ;
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
        if (!this.iGU) {
            c.cuw().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cun().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.iGR) {
                                if (d.this.iGS == null) {
                                    d.this.iGS = new ConcurrentHashMap();
                                }
                                d.this.iGS.clear();
                                d.this.iGS.putAll(hashMap);
                            }
                            d.this.iGU = true;
                            d.this.cuC();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.iGS.entrySet()) {
                                if (d.this.iGT != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).iGE > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cum().aD("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.iGS.remove(aVar.name);
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

    public void cuB() {
        cuC();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuC() {
        if (this.iGU) {
            String cuv = a.cuv();
            if (!TextUtils.isEmpty(cuv)) {
                if (!this.iGS.containsKey(cuv)) {
                    e.cun().pM(false);
                    return;
                }
                this.iGT = this.iGS.get(cuv);
                if (this.iGT == null) {
                    e.cun().pM(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.iGT.iGF > BdKVCache.MILLS_1Hour && currentTimeMillis - this.iGT.iGE < BdKVCache.MILLS_1Hour) {
                    e.cun().pM(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.iGU || this.iGT == null) {
            return 0.0f;
        }
        b bVar = this.iGT.iGC.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.iGG;
    }

    public float eN(String str, String str2) {
        if (!this.iGU || this.iGT == null) {
            return 10000.0f;
        }
        b bVar = this.iGT.iGD.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.iGG;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.iGU && !TextUtils.isEmpty(str)) {
            e.cun().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iGT != null) {
                        b bVar = d.this.iGT.iGC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iGT.iGC.put(str, bVar);
                        }
                        bVar.xo(z ? 1 : 0);
                        synchronized (d.this.iGR) {
                            hashMap = new HashMap(d.this.iGS);
                        }
                        c.cuw().G(hashMap);
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
        if (this.iGU && !TextUtils.isEmpty(str)) {
            e.cun().o(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.iGT == null) {
                        String cuv = a.cuv();
                        if (!TextUtils.isEmpty(cuv)) {
                            a aVar = new a();
                            aVar.name = cuv;
                            d.this.iGT = aVar;
                            d.this.iGS.put(cuv, aVar);
                        }
                    }
                    if (d.this.iGT != null) {
                        b bVar = d.this.iGT.iGC.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.iGT.iGC.put(str, bVar);
                        }
                        bVar.xo(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.iGT.iGD.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.iGT.iGD.put(str, bVar2);
                            }
                            bVar2.xo(i);
                        }
                        synchronized (d.this.iGR) {
                            hashMap = new HashMap(d.this.iGS);
                        }
                        c.cuw().G(hashMap);
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
