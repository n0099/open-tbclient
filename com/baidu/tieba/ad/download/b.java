package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> fEm;

    /* loaded from: classes21.dex */
    private static final class a {
        private static final b fEn = new b();
    }

    private b() {
        this.fEm = new HashMap();
    }

    public static b bFb() {
        return a.fEn;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.fEm.get(downloadCacheKey) == null) {
            this.fEm.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.fEm.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> EA(String str) {
        HashMap hashMap = new HashMap(this.fEm.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.fEm.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
