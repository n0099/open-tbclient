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
    private static d gLT = null;
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
    private Object gLU = new Object();
    private Map<String, a> gLV = null;
    private a gLW = null;
    private boolean gLX = false;

    public static final d bNm() {
        if (gLT == null) {
            synchronized (d.class) {
                if (gLT == null) {
                    gLT = new d();
                }
            }
        }
        return gLT;
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
        if (!this.gLX) {
            c.bNi().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bMZ().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.gLU) {
                                if (d.this.gLV == null) {
                                    d.this.gLV = new ConcurrentHashMap();
                                }
                                d.this.gLV.clear();
                                d.this.gLV.putAll(hashMap);
                            }
                            d.this.gLX = true;
                            d.this.bNo();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.gLV.entrySet()) {
                                if (d.this.gLW != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).gLH > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bMY().am("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.gLV.remove(aVar.name);
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

    public void bNn() {
        bNo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bNo() {
        if (this.gLX) {
            String bNh = a.bNh();
            if (!TextUtils.isEmpty(bNh)) {
                if (!this.gLV.containsKey(bNh)) {
                    e.bMZ().mc(false);
                    return;
                }
                this.gLW = this.gLV.get(bNh);
                if (this.gLW == null) {
                    e.bMZ().mc(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.gLW.gLI > BdKVCache.MILLS_1Hour && currentTimeMillis - this.gLW.gLH < BdKVCache.MILLS_1Hour) {
                    e.bMZ().mc(false);
                }
            }
        }
    }

    public float dS(String str, String str2) {
        if (!this.gLX || this.gLW == null) {
            return 0.0f;
        }
        b bVar = this.gLW.gLF.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.gLJ;
    }

    public float dT(String str, String str2) {
        if (!this.gLX || this.gLW == null) {
            return 10000.0f;
        }
        b bVar = this.gLW.gLG.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.gLJ;
    }

    public void aA(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.gLX && !TextUtils.isEmpty(str)) {
            e.bMZ().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gLW != null) {
                        b bVar = d.this.gLW.gLF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gLW.gLF.put(str, bVar);
                        }
                        bVar.sA(z ? 1 : 0);
                        synchronized (d.this.gLU) {
                            hashMap = new HashMap(d.this.gLV);
                        }
                        c.bNi().s(hashMap);
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
        if (this.gLX && !TextUtils.isEmpty(str)) {
            e.bMZ().w(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.gLW == null) {
                        String bNh = a.bNh();
                        if (!TextUtils.isEmpty(bNh)) {
                            a aVar = new a();
                            aVar.name = bNh;
                            d.this.gLW = aVar;
                            d.this.gLV.put(bNh, aVar);
                        }
                    }
                    if (d.this.gLW != null) {
                        b bVar = d.this.gLW.gLF.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.gLW.gLF.put(str, bVar);
                        }
                        bVar.sA(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.gLW.gLG.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.gLW.gLG.put(str, bVar2);
                            }
                            bVar2.sA(i);
                        }
                        synchronized (d.this.gLU) {
                            hashMap = new HashMap(d.this.gLV);
                        }
                        c.bNi().s(hashMap);
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
