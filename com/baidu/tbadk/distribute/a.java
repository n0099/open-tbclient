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
    public static String aht = null;
    private static a ahu = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a ahA = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener ahB = new d(this, 2001121);
    private ArrayList<AdReq> ahw = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> ahC = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> ahD = new ArrayList<>();
    private boolean ahx = true;
    private long ahy = TbConfig.USE_TIME_INTERVAL;
    private int ahz = 10;
    private boolean ahv = k.iH();

    public static a ye() {
        return ahu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aL(boolean z) {
        if (this.ahv != z) {
            this.ahv = z;
            if (z) {
                aN(true);
            } else {
                yf();
            }
        }
    }

    private void yf() {
        this.handler.removeMessages(1);
    }

    private void yg() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.ahy);
    }

    private synchronized void a(AdReq adReq) {
        if (this.ahw != null && this.ahw.size() < 20) {
            this.ahw.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(List<AdReq> list) {
        if (this.ahw != null) {
            this.ahw.addAll(list);
        }
    }

    private a() {
    }

    public void yh() {
        MessageManager messageManager = MessageManager.getInstance();
        messageManager.registerTask(yk());
        messageManager.registerTask(yi());
        messageManager.registerListener(this.ahA);
        messageManager.registerListener(this.ahB);
    }

    private HttpMessageTask yi() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void aM(boolean z) {
        this.ahx = z;
    }

    public void dj(int i) {
        if (i > 3600) {
            this.ahy = 300000L;
        } else if (i <= 0) {
            this.ahy = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.ahy = i * 1000;
        }
    }

    public void dk(int i) {
        if (i > 20) {
            this.ahz = 10;
        } else if (i <= 0) {
            this.ahz = 5;
        } else {
            this.ahz = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3) {
        AdReq a = cVar.a(str, j, str2, str3);
        if (TextUtils.equals(str3, "show")) {
            a(a);
        }
        if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
            if (this.ahv) {
                MessageManager.getInstance().sendMessage(new DistributeRequest(a));
            } else {
                a(a);
            }
        }
        aN(false);
    }

    private boolean yj() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aN(boolean z) {
        if (this.ahv && this.ahx) {
            List<AdReq> aO = aO(z);
            if (z || !yj()) {
                yg();
            }
            if (aO != null && aO.size() != 0) {
                if (!z) {
                    yg();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(aO));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.ahw.size() < r3.ahz) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> aO(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.ahw.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ahw);
                this.ahw.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask yk() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.i(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, com.baidu.tbadk.core.data.c cVar, String str, String str2, String str3, long j) {
        if (TextUtils.equals(str, "show")) {
            if (TextUtils.equals(str2, "frs")) {
                this.ahC.add(cVar);
            } else if (TextUtils.equals(str2, "pb")) {
                this.ahD.add(cVar);
            }
        } else if (TextUtils.equals(str, "btn_click") || TextUtils.equals(str, "btn_download") || TextUtils.equals(str, "area_click") || TextUtils.equals(str, "area_download")) {
            StringBuilder sb = new StringBuilder(15);
            sb.append(String.valueOf(n.M(context)));
            sb.append(",");
            sb.append(String.valueOf(n.N(context)));
            TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str2, "da_locate", Integer.valueOf(cVar.Pc), "da_type", str, "da_obj_id", cVar.OW, ImageViewerConfig.FORUM_ID, str3, "tid", Long.valueOf(j), "da_good_id", Integer.valueOf(cVar.Pk.Pm), "da_ext_info", cVar.Pi, "da_price", cVar.price, "da_verify", cVar.Ph, "cuid", TbadkCoreApplication.m411getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", cVar.OX, "da_first_name", cVar.Pd, "da_second_name", cVar.Pe, "da_cpid", Integer.valueOf(cVar.Pf), "da_abtest", cVar.abtest, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb.toString(), "model", Build.MODEL);
        }
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.ahC, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.ahD, str, str2, j);
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
                            sb.append(cVar.Ph).append("|");
                            sb2.append(cVar.Pc).append("|");
                            sb3.append(cVar.OW).append("|");
                            sb4.append(cVar.Pk.Pm).append("|");
                            sb5.append(cVar.Pi).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.OX).append("|");
                            sb8.append(cVar.Pd).append("|");
                            sb9.append(cVar.Pe).append("|");
                            sb10.append(cVar.Pf).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Ph);
                            sb2.append(cVar.Pc);
                            sb3.append(cVar.OW);
                            sb4.append(cVar.Pk.Pm);
                            sb5.append(cVar.Pi);
                            sb6.append(cVar.price);
                            sb7.append(cVar.OX);
                            sb8.append(cVar.Pd);
                            sb9.append(cVar.Pe);
                            sb10.append(cVar.Pf);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(n.M(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(n.N(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.m411getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }
}
