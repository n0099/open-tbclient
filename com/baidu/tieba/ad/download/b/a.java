package com.baidu.tieba.ad.download.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.a.c;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public interface a {
    public static final AtomicReference<a> ctd = new AtomicReference<>();
    public static final a gjT = new a() { // from class: com.baidu.tieba.ad.download.b.a.1
        @Override // com.baidu.tieba.ad.download.b.a
        public void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void FB(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public void FC(String str) {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }

        @Override // com.baidu.tieba.ad.download.b.a
        public c bOZ() {
            throw new IllegalArgumentException("IDownloaderProxy 无有效实例");
        }
    };

    void FB(String str);

    void FC(String str);

    void b(@NonNull DownloadCacheKey downloadCacheKey, @Nullable AdDownloadData adDownloadData);

    c bOZ();
}
