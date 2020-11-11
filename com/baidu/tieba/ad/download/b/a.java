package com.baidu.tieba.ad.download.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes21.dex */
public interface a {
    public static final AtomicReference<a> che = new AtomicReference<>();
    public static final a fSJ = new a() { // from class: com.baidu.tieba.ad.download.b.a.1
        @Override // com.baidu.tieba.ad.download.b.a
        public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void Fo(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void Fp(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public c bJF() {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }
    };

    void Fo(String str);

    void Fp(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c bJF();
}
