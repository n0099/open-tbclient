package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> foQ;

    /* loaded from: classes15.dex */
    private static final class a {
        private static final b foR = new b();
    }

    private b() {
        this.foQ = new HashMap();
    }

    public static b bBc() {
        return a.foR;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.foQ.get(downloadCacheKey) == null) {
            this.foQ.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.foQ.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Dr(String str) {
        HashMap hashMap = new HashMap(this.foQ.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.foQ.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
