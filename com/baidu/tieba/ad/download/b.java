package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dVh;

    /* loaded from: classes5.dex */
    private static final class a {
        private static final b dVi = new b();
    }

    private b() {
        this.dVh = new HashMap();
    }

    public static b aVx() {
        return a.dVi;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dVh.get(downloadCacheKey) == null) {
            this.dVh.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dVh.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wy(String str) {
        HashMap hashMap = new HashMap(this.dVh.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dVh.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
