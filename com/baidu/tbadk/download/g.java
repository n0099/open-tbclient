package com.baidu.tbadk.download;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
/* loaded from: classes.dex */
public class g implements d {
    @Override // com.baidu.tbadk.download.d
    public void b(DownloadData downloadData) {
        if (downloadData != null) {
            h.CL().f(downloadData);
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
            h.CL().f(downloadData);
            if (downloadData.isNeedInvokeApk()) {
                UtilHelper.install_apk(TbadkCoreApplication.m9getInst().getApp(), downloadData.getPath());
            }
        }
    }

    @Override // com.baidu.tbadk.download.d
    public void a(DownloadData downloadData, int i, String str) {
        h.CL().o(downloadData);
        h.CL().f(downloadData);
    }
}
