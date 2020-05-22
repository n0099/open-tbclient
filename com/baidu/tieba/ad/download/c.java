package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes8.dex */
public class c {
    private final String eOC;
    private final String mExtra;
    private final String mPage;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.mPage = str;
        this.eOC = str2;
        this.mExtra = str3;
    }

    public void as(int i, @Nullable String str) {
        l("", i, str);
    }

    public void l(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
        cVar.Cq(i);
        if (TextUtils.isEmpty(str)) {
            str = this.mPage;
        }
        cVar.LC(str);
        cVar.LD(this.eOC);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.mExtra)) {
            cVar.Lu(this.mExtra);
        }
        com.baidu.tieba.recapp.report.d.cVk().a(cVar);
    }
}
