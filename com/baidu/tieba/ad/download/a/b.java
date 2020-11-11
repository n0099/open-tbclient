package com.baidu.tieba.ad.download.a;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes21.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a fSI;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.fSI = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.fSI.c(com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.fSI.fa(com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.fSI.c(com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.fSI.c(com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
        this.fSI.fa(100);
        this.fSI.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
        this.fSI.fa(100);
        this.fSI.c(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(downloadCacheKey);
        this.fSI.fa(100);
        this.fSI.c(d.extra().getStatus());
    }
}
