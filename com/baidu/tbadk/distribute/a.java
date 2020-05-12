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
    public static String dVZ = null;
    private static a dWa = new a();
    private Handler handler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tbadk.distribute.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    a.this.hx(true);
                    return;
                default:
                    return;
            }
        }
    };
    private com.baidu.adp.framework.listener.a dWf = new com.baidu.adp.framework.listener.a(1003000, CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG) { // from class: com.baidu.tbadk.distribute.a.2
        @Override // com.baidu.adp.framework.listener.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage != null && responsedMessage.hasError()) {
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                if (extra instanceof DistributeRequest) {
                    a.this.aP(((DistributeRequest) extra).getAdReqList());
                }
            }
        }
    };
    private CustomMessageListener dWg = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tbadk.distribute.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                if (j.isWifiNet() || j.isMobileNet()) {
                    a.this.hu(true);
                } else {
                    a.this.hu(false);
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
                                    a.this.am(downloadData.getId(), downloadData.getStatus());
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
    private HashMap<String, AdvertAppInfo> dWj = new HashMap<>();
    private HashMap<String, AdvertAppInfo> dWk = new HashMap<>();
    private HashMap<String, DownloadStaticsData> dWl = new HashMap<>();
    private ArrayList<AdReq> dWc = new ArrayList<>();
    private ArrayList<AdvertAppInfo> dWh = new ArrayList<>();
    private ArrayList<AdvertAppInfo> dWi = new ArrayList<>();
    private boolean isUpload = true;
    private long dWd = 60000;
    private int dWe = 10;
    private boolean dWb = j.isNetWorkAvailable();

    public static a aWB() {
        return dWa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hu(boolean z) {
        if (this.dWb != z) {
            this.dWb = z;
            if (z) {
                hx(true);
            } else {
                aWC();
            }
        }
    }

    private void aWC() {
        this.handler.removeMessages(1);
    }

    private void aWD() {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, this.dWd);
    }

    private synchronized void a(AdReq adReq) {
        if (this.dWc != null && this.dWc.size() < 20) {
            this.dWc.add(adReq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aP(List<AdReq> list) {
        if (this.dWc != null) {
            this.dWc.addAll(list);
        }
    }

    private a() {
    }

    public void hv(boolean z) {
        MessageManager messageManager = MessageManager.getInstance();
        if (z) {
            messageManager.registerTask(aWG());
        }
        messageManager.registerTask(aWE());
        messageManager.registerListener(this.dWf);
        messageManager.registerListener(this.dWg);
        messageManager.registerListener(this.downloadListener);
    }

    private HttpMessageTask aWE() {
        HttpMessageTask httpMessageTask = new HttpMessageTask(1003000, TbConfig.SERVER_ADDRESS + TbConfig.LOG_TOGETHER + "?cmd=" + CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        httpMessageTask.setResponsedClass(DistributeHttpResponse.class);
        return httpMessageTask;
    }

    public void hw(boolean z) {
        this.isUpload = z;
    }

    public void mw(int i) {
        if (i > 3600) {
            this.dWd = 300000L;
        } else if (i <= 0) {
            this.dWd = 60000L;
        } else {
            this.dWd = i * 1000;
        }
    }

    public void mx(int i) {
        if (i > 20) {
            this.dWe = 10;
        } else if (i <= 0) {
            this.dWe = 5;
        } else {
            this.dWe = i;
        }
    }

    public void a(AdvertAppInfo advertAppInfo, String str, long j, String str2, String str3, int i) {
        if (advertAppInfo != null) {
            AdReq a = advertAppInfo.a(str, j, str2, str3, i);
            if (TextUtils.equals(str3, "show")) {
                a(a);
            }
            if (TextUtils.equals(str3, "click") || TextUtils.equals(str3, "download")) {
                if (this.dWb) {
                    MessageManager.getInstance().sendMessage(new DistributeRequest(a));
                } else {
                    a(a);
                }
            }
            hx(false);
        }
    }

    private boolean aWF() {
        return this.handler.hasMessages(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(boolean z) {
        if (this.dWb && this.isUpload) {
            List<AdReq> hy = hy(z);
            if (z || !aWF()) {
                aWD();
            }
            if (hy != null && hy.size() != 0) {
                if (!z) {
                    aWD();
                }
                MessageManager.getInstance().sendMessage(new DistributeRequest(hy));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r3.dWc.size() < r3.dWe) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized List<AdReq> hy(boolean z) {
        ArrayList arrayList = null;
        synchronized (this) {
            if (!z) {
            }
            if (this.dWc.size() > 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.dWc);
                this.dWc.clear();
            }
        }
        return arrayList;
    }

    private SocketMessageTask aWG() {
        SocketMessageTask socketMessageTask = new SocketMessageTask(CmdConfigSocket.CMD_UPLOAD_ACTUAL_LOG);
        socketMessageTask.setNeedAck(true);
        socketMessageTask.setResponsedClass(DistributeSocketResponse.class);
        return socketMessageTask;
    }

    public void b(Context context, String str, String str2, long j) {
        if (TextUtils.equals(str, "frs")) {
            a(context, this.dWh, str, str2, j);
        } else if (TextUtils.equals(str, "pb")) {
            a(context, this.dWi, str, str2, j);
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
                            sb.append(advertAppInfo.dmz).append("|");
                            sb2.append(advertAppInfo.adPosition).append("|");
                            sb3.append(advertAppInfo.dms).append("|");
                            sb4.append(advertAppInfo.dmB.dmJ).append("|");
                            sb5.append(advertAppInfo.extensionInfo).append("|");
                            sb6.append(advertAppInfo.price).append("|");
                            sb7.append(advertAppInfo.dmt).append("|");
                            sb8.append(advertAppInfo.bKg).append("|");
                            sb9.append(advertAppInfo.dmx).append("|");
                            sb10.append(advertAppInfo.cpid).append("|");
                            sb11.append(advertAppInfo.abtest).append("|");
                        } else {
                            sb.append(advertAppInfo.dmz);
                            sb2.append(advertAppInfo.adPosition);
                            sb3.append(advertAppInfo.dms);
                            sb4.append(advertAppInfo.dmB.dmJ);
                            sb5.append(advertAppInfo.extensionInfo);
                            sb6.append(advertAppInfo.price);
                            sb7.append(advertAppInfo.dmt);
                            sb8.append(advertAppInfo.bKg);
                            sb9.append(advertAppInfo.dmx);
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
        AdvertAppInfo remove = this.dWj.remove(str);
        if (remove != null) {
            this.dWk.put(str, remove);
        } else if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            this.dWl.put(str, downloadStaticsData);
            downloadStaticsData.setDa_page(null);
            downloadStaticsData.setFid(null);
        } else {
            return;
        }
        c a = g.a(downloadStaticsData, 101, 0);
        a.eE(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, "start");
        d.cOj().a(a);
        if (downloadStaticsData != null && "1".equals(downloadStaticsData.getDa_range_nt())) {
            downloadStaticsData.setDa_range_nt("0");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void am(String str, int i) {
        c a;
        String str2;
        AdvertAppInfo remove = this.dWk.remove(str);
        DownloadStaticsData remove2 = this.dWl.remove(str);
        if (remove != null) {
            a = g.c(remove, 101, 0);
        } else if (remove2 != null) {
            a = g.a(remove2, 101, 0);
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
            a.eE(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, str2);
            d.cOj().a(a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(DownloadStaticsData downloadStaticsData) {
        if (downloadStaticsData != null) {
            c a = g.a(downloadStaticsData, 101, 0);
            a.setDownloadStaticsData(null);
            a.eE(IXAdCommonUtils.PKGS_PREF_DOWNLOAD_STATUS, "delete");
            d.cOj().a(a);
        }
    }

    public void b(AdvertAppInfo advertAppInfo) {
        this.dWj.put(advertAppInfo.dmv, advertAppInfo);
    }
}
