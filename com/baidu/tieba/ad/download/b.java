package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> cYQ;

    /* loaded from: classes3.dex */
    private static final class a {
        private static final b cYR = new b();
    }

    private b() {
        this.cYQ = new HashMap();
    }

    public static b aDx() {
        return a.cYR;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.cYQ.get(downloadCacheKey) == null) {
            this.cYQ.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.cYQ.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> sG(String str) {
        HashMap hashMap = new HashMap(this.cYQ.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.cYQ.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
