package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes15.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> foU;

    /* loaded from: classes15.dex */
    private static final class a {
        private static final b foV = new b();
    }

    private b() {
        this.foU = new HashMap();
    }

    public static b bBd() {
        return a.foV;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.foU.get(downloadCacheKey) == null) {
            this.foU.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.foU.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Ds(String str) {
        HashMap hashMap = new HashMap(this.foU.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.foU.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
