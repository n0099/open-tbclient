package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> fMH;

    /* loaded from: classes21.dex */
    private static final class a {
        private static final b fMI = new b();
    }

    private b() {
        this.fMH = new HashMap();
    }

    public static b bGU() {
        return a.fMI;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.fMH.get(downloadCacheKey) == null) {
            this.fMH.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.fMH.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> ET(String str) {
        HashMap hashMap = new HashMap(this.fMH.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.fMH.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
