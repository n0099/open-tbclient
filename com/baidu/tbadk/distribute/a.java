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
import com.baidu.adp.lib.util.k;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String atE = null;
    private static a atF = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a atK = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener atL = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.c> atO = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.c> atP = new HashMap<>();
    private HashMap<String, DownloadStaticsData> atQ = new HashMap<>();
    private ArrayList<AdReq> atH = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> atM = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> atN = new ArrayList<>();
    private boolean isUpload = true;
    private long atI = TbConfig.USE_TIME_INTERVAL;
    private int atJ = 10;
    private boolean atG = i.gm();

    public static a Cx() {
        return atF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (this.atG != z) {
            this.atG = z;
            if (z) {
                bz(true);
            } else {
                Cy();
            }
        }
    }

    private void Cy() {
        this.handler.removeMessages(1);
    }

    private void Cz() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.atI);
    }

    private synchronized void a(AdReq adReq) {
        if (this.atH != null && this.atH.size() < 20) {
            this.atH.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void v(List<AdReq> list) {
        if (this.atH != null) {
            this.atH.addAll(list);
        }
    }

    private a() {
    }

    public void bx(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(CC());
        }
        messageManager.registerTask(CA());
        messageManager.registerListener(this.atK);
        messageManager.registerListener(this.atL);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask CA() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void by(boolean z) {
        this.isUpload = z;
    }

    public void es(int i) {
        if (i > 3600) {
            this.atI = 300000L;
        } else if (i <= 0) {
            this.atI = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.atI = i * 1000;
        }
    }

    public void et(int i) {
        if (i > 20) {
            this.atJ = 10;
        } else if (i <= 0) {
            this.atJ = 5;
        } else {
            this.atJ = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3, int i) {
        if (cVar != null) {
            AdReq a = cVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.atG) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bz(false);
        }
    }

    private boolean CB() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        if (this.atG && this.isUpload) {
            List<AdReq> bA = bA(z);
            if (z || !CB()) {
                Cz();
            }
            if (bA != null && bA.size() != 0) {
                if (!z) {
                    Cz();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bA));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.atH.size() < r3.atJ) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bA(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.atH.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.atH);
                this.atH.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask CC() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.l(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.atM, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.atN, str, str2, j);
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
                            sb.append(cVar.Px).append("|");
                            sb2.append(cVar.adPosition).append("|");
                            sb3.append(cVar.Pm).append("|");
                            sb4.append(cVar.Pz.PJ).append("|");
                            sb5.append(cVar.extensionInfo).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Pn).append("|");
                            sb8.append(cVar.Pt).append("|");
                            sb9.append(cVar.Pu).append("|");
                            sb10.append(cVar.Pv).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.Px);
                            sb2.append(cVar.adPosition);
                            sb3.append(cVar.Pm);
                            sb4.append(cVar.Pz.PJ);
                            sb5.append(cVar.extensionInfo);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Pn);
                            sb8.append(cVar.Pt);
                            sb9.append(cVar.Pu);
                            sb10.append(cVar.Pv);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.K(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.L(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.core.data.c remove = this.atO.remove(str);
        if (remove != null) {
            this.atP.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.atQ.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
        a.bP("dl", IntentConfig.START);
        com.baidu.tieba.recapp.report.b.beF().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        com.baidu.tbadk.core.data.c remove = this.atP.remove(str);
        DownloadStaticsData remove2 = this.atQ.remove(str);
        if (remove != null) {
            a = com.baidu.tieba.recapp.report.e.a(remove, 101, 0);
        } else if (remove2 != null) {
            a = com.baidu.tieba.recapp.report.e.a(remove2, 101, 0);
            a.setDownloadStaticsData(null);
        } else {
            return;
        }
        if (remove != null || remove2 != null) {
            if (i == 0) {
                str2 = ImagesInvalidReceiver.SUCCESS;
            } else if (i == 2) {
                str2 = "fail";
            } else if (i == 4) {
                str2 = "cancel";
            } else {
                return;
            }
            a.bP("dl", str2);
            com.baidu.tieba.recapp.report.b.beF().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.bP("dl", WriteImageActivityConfig.DELET_FLAG);
            com.baidu.tieba.recapp.report.b.beF().a(a);
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar) {
        this.atO.put(cVar.Ps, cVar);
    }
}
