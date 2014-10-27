package com.baidu.tbadk.download;

import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.s;
import com.baidu.tieba.y;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class b {
    private static b QV = null;
    private static e QZ = null;
    private static List<e> Ra = new LinkedList();
    private final int max = 5;
    private int QW = 0;
    private c QX = null;
    private d QY = null;
    private int Rb = 1000;
    private int progress = 0;
    private String schedule = null;

    private b() {
    }

    public static b rh() {
        synchronized (b.class) {
            if (QV == null) {
                QV = new b();
            }
        }
        return QV;
    }

    public void a(String str, String str2, String str3, int i) {
        if (this.QW > 5) {
            Toast.makeText(TbadkApplication.m251getInst(), y.download_fail_over_max, 0).show();
            return;
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(12);
        this.QW++;
        downloadData.setStatus(1);
        downloadData.setStatusMsg(null);
        a(downloadData);
        e eVar = new e(this);
        eVar.setKey(str);
        eVar.setUrl(str2);
        eVar.setName(str3);
        eVar.setPosition(i);
        Ra.add(eVar);
        ri();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        if (QZ == null && !Ra.isEmpty()) {
            QZ = Ra.get(0);
            if (QZ != null) {
                this.QX = new c(this, null);
                this.QX.setPriority(3);
                this.QX.execute(QZ);
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
        if (downloadData.getStatus() != 1 && downloadData.getStatus() != 5) {
            this.QW--;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(linkedList));
    }

    public void h(List<DownloadData> list) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new DownloadMessage(list));
    }

    public void j(ArrayList<com.baidu.tbadk.core.data.a> arrayList) {
        this.QY = new d(this, null);
        this.QY.execute(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String aq(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.lw());
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
            NotificationHelper.showProgressNotification(TbadkApplication.m251getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkApplication.m251getInst().getApp().getResources().getString(y.download_will_begin), this.progress, this.schedule, downloadData.getName(), false);
        }
    }

    public void c(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkApplication.m251getInst().getString(y.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkApplication.m251getInst().getString(y.download_fail_tip);
                    break;
                case 3:
                    string = TbadkApplication.m251getInst().getString(y.download_fail_tip_net);
                    break;
            }
            NotificationHelper.showProgressNotification(TbadkApplication.m251getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkApplication.m251getInst().getApp().getResources().getString(y.download_fail_tip), this.progress, this.schedule, string, false);
        }
    }

    public boolean cV(String str) {
        for (DownloadData downloadData : g.rk().rm()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean cW(String str) {
        return (TextUtils.isEmpty(str) || s.br(new StringBuilder(String.valueOf(str.replace(".", "_"))).append(".apk").toString()) == null) ? false : true;
    }
}
