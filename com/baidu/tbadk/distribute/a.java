package com.baidu.tbadk.distribute;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.j;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String a = null;
    private static a b = new a();
    private Handler h = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.d i = new c(this, 303101);
    private CustomMessageListener j = new d(this, 2001121);
    private ArrayList<AdReq> d = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.a> k = new ArrayList<>();
    private boolean e = true;
    private long f = TbConfig.USE_TIME_INTERVAL;
    private int g = 10;
    private boolean c = UtilHelper.isNetOk();

    public static a a() {
        return b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (this.c != z) {
            this.c = z;
            if (z) {
                c(true);
            } else {
                c();
            }
        }
    }

    private void c() {
        this.h.removeMessages(1);
    }

    private void d() {
        this.h.removeMessages(1);
        this.h.sendEmptyMessageDelayed(1, this.f);
    }

    private synchronized void a(AdReq adReq) {
        if (this.d != null && this.d.size() < 20) {
            this.d.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(List<AdReq> list) {
        if (this.d != null) {
            this.d.addAll(list);
        }
    }

    private a() {
    }

    public void b() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(f());
        messageManager.registerListener(this.i);
        messageManager.registerListener(this.j);
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void a(int i) {
        if (i > 3600) {
            this.f = 300000L;
        } else if (i <= 0) {
            this.f = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.f = i * 1000;
        }
    }

    public void b(int i) {
        if (i > 20) {
            this.g = 10;
        } else if (i <= 0) {
            this.g = 5;
        } else {
            this.g = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str, long j, String str2, String str3) {
        AdReq a2 = aVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a2);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.c) {
                MessageManager.getInstance().sendMessage(new RequestDistributeMessage(a2));
            } else {
                a(a2);
            }
        }
        c(false);
    }

    private boolean e() {
        return this.h.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z) {
        if (this.c && this.e) {
            List<AdReq> d = d(z);
            if (z || !e()) {
                d();
            }
            if (d != null && d.size() != 0) {
                if (!z) {
                    d();
                }
                MessageManager.getInstance().sendMessage(new RequestDistributeMessage(d));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.d.size() < r3.g) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> d(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.d.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.d);
                this.d.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask f() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.a(true);
        socketMessageTask.a(ResponseDistributeMessage.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.a aVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            this.k.add(aVar);
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(j.b(context)));
            sb.append(",");
            sb.append(String.valueOf(j.c(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(aVar.h), "da_type", str, "da_obj_id", aVar.b, "fid", str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(aVar.s.a), "da_ext_info", aVar.q, "da_price", aVar.l, "da_verify", aVar.p, "cuid", TbadkApplication.m252getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", aVar.c, "da_first_name", aVar.i, "da_second_name", aVar.j, "da_cpid", Integer.valueOf(aVar.k), "da_abtest", aVar.m, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (this.k != null && this.k.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            StringBuilder sb4 = new StringBuilder();
            StringBuilder sb5 = new StringBuilder();
            StringBuilder sb6 = new StringBuilder();
            StringBuilder sb7 = new StringBuilder();
            StringBuilder sb8 = new StringBuilder();
            StringBuilder sb9 = new StringBuilder();
            StringBuilder sb10 = new StringBuilder();
            StringBuilder sb11 = new StringBuilder();
            int size = this.k.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    com.baidu.tbadk.core.data.a aVar = this.k.get(i2);
                    if (aVar != null) {
                        if (i2 != size - 1) {
                            sb.append(aVar.p).append("|");
                            sb2.append(aVar.h).append("|");
                            sb3.append(aVar.b).append("|");
                            sb4.append(aVar.s.a).append("|");
                            sb5.append(aVar.q).append("|");
                            sb6.append(aVar.l).append("|");
                            sb7.append(aVar.c).append("|");
                            sb8.append(aVar.i).append("|");
                            sb9.append(aVar.j).append("|");
                            sb10.append(aVar.k).append("|");
                            sb11.append(aVar.m).append("|");
                        } else {
                            sb.append(aVar.p);
                            sb2.append(aVar.h);
                            sb3.append(aVar.b);
                            sb4.append(aVar.s.a);
                            sb5.append(aVar.q);
                            sb6.append(aVar.l);
                            sb7.append(aVar.c);
                            sb8.append(aVar.i);
                            sb9.append(aVar.j);
                            sb10.append(aVar.k);
                            sb11.append(aVar.m);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(j.b(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(j.c(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkApplication.m252getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    this.k.clear();
                    return;
                }
            }
        }
    }
}
