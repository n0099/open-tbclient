package com.baidu.tieba.ad.download.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public interface a {
    public static final AtomicReference<a> ghF = new AtomicReference<>();
    public static final a ghG = new a() { // from class: com.baidu.tieba.ad.download.b.a.1
        @Override // com.baidu.tieba.ad.download.b.a
        public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void EM(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void EN(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public c bLH() {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }
    };

    void EM(String str);

    void EN(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c bLH();
}
