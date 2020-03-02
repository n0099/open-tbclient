package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dZv;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b dZw = new b();
    }

    private b() {
        this.dZv = new HashMap();
    }

    public static b aYh() {
        return a.dZw;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dZv.get(downloadCacheKey) == null) {
            this.dZv.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dZv.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> wW(String str) {
        HashMap hashMap = new HashMap(this.dZv.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dZv.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
