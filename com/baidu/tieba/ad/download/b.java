package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dik;

    /* loaded from: classes3.dex */
    private static final class a {
        private static final b dil = new b();
    }

    private b() {
        this.dik = new HashMap();
    }

    public static b aDF() {
        return a.dil;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dik.get(downloadCacheKey) == null) {
            this.dik.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dik.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> rp(String str) {
        HashMap hashMap = new HashMap(this.dik.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dik.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
