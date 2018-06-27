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
import com.baidu.sapi2.views.SmsLoginView;
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
import com.baidu.tieba.recapp.report.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String aLk = null;
    private static a aLl = new a();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.distribute.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.bB(true);
                    return;
                default:
                    return;
            }
        }
    };
    private com.baidu.adp.framework.listener.a aLp = new com.baidu.adp.framework.listener.a(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, 303101) { // from class: com.baidu.tbadk.distribute.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.E(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    };
    private CustomMessageListener aLq = new CustomMessageListener(2000994) { // from class: com.baidu.tbadk.distribute.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.jE() || j.jF()) {
                    a.this.by(true);
                } else {
                    a.this.by(false);
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
                                    a.this.y(downloadData.getId(), downloadData.getStatus());
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
    private HashMap<String, AdvertAppInfo> aLt = new HashMap<>();
    private HashMap<String, AdvertAppInfo> aLu = new HashMap<>();
    private HashMap<String, DownloadStaticsData> aLv = new HashMap<>();
    private ArrayList<AdReq> aLn = new ArrayList<>();
    private ArrayList<AdvertAppInfo> aLr = new ArrayList<>();
    private ArrayList<AdvertAppInfo> aLs = new ArrayList<>();
    private boolean isUpload = true;
    private long aLo = 60000;
    private int uploadSize = 10;
    private boolean aLm = j.jD();

    public static a Hj() {
        return aLl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void by(boolean z) {
        if (this.aLm != z) {
            this.aLm = z;
            if (z) {
                bB(true);
            } else {
                Hk();
            }
        }
    }

    private void Hk() {
        this.handler.removeMessages(1);
    }

    private void Hl() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.aLo);
    }

    private synchronized void a(AdReq adReq) {
        if (this.aLn != null && this.aLn.size() < 20) {
            this.aLn.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void E(List<AdReq> list) {
        if (this.aLn != null) {
            this.aLn.addAll(list);
        }
    }

    private a() {
    }

    public void bz(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(getSocketTask());
        }
        messageManager.registerTask(Hm());
        messageManager.registerListener(this.aLp);
        messageManager.registerListener(this.aLq);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask Hm() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(CmdConfigHttp.DISTRIBUTE_ACTRUAL_CMD, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=303101");
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void bA(boolean z) {
        this.isUpload = z;
    }

    public void eD(int i) {
        if (i > 3600) {
            this.aLo = ReportUserInfoModel.TIME_INTERVAL;
        } else if (i <= 0) {
            this.aLo = 60000L;
        } else {
            this.aLo = i * 1000;
        }
    }

    public void eE(int i) {
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
            if (TextUtils.equals(str3, SmsLoginView.StatEvent.LOGIN_SHOW)) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.aLm) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            bB(false);
        }
    }

    private boolean Hn() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bB(boolean z) {
        if (this.aLm && this.isUpload) {
            List<AdReq> bC = bC(z);
            if (z || !Hn()) {
                Hl();
            }
            if (bC != null && bC.size() != 0) {
                if (!z) {
                    Hl();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(bC));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.aLn.size() < r3.uploadSize) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> bC(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.aLn.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.aLn);
                this.aLn.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask getSocketTask() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(303101);
        socketMessageTask.p(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void a(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.aLr, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.aLs, str, str2, j);
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
                            sb.append(advertAppInfo.aek).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.aea).append("|");
                            sb4.append(advertAppInfo.aem.aeu).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.aeb).append("|");
                            sb8.append(advertAppInfo.aeh).append("|");
                            sb9.append(advertAppInfo.aei).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.aek);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.aea);
                            sb4.append(advertAppInfo.aem.aeu);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.aeb);
                            sb8.append(advertAppInfo.aeh);
                            sb9.append(advertAppInfo.aei);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.ah(context)));
                    sb12.append(",");
                    sb12.append(String.valueOf(l.aj(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", SmsLoginView.StatEvent.LOGIN_SHOW, "da_obj_id", sb3, ImageViewerConfig.FORUM_ID, str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), "baiduid", TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.aLt.remove(str);
        if (remove != null) {
            this.aLu.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.aLv.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        com.baidu.tieba.recapp.report.a a = e.a(downloadStaticsData, 101, 0);
        a.cd("dl", IntentConfig.START);
        b.bpD().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(String str, int i) {
        com.baidu.tieba.recapp.report.a a;
        String str2;
        AdvertAppInfo remove = this.aLu.remove(str);
        DownloadStaticsData remove2 = this.aLv.remove(str);
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
                str2 = "success";
            } else if (i == 2) {
                str2 = "fail";
            } else if (i == 4) {
                str2 = "cancel";
            } else {
                return;
            }
            a.cd("dl", str2);
            b.bpD().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            com.baidu.tieba.recapp.report.a a = e.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.cd("dl", WriteImageActivityConfig.DELET_FLAG);
            b.bpD().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.aLt.put(advertAppInfo.aef, advertAppInfo);
    }
}
