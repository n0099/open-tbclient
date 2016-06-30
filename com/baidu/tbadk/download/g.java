package com.baidu.tbadk.download;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class g implements d {
    @Override // com.baidu.tbadk.download.d
    public void d(DownloadData downloadData) {
        if (downloadData != null) {
            h.Bi().h(downloadData);
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
            h.Bi().h(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
            }
        }
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        h.Bi().j(downloadData);
        h.Bi().h(downloadData);
    }
}
