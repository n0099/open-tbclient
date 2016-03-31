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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.t;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h ati;
    private static DownloadData atk;
    private static List<DownloadData> atl = new LinkedList();
    private SparseArray<c> atj = new SparseArray<>();

    public static h De() {
        synchronized (h.class) {
            if (ati == null) {
                ati = new h();
            }
        }
        return ati;
    }

    private h() {
        Df();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        if (this.atj.get(i2) == null) {
            throw new RuntimeException("you need register downloadType first");
        }
        DownloadData downloadData = new DownloadData(str);
        downloadData.setType(i2);
        downloadData.setId(str);
        downloadData.setUrl(str2);
        downloadData.setName(str3);
        downloadData.setNotifyId(i);
        downloadData.setNeedInvokeApk(false);
        o(downloadData);
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            atl.add(downloadData);
            CY();
        }
    }

    private void CY() {
        if (atk == null && !atl.isEmpty()) {
            atk = atl.get(0);
            if (atk != null) {
                q(p(atk));
            }
        }
    }

    public void h(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String y(String str, int i) {
        c ex = ex(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ex.ata).append("/").append(ex.atb).append("/").append(str);
        if (!StringUtils.isNull(ex.atc)) {
            sb.append(".").append(ex.atc);
        }
        return sb.toString();
    }

    public void ew(int i) {
        List<DownloadData> lL = e.Da().lL();
        if (lL != null && lL.size() != 0) {
            for (DownloadData downloadData : lL) {
                if (downloadData.getType() == i) {
                    z(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData p(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ay.isEmpty(id) && !ay.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String y = y(id, type);
                File file = new File(y);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
                    downloadData.setPath(y);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(y);
                downloadData2.setStatus(3);
                return downloadData2;
            }
            return downloadData;
        }
        return downloadData;
    }

    private void q(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 3) {
                h(downloadData);
                if (downloadData.isNeedInvokeApk()) {
                    UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.Da().a(downloadData, ex(downloadData.getType()).maxSize);
            }
            atk = null;
            if (!atl.isEmpty()) {
                atl.remove(0);
                CY();
            }
        }
    }

    private PendingIntent fc(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m411getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m411getInst().getString(t.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fc(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long ao = ao(str, str2);
        long j = TbadkCoreApplication.m411getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ao <= j) {
            return (int) ((ao * 100) / j);
        }
        return 0;
    }

    public boolean fi(String str) {
        for (DownloadData downloadData : e.Da().lL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fe(String str) {
        for (DownloadData downloadData : e.Da().lL()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void z(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Da().lL()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Da().x(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(al) + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), al, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m411getInst().getApp().getResources().getString(t.j.download_cancel), fc(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        return cU != null && cU.exists() && cU.isFile();
    }

    public long ao(String str, String str2) {
        File cU = m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cU != null && cU.exists() && cU.isFile()) {
            return cU.length();
        }
        return -1L;
    }

    public File ap(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return m.cU(String.valueOf(str) + "_" + str2 + ".tmp");
    }

    public boolean A(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(y(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File B(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(y(str, i));
    }

    public void a(int i, c cVar) {
        this.atj.put(i, cVar);
    }

    public c ex(int i) {
        c cVar = this.atj.get(i);
        if (cVar == null) {
            return this.atj.get(10);
        }
        return cVar;
    }

    private void Df() {
        c cVar = new c();
        cVar.ata = new File(m.vt());
        cVar.atb = "common";
        cVar.atc = "";
        this.atj.put(10, cVar);
    }
}
