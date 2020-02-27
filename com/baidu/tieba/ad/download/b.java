package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dZu;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b dZv = new b();
    }

    private b() {
        this.dZu = new HashMap();
    }

    public static b aYf() {
        return a.dZv;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dZu.get(downloadCacheKey) == null) {
            this.dZu.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dZu.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wW(String str) {
        HashMap hashMap = new HashMap(this.dZu.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dZu.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
