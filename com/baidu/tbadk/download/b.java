package com.baidu.tbadk.download;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.o;
import com.baidu.tieba.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b ahF = null;
    private static e ahJ = null;
    private static List<e> ahK = new LinkedList();
    private final int max = 5;
    private int ahG = 0;
    private c ahH = null;
    private d ahI = null;
    private int progress = 0;
    private String schedule = null;

    private b() {
    }

    public static b yl() {
        synchronized (b.class) {
            if (ahF == null) {
                ahF = new b();
            }
        }
        return ahF;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        if (this.ahG >= 5) {
            Toast.makeText(TbadkCoreApplication.m411getInst(), y.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        this.ahG++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        downloadData.setNotifyId(i2);
        e(downloadData);
        e eVar = new e(this);
        eVar.setKey(str);
        eVar.setUrl(str2);
        eVar.setName(str3);
        eVar.setPosition(i);
        eVar.dl(i2);
        ahK.add(eVar);
        ym();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ym() {
        if (ahJ == null && !ahK.isEmpty()) {
            ahJ = ahK.get(0);
            if (ahJ != null) {
                this.ahH = new c(this, null);
                this.ahH.setPriority(3);
                this.ahH.execute(ahJ);
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

    public void e(DownloadData downloadData) {
        if (downloadData.getStatus() != 1 && downloadData.getStatus() != 5) {
            this.ahG--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void m(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void s(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.ahI = new d(this, null);
        this.ahI.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aA(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(o.rK());
        File file = new File(sb.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        sb.append("/");
        sb.append(str);
        return sb.toString();
    }

    public void f(DownloadData downloadData) {
        if (downloadData != null) {
            this.progress = (int) ((downloadData.getLength() * 100) / downloadData.getSize());
            StringBuilder sb = new StringBuilder(20);
            sb.append(String.valueOf(downloadData.getLength() / 1000));
            sb.append("K/");
            sb.append(String.valueOf(downloadData.getSize() / 1000));
            sb.append("K");
            this.schedule = sb.toString();
            this.schedule = String.valueOf(this.progress) + "%";
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(y.download_will_begin), this.progress, this.schedule, downloadData.getName(), true);
        }
    }

    public void g(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getString(y.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(y.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(y.download_fail_tip_net);
                    break;
            }
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(y.download_fail_tip), this.progress, String.valueOf(this.progress) + "%", string, false);
        }
    }

    public boolean dX(String str) {
        for (DownloadData downloadData : g.yp().lG()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean dY(String str) {
        return (TextUtils.isEmpty(str) || o.cm(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
