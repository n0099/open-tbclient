package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> geZ;

    /* loaded from: classes.dex */
    private static final class a {
        private static final b gfa = new b();
    }

    private b() {
        this.geZ = new HashMap();
    }

    public static b bKW() {
        return a.gfa;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.geZ.get(downloadCacheKey) == null) {
            this.geZ.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.geZ.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Ei(String str) {
        HashMap hashMap = new HashMap(this.geZ.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.geZ.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
