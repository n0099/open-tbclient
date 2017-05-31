package com.baidu.tbadk.download;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class g implements d {
    @Override // com.baidu.tbadk.download.d
    public void onFileUpdateProgress(DownloadData downloadData) {
        if (downloadData != null) {
            h.Cj().b(downloadData);
        }
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onPreDownload(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public boolean onFileDownloaded(DownloadData downloadData) {
        if (downloadData == null) {
            return false;
        }
        downloadData.setStatusMsg(null);
        return true;
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadSucceed(DownloadData downloadData) {
        if (downloadData != null) {
            h.Cj().b(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
            }
        }
    }

    @Override // com.baidu.tbadk.download.d
    public void onFileDownloadFailed(DownloadData downloadData, int i, String str) {
        h.Cj().k(downloadData);
        h.Cj().b(downloadData);
    }
}
