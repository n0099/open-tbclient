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
    private static d hyz = null;
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
    private Object hyA = new Object();
    private Map<String, a> hyB = null;
    private a hyC = null;
    private boolean hyD = false;

    public static final d chf() {
        if (hyz == null) {
            synchronized (d.class) {
                if (hyz == null) {
                    hyz = new d();
                }
            }
        }
        return hyz;
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
        if (!this.hyD) {
            c.chb().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cgS().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.hyA) {
                                if (d.this.hyB == null) {
                                    d.this.hyB = new ConcurrentHashMap();
                                }
                                d.this.hyB.clear();
                                d.this.hyB.putAll(hashMap);
                            }
                            d.this.hyD = true;
                            d.this.chh();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.hyB.entrySet()) {
                                if (d.this.hyC != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).hyn > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.cgR().ao("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.hyB.remove(aVar.name);
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

    public void chg() {
        chh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chh() {
        if (this.hyD) {
            String cha = a.cha();
            if (!TextUtils.isEmpty(cha)) {
                if (!this.hyB.containsKey(cha)) {
                    e.cgS().nE(false);
                    return;
                }
                this.hyC = this.hyB.get(cha);
                if (this.hyC == null) {
                    e.cgS().nE(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hyC.hyo > BdKVCache.MILLS_1Hour && currentTimeMillis - this.hyC.hyn < BdKVCache.MILLS_1Hour) {
                    e.cgS().nE(false);
                }
            }
        }
    }

    public float ev(String str, String str2) {
        if (!this.hyD || this.hyC == null) {
            return 0.0f;
        }
        b bVar = this.hyC.hyl.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.hyp;
    }

    public float ew(String str, String str2) {
        if (!this.hyD || this.hyC == null) {
            return 10000.0f;
        }
        b bVar = this.hyC.hym.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.hyp;
    }

    public void aE(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.hyD && !TextUtils.isEmpty(str)) {
            e.cgS().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hyC != null) {
                        b bVar = d.this.hyC.hyl.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hyC.hyl.put(str, bVar);
                        }
                        bVar.wh(z ? 1 : 0);
                        synchronized (d.this.hyA) {
                            hashMap = new HashMap(d.this.hyB);
                        }
                        c.chb().t(hashMap);
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
        if (this.hyD && !TextUtils.isEmpty(str)) {
            e.cgS().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hyC == null) {
                        String cha = a.cha();
                        if (!TextUtils.isEmpty(cha)) {
                            a aVar = new a();
                            aVar.name = cha;
                            d.this.hyC = aVar;
                            d.this.hyB.put(cha, aVar);
                        }
                    }
                    if (d.this.hyC != null) {
                        b bVar = d.this.hyC.hyl.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hyC.hyl.put(str, bVar);
                        }
                        bVar.wh(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.hyC.hym.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.hyC.hym.put(str, bVar2);
                            }
                            bVar2.wh(i);
                        }
                        synchronized (d.this.hyA) {
                            hashMap = new HashMap(d.this.hyB);
                        }
                        c.chb().t(hashMap);
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
