package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dZY;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b dZZ = new b();
    }

    private b() {
        this.dZY = new HashMap();
    }

    public static b aYm() {
        return a.dZZ;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dZY.get(downloadCacheKey) == null) {
            this.dZY.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dZY.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wX(String str) {
        HashMap hashMap = new HashMap(this.dZY.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dZY.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
