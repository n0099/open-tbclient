package com.baidu.tbadk.distribute;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
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
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.e;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String azx = null;
    private static a azy = new a();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.distribute.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.by(true);
                    return;
                default:
                    return;
            }
        }
    };
    private com.baidu.adp.framework.listener.a azC = new com.baidu.adp.framework.listener.a(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101) { // from class: com.baidu.tbadk.distribute.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.x(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    };
    private CustomMessageListener azD = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.distribute.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.hi() || j.hj()) {
                    a.this.bv(true);
                } else {
                    a.this.bv(false);
                }
            }
        }
    };
    private final CustomMessageListener downloadListener = new CustomMessageListener(CmdConfigCustom.CMD_FILE_DOWNLOAD) { // from class: com.baidu.tbadk.distribute.a.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            List<DownloadData> data;
            if ((customResponsedMessage instanceof DownloadMessage) && (data = ((DownloadMessage) customResponsedMessage).getData()) != null && !data.isEmpty()) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < data.size()) {
                        DownloadData downloadData = data.get(i2);
                        if (downloadData.getType() == 12) {
                            switch (downloadData.getStatus()) {
                                case 0:
                                case 2:
                                case 4:
                                    a.this.w(downloadData.getId(), downloadData.getStatus());
                                    continue;
                                case 1:
                                    a.this.a(downloadData.getId(), downloadData.getDownloadStaticsData());
                                    continue;
                                case 5:
                                    a.this.a(downloadData.getDownloadStaticsData());
                                    continue;
                            }
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private HashMap<String, AdvertAppInfo> azG = new HashMap<>();
    private HashMap<String, AdvertAppInfo> azH = new HashMap<>();
    private HashMap<String, DownloadStaticsData> azI = new HashMap<>();
    private ArrayList<AdReq> azA = new ArrayList<>();
    private ArrayList<AdvertAppInfo> azE = new ArrayList<>();
    private ArrayList<AdvertAppInfo> azF = new ArrayList<>();
    private boolean isUpload = true;
    private long azB = 60000;
    private int uploadSize = 10;
    private boolean azz = j.hh();

    public static a Cd() {
        return azy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bv(boolean z) {
        if (this.azz != z) {
            this.azz = z;
            if (z) {
                by(true);
            } else {
                Ce();
            }
        }
    }

    private void Ce() {
        this.handler.removeMessages(1);
    }

    private void Cf() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.azB);
    }

    private synchronized void a(AdReq adReq) {
        if (this.azA != null && this.azA.size() < 20) {
            this.azA.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void x(List<AdReq> list) {
        if (this.azA != null) {
            this.azA.addAll(list);
        }
    }

    private a() {
    }

    public void bw(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(Cg());
        messageManager.registerListener(this.azC);
        messageManager.registerListener(this.azD);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Cg() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bx(boolean z) {
        this.isUpload = z;
    }

    public void eF(int i) {
        if (i > 3600) {
            this.azB = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.azB = 60000L;
        } else {
            this.azB = i * 1000;
        }
    }

    public void eG(int i) {
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
                if (this.azz) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            by(false);
        }
    }

    private boolean Ch() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        if (this.azz && this.isUpload) {
            List<AdReq> bz = bz(z);
            if (z || !Ch()) {
                Cf();
            }
            if (bz != null && bz.size() != 0) {
                if (!z) {
                    Cf();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bz));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.azA.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bz(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.azA.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.azA);
                this.azA.clear();
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
            a(context, this.azE, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.azF, str, str2, j);
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
                            sb.append(advertAppInfo.TY).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.TO).append("|");
                            sb4.append(advertAppInfo.Ua.Uh).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.TP).append("|");
                            sb8.append(advertAppInfo.TV).append("|");
                            sb9.append(advertAppInfo.TW).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.TY);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.TO);
                            sb4.append(advertAppInfo.Ua.Uh);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.TP);
                            sb8.append(advertAppInfo.TV);
                            sb9.append(advertAppInfo.TW);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.ad(context)));
                    sb12.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb12.append(String.valueOf(l.af(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.azG.remove(str);
        if (remove != null) {
            this.azH.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.azI.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = e.a(downloadStaticsData, 101, 0);
        a.bT("dl", IntentConfig.START);
        b.bgy().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        AdvertAppInfo remove = this.azH.remove(str);
        DownloadStaticsData remove2 = this.azI.remove(str);
        if (remove != null) {
            a = e.c(remove, 101, 0);
        } else if (remove2 != null) {
            a = e.a(remove2, 101, 0);
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
            b.bgy().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.bT("dl", WriteImageActivityConfig.DELET_FLAG);
            b.bgy().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.azG.put(advertAppInfo.TT, advertAppInfo);
    }
}
