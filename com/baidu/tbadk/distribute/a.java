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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.n;
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
    public static String aiC = null;
    private static a aiD = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a aiI = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener aiJ = new d(this, 2001121);
    private ArrayList<AdReq> aiF = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> aiK = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> aiL = new ArrayList<>();
    private boolean isUpload = true;
    private long aiG = TbConfig.USE_TIME_INTERVAL;
    private int aiH = 10;
    private boolean aiE = k.iX();

    public static a yY() {
        return aiD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(boolean z) {
        if (this.aiE != z) {
            this.aiE = z;
            if (z) {
                aU(true);
            } else {
                yZ();
            }
        }
    }

    private void yZ() {
        this.handler.removeMessages(1);
    }

    private void za() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.aiG);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aiF != null && this.aiF.size() < 20) {
            this.aiF.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m(List<AdReq> list) {
        if (this.aiF != null) {
            this.aiF.addAll(list);
        }
    }

    private a() {
    }

    public void zb() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(ze());
        messageManager.registerTask(zc());
        messageManager.registerListener(this.aiI);
        messageManager.registerListener(this.aiJ);
    }

    private HttpMessageTask zc() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aT(boolean z) {
        this.isUpload = z;
    }

    public void dt(int i) {
        if (i > 3600) {
            this.aiG = 300000L;
        } else if (i <= 0) {
            this.aiG = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.aiG = i * 1000;
        }
    }

    public void du(int i) {
        if (i > 20) {
            this.aiH = 10;
        } else if (i <= 0) {
            this.aiH = 5;
        } else {
            this.aiH = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq a = cVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.aiE) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        aU(false);
    }

    private boolean zd() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aU(boolean z) {
        if (this.aiE && this.isUpload) {
            List<AdReq> aV = aV(z);
            if (z || !zd()) {
                za();
            }
            if (aV != null && aV.size() != 0) {
                if (!z) {
                    za();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(aV));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aiF.size() < r3.aiH) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> aV(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aiF.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aiF);
                this.aiF.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask ze() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.aiK.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.aiL.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(n.M(context)));
            sb.append(",");
            sb.append(String.valueOf(n.N(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Py), "da_type", str, "da_obj_id", cVar.Ps, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.PH.PK), "da_ext_info", cVar.PF, "da_price", cVar.price, "da_verify", cVar.PE, "cuid", TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.Pt, "da_first_name", cVar.Pz, "da_second_name", cVar.PA, "da_cpid", Integer.valueOf(cVar.PC), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aiK, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aiL, str, str2, j);
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
                            sb.append(cVar.PE).append("|");
                            sb2.append(cVar.Py).append("|");
                            sb3.append(cVar.Ps).append("|");
                            sb4.append(cVar.PH.PK).append("|");
                            sb5.append(cVar.PF).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Pt).append("|");
                            sb8.append(cVar.Pz).append("|");
                            sb9.append(cVar.PA).append("|");
                            sb10.append(cVar.PC).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.PE);
                            sb2.append(cVar.Py);
                            sb3.append(cVar.Ps);
                            sb4.append(cVar.PH.PK);
                            sb5.append(cVar.PF);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Pt);
                            sb8.append(cVar.Pz);
                            sb9.append(cVar.PA);
                            sb10.append(cVar.PC);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(n.M(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(n.N(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.m411getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
