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
    private static d hZR = null;
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
    private Object hZS = new Object();
    private Map<String, a> hZT = null;
    private a hZU = null;
    private boolean hZV = false;

    public static final d cnI() {
        if (hZR == null) {
            synchronized (d.class) {
                if (hZR == null) {
                    hZR = new d();
                }
            }
        }
        return hZR;
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
        if (!this.hZV) {
            c.cnE().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cnv().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.hZS) {
                                if (d.this.hZT == null) {
                                    d.this.hZT = new ConcurrentHashMap();
                                }
                                d.this.hZT.clear();
                                d.this.hZT.putAll(hashMap);
                            }
                            d.this.hZV = true;
                            d.this.cnK();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.hZT.entrySet()) {
                                if (d.this.hZU != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).hZF > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cnu().ax("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.hZT.remove(aVar.name);
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

    public void cnJ() {
        cnK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnK() {
        if (this.hZV) {
            String cnD = a.cnD();
            if (!TextUtils.isEmpty(cnD)) {
                if (!this.hZT.containsKey(cnD)) {
                    e.cnv().oB(false);
                    return;
                }
                this.hZU = this.hZT.get(cnD);
                if (this.hZU == null) {
                    e.cnv().oB(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hZU.hZG > BdKVCache.MILLS_1Hour && currentTimeMillis - this.hZU.hZF < BdKVCache.MILLS_1Hour) {
                    e.cnv().oB(false);
                }
            }
        }
    }

    public float eH(String str, String str2) {
        if (!this.hZV || this.hZU == null) {
            return 0.0f;
        }
        b bVar = this.hZU.hZD.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.hZH;
    }

    public float eI(String str, String str2) {
        if (!this.hZV || this.hZU == null) {
            return 10000.0f;
        }
        b bVar = this.hZU.hZE.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.hZH;
    }

    public void aK(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.hZV && !TextUtils.isEmpty(str)) {
            e.cnv().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hZU != null) {
                        b bVar = d.this.hZU.hZD.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hZU.hZD.put(str, bVar);
                        }
                        bVar.xg(z ? 1 : 0);
                        synchronized (d.this.hZS) {
                            hashMap = new HashMap(d.this.hZT);
                        }
                        c.cnE().D(hashMap);
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
        if (this.hZV && !TextUtils.isEmpty(str)) {
            e.cnv().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hZU == null) {
                        String cnD = a.cnD();
                        if (!TextUtils.isEmpty(cnD)) {
                            a aVar = new a();
                            aVar.name = cnD;
                            d.this.hZU = aVar;
                            d.this.hZT.put(cnD, aVar);
                        }
                    }
                    if (d.this.hZU != null) {
                        b bVar = d.this.hZU.hZD.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hZU.hZD.put(str, bVar);
                        }
                        bVar.xg(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.hZU.hZE.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.hZU.hZE.put(str, bVar2);
                            }
                            bVar2.xg(i);
                        }
                        synchronized (d.this.hZS) {
                            hashMap = new HashMap(d.this.hZT);
                        }
                        c.cnE().D(hashMap);
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
