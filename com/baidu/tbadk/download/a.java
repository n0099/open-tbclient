package com.baidu.tbadk.download;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements f {
    @Override // com.baidu.tbadk.download.f
    public void a(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 1) {
                b.zf().f(downloadData);
            }
            b.zf().e(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.f
    public boolean b(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.f
    public boolean c(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.f
    public void d(DownloadData downloadData) {
        NotificationHelper.cancelNotification(TbadkCoreApplication.m411getInst().getApp(), downloadData.getNotifyId());
        UtilHelper.install_apk(TbadkCoreApplication.m411getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
    }

    @Override // com.baidu.tbadk.download.f
    public void a(DownloadData downloadData, int i, String str) {
        b.zf().g(downloadData);
    }
}
