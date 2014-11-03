package com.baidu.tieba.game;

import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.download.DownloadData;
/* loaded from: classes.dex */
public class b implements com.baidu.tbadk.download.f {
    @Override // com.baidu.tbadk.download.f
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null && downloadData.getStatus() == 1) {
            c.Hf().b(downloadData);
            c.Hf().a(downloadData);
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
        return downloadData != null;
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadSucceed(DownloadData downloadData) {
        if (downloadData != null) {
            TiebaStatic.eventStat(com.baidu.tieba.aj.wm().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", downloadData.getTag());
            NotificationHelper.cancelNotification(com.baidu.tieba.aj.wm().getApp(), downloadData.getNotifyId());
            c.Hf().a(downloadData);
            ab.Hu().fp(downloadData.getId());
        }
    }

    @Override // com.baidu.tbadk.download.f
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        c.Hf().c(downloadData);
        c.Hf().a(downloadData);
    }
}
