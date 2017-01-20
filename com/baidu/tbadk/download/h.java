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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.l;
import com.baidu.tieba.r;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h asR;
    private static DownloadData asT;
    private static List<DownloadData> asU = new LinkedList();
    private SparseArray<c> asS = new SparseArray<>();

    public static h Ct() {
        synchronized (h.class) {
            if (asR == null) {
                asR = new h();
            }
        }
        return asR;
    }

    private h() {
        Cu();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.asS.get(i2) == null) {
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
            asU.add(downloadData);
            Cm();
        }
    }

    private void Cm() {
        if (asT == null && !asU.isEmpty()) {
            asT = asU.get(0);
            if (asT != null) {
                j(i(asT));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String z(String str, int i) {
        c ey = ey(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ey.asJ).append("/").append(ey.asK).append("/").append(str);
        if (!StringUtils.isNull(ey.asL)) {
            sb.append(".").append(ey.asL);
        }
        return sb.toString();
    }

    public void ex(int i) {
        List<DownloadData> iT = e.Co().iT();
        if (iT != null && iT.size() != 0) {
            for (DownloadData downloadData : iT) {
                if (downloadData.getType() == i) {
                    A(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData i(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!at.isEmpty(id) && !at.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String z = z(id, type);
                File file = new File(z);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
                    downloadData.setPath(z);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(z);
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
                e.Co().a(downloadData, ey(downloadData.getType()).maxSize);
            }
            asT = null;
            if (!asU.isEmpty()) {
                asU.remove(0);
                Cm();
            }
        }
    }

    private PendingIntent fe(String str) {
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
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(r.l.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fe(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((am * 100) / j);
        }
        return 0;
    }

    public boolean fj(String str) {
        for (DownloadData downloadData : e.Co().iT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fk(String str) {
        for (DownloadData downloadData : e.Co().iT()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void A(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Co().iT()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Co().y(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(al) + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.download_cancel), al, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(r.l.download_cancel), fe(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        return cX != null && cX.exists() && cX.isFile();
    }

    public long am(String str, String str2) {
        File cX = l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cX != null && cX.exists() && cX.isFile()) {
            return cX.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return l.cX(String.valueOf(str) + "_" + str2 + ".tmp");
    }

    public boolean B(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(z(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File C(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(z(str, i));
    }

    public void a(int i, c cVar) {
        this.asS.put(i, cVar);
    }

    public c ey(int i) {
        c cVar = this.asS.get(i);
        if (cVar == null) {
            return this.asS.get(10);
        }
        return cVar;
    }

    private void Cu() {
        c cVar = new c();
        cVar.asJ = new File(l.ua());
        cVar.asK = "common";
        cVar.asL = "";
        this.asS.put(10, cVar);
    }
}
