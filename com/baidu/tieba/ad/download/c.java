package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes3.dex */
public class c {
    private final String aTe;
    private final String dim;
    private final String din;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.aTe = str;
        this.dim = str2;
        this.din = str3;
    }

    public void O(int i, @Nullable String str) {
        j("", i, str);
    }

    public void j(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.b bVar = new com.baidu.tieba.recapp.report.b();
        bVar.yp(i);
        if (TextUtils.isEmpty(str)) {
            str = this.aTe;
        }
        bVar.CX(str);
        bVar.CY(this.dim);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            bVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.din)) {
            bVar.CP(this.din);
        }
        com.baidu.tieba.recapp.report.c.cgI().a(bVar);
    }
}
