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
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.mobads.interfaces.utils.IXAdCommonUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
import com.baidu.tieba.recapp.report.c;
import com.baidu.tieba.recapp.report.d;
import com.baidu.tieba.recapp.report.g;
import com.baidu.webkit.internal.ETAG;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.LogTogether.AdReq;
/* loaded from: classes.dex */
public class a {
    public static String fmC = null;
    private static a fmD = new a();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.distribute.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.jY(true);
                    return;
                default:
                    return;
            }
        }
    };
    private com.baidu.adp.framework.listener.a fmI = new com.baidu.adp.framework.listener.a(1003000, CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG) { // from class: com.baidu.tbadk.distribute.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.by(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    };
    private CustomMessageListener fmJ = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.distribute.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isWifiNet() || j.isMobileNet()) {
                    a.this.jV(true);
                } else {
                    a.this.jV(false);
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
                                    a.this.au(downloadData.getId(), downloadData.getStatus());
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
    private HashMap<String, AdvertAppInfo> fmM = new HashMap<>();
    private HashMap<String, AdvertAppInfo> fmN = new HashMap<>();
    private HashMap<String, DownloadStaticsData> fmO = new HashMap<>();
    private ArrayList<AdReq> fmF = new ArrayList<>();
    private ArrayList<AdvertAppInfo> fmK = new ArrayList<>();
    private ArrayList<AdvertAppInfo> fmL = new ArrayList<>();
    private boolean isUpload = true;
    private long fmG = 60000;
    private int fmH = 10;
    private boolean fmE = j.isNetWorkAvailable();

    public static a bzk() {
        return fmD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jV(boolean z) {
        if (this.fmE != z) {
            this.fmE = z;
            if (z) {
                jY(true);
            } else {
                bzl();
            }
        }
    }

    private void bzl() {
        this.handler.removeMessages(1);
    }

    private void bzm() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.fmG);
    }

    private synchronized void a(AdReq adReq) {
        if (this.fmF != null && this.fmF.size() < 20) {
            this.fmF.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void by(List<AdReq> list) {
        if (this.fmF != null) {
            this.fmF.addAll(list);
        }
    }

    private a() {
    }

    public void jW(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(bzp());
        }
        messageManager.registerTask(bzn());
        messageManager.registerListener(this.fmI);
        messageManager.registerListener(this.fmJ);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask bzn() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(1003000, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=" + CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void jX(boolean z) {
        this.isUpload = z;
    }

    public void rd(int i) {
        if (i > 3600) {
            this.fmG = 300000L;
        } else if (i <= 0) {
            this.fmG = 60000L;
        } else {
            this.fmG = i * 1000;
        }
    }

    public void re(int i) {
        if (i > 20) {
            this.fmH = 10;
        } else if (i <= 0) {
            this.fmH = 5;
        } else {
            this.fmH = i;
        }
    }

    public void a(AdvertAppInfo advertAppInfo, String str, long j, String str2, String str3, int i) {
        if (advertAppInfo != null) {
            AdReq a2 = advertAppInfo.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a2);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.fmE) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a2));
                } else {
                    a(a2);
                }
            }
            jY(false);
        }
    }

    private boolean bzo() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jY(boolean z) {
        if (this.fmE && this.isUpload) {
            List<AdReq> jZ = jZ(z);
            if (z || !bzo()) {
                bzm();
            }
            if (jZ != null && jZ.size() != 0) {
                if (!z) {
                    bzm();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(jZ));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.fmF.size() < r3.fmH) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> jZ(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.fmF.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.fmF);
                this.fmF.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask bzp() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        socketMessageTask.setNeedAck(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.fmK, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.fmL, str, str2, j);
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
                            sb.append(advertAppInfo.eyV).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.eyO).append("|");
                            sb4.append(advertAppInfo.eyX.ezf).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.eyP).append("|");
                            sb8.append(advertAppInfo.cHj).append("|");
                            sb9.append(advertAppInfo.eyT).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.eyV);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.eyO);
                            sb4.append(advertAppInfo.eyX.ezf);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.eyP);
                            sb8.append(advertAppInfo.cHj);
                            sb9.append(advertAppInfo.eyT);
                            sb10.append(advertAppInfo.cpid);
                            sb11.append(advertAppInfo.abtest);
                        }
                    }
                    i = i2 + 1;
                } else {
                    StringBuilder sb12 = new StringBuilder(15);
                    sb12.append(String.valueOf(l.getEquipmentWidth(context)));
                    sb12.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb12.append(String.valueOf(l.getEquipmentHeight(context)));
                    TiebaStatic.eventStat(context, "ad_distribute", null, 1, "da_task", "tbda", "da_page", str, "da_locate", sb2, "da_type", "show", "da_obj_id", sb3, "fid", str2, "tid", Long.valueOf(j), "da_good_id", sb4, "da_ext_info", sb5, "da_price", sb6, "da_verify", sb, "cuid", TbadkCoreApplication.getInst().getCuid(), "uid", TbadkCoreApplication.getCurrentAccount(), ETAG.KEY_BAIDU_ID, TbadkCoreApplication.getCurrentBduss(), "da_obj_name", sb7, "da_first_name", sb8, "da_second_name", sb9, "da_cpid", sb10, "da_abtest", sb11, "da_stime", Long.valueOf(System.currentTimeMillis()), "phone_screen", sb12.toString(), "model", Build.MODEL);
                    arrayList.clear();
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, DownloadStaticsData downloadStaticsData) {
        AdvertAppInfo remove = this.fmM.remove(str);
        if (remove != null) {
            this.fmN.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.fmO.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        c a2 = g.a(downloadStaticsData, 101, 0);
        a2.ge(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, "start");
        d.dBp().a(a2);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(String str, int i) {
        c a2;
        String str2;
        AdvertAppInfo remove = this.fmN.remove(str);
        DownloadStaticsData remove2 = this.fmO.remove(str);
        if (remove != null) {
            a2 = g.c(remove, 101, 0);
        } else if (remove2 != null) {
            a2 = g.a(remove2, 101, 0);
            a2.setDownloadStaticsData(null);
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
            a2.ge(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, str2);
            d.dBp().a(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            c a2 = g.a(downloadStaticsData, 101, 0);
            a2.setDownloadStaticsData(null);
            a2.ge(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, "delete");
            d.dBp().a(a2);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.fmM.put(advertAppInfo.eyR, advertAppInfo);
    }
}
