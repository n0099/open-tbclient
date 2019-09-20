package com.baidu.tbadk.download;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.recapp.download.e;
/* loaded from: classes.dex */
public class a implements c {
    @Override // com.baidu.tbadk.download.c
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            SharedPreferences sharedPreferences = TbadkCoreApplication.getInst().getSharedPreferences("app_download_progress", 0);
            long j = sharedPreferences.getLong(downloadData.getId(), 0L);
            if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(downloadData.getId(), downloadData.getSize());
                edit.commit();
            }
            e.ciQ().c(downloadData);
            e.ciQ().b(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.c
    public void onFileDownloadSucceed(DownloadData downloadData) {
        if (downloadData != null) {
            String[] tag = downloadData.getTag();
            if (tag != null && tag.length == 3) {
                String str = tag[0];
                String str2 = tag[1];
                TiebaStatic.eventStat(TbadkCoreApplication.getInst().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
            }
            NotificationHelper.cancelNotification(TbadkCoreApplication.getInst().getApp(), downloadData.getNotifyId());
            e.ciQ().b(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.getInst().getApp(), downloadData.getId().replace(".", "_") + ".apk");
            }
        }
    }

    @Override // com.baidu.tbadk.download.c
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        e ciQ = e.ciQ();
        if (i == 3) {
            ciQ.k(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016484, downloadData));
        } else {
            ciQ.l(downloadData);
        }
        e.ciQ().b(downloadData);
    }
}
