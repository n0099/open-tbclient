package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> eYW;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b eYX = new b();
    }

    private b() {
        this.eYW = new HashMap();
    }

    public static b bpd() {
        return a.eYX;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.eYW.get(downloadCacheKey) == null) {
            this.eYW.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.eYW.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Am(String str) {
        HashMap hashMap = new HashMap(this.eYW.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.eYW.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
