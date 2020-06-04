package com.baidu.tieba.ad.download.a;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes8.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a eOW;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.eOW = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.eOW.c(com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.eOW.dt(com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.eOW.c(com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.eOW.c(com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
        this.eOW.dt(100);
        this.eOW.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
        this.eOW.dt(100);
        this.eOW.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(downloadCacheKey);
        this.eOW.dt(100);
        this.eOW.c(d.extra().getStatus());
    }
}
