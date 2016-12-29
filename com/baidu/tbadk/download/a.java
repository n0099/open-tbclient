package com.baidu.tbadk.download;

import android.content.SharedPreferences;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements d {
    @Override // com.baidu.tbadk.download.d
    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            SharedPreferences sharedPreferences = TbadkCoreApplication.m9getInst().getSharedPreferences("app_download_progress", 0);
            long j = sharedPreferences.getLong(downloadData.getId(), 0L);
            if (j <= 1 || (downloadData.getSize() > 1 && j != downloadData.getSize())) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(downloadData.getId(), downloadData.getSize());
                edit.commit();
            }
            com.baidu.tieba.recapp.b.a.aYh().g(downloadData);
            com.baidu.tieba.recapp.b.a.aYh().f(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean a(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean c(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        if (downloadData != null) {
            String[] tag = downloadData.getTag();
            if (tag != null && tag.length == 3) {
                String str = tag[0];
                String str2 = tag[1];
                TiebaStatic.eventStat(TbadkCoreApplication.m9getInst().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
            }
            NotificationHelper.cancelNotification(TbadkCoreApplication.m9getInst().getApp(), downloadData.getNotifyId());
            com.baidu.tieba.recapp.b.a.aYh().f(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            }
        }
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        com.baidu.tieba.recapp.b.a aYh = com.baidu.tieba.recapp.b.a.aYh();
        if (i == 3) {
            aYh.r(downloadData);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_APP_DOWNLOAD_MSG, downloadData));
        } else {
            aYh.o(downloadData);
        }
        com.baidu.tieba.recapp.b.a.aYh().f(downloadData);
    }
}
