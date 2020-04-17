package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> ezV;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b ezW = new b();
    }

    private b() {
        this.ezV = new HashMap();
    }

    public static b bgr() {
        return a.ezW;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.ezV.get(downloadCacheKey) == null) {
            this.ezV.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.ezV.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> yk(String str) {
        HashMap hashMap = new HashMap(this.ezV.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.ezV.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
