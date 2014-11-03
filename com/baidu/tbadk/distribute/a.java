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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.m;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import java.util.ArrayList;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String QM = null;
    private static a QN = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a QU = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener QV = new d(this, 2001121);
    private ArrayList<AdReq> QP = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.a> QW = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.a> QX = new ArrayList<>();
    private boolean QR = true;
    private long QS = TbConfig.USE_TIME_INTERVAL;
    private int QT = 10;
    private boolean QO = j.fh();

    public static a rc() {
        return QN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(boolean z) {
        if (this.QO != z) {
            this.QO = z;
            if (z) {
                ar(true);
            } else {
                rd();
            }
        }
    }

    private void rd() {
        this.handler.removeMessages(1);
    }

    private void re() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.QS);
    }

    private synchronized void a(AdReq adReq) {
        if (this.QP != null && this.QP.size() < 20) {
            this.QP.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void g(List<AdReq> list) {
        if (this.QP != null) {
            this.QP.addAll(list);
        }
    }

    private a() {
    }

    public void rf() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(ri());
        messageManager.registerTask(rg());
        messageManager.registerListener(this.QU);
        messageManager.registerListener(this.QV);
    }

    private HttpMessageTask rg() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aq(boolean z) {
        this.QR = z;
    }

    public void cD(int i) {
        if (i > 3600) {
            this.QS = 300000L;
        } else if (i <= 0) {
            this.QS = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.QS = i * 1000;
        }
    }

    public void cE(int i) {
        if (i > 20) {
            this.QT = 10;
        } else if (i <= 0) {
            this.QT = 5;
        } else {
            this.QT = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.a aVar, String str, long j, String str2, String str3) {
        AdReq a = aVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.QO) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        ar(false);
    }

    private boolean rh() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ar(boolean z) {
        if (this.QO && this.QR) {
            List<AdReq> as = as(z);
            if (z || !rh()) {
                re();
            }
            if (as != null && as.size() != 0) {
                if (!z) {
                    re();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(as));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.QP.size() < r3.QT) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> as(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.QP.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.QP);
                this.QP.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask ri() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.e(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.a aVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.QW.add(aVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.QX.add(aVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(m.n(context)));
            sb.append(",");
            sb.append(String.valueOf(m.o(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(aVar.zm), "da_type", str, "da_obj_id", aVar.zg, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(aVar.zu.zw), "da_ext_info", aVar.zs, "da_price", aVar.price, "da_verify", aVar.zr, "cuid", TbadkApplication.m251getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", aVar.zh, "da_first_name", aVar.zn, "da_second_name", aVar.zo, "da_cpid", Integer.valueOf(aVar.zp), "da_abtest", aVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.QW, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.QX, str, str2, j);
        }
    }

    private void a(Context context, ArrayList<com.baidu.tbadk.core.data.a> arrayList, String str, String str2, long j) {
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
                    com.baidu.tbadk.core.data.a aVar = arrayList.get(i2);
                    if (aVar != null) {
                        if (i2 != size - 1) {
                            sb.append(aVar.zr).append("|");
                            sb2.append(aVar.zm).append("|");
                            sb3.append(aVar.zg).append("|");
                            sb4.append(aVar.zu.zw).append("|");
                            sb5.append(aVar.zs).append("|");
                            sb6.append(aVar.price).append("|");
                            sb7.append(aVar.zh).append("|");
                            sb8.append(aVar.zn).append("|");
                            sb9.append(aVar.zo).append("|");
                            sb10.append(aVar.zp).append("|");
                            sb11.append(aVar.abtest).append("|");
                        } else {
                            sb.append(aVar.zr);
                            sb2.append(aVar.zm);
                            sb3.append(aVar.zg);
                            sb4.append(aVar.zu.zw);
                            sb5.append(aVar.zs);
                            sb6.append(aVar.price);
                            sb7.append(aVar.zh);
                            sb8.append(aVar.zn);
                            sb9.append(aVar.zo);
                            sb10.append(aVar.zp);
                            sb11.append(aVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(m.n(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(m.o(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkApplication.m251getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkApplication.getCurrentAccount(), "baiduid", TbadkApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
