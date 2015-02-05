package com.baidu.tbadk.download;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.z;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b Xz = null;
    private static e XD = null;
    private static List<e> XE = new LinkedList();
    private final int max = 5;
    private int XA = 0;
    private c XB = null;
    private d XC = null;
    private int progress = 0;
    private String schedule = null;

    private b() {
    }

    public static b uV() {
        synchronized (b.class) {
            if (Xz == null) {
                Xz = new b();
            }
        }
        return Xz;
    }

    public void a(String str, String str2, String str3, int i, int i2) {
        if (this.XA >= 5) {
            Toast.makeText(TbadkCoreApplication.m255getInst(), z.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        this.XA++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        downloadData.setNotifyId(i2);
        e(downloadData);
        e eVar = new e(this);
        eVar.setKey(str);
        eVar.setUrl(str2);
        eVar.setName(str3);
        eVar.setPosition(i);
        eVar.dj(i2);
        XE.add(eVar);
        uW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uW() {
        if (XD == null && !XE.isEmpty()) {
            XD = XE.get(0);
            if (XD != null) {
                this.XB = new c(this, null);
                this.XB.setPriority(3);
                this.XB.execute(XD);
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
            this.XA--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void l(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void v(ArrayList<com.baidu.tbadk.core.data.c> arrayList) {
        this.XC = new d(this, null);
        this.XC.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String at(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.on());
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
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m255getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m255getInst().getApp().getResources().getString(z.download_will_begin), this.progress, this.schedule, downloadData.getName(), false);
        }
    }

    public void g(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m255getInst().getString(z.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m255getInst().getString(z.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m255getInst().getString(z.download_fail_tip_net);
                    break;
            }
            NotificationHelper.showProgressNotification(TbadkCoreApplication.m255getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m255getInst().getApp().getResources().getString(z.download_fail_tip), this.progress, String.valueOf(this.progress) + "%", string, false);
        }
    }

    public boolean dO(String str) {
        for (DownloadData downloadData : g.uZ().vb()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean dP(String str) {
        return (TextUtils.isEmpty(str) || s.ce(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
