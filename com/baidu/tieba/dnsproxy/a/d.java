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
/* loaded from: classes13.dex */
public class d {
    private static d hev = null;
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
    private Object hew = new Object();
    private Map<String, a> hex = null;
    private a hey = null;
    private boolean hez = false;

    public static final d bTD() {
        if (hev == null) {
            synchronized (d.class) {
                if (hev == null) {
                    hev = new d();
                }
            }
        }
        return hev;
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
        if (!this.hez) {
            c.bTz().a(new l<WriteHistroyDataReqIdl>() { // from class: com.baidu.tieba.dnsproxy.a.d.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.tbadk.util.l
                /* renamed from: a */
                public void onReturnDataInUI(final WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
                    e.bTq().v(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.2.1
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
                            synchronized (d.this.hew) {
                                if (d.this.hex == null) {
                                    d.this.hex = new ConcurrentHashMap();
                                }
                                d.this.hex.clear();
                                d.this.hex.putAll(hashMap);
                            }
                            d.this.hez = true;
                            d.this.bTF();
                            ArrayList<a> arrayList = new ArrayList();
                            for (Map.Entry entry : d.this.hex.entrySet()) {
                                if (d.this.hey != entry.getValue() && System.currentTimeMillis() - ((a) entry.getValue()).hej > 604800000) {
                                    arrayList.add(entry.getValue());
                                    com.baidu.tieba.dnsproxy.d.bTp().ao("conpoint_remove", "out_time", (String) entry.getKey());
                                }
                            }
                            for (a aVar : arrayList) {
                                d.this.hex.remove(aVar.name);
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

    public void bTE() {
        bTF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bTF() {
        if (this.hez) {
            String bTy = a.bTy();
            if (!TextUtils.isEmpty(bTy)) {
                if (!this.hex.containsKey(bTy)) {
                    e.bTq().mS(false);
                    return;
                }
                this.hey = this.hex.get(bTy);
                if (this.hey == null) {
                    e.bTq().mS(false);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.hey.hek > BdKVCache.MILLS_1Hour && currentTimeMillis - this.hey.hej < BdKVCache.MILLS_1Hour) {
                    e.bTq().mS(false);
                }
            }
        }
    }

    public float dZ(String str, String str2) {
        if (!this.hez || this.hey == null) {
            return 0.0f;
        }
        b bVar = this.hey.heh.get(str2);
        if (bVar == null) {
            return 0.0f;
        }
        return bVar.hel;
    }

    public float ea(String str, String str2) {
        if (!this.hez || this.hey == null) {
            return 10000.0f;
        }
        b bVar = this.hey.hei.get(str2);
        if (bVar == null) {
            return 10000.0f;
        }
        return bVar.hel;
    }

    public void aA(String str, boolean z) {
        i(str, z, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(final String str, final boolean z, final boolean z2) {
        if (this.hez && !TextUtils.isEmpty(str)) {
            e.bTq().v(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.3
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hey != null) {
                        b bVar = d.this.hey.heh.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hey.heh.put(str, bVar);
                        }
                        bVar.tt(z ? 1 : 0);
                        synchronized (d.this.hew) {
                            hashMap = new HashMap(d.this.hex);
                        }
                        c.bTz().t(hashMap);
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
        if (this.hez && !TextUtils.isEmpty(str)) {
            e.bTq().v(new Runnable() { // from class: com.baidu.tieba.dnsproxy.a.d.4
                @Override // java.lang.Runnable
                public void run() {
                    HashMap hashMap;
                    if (d.this.hey == null) {
                        String bTy = a.bTy();
                        if (!TextUtils.isEmpty(bTy)) {
                            a aVar = new a();
                            aVar.name = bTy;
                            d.this.hey = aVar;
                            d.this.hex.put(bTy, aVar);
                        }
                    }
                    if (d.this.hey != null) {
                        b bVar = d.this.hey.heh.get(str);
                        if (bVar == null) {
                            bVar = new b();
                            bVar.address = str;
                            d.this.hey.heh.put(str, bVar);
                        }
                        bVar.tt(z ? 1 : 0);
                        if (z) {
                            b bVar2 = d.this.hey.hei.get(str);
                            if (bVar2 == null) {
                                bVar2 = new b();
                                bVar2.address = str;
                                d.this.hey.hei.put(str, bVar2);
                            }
                            bVar2.tt(i);
                        }
                        synchronized (d.this.hew) {
                            hashMap = new HashMap(d.this.hex);
                        }
                        c.bTz().t(hashMap);
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
