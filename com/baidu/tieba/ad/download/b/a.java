package com.baidu.tieba.ad.download.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes20.dex */
public interface a {
    public static final AtomicReference<a> bMm = new AtomicReference<>();
    public static final a fsn = new a() { // from class: com.baidu.tieba.ad.download.b.a.1
        @Override // com.baidu.tieba.ad.download.b.a
        public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void DW(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void DX(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public c bCB() {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }
    };

    void DW(String str);

    void DX(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c bCB();
}
