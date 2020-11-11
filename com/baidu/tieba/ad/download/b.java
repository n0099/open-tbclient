package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes21.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> fSx;

    /* loaded from: classes21.dex */
    private static final class a {
        private static final b fSy = new b();
    }

    private b() {
        this.fSx = new HashMap();
    }

    public static b bJt() {
        return a.fSy;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.fSx.get(downloadCacheKey) == null) {
            this.fSx.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.fSx.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Fh(String str) {
        HashMap hashMap = new HashMap(this.fSx.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.fSx.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
