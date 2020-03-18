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
    private static d fSk = null;
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
    private Object fSl = new Object();
    private Map<String, a> fSm = null;
    private a fSn = null;
    private boolean fSo = false;

    public static final d bxg() {
        if (fSk == null) {
            synchronized (d.class) {
                if (fSk == null) {
                    fSk = new d();
                }
            }
        }
        return fSk;
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
        if (!this.fSo) {
            c.bxc().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bwT().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.fSl) {
                                if (d.this.fSm == null) {
                                    d.this.fSm = new ConcurrentHashMap();
                                }
                                d.this.fSm.clear();
                                d.this.fSm.putAll(hashMap);
                            }
                            d.this.fSo = true;
                            d.this.bxi();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.fSm.entrySet()) {
                                if (d.this.fSn != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).fRY > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bwS().aj("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.fSm.remove(aVar.name);
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

    public void bxh() {
        bxi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxi() {
        if (this.fSo) {
            String bxb = a.bxb();
            if (!TextUtils.isEmpty(bxb)) {
                if (!this.fSm.containsKey(bxb)) {
                    e.bwT().kD(false);
                    return;
                }
                this.fSn = this.fSm.get(bxb);
                if (this.fSn == null) {
                    e.bwT().kD(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fSn.fRZ > BdKVCache.MILLS_1Hour && currentTimeMillis - this.fSn.fRY < BdKVCache.MILLS_1Hour) {
                    e.bwT().kD(false);
                }
            }
        }
    }

    public float dd(String str, String str2) {
        if (!this.fSo || this.fSn == null) {
            return 0.0f;
        }
        b bVar = this.fSn.fRW.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.fSa;
    }

    public float de(String str, String str2) {
        if (!this.fSo || this.fSn == null) {
            return 10000.0f;
        }
        b bVar = this.fSn.fRX.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.fSa;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.fSo && !TextUtils.isEmpty(str)) {
            e.bwT().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fSn != null) {
                        b bVar = d.this.fSn.fRW.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fSn.fRW.put(str, bVar);
                        }
                        bVar.rC(z ? 1 : 0);
                        synchronized (d.this.fSl) {
                            hashMap = new HashMap(d.this.fSm);
                        }
                        c.bxc().v(hashMap);
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
        if (this.fSo && !TextUtils.isEmpty(str)) {
            e.bwT().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fSn == null) {
                        String bxb = a.bxb();
                        if (!TextUtils.isEmpty(bxb)) {
                            a aVar = new a();
                            aVar.name = bxb;
                            d.this.fSn = aVar;
                            d.this.fSm.put(bxb, aVar);
                        }
                    }
                    if (d.this.fSn != null) {
                        b bVar = d.this.fSn.fRW.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fSn.fRW.put(str, bVar);
                        }
                        bVar.rC(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.fSn.fRX.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.fSn.fRX.put(str, bVar2);
                            }
                            bVar2.rC(i);
                        }
                        synchronized (d.this.fSl) {
                            hashMap = new HashMap(d.this.fSm);
                        }
                        c.bxc().v(hashMap);
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
