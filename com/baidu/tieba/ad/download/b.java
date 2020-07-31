package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> fdy;

    /* loaded from: classes15.dex */
    private static final class a {
        private static final b fdz = new b();
    }

    private b() {
        this.fdy = new HashMap();
    }

    public static b bsf() {
        return a.fdz;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.fdy.get(downloadCacheKey) == null) {
            this.fdy.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.fdy.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> AX(String str) {
        HashMap hashMap = new HashMap(this.fdy.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.fdy.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
