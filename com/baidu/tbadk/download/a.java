package com.baidu.tbadk.download;

import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements f {
    @Override // com.baidu.tbadk.download.f
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 1) {
                b.rj().b(downloadData);
            }
            b.rj().a(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.f
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.f
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadSucceed(DownloadData downloadData) {
        NotificationHelper.cancelNotification(TbadkApplication.m251getInst().getApp(), downloadData.getNotifyId());
        UtilHelper.install_apk(TbadkApplication.m251getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        b.rj().c(downloadData);
    }
}
