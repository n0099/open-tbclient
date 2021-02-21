package com.baidu.tieba.ad.download.a;

import androidx.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a ghE;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.ghE = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.ghE.c(com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.ghE.fn(com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.ghE.c(com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.ghE.c(com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
        this.ghE.fn(100);
        this.ghE.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
        this.ghE.fn(100);
        this.ghE.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(downloadCacheKey);
        this.ghE.fn(100);
        this.ghE.c(d.extra().getStatus());
    }
}
