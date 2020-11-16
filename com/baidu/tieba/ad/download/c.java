package com.baidu.tieba.ad.download;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes20.dex */
public class c {
    private final String DEFAULT_PAGE = "DOWNLOAD_PAGE";
    private final String fSg = "DOWNLOAD_BUTTON";

    public void h(int i, @Nullable String str, String str2) {
        c("DOWNLOAD_PAGE", i, str, str2);
    }

    public void c(String str, int i, @Nullable String str2, String str3) {
        com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
        cVar.Iz(i);
        if (TextUtils.isEmpty(str)) {
            str = "DOWNLOAD_PAGE";
        }
        cVar.Rk(str);
        cVar.Rl("DOWNLOAD_BUTTON");
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(str3)) {
            cVar.setExtInfo(str3);
        }
        com.baidu.tieba.recapp.report.d.dAT().a(cVar);
    }
}
