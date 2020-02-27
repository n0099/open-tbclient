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
    private static d fRm = null;
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
    private Object fRn = new Object();
    private Map<String, a> fRo = null;
    private a fRp = null;
    private boolean fRq = false;

    public static final d bwY() {
        if (fRm == null) {
            synchronized (d.class) {
                if (fRm == null) {
                    fRm = new d();
                }
            }
        }
        return fRm;
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
        if (!this.fRq) {
            c.bwU().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bwL().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.fRn) {
                                if (d.this.fRo == null) {
                                    d.this.fRo = new ConcurrentHashMap();
                                }
                                d.this.fRo.clear();
                                d.this.fRo.putAll(hashMap);
                            }
                            d.this.fRq = true;
                            d.this.bxa();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.fRo.entrySet()) {
                                if (d.this.fRp != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).fRa > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bwK().aj("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.fRo.remove(aVar.name);
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

    public void bwZ() {
        bxa();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bxa() {
        if (this.fRq) {
            String bwT = a.bwT();
            if (!TextUtils.isEmpty(bwT)) {
                if (!this.fRo.containsKey(bwT)) {
                    e.bwL().ky(false);
                    return;
                }
                this.fRp = this.fRo.get(bwT);
                if (this.fRp == null) {
                    e.bwL().ky(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fRp.fRb > BdKVCache.MILLS_1Hour && currentTimeMillis - this.fRp.fRa < BdKVCache.MILLS_1Hour) {
                    e.bwL().ky(false);
                }
            }
        }
    }

    public float de(String str, String str2) {
        if (!this.fRq || this.fRp == null) {
            return 0.0f;
        }
        b bVar = this.fRp.fQY.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.fRc;
    }

    public float df(String str, String str2) {
        if (!this.fRq || this.fRp == null) {
            return 10000.0f;
        }
        b bVar = this.fRp.fQZ.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.fRc;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.fRq && !TextUtils.isEmpty(str)) {
            e.bwL().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fRp != null) {
                        b bVar = d.this.fRp.fQY.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fRp.fQY.put(str, bVar);
                        }
                        bVar.rA(z ? 1 : 0);
                        synchronized (d.this.fRn) {
                            hashMap = new HashMap(d.this.fRo);
                        }
                        c.bwU().v(hashMap);
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
        if (this.fRq && !TextUtils.isEmpty(str)) {
            e.bwL().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fRp == null) {
                        String bwT = a.bwT();
                        if (!TextUtils.isEmpty(bwT)) {
                            a aVar = new a();
                            aVar.name = bwT;
                            d.this.fRp = aVar;
                            d.this.fRo.put(bwT, aVar);
                        }
                    }
                    if (d.this.fRp != null) {
                        b bVar = d.this.fRp.fQY.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fRp.fQY.put(str, bVar);
                        }
                        bVar.rA(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.fRp.fQZ.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.fRp.fQZ.put(str, bVar2);
                            }
                            bVar2.rA(i);
                        }
                        synchronized (d.this.fRn) {
                            hashMap = new HashMap(d.this.fRo);
                        }
                        c.bwU().v(hashMap);
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
