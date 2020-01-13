package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dVq;

    /* loaded from: classes6.dex */
    private static final class a {
        private static final b dVr = new b();
    }

    private b() {
        this.dVq = new HashMap();
    }

    public static b aVQ() {
        return a.dVr;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dVq.get(downloadCacheKey) == null) {
            this.dVq.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dVq.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wC(String str) {
        HashMap hashMap = new HashMap(this.dVq.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dVq.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
