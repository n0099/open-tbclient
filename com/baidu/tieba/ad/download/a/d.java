package com.baidu.tieba.ad.download.a;

import android.support.annotation.NonNull;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.StopStatus;
/* loaded from: classes6.dex */
public interface d {
    void a(@NonNull DownloadCacheKey downloadCacheKey, int i);

    void a(@NonNull DownloadCacheKey downloadCacheKey, StopStatus stopStatus);

    void a(@NonNull DownloadCacheKey downloadCacheKey, String str, boolean z);

    void b(@NonNull DownloadCacheKey downloadCacheKey, int i);

    void e(@NonNull DownloadCacheKey downloadCacheKey);

    void f(@NonNull DownloadCacheKey downloadCacheKey);

    void g(@NonNull DownloadCacheKey downloadCacheKey);
}
