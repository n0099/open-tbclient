package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dZI;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b dZJ = new b();
    }

    private b() {
        this.dZI = new HashMap();
    }

    public static b aYi() {
        return a.dZJ;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dZI.get(downloadCacheKey) == null) {
            this.dZI.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dZI.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wX(String str) {
        HashMap hashMap = new HashMap(this.dZI.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dZI.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
