package com.baidu.tieba.ad.download.a;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes15.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a fpb;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.fpb = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.fpb.c(com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.fpb.fy(com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.fpb.c(com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.fpb.c(com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
        this.fpb.fy(100);
        this.fpb.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
        this.fpb.fy(100);
        this.fpb.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(downloadCacheKey);
        this.fpb.fy(100);
        this.fpb.c(d.extra().getStatus());
    }
}
