package com.baidu.tieba.ad.download.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public interface a {
    public static final AtomicReference<a> dVC = new AtomicReference<>();
    public static final a dVD = new a() { // from class: com.baidu.tieba.ad.download.b.a.1
        @Override // com.baidu.tieba.ad.download.b.a
        public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void wJ(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void wK(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public c aWc() {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }
    };

    c aWc();

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    void wJ(String str);

    void wK(String str);
}
