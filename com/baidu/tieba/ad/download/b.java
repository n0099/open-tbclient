package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> eOL;

    /* loaded from: classes8.dex */
    private static final class a {
        private static final b eOM = new b();
    }

    private b() {
        this.eOL = new HashMap();
    }

    public static b bmC() {
        return a.eOM;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.eOL.get(downloadCacheKey) == null) {
            this.eOL.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.eOL.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> zT(String str) {
        HashMap hashMap = new HashMap(this.eOL.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.eOL.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
