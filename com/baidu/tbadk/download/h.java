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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.m;
import com.baidu.tieba.u;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private static h apN;
    private static DownloadData apP;
    private static List<DownloadData> apQ = new LinkedList();
    private SparseArray<c> apO = new SparseArray<>();

    public static h Bi() {
        synchronized (h.class) {
            if (apN == null) {
                apN = new h();
            }
        }
        return apN;
    }

    private h() {
        Bj();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.apO.get(i2) == null) {
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
        o(downloadData);
    }

    private void o(DownloadData downloadData) {
        if (downloadData != null) {
            apQ.add(downloadData);
            Bb();
        }
    }

    private void Bb() {
        if (apP == null && !apQ.isEmpty()) {
            apP = apQ.get(0);
            if (apP != null) {
                q(p(apP));
            }
        }
    }

    public void h(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String B(String str, int i) {
        c eg = eg(i);
        StringBuilder sb = new StringBuilder();
        sb.append(eg.apF).append("/").append(eg.apG).append("/").append(str);
        if (!StringUtils.isNull(eg.apH)) {
            sb.append(".").append(eg.apH);
        }
        return sb.toString();
    }

    public void ef(int i) {
        List<DownloadData> ib = e.Bd().ib();
        if (ib != null && ib.size() != 0) {
            for (DownloadData downloadData : ib) {
                if (downloadData.getType() == i) {
                    C(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData p(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!ba.isEmpty(id) && !ba.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String B = B(id, type);
                File file = new File(B);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new g());
                    downloadData.setPath(B);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(B);
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
                    UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.Bd().a(downloadData, eg(downloadData.getType()).maxSize);
            }
            apP = null;
            if (!apQ.isEmpty()) {
                apQ.remove(0);
                Bb();
            }
        }
    }

    private PendingIntent ff(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m9getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m9getInst().getString(u.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m9getInst().getString(u.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m9getInst().getString(u.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, ff(downloadData.getAction()), false);
            }
        }
    }

    public int ak(String str, String str2) {
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

    public boolean fl(String str) {
        for (DownloadData downloadData : e.Bd().ib()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean fh(String str) {
        for (DownloadData downloadData : e.Bd().ib()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void C(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Bd().ib()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Bd().A(str, i);
        if (downloadData != null) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(ak) + "%";
            if (downloadData != null && ak >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.download_cancel), ak, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m9getInst().getApp().getResources().getString(u.j.download_cancel), ff(downloadData.getAction()), false);
            }
        }
    }

    public boolean al(String str, String str2) {
        File cR = m.cR(String.valueOf(str) + "_" + str2 + ".tmp");
        return cR != null && cR.exists() && cR.isFile();
    }

    public long am(String str, String str2) {
        File cR = m.cR(String.valueOf(str) + "_" + str2 + ".tmp");
        if (cR != null && cR.exists() && cR.isFile()) {
            return cR.length();
        }
        return -1L;
    }

    public File an(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return m.cR(String.valueOf(str) + "_" + str2 + ".tmp");
    }

    public boolean D(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(B(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File E(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(B(str, i));
    }

    public void a(int i, c cVar) {
        this.apO.put(i, cVar);
    }

    public c eg(int i) {
        c cVar = this.apO.get(i);
        if (cVar == null) {
            return this.apO.get(10);
        }
        return cVar;
    }

    private void Bj() {
        c cVar = new c();
        cVar.apF = new File(m.sX());
        cVar.apG = "common";
        cVar.apH = "";
        this.apO.put(10, cVar);
    }
}
