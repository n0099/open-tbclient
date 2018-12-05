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
import com.baidu.searchbox.ng.ai.apps.scheme.actions.OpenAppAction;
import com.baidu.searchbox.ng.ai.apps.statistic.AiAppsUBCStatistic;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.atomData.WriteImageActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.report.b;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.f;
import com.baidu.webkit.internal.ETAG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String aXu = null;
    private static a aXv = new a();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.distribute.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.cn(true);
                    return;
                default:
                    return;
            }
        }
    };
    private com.baidu.adp.framework.listener.a aXz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101) { // from class: com.baidu.tbadk.distribute.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.N(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    };
    private CustomMessageListener aXA = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.distribute.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.kW() || j.kX()) {
                    a.this.ck(true);
                } else {
                    a.this.ck(false);
                }
            }
        }
    };
    private final CustomMessageListener downloadListener = new CustomMessageListener(2001118) { // from class: com.baidu.tbadk.distribute.a.4
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
                                    a.this.E(downloadData.getId(), downloadData.getStatus());
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
    private HashMap<String, AdvertAppInfo> aXD = new HashMap<>();
    private HashMap<String, AdvertAppInfo> aXE = new HashMap<>();
    private HashMap<String, DownloadStaticsData> aXF = new HashMap<>();
    private ArrayList<AdReq> aXx = new ArrayList<>();
    private ArrayList<AdvertAppInfo> aXB = new ArrayList<>();
    private ArrayList<AdvertAppInfo> aXC = new ArrayList<>();
    private boolean isUpload = true;
    private long aXy = 60000;
    private int uploadSize = 10;
    private boolean aXw = j.kV();

    public static a LK() {
        return aXv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ck(boolean z) {
        if (this.aXw != z) {
            this.aXw = z;
            if (z) {
                cn(true);
            } else {
                LL();
            }
        }
    }

    private void LL() {
        this.handler.removeMessages(1);
    }

    private void LM() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.aXy);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aXx != null && this.aXx.size() < 20) {
            this.aXx.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void N(List<AdReq> list) {
        if (this.aXx != null) {
            this.aXx.addAll(list);
        }
    }

    private a() {
    }

    public void cl(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(LN());
        messageManager.registerListener(this.aXz);
        messageManager.registerListener(this.aXA);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask LN() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void cm(boolean z) {
        this.isUpload = z;
    }

    public void fC(int i) {
        if (i > 3600) {
            this.aXy = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.aXy = 60000L;
        } else {
            this.aXy = i * 1000;
        }
    }

    public void fD(int i) {
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
            if (TextUtils.equals(str3, AiAppsUBCStatistic.TYPE_CLICK) || TextUtils.equals(str3, OpenAppAction.PARAMS_DOWNLOAD_KEY)) {
                if (this.aXw) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            cn(false);
        }
    }

    private boolean LO() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cn(boolean z) {
        if (this.aXw && this.isUpload) {
            List<AdReq> co = co(z);
            if (z || !LO()) {
                LM();
            }
            if (co != null && co.size() != 0) {
                if (!z) {
                    LM();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(co));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aXx.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> co(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aXx.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aXx);
                this.aXx.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask getSocketTask() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.L(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aXB, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aXC, str, str2, j);
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
                            sb.append(advertAppInfo.apz).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.apq).append("|");
                            sb4.append(advertAppInfo.apB.apJ).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.apr).append("|");
                            sb8.append(advertAppInfo.firstName).append("|");
                            sb9.append(advertAppInfo.apx).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.apz);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.apq);
                            sb4.append(advertAppInfo.apB.apJ);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.apr);
                            sb8.append(advertAppInfo.firstName);
                            sb9.append(advertAppInfo.apx);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.aO(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(l.aQ(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), ETAG.KEY_BAIDU_ID, TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.aXD.remove(str);
        if (remove != null) {
            this.aXE.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.aXF.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        b a = f.a(downloadStaticsData, 101, 0);
        a.cA("dl", IntentConfig.START);
        c.bvu().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String str, int i) {
        b a;
        String str2;
        AdvertAppInfo remove = this.aXE.remove(str);
        DownloadStaticsData remove2 = this.aXF.remove(str);
        if (remove != null) {
            a = f.c(remove, 101, 0);
        } else if (remove2 != null) {
            a = f.a(remove2, 101, 0);
            a.setDownloadStaticsData(null);
        } else {
            return;
        }
        if (remove != null || remove2 != null) {
            if (i == 0) {
                str2 = "success";
            } else if (i == 2) {
                str2 = "fail";
            } else if (i == 4) {
                str2 = AiAppsUBCStatistic.VALUE_CANCEL;
            } else {
                return;
            }
            a.cA("dl", str2);
            c.bvu().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            b a = f.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.cA("dl", WriteImageActivityConfig.DELET_FLAG);
            c.bvu().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.aXD.put(advertAppInfo.apv, advertAppInfo);
    }
}
