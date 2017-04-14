package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.w;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h ayC;
    private static DownloadData ayE;
    private static List<DownloadData> ayF = new LinkedList();
    private SparseArray<c> ayD = new SparseArray<>();

    public static h Dk() {
        synchronized (h.class) {
            if (ayC == null) {
                ayC = new h();
            }
        }
        return ayC;
    }

    private h() {
        Dl();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.ayD.get(i2) == null) {
            throw new RuntimeException("you need register downloadType first");
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(i2);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setNotifyId(i);
        downloadData.setNeedInvokeApk(false);
        downloadData.setNeedNotify(z);
        h(downloadData);
    }

    private void h(DownloadData downloadData) {
        if (downloadData != null) {
            ayF.add(downloadData);
            Dd();
        }
    }

    private void Dd() {
        if (ayE == null && !ayF.isEmpty()) {
            ayE = ayF.get(0);
            if (ayE != null) {
                j(i(ayE));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String x(String str, int i) {
        c ew = ew(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ew.ayu).append("/").append(ew.ayv).append("/").append(str);
        if (!StringUtils.isNull(ew.ayw)) {
            sb.append(".").append(ew.ayw);
        }
        return sb.toString();
    }

    public void ev(int i) {
        List<DownloadData> jR = e.Df().jR();
        if (jR != null && jR.size() != 0) {
            for (DownloadData downloadData : jR) {
                if (downloadData.getType() == i) {
                    y(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData i(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!au.isEmpty(id) && !au.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String x = x(id, type);
                File file = new File(x);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
                    downloadData.setPath(x);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(x);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            return downloadData;
        }
        return downloadData;
    }

    private void j(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                b(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.Df().a(downloadData, ew(downloadData.getType()).maxSize);
            }
            ayE = null;
            if (!ayF.isEmpty()) {
                ayF.remove(0);
                Dd();
            }
        }
    }

    private PendingIntent eZ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void k(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(w.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, eZ(downloadData.getAction()), false);
            }
        }
    }

    public int ak(String str, String str2) {
        long al = al(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (al <= j) {
            return (int) ((al * 100) / j);
        }
        return 0;
    }

    public boolean fe(String str) {
        for (DownloadData downloadData : e.Df().jR()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : e.Df().jR()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void y(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Df().jR()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Df().w(str, i);
        if (downloadData != null) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(ak) + "%";
            if (downloadData != null && ak >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_cancel), ak, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_cancel), eZ(downloadData.getAction()), false);
            }
        }
    }

    public boolean am(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        return cX != null && cX.exists() && cX.isFile();
    }

    public long al(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cX != null && cX.exists() && cX.isFile()) {
            return cX.length();
        }
        return -1L;
    }

    public File an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
    }

    public boolean z(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(x(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File A(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(x(str, i));
    }

    public void a(int i, c cVar) {
        this.ayD.put(i, cVar);
    }

    public c ew(int i) {
        c cVar = this.ayD.get(i);
        if (cVar == null) {
            return this.ayD.get(10);
        }
        return cVar;
    }

    private void Dl() {
        c cVar = new c();
        cVar.ayu = new File(l.uV());
        cVar.ayv = "common";
        cVar.ayw = "";
        this.ayD.put(10, cVar);
    }
}
