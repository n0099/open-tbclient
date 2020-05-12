package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.recapp.report.DownloadStaticsData;
/* loaded from: classes8.dex */
public class c {
    private final String eAc;
    private final String mExtra;
    private final String mPage;

    public c(@NonNull String str, @NonNull String str2, String str3) {
        this.mPage = str;
        this.eAc = str2;
        this.mExtra = str3;
    }

    public void an(int i, @Nullable String str) {
        n("", i, str);
    }

    public void n(String str, int i, @Nullable String str2) {
        com.baidu.tieba.recapp.report.c cVar = new com.baidu.tieba.recapp.report.c();
        cVar.BG(i);
        if (TextUtils.isEmpty(str)) {
            str = this.mPage;
        }
        cVar.JQ(str);
        cVar.JR(this.eAc);
        if (!TextUtils.isEmpty(str2)) {
            DownloadStaticsData downloadStaticsData = new DownloadStaticsData();
            downloadStaticsData.setApk_name(str2);
            cVar.setDownloadStaticsData(downloadStaticsData);
        }
        if (!TextUtils.isEmpty(this.mExtra)) {
            cVar.JI(this.mExtra);
        }
        com.baidu.tieba.recapp.report.d.cOj().a(cVar);
    }
}
