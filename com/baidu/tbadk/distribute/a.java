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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
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
    public static String ayc = null;
    private static a ayd = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a ayh = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener ayi = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, AdvertAppInfo> ayl = new HashMap<>();
    private HashMap<String, AdvertAppInfo> aym = new HashMap<>();
    private HashMap<String, DownloadStaticsData> ayn = new HashMap<>();
    private ArrayList<AdReq> ayf = new ArrayList<>();
    private ArrayList<AdvertAppInfo> ayj = new ArrayList<>();
    private ArrayList<AdvertAppInfo> ayk = new ArrayList<>();
    private boolean isUpload = true;
    private long ayg = TbConfig.USE_TIME_INTERVAL;
    private int uploadSize = 10;
    private boolean aye = i.hk();

    public static a CX() {
        return ayd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bx(boolean z) {
        if (this.aye != z) {
            this.aye = z;
            if (z) {
                bA(true);
            } else {
                CY();
            }
        }
    }

    private void CY() {
        this.handler.removeMessages(1);
    }

    private void CZ() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.ayg);
    }

    private synchronized void a(AdReq adReq) {
        if (this.ayf != null && this.ayf.size() < 20) {
            this.ayf.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(List<AdReq> list) {
        if (this.ayf != null) {
            this.ayf.addAll(list);
        }
    }

    private a() {
    }

    public void by(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(Da());
        messageManager.registerListener(this.ayh);
        messageManager.registerListener(this.ayi);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Da() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bz(boolean z) {
        this.isUpload = z;
    }

    public void es(int i) {
        if (i > 3600) {
            this.ayg = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.ayg = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.ayg = i * 1000;
        }
    }

    public void et(int i) {
        if (i > 20) {
            this.uploadSize = 10;
        } else if (i <= 0) {
            this.uploadSize = 5;
        } else {
            this.uploadSize = i;
        }
    }

    public void a(AdvertAppInfo advertAppInfo, String str, long j, String str2, String str3, int i) {
        if (advertAppInfo != null) {
            AdReq a = advertAppInfo.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.aye) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bA(false);
        }
    }

    private boolean Db() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bA(boolean z) {
        if (this.aye && this.isUpload) {
            List<AdReq> bB = bB(z);
            if (z || !Db()) {
                CZ();
            }
            if (bB != null && bB.size() != 0) {
                if (!z) {
                    CZ();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bB));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.ayf.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bB(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.ayf.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.ayf);
                this.ayf.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask getSocketTask() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.m(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.ayj, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.ayk, str, str2, j);
        }
    }

    private void a(Context context, ArrayList<AdvertAppInfo> arrayList, String str, String str2, long j) {
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
                    AdvertAppInfo advertAppInfo = arrayList.get(i2);
                    if (advertAppInfo != null) {
                        if (i2 != size - 1) {
                            sb.append(advertAppInfo.Uc).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.TT).append("|");
                            sb4.append(advertAppInfo.Ue.Ul).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.TU).append("|");
                            sb8.append(advertAppInfo.TZ).append("|");
                            sb9.append(advertAppInfo.Ua).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.Uc);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.TT);
                            sb4.append(advertAppInfo.Ue.Ul);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.TU);
                            sb8.append(advertAppInfo.TZ);
                            sb9.append(advertAppInfo.Ua);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.af(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.ag(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.m9getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.ayl.remove(str);
        if (remove != null) {
            this.aym.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.ayn.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
        a.bT("dl", IntentConfig.START);
        com.baidu.tieba.recapp.report.b.bbA().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        AdvertAppInfo remove = this.aym.remove(str);
        DownloadStaticsData remove2 = this.ayn.remove(str);
        if (remove != null) {
            a = com.baidu.tieba.recapp.report.e.b(remove, 101, 0);
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
            a.bT("dl", str2);
            com.baidu.tieba.recapp.report.b.bbA().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.bT("dl", WriteImageActivityConfig.DELET_FLAG);
            com.baidu.tieba.recapp.report.b.bbA().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.ayl.put(advertAppInfo.TY, advertAppInfo);
    }
}
