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
    private static d hNu = null;
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
    private Object hNv = new Object();
    private Map<String, a> hNw = null;
    private a hNx = null;
    private boolean hNy = false;

    public static final d ckB() {
        if (hNu == null) {
            synchronized (d.class) {
                if (hNu == null) {
                    hNu = new d();
                }
            }
        }
        return hNu;
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
        if (!this.hNy) {
            c.ckx().a(new m<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.m
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.cko().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.hNv) {
                                if (d.this.hNw == null) {
                                    d.this.hNw = new ConcurrentHashMap();
                                }
                                d.this.hNw.clear();
                                d.this.hNw.putAll(hashMap);
                            }
                            d.this.hNy = true;
                            d.this.ckD();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.hNw.entrySet()) {
                                if (d.this.hNx != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).hNi > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.ckn().aq("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.hNw.remove(aVar.name);
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

    public void ckC() {
        ckD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckD() {
        if (this.hNy) {
            String ckw = a.ckw();
            if (!TextUtils.isEmpty(ckw)) {
                if (!this.hNw.containsKey(ckw)) {
                    e.cko().oj(false);
                    return;
                }
                this.hNx = this.hNw.get(ckw);
                if (this.hNx == null) {
                    e.cko().oj(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hNx.hNj > BdKVCache.MILLS_1Hour && currentTimeMillis - this.hNx.hNi < BdKVCache.MILLS_1Hour) {
                    e.cko().oj(false);
                }
            }
        }
    }

    public float eC(String str, String str2) {
        if (!this.hNy || this.hNx == null) {
            return 0.0f;
        }
        b bVar = this.hNx.hNg.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.hNk;
    }

    public float eD(String str, String str2) {
        if (!this.hNy || this.hNx == null) {
            return 10000.0f;
        }
        b bVar = this.hNx.hNh.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.hNk;
    }

    public void aI(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.hNy && !TextUtils.isEmpty(str)) {
            e.cko().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hNx != null) {
                        b bVar = d.this.hNx.hNg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hNx.hNg.put(str, bVar);
                        }
                        bVar.wN(z ? 1 : 0);
                        synchronized (d.this.hNv) {
                            hashMap = new HashMap(d.this.hNw);
                        }
                        c.ckx().D(hashMap);
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
        if (this.hNy && !TextUtils.isEmpty(str)) {
            e.cko().s(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hNx == null) {
                        String ckw = a.ckw();
                        if (!TextUtils.isEmpty(ckw)) {
                            a aVar = new a();
                            aVar.name = ckw;
                            d.this.hNx = aVar;
                            d.this.hNw.put(ckw, aVar);
                        }
                    }
                    if (d.this.hNx != null) {
                        b bVar = d.this.hNx.hNg.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hNx.hNg.put(str, bVar);
                        }
                        bVar.wN(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.hNx.hNh.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.hNx.hNh.put(str, bVar2);
                            }
                            bVar2.wN(i);
                        }
                        synchronized (d.this.hNv) {
                            hashMap = new HashMap(d.this.hNw);
                        }
                        c.ckx().D(hashMap);
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
