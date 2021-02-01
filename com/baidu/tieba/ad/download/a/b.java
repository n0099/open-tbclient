package com.baidu.tieba.ad.download.a;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a ghy;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.ghy = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.ghy.c(com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.ghy.fn(com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.ghy.c(com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.ghy.c(com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
        this.ghy.fn(100);
        this.ghy.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
        this.ghy.fn(100);
        this.ghy.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(downloadCacheKey);
        this.ghy.fn(100);
        this.ghy.c(d.extra().getStatus());
    }
}
