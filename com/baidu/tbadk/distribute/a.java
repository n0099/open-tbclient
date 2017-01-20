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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.diskCache.ImagesInvalidReceiver;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String asp = null;
    private static a asq = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a asu = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener asv = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, com.baidu.tbadk.core.data.c> asy = new HashMap<>();
    private HashMap<String, com.baidu.tbadk.core.data.c> asz = new HashMap<>();
    private HashMap<String, DownloadStaticsData> asA = new HashMap<>();
    private ArrayList<AdReq> ass = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asw = new ArrayList<>();
    private ArrayList<com.baidu.tbadk.core.data.c> asx = new ArrayList<>();
    private boolean isUpload = true;
    private long ast = TbConfig.USE_TIME_INTERVAL;
    private int uploadSize = 10;
    private boolean asr = i.gk();

    public static a Cg() {
        return asq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bw(boolean z) {
        if (this.asr != z) {
            this.asr = z;
            if (z) {
                bz(true);
            } else {
                Ch();
            }
        }
    }

    private void Ch() {
        this.handler.removeMessages(1);
    }

    private void Ci() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.ast);
    }

    private synchronized void a(AdReq adReq) {
        if (this.ass != null && this.ass.size() < 20) {
            this.ass.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void u(List<AdReq> list) {
        if (this.ass != null) {
            this.ass.addAll(list);
        }
    }

    private a() {
    }

    public void bx(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(Cj());
        messageManager.registerListener(this.asu);
        messageManager.registerListener(this.asv);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Cj() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void by(boolean z) {
        this.isUpload = z;
    }

    public void eu(int i) {
        if (i > 3600) {
            this.ast = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.ast = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.ast = i * 1000;
        }
    }

    public void ev(int i) {
        if (i > 20) {
            this.uploadSize = 10;
        } else if (i <= 0) {
            this.uploadSize = 5;
        } else {
            this.uploadSize = i;
        }
    }

    public void a(com.baidu.tbadk.core.data.c cVar, String str, long j, String str2, String str3, int i) {
        if (cVar != null) {
            AdReq a = cVar.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.asr) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bz(false);
        }
    }

    private boolean Ck() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bz(boolean z) {
        if (this.asr && this.isUpload) {
            List<AdReq> bA = bA(z);
            if (z || !Ck()) {
                Ci();
            }
            if (bA != null && bA.size() != 0) {
                if (!z) {
                    Ci();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bA));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.ass.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bA(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.ass.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ass);
                this.ass.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask getSocketTask() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.l(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.asw, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.asx, str, str2, j);
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
                            sb.append(cVar.OD).append("|");
                            sb2.append(cVar.adPosition).append("|");
                            sb3.append(cVar.Ou).append("|");
                            sb4.append(cVar.OF.OO).append("|");
                            sb5.append(cVar.extensionInfo).append("|");
                            sb6.append(cVar.price).append("|");
                            sb7.append(cVar.Ov).append("|");
                            sb8.append(cVar.OA).append("|");
                            sb9.append(cVar.OB).append("|");
                            sb10.append(cVar.cpid).append("|");
                            sb11.append(cVar.abtest).append("|");
                        } else {
                            sb.append(cVar.OD);
                            sb2.append(cVar.adPosition);
                            sb3.append(cVar.Ou);
                            sb4.append(cVar.OF.OO);
                            sb5.append(cVar.extensionInfo);
                            sb6.append(cVar.price);
                            sb7.append(cVar.Ov);
                            sb8.append(cVar.OA);
                            sb9.append(cVar.OB);
                            sb10.append(cVar.cpid);
                            sb11.append(cVar.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.I(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.J(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        com.baidu.tbadk.core.data.c remove = this.asy.remove(str);
        if (remove != null) {
            this.asz.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.asA.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
        a.cb("dl", IntentConfig.START);
        com.baidu.tieba.recapp.report.b.bai().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        com.baidu.tbadk.core.data.c remove = this.asz.remove(str);
        DownloadStaticsData remove2 = this.asA.remove(str);
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
            a.cb("dl", str2);
            com.baidu.tieba.recapp.report.b.bai().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.cb("dl", WriteImageActivityConfig.DELET_FLAG);
            com.baidu.tieba.recapp.report.b.bai().a(a);
        }
    }

    public void b(com.baidu.tbadk.core.data.c cVar) {
        this.asy.put(cVar.Oz, cVar);
    }
}
