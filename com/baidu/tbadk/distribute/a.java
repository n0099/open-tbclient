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
    public static String axK = null;
    private static a axL = new a();
    private Handler handler = new b(this, Looper.getMainLooper());
    private com.baidu.adp.framework.listener.a axP = new c(this, CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101);
    private CustomMessageListener axQ = new d(this, 2000994);
    private final CustomMessageListener downloadListener = new e(this, CmdConfigCustom.CMD_FILE_DOWNLOAD);
    private HashMap<String, AdvertAppInfo> axT = new HashMap<>();
    private HashMap<String, AdvertAppInfo> axU = new HashMap<>();
    private HashMap<String, DownloadStaticsData> axV = new HashMap<>();
    private ArrayList<AdReq> axN = new ArrayList<>();
    private ArrayList<AdvertAppInfo> axR = new ArrayList<>();
    private ArrayList<AdvertAppInfo> axS = new ArrayList<>();
    private boolean isUpload = true;
    private long axO = TbConfig.USE_TIME_INTERVAL;
    private int uploadSize = 10;
    private boolean axM = i.he();

    public static a Cz() {
        return axL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (this.axM != z) {
            this.axM = z;
            if (z) {
                by(true);
            } else {
                CA();
            }
        }
    }

    private void CA() {
        this.handler.removeMessages(1);
    }

    private void CB() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.axO);
    }

    private synchronized void a(AdReq adReq) {
        if (this.axN != null && this.axN.size() < 20) {
            this.axN.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(List<AdReq> list) {
        if (this.axN != null) {
            this.axN.addAll(list);
        }
    }

    private a() {
    }

    public void bw(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(CC());
        messageManager.registerListener(this.axP);
        messageManager.registerListener(this.axQ);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask CC() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, String.valueOf(TbConfig.SERVER_ADDRESS) + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bx(boolean z) {
        this.isUpload = z;
    }

    public void ep(int i) {
        if (i > 3600) {
            this.axO = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.axO = TbConfig.USE_TIME_INTERVAL;
        } else {
            this.axO = i * 1000;
        }
    }

    public void eq(int i) {
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
                if (this.axM) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            by(false);
        }
    }

    private boolean CD() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        if (this.axM && this.isUpload) {
            List<AdReq> bz = bz(z);
            if (z || !CD()) {
                CB();
            }
            if (bz != null && bz.size() != 0) {
                if (!z) {
                    CB();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bz));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.axN.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bz(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.axN.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.axN);
                this.axN.clear();
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

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.axR, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.axS, str, str2, j);
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
                            sb.append(advertAppInfo.TH).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.Ty).append("|");
                            sb4.append(advertAppInfo.TJ.TR).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.Tz).append("|");
                            sb8.append(advertAppInfo.TE).append("|");
                            sb9.append(advertAppInfo.TF).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.TH);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.Ty);
                            sb4.append(advertAppInfo.TJ.TR);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.Tz);
                            sb8.append(advertAppInfo.TE);
                            sb9.append(advertAppInfo.TF);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(k.ag(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(k.ah(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, SocialConstants.PARAM_CUID, TbadkCoreApplication.m9getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.axT.remove(str);
        if (remove != null) {
            this.axU.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.axV.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
        a.bU("dl", IntentConfig.START);
        com.baidu.tieba.recapp.report.b.aZQ().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        AdvertAppInfo remove = this.axU.remove(str);
        DownloadStaticsData remove2 = this.axV.remove(str);
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
            a.bU("dl", str2);
            com.baidu.tieba.recapp.report.b.aZQ().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = com.baidu.tieba.recapp.report.e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.bU("dl", WriteImageActivityConfig.DELET_FLAG);
            com.baidu.tieba.recapp.report.b.aZQ().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.axT.put(advertAppInfo.TD, advertAppInfo);
    }
}
