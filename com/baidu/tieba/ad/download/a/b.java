package com.baidu.tieba.ad.download.a;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a gfk;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.gfk = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.gfk.c(com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.gfk.dO(com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.gfk.c(com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.gfk.c(com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
        this.gfk.dO(100);
        this.gfk.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
        this.gfk.dO(100);
        this.gfk.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(downloadCacheKey);
        this.gfk.dO(100);
        this.gfk.c(d.extra().getStatus());
    }
}
