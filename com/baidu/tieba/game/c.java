package com.baidu.tieba.game;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
import com.baidu.tbadk.download.DownloadMessage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class c {
    private static c aGN = null;
    private static f aGQ = null;
    private static List<f> Re = new LinkedList();
    private final int max = 10;
    private d aGO = null;
    private e aGP = null;
    private int progress = 0;
    private String schedule = null;

    private c() {
    }

    public static c Hf() {
        synchronized (c.class) {
            if (aGN == null) {
                aGN = new c();
            }
        }
        return aGN;
    }

    public void d(String str, String str2, String str3, String str4) {
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        List<DownloadData> ro = com.baidu.tbadk.download.g.rm().ro();
        if (ro != null && ro.size() >= 10) {
            downloadData.setStatus(2);
            downloadData.setStatusMsg(com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.download_fail_over_max));
            downloadData.setTag(str4);
            a(downloadData);
            UtilHelper.showToast(TbadkApplication.m251getInst(), com.baidu.tieba.y.download_fail_over_max);
            return;
        }
        f fVar = new f(this);
        fVar.setKey(str);
        fVar.setUrl(str2);
        fVar.setName(str3);
        fVar.setTag(str4);
        Re.add(fVar);
        rk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rk() {
        if (aGQ == null && !Re.isEmpty()) {
            aGQ = Re.get(0);
            if (aGQ != null) {
                this.aGO = new d(this, null);
                this.aGO.setPriority(3);
                this.aGO.execute(aGQ);
            }
        }
    }

    public String getFileOfUrl(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.contains("?")) {
            str = str.substring(0, str.indexOf("?"));
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void a(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void h(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(com.baidu.tbadk.core.util.s.lw());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            this.progress = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(downloadData.getLength() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(downloadData.getSize() / 1000));
            sb.append("K");
            this.schedule = sb.toString();
            NotificationHelper.showProgressNotification(com.baidu.tieba.aj.wm().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + com.baidu.tieba.aj.wm().getApp().getResources().getString(com.baidu.tieba.y.download_will_begin), this.progress, this.schedule, downloadData.getName(), false);
        }
    }

    public void c(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.download_fail_tip);
                    break;
                case 3:
                    string = com.baidu.tieba.aj.wm().getApp().getString(com.baidu.tieba.y.download_fail_tip_net);
                    break;
            }
            this.progress = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(downloadData.getLength() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(downloadData.getSize() / 1000));
            sb.append("K");
            this.schedule = sb.toString();
            NotificationHelper.showProgressNotification(com.baidu.tieba.aj.wm().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + com.baidu.tieba.aj.wm().getApp().getResources().getString(com.baidu.tieba.y.download_fail_tip), this.progress, this.schedule, string, false);
        }
    }

    public boolean fj(String str) {
        for (DownloadData downloadData : com.baidu.tbadk.download.g.rm().ro()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public float fk(String str) {
        for (DownloadData downloadData : com.baidu.tbadk.download.g.rm().ro()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return ((float) downloadData.getLength()) / ((float) downloadData.getSize());
            }
        }
        return -1.0f;
    }

    public boolean fl(String str) {
        for (DownloadData downloadData : com.baidu.tbadk.download.g.rm().ro()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void af(String str, String str2) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : com.baidu.tbadk.download.g.rm().ro()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str2)) {
                downloadData = downloadData2;
            }
        }
        com.baidu.tbadk.download.g.rm().cX(str);
        if (downloadData != null) {
            NotificationHelper.showProgressNotification(com.baidu.tieba.aj.wm().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + com.baidu.tieba.aj.wm().getApp().getResources().getString(com.baidu.tieba.y.download_cancel), this.progress, this.schedule, String.valueOf(downloadData.getName()) + com.baidu.tieba.aj.wm().getApp().getResources().getString(com.baidu.tieba.y.download_cancel), false);
        }
    }

    public boolean ag(String str, String str2) {
        File br = com.baidu.tbadk.core.util.s.br(String.valueOf(str) + "_" + str2 + ".tmp");
        return br != null && br.exists() && br.isFile();
    }

    public long ah(String str, String str2) {
        File br = com.baidu.tbadk.core.util.s.br(String.valueOf(str) + "_" + str2 + ".tmp");
        if (br != null && br.exists() && br.isFile()) {
            return br.length();
        }
        return -1L;
    }

    public boolean fm(String str) {
        return (TextUtils.isEmpty(str) || com.baidu.tbadk.core.util.s.br(new StringBuilder(String.valueOf(str)).append(".apk").toString()) == null) ? false : true;
    }

    public File fn(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.baidu.tbadk.core.util.s.br(String.valueOf(str) + ".apk");
    }
}
