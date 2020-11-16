package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes20.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> fSe;

    /* loaded from: classes20.dex */
    private static final class a {
        private static final b fSf = new b();
    }

    private b() {
        this.fSe = new HashMap();
    }

    public static b bIM() {
        return a.fSf;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.fSe.get(downloadCacheKey) == null) {
            this.fSe.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.fSe.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> EI(String str) {
        HashMap hashMap = new HashMap(this.fSe.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.fSe.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
