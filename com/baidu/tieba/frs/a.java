package com.baidu.tieba.frs;

import android.app.NotificationManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
public class a implements com.baidu.tbadk.download.a {
    private NotificationManager a = null;

    @Override // com.baidu.tbadk.download.a
    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            if (downloadData.getStatus() == 1) {
                b.a().b(downloadData);
            }
            b.a().a(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.a
    public boolean c(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public boolean d(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData) {
        if (this.a == null) {
            this.a = b.a().c();
        }
        this.a.cancel(downloadData.getNotifyId());
        UtilHelper.install_apk(com.baidu.tieba.ai.c().d(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
    }

    @Override // com.baidu.tbadk.download.a
    public void a(DownloadData downloadData, int i, String str) {
        b.a().c(downloadData);
    }
}
