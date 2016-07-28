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
    private static h aqC;
    private static DownloadData aqE;
    private static List<DownloadData> aqF = new LinkedList();
    private SparseArray<c> aqD = new SparseArray<>();

    public static h Bi() {
        synchronized (h.class) {
            if (aqC == null) {
                aqC = new h();
            }
        }
        return aqC;
    }

    private h() {
        Bj();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.aqD.get(i2) == null) {
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
            aqF.add(downloadData);
            Bb();
        }
    }

    private void Bb() {
        if (aqE == null && !aqF.isEmpty()) {
            aqE = aqF.get(0);
            if (aqE != null) {
                q(p(aqE));
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
        sb.append(eg.aqu).append("/").append(eg.aqv).append("/").append(str);
        if (!StringUtils.isNull(eg.aqw)) {
            sb.append(".").append(eg.aqw);
        }
        return sb.toString();
    }

    public void ef(int i) {
        List<DownloadData> ia = e.Bd().ia();
        if (ia != null && ia.size() != 0) {
            for (DownloadData downloadData : ia) {
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
                    UtilHelper.install_apk(TbadkCoreApplication.m10getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.Bd().a(downloadData, eg(downloadData.getType()).maxSize);
            }
            aqE = null;
            if (!aqF.isEmpty()) {
                aqF.remove(0);
                Bb();
            }
        }
    }

    private PendingIntent fd(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.m10getInst(), 0, intent, 0);
    }

    public void j(DownloadData downloadData) {
        String string;
        int process;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.m10getInst().getString(u.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_fail_tip), downloadData.getProcess(), String.valueOf(process) + "%", string, fd(downloadData.getAction()), false);
            }
        }
    }

    public int ak(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.m10getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((am * 100) / j);
        }
        return 0;
    }

    public boolean fj(String str) {
        for (DownloadData downloadData : e.Bd().ia()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean ff(String str) {
        for (DownloadData downloadData : e.Bd().ia()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void C(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.Bd().ia()) {
            if (downloadData2.getId() != null && downloadData2.getId().equals(str)) {
                downloadData = downloadData2;
            }
        }
        e.Bd().A(str, i);
        if (downloadData != null) {
            int ak = ak(downloadData.getId(), downloadData.getName());
            String str2 = String.valueOf(ak) + "%";
            if (downloadData != null && ak >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.m10getInst().getApp(), downloadData.getNotifyId(), String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_cancel), ak, str2, String.valueOf(downloadData.getName()) + TbadkCoreApplication.m10getInst().getApp().getResources().getString(u.j.download_cancel), fd(downloadData.getAction()), false);
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
        this.aqD.put(i, cVar);
    }

    public c eg(int i) {
        c cVar = this.aqD.get(i);
        if (cVar == null) {
            return this.aqD.get(10);
        }
        return cVar;
    }

    private void Bj() {
        c cVar = new c();
        cVar.aqu = new File(m.sW());
        cVar.aqv = "common";
        cVar.aqw = "";
        this.aqD.put(10, cVar);
    }
}
