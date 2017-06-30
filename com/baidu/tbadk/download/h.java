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
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.n;
import com.baidu.tieba.w;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h azp;
    private static DownloadData azr;
    private static List<DownloadData> azs = new LinkedList();
    private SparseArray<c> azq = new SparseArray<>();

    public static h CD() {
        synchronized (h.class) {
            if (azp == null) {
                azp = new h();
            }
        }
        return azp;
    }

    private h() {
        CE();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.azq.get(i2) == null) {
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
            azs.add(downloadData);
            Cw();
        }
    }

    private void Cw() {
        if (azr == null && !azs.isEmpty()) {
            azr = azs.get(0);
            if (azr != null) {
                j(i(azr));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String x(String str, int i) {
        c ev = ev(i);
        StringBuilder sb = new StringBuilder();
        sb.append(ev.azh).append("/").append(ev.azi).append("/").append(str);
        if (!StringUtils.isNull(ev.azj)) {
            sb.append(".").append(ev.azj);
        }
        return sb.toString();
    }

    public void eu(int i) {
        List<DownloadData> jP = e.Cy().jP();
        if (jP != null && jP.size() != 0) {
            for (DownloadData downloadData : jP) {
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
            if (!aw.isEmpty(id) && !aw.isEmpty(name)) {
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
                e.Cy().a(downloadData, ev(downloadData.getType()).maxSize);
            }
            azr = null;
            if (!azs.isEmpty()) {
                azs.remove(0);
                Cw();
            }
        }
    }

    private PendingIntent fo(String str) {
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
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fo(downloadData.getAction()), false);
            }
        }
    }

    public int aj(String str, String str2) {
        long ak = ak(str, str2);
        long j = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (ak <= j) {
            return (int) ((ak * 100) / j);
        }
        return 0;
    }

    public boolean ft(String str) {
        for (DownloadData downloadData : e.Cy().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fu(String str) {
        for (DownloadData downloadData : e.Cy().jP()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void y(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Cy().jP()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Cy().w(str, i);
        if (downloadData != null) {
            int aj = aj(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(aj) + "%";
            if (downloadData != null && aj >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_cancel), aj, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(w.l.download_cancel), fo(downloadData.getAction()), false);
            }
        }
    }

    public boolean al(String str, String str2) {
        File dm = n.dm(String.valueOf(str) + "_" + str2 + ".tmp");
        return dm != null && dm.exists() && dm.isFile();
    }

    public long ak(String str, String str2) {
        File dm = n.dm(String.valueOf(str) + "_" + str2 + ".tmp");
        if (dm != null && dm.exists() && dm.isFile()) {
            return dm.length();
        }
        return -1L;
    }

    public File am(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return n.dm(String.valueOf(str) + "_" + str2 + ".tmp");
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
        this.azq.put(i, cVar);
    }

    public c ev(int i) {
        c cVar = this.azq.get(i);
        if (cVar == null) {
            return this.azq.get(10);
        }
        return cVar;
    }

    private void CE() {
        c cVar = new c();
        cVar.azh = new File(n.uv());
        cVar.azi = "common";
        cVar.azj = "";
        this.azq.put(10, cVar);
    }
}
