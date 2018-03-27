package com.baidu.tbadk.download;

import android.app.PendingIntent;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.ar.util.Constants;
import com.baidu.fsg.base.utils.PhoneUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.k;
import com.baidu.tieba.d;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private static g brS;
    private static DownloadData brU;
    private static List<DownloadData> brV = new LinkedList();
    private SparseArray<c> brT = new SparseArray<>();

    public static g KZ() {
        synchronized (g.class) {
            if (brS == null) {
                brS = new g();
            }
        }
        return brS;
    }

    private g() {
        La();
    }

    public void b(String str, String str2, String str3, int i, int i2) {
        a(str, str2, str3, i, i2, true);
    }

    public void a(String str, String str2, String str3, int i, int i2, boolean z) {
        if (this.brT.get(i2) == null) {
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
            brV.add(downloadData);
            KS();
        }
    }

    private void KS() {
        if (brU == null && !brV.isEmpty()) {
            brU = brV.get(0);
            if (brU != null) {
                j(i(brU));
            }
        }
    }

    public void b(DownloadData downloadData) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(downloadData);
        MessageManager.getInstance().dispatchResponsedMessage(new DownloadMessage(linkedList));
    }

    private String A(String str, int i) {
        c hD = hD(i);
        StringBuilder sb = new StringBuilder();
        sb.append(hD.brK).append("/").append(hD.brL).append("/").append(str);
        if (!StringUtils.isNull(hD.brM)) {
            sb.append(Constants.DOT).append(hD.brM);
        }
        return sb.toString();
    }

    public void hC(int i) {
        List<DownloadData> rl = e.KU().rl();
        if (rl != null && rl.size() != 0) {
            for (DownloadData downloadData : rl) {
                if (downloadData.getType() == i) {
                    B(downloadData.getId(), i);
                }
            }
        }
    }

    private DownloadData i(DownloadData downloadData) {
        if (downloadData != null) {
            String id = downloadData.getId();
            String name = downloadData.getName();
            int type = downloadData.getType();
            if (!am.isEmpty(id) && !am.isEmpty(name)) {
                boolean isForceDownload = downloadData.isForceDownload();
                String A = A(id, type);
                File file = new File(A);
                if (isForceDownload || !file.exists() || file.length() == 0) {
                    downloadData.setCallback(new f());
                    downloadData.setPath(A);
                    return downloadData;
                }
                DownloadData downloadData2 = new DownloadData(id);
                downloadData2.setPath(A);
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
                    UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getPath());
                }
            } else {
                e.KU().a(downloadData, hD(downloadData.getType()).maxSize);
            }
            brU = null;
            if (!brV.isEmpty()) {
                brV.remove(0);
                KS();
            }
        }
    }

    private PendingIntent gb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Intent intent = new Intent(str);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268435456);
        return PendingIntent.getActivity(TbadkCoreApplication.getInst(), 0, intent, 0);
    }

    public void k(DownloadData downloadData) {
        String string;
        if (downloadData != null) {
            switch (downloadData.getErrorCode()) {
                case 1:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_sdcrad);
                    break;
                case 2:
                default:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip);
                    break;
                case 3:
                    string = TbadkCoreApplication.getInst().getString(d.j.download_fail_tip_net);
                    break;
            }
            if (downloadData.isNeedNotify()) {
                int process = downloadData.getProcess();
                String str = String.valueOf(downloadData.getLength() / 1000) + "K/" + String.valueOf(downloadData.getSize() / 1000) + "K";
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_fail_tip), process, process + "%", string, gb(downloadData.getAction()), false);
            }
        }
    }

    public int al(String str, String str2) {
        long am = am(str, str2);
        long j = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0).getLong(str, 0L);
        if (0 == j) {
            return -1;
        }
        if (am <= j) {
            return (int) ((100 * am) / j);
        }
        return 0;
    }

    public boolean gg(String str) {
        for (DownloadData downloadData : e.KU().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 1) {
                return true;
            }
        }
        return false;
    }

    public boolean gh(String str) {
        for (DownloadData downloadData : e.KU().rl()) {
            if (downloadData.getId() != null && downloadData.getId().equals(str) && downloadData.getStatus() == 5) {
                return true;
            }
        }
        return false;
    }

    public void B(String str, int i) {
        DownloadData downloadData = null;
        for (DownloadData downloadData2 : e.KU().rl()) {
            if (downloadData2.getId() == null || !downloadData2.getId().equals(str)) {
                downloadData2 = downloadData;
            }
            downloadData = downloadData2;
        }
        e.KU().z(str, i);
        if (downloadData != null) {
            int al = al(downloadData.getId(), downloadData.getName());
            String str2 = al + "%";
            if (downloadData != null && al >= 0) {
                NotificationHelper.showProgressNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId(), downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), al, str2, downloadData.getName() + TbadkCoreApplication.getInst().getApp().getResources().getString(d.j.download_cancel), gb(downloadData.getAction()), false);
            }
        }
    }

    public boolean an(String str, String str2) {
        File dC = k.dC(str + "_" + str2 + ".tmp");
        return dC != null && dC.exists() && dC.isFile();
    }

    public long am(String str, String str2) {
        File dC = k.dC(str + "_" + str2 + ".tmp");
        if (dC != null && dC.exists() && dC.isFile()) {
            return dC.length();
        }
        return -1L;
    }

    public File ao(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        return k.dC(str + "_" + str2 + ".tmp");
    }

    public boolean C(String str, int i) {
        File file;
        return !TextUtils.isEmpty(str) && (file = new File(A(str, i))) != null && file.exists() && file.length() > 0;
    }

    public File D(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new File(A(str, i));
    }

    public void a(int i, c cVar) {
        this.brT.put(i, cVar);
    }

    public c hD(int i) {
        c cVar = this.brT.get(i);
        if (cVar == null) {
            return this.brT.get(10);
        }
        return cVar;
    }

    private void La() {
        c cVar = new c();
        cVar.brK = new File(k.BW());
        cVar.brL = PhoneUtils.CPUInfo.FEATURE_COMMON;
        cVar.brM = "";
        this.brT.put(10, cVar);
    }
}
