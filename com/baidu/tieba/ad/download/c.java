package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes8.dex */
public class c {
    private final String dZx;
    private final String mExtra;
    private final String mPage;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.mPage = str;
        this.dZx = str2;
        this.mExtra = str3;
    }

    public void Y(int i, @Nullable String str) {
        n("", i, str);
    }

    public void n(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
        bVar.AY(i);
        if (TextUtils.isEmpty(str)) {
            str = this.mPage;
        }
        bVar.Ii(str);
        bVar.Ij(this.dZx);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            bVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.mExtra)) {
            bVar.Ia(this.mExtra);
        }
        com.baidu.tieba.recapp.report.c.cDp().a(bVar);
    }
}
