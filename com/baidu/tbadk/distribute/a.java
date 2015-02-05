package com.baidu.tbadk.distribute;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.l;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String Xn = null;
    private static a Xo = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a Xu = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener Xv = new d(this, 2001121);
    private ArrayList<AdReq> Xq = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> Xw = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> Xx = new ArrayList<>();
    private boolean Xr = true;
    private long Xs = TbConfig.USE_TIME_INTERVAL;
    private int Xt = 10;
    private boolean Xp = i.ff();

    public static a uO() {
        return Xo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(boolean z) {
        if (this.Xp != z) {
            this.Xp = z;
            if (z) {
                aH(true);
            } else {
                uP();
            }
        }
    }

    private void uP() {
        this.handler.removeMessages(1);
    }

    private void uQ() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.Xs);
    }

    private synchronized void a(AdReq adReq) {
        if (this.Xq != null && this.Xq.size() < 20) {
            this.Xq.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void k(List<AdReq> list) {
        if (this.Xq != null) {
            this.Xq.addAll(list);
        }
    }

    private a() {
    }

    public void uR() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(uU());
        messageManager.registerTask(uS());
        messageManager.registerListener(this.Xu);
        messageManager.registerListener(this.Xv);
    }

    private HttpMessageTask uS() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aG(boolean z) {
        this.Xr = z;
    }

    public void dh(int i) {
        if (i > 3600) {
            this.Xs = 300000L;
        } else if (i <= 0) {
            this.Xs = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.Xs = i * 1000;
        }
    }

    public void di(int i) {
        if (i > 20) {
            this.Xt = 10;
        } else if (i <= 0) {
            this.Xt = 5;
        } else {
            this.Xt = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq a = cVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.Xp) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        aH(false);
    }

    private boolean uT() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(boolean z) {
        if (this.Xp && this.Xr) {
            List<AdReq> aI = aI(z);
            if (z || !uT()) {
                uQ();
            }
            if (aI != null && aI.size() != 0) {
                if (!z) {
                    uQ();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(aI));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.Xq.size() < r3.Xt) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> aI(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.Xq.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Xq);
                this.Xq.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask uU() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.Xw.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.Xx.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(l.M(context)));
            sb.append(",");
            sb.append(String.valueOf(l.N(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Dq), "da_type", str, "da_obj_id", cVar.Dk, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Dy.DA), "da_ext_info", cVar.Dw, "da_price", cVar.price, "da_verify", cVar.Dv, "cuid", TbadkCoreApplication.m255getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Dl, "da_first_name", cVar.Dr, "da_second_name", cVar.Ds, "da_cpid", Integer.valueOf(cVar.Dt), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.Xw, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.Xx, str, str2, j);
        }
    }

    private void a(Context context, ArrayList<com.baidu.tbadk.core.data.c> arrayList, String str, String str2, long j) {
        if (arrayList != null && arrayList.size() > 0) {
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
            int size = arrayList.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < size) {
                    com.baidu.tbadk.core.data.c cVar = arrayList.get(i2);
                    if (cVar != null) {
                        if (i2 != size - 1) {
                            sb.append(cVar.Dv).append("|");
                            sb2.append(cVar.Dq).append("|");
                            sb3.append(cVar.Dk).append("|");
                            sb4.append(cVar.Dy.DA).append("|");
                            sb5.append(cVar.Dw).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Dl).append("|");
                            sb8.append(cVar.Dr).append("|");
                            sb9.append(cVar.Ds).append("|");
                            sb10.append(cVar.Dt).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Dv);
                            sb2.append(cVar.Dq);
                            sb3.append(cVar.Dk);
                            sb4.append(cVar.Dy.DA);
                            sb5.append(cVar.Dw);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Dl);
                            sb8.append(cVar.Dr);
                            sb9.append(cVar.Ds);
                            sb10.append(cVar.Dt);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.M(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(l.N(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.m255getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
