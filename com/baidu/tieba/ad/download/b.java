package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> gaq;

    /* loaded from: classes21.dex */
    private static final class a {
        private static final b gar = new b();
    }

    private b() {
        this.gaq = new HashMap();
    }

    public static b bMv() {
        return a.gar;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.gaq.get(downloadCacheKey) == null) {
            this.gaq.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.gaq.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Fw(String str) {
        HashMap hashMap = new HashMap(this.gaq.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.gaq.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
