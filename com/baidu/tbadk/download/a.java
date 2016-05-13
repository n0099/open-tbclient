package com.baidu.tbadk.download;

import android.content.SharedPreferences;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NotificationHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class a implements d {
    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        if (downloadData != null) {
            SharedPreferences sharedPreferences = TbadkCoreApplication.m11getInst().getSharedPreferences("app_download_progress", 0);
            if (sharedPreferences.getLong(downloadData.getId(), 0L) <= 1) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putLong(downloadData.getId(), downloadData.getSize());
                edit.commit();
            }
            b.AR().i(downloadData);
            b.AR().h(downloadData);
        }
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
    public boolean e(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void f(DownloadData downloadData) {
        if (downloadData != null) {
            String[] tag = downloadData.getTag();
            if (tag != null && tag.length == 3) {
                String str = tag[0];
                String str2 = tag[1];
                TiebaStatic.eventStat(TbadkCoreApplication.m11getInst().getApp(), "dl_game_success", "click", 1, "dev_id", downloadData.getId(), "ref_id", str, "is_detail", tag[2], "ref_type", str2);
            }
            NotificationHelper.cancelNotification(TbadkCoreApplication.m11getInst().getApp(), downloadData.getNotifyId());
            b.AR().h(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.m11getInst().getApp(), String.valueOf(downloadData.getId().replace(".", "_")) + ".apk");
            }
        }
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        b.AR().j(downloadData);
        b.AR().h(downloadData);
    }
}
