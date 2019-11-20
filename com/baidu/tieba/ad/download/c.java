package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes3.dex */
public class c {
    private final String aSM;
    private final String dhv;
    private final String dhw;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.aSM = str;
        this.dhv = str2;
        this.dhw = str3;
    }

    public void N(int i, @Nullable String str) {
        j("", i, str);
    }

    public void j(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
        bVar.yo(i);
        if (TextUtils.isEmpty(str)) {
            str = this.aSM;
        }
        bVar.CX(str);
        bVar.CY(this.dhv);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            bVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.dhw)) {
            bVar.CP(this.dhw);
        }
        com.baidu.tieba.recapp.report.c.cgG().a(bVar);
    }
}
