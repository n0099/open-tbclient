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
/* loaded from: classes7.dex */
public class d {
    private static d izj = null;
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
    private Object izk = new Object();
    private Map<String, a> izl = null;
    private a izm = null;
    private boolean izn = false;

    public static final d ctb() {
        if (izj == null) {
            synchronized (d.class) {
                if (izj == null) {
                    izj = new d();
                }
            }
        }
        return izj;
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
        if (!this.izn) {
            c.csX().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.csO().r(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.izk) {
                                if (d.this.izl == null) {
                                    d.this.izl = new ConcurrentHashMap();
                                }
                                d.this.izl.clear();
                                d.this.izl.putAll(hashMap);
                            }
                            d.this.izn = true;
                            d.this.ctd();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.izl.entrySet()) {
                                if (d.this.izm != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).iyX > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.csN().aC("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.izl.remove(aVar.name);
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

    public void ctc() {
        ctd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctd() {
        if (this.izn) {
            String csW = a.csW();
            if (!TextUtils.isEmpty(csW)) {
                if (!this.izl.containsKey(csW)) {
                    e.csO().pC(false);
                    return;
                }
                this.izm = this.izl.get(csW);
                if (this.izm == null) {
                    e.csO().pC(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.izm.iyY > BdKVCache.MILLS_1Hour && currentTimeMillis - this.izm.iyX < BdKVCache.MILLS_1Hour) {
                    e.csO().pC(false);
                }
            }
        }
    }

    public float eM(String str, String str2) {
        if (!this.izn || this.izm == null) {
            return 0.0f;
        }
        b bVar = this.izm.iyV.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.iyZ;
    }

    public float eN(String str, String str2) {
        if (!this.izn || this.izm == null) {
            return 10000.0f;
        }
        b bVar = this.izm.iyW.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.iyZ;
    }

    public void aL(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.izn && !TextUtils.isEmpty(str)) {
            e.csO().r(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.izm != null) {
                        b bVar = d.this.izm.iyV.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.izm.iyV.put(str, bVar);
                        }
                        bVar.xd(z ? 1 : 0);
                        synchronized (d.this.izk) {
                            hashMap = new HashMap(d.this.izl);
                        }
                        c.csX().E(hashMap);
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
        if (this.izn && !TextUtils.isEmpty(str)) {
            e.csO().r(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.izm == null) {
                        String csW = a.csW();
                        if (!TextUtils.isEmpty(csW)) {
                            a aVar = new a();
                            aVar.name = csW;
                            d.this.izm = aVar;
                            d.this.izl.put(csW, aVar);
                        }
                    }
                    if (d.this.izm != null) {
                        b bVar = d.this.izm.iyV.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.izm.iyV.put(str, bVar);
                        }
                        bVar.xd(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.izm.iyW.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.izm.iyW.put(str, bVar2);
                            }
                            bVar2.xd(i);
                        }
                        synchronized (d.this.izk) {
                            hashMap = new HashMap(d.this.izl);
                        }
                        c.csX().E(hashMap);
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
