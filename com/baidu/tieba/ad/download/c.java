package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes6.dex */
public class c {
    private final String dVs;
    private final String mExtra;
    private final String mPage;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.mPage = str;
        this.dVs = str2;
        this.mExtra = str3;
    }

    public void X(int i, @Nullable String str) {
        m("", i, str);
    }

    public void m(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
        bVar.AP(i);
        if (TextUtils.isEmpty(str)) {
            str = this.mPage;
        }
        bVar.HU(str);
        bVar.HV(this.dVs);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            bVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.mExtra)) {
            bVar.HM(this.mExtra);
        }
        com.baidu.tieba.recapp.report.c.cBP().a(bVar);
    }
}
