package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> eOA;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b eOB = new b();
    }

    private b() {
        this.eOA = new HashMap();
    }

    public static b bmA() {
        return a.eOB;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.eOA.get(downloadCacheKey) == null) {
            this.eOA.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.eOA.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> zT(String str) {
        HashMap hashMap = new HashMap(this.eOA.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.eOA.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
