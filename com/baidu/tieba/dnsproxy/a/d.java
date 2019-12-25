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
/* loaded from: classes4.dex */
public class d {
    private static d fLI = null;
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
    private Object fLJ = new Object();
    private Map<String, a> fLK = null;
    private a fLL = null;
    private boolean fLM = false;

    public static final d bus() {
        if (fLI == null) {
            synchronized (d.class) {
                if (fLI == null) {
                    fLI = new d();
                }
            }
        }
        return fLI;
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
        if (!this.fLM) {
            c.buo().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.buf().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.fLJ) {
                                if (d.this.fLK == null) {
                                    d.this.fLK = new ConcurrentHashMap();
                                }
                                d.this.fLK.clear();
                                d.this.fLK.putAll(hashMap);
                            }
                            d.this.fLM = true;
                            d.this.buu();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.fLK.entrySet()) {
                                if (d.this.fLL != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).fLw > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bue().ai("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.fLK.remove(aVar.name);
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

    public void but() {
        buu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buu() {
        if (this.fLM) {
            String bun = a.bun();
            if (!TextUtils.isEmpty(bun)) {
                if (!this.fLK.containsKey(bun)) {
                    e.buf().kl(false);
                    return;
                }
                this.fLL = this.fLK.get(bun);
                if (this.fLL == null) {
                    e.buf().kl(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.fLL.fLx > BdKVCache.MILLS_1Hour && currentTimeMillis - this.fLL.fLw < BdKVCache.MILLS_1Hour) {
                    e.buf().kl(false);
                }
            }
        }
    }

    public float cT(String str, String str2) {
        if (!this.fLM || this.fLL == null) {
            return 0.0f;
        }
        b bVar = this.fLL.fLu.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.fLy;
    }

    public float cU(String str, String str2) {
        if (!this.fLM || this.fLL == null) {
            return 10000.0f;
        }
        b bVar = this.fLL.fLv.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.fLy;
    }

    public void ah(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.fLM && !TextUtils.isEmpty(str)) {
            e.buf().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fLL != null) {
                        b bVar = d.this.fLL.fLu.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fLL.fLu.put(str, bVar);
                        }
                        bVar.ro(z ? 1 : 0);
                        synchronized (d.this.fLJ) {
                            hashMap = new HashMap(d.this.fLK);
                        }
                        c.buo().v(hashMap);
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
        if (this.fLM && !TextUtils.isEmpty(str)) {
            e.buf().p(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.fLL == null) {
                        String bun = a.bun();
                        if (!TextUtils.isEmpty(bun)) {
                            a aVar = new a();
                            aVar.name = bun;
                            d.this.fLL = aVar;
                            d.this.fLK.put(bun, aVar);
                        }
                    }
                    if (d.this.fLL != null) {
                        b bVar = d.this.fLL.fLu.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.fLL.fLu.put(str, bVar);
                        }
                        bVar.ro(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.fLL.fLv.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.fLL.fLv.put(str, bVar2);
                            }
                            bVar2.ro(i);
                        }
                        synchronized (d.this.fLJ) {
                            hashMap = new HashMap(d.this.fLK);
                        }
                        c.buo().v(hashMap);
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
