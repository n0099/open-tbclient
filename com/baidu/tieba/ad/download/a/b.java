package com.baidu.tieba.ad.download.a;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes3.dex */
public class b implements d {
    private final com.baidu.tieba.ad.download.mvp.a cYY;

    public b(@NonNull com.baidu.tieba.ad.download.mvp.a aVar) {
        this.cYY = aVar;
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void e(@NonNull DownloadCacheKey downloadCacheKey) {
        this.cYY.a(com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.cYY.cw(com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey).extra().getPercent());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus) {
        this.cYY.a(com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void b(@NonNull DownloadCacheKey downloadCacheKey, int i) {
        this.cYY.a(com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey).extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z) {
        AdDownloadData d = com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey);
        this.cYY.cw(100);
        this.cYY.a(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void f(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey);
        this.cYY.cw(100);
        this.cYY.a(d.extra().getStatus());
    }

    @Override // com.baidu.tieba.ad.download.a.d
    public void g(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData d = com.baidu.tieba.ad.download.c.aDA().d(downloadCacheKey);
        this.cYY.cw(100);
        this.cYY.a(d.extra().getStatus());
    }
}
