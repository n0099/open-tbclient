package com.baidu.tbadk.download;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements c {
    @Override // com.baidu.tbadk.download.c
    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 1) {
                b.Ak().f(downloadData);
            }
            b.Ak().e(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean a(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean c(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void d(DownloadData downloadData) {
        NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId());
        if (downloadData.isNeedInvokeApk()) {
            UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
        }
    }

    @Override // com.baidu.tbadk.download.c
    public void a(DownloadData downloadData, int i, String str) {
        b.Ak().g(downloadData);
    }
}
