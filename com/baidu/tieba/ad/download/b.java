package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> eAa;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b eAb = new b();
    }

    private b() {
        this.eAa = new HashMap();
    }

    public static b bgp() {
        return a.eAb;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.eAa.get(downloadCacheKey) == null) {
            this.eAa.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.eAa.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> yn(String str) {
        HashMap hashMap = new HashMap(this.eAa.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.eAa.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
