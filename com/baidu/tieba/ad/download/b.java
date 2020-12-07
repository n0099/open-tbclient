package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> gan;

    /* loaded from: classes21.dex */
    private static final class a {
        private static final b gao = new b();
    }

    private b() {
        this.gan = new HashMap();
    }

    public static b bMu() {
        return a.gao;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.gan.get(downloadCacheKey) == null) {
            this.gan.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.gan.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Fw(String str) {
        HashMap hashMap = new HashMap(this.gan.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.gan.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
