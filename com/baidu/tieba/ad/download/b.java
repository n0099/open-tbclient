package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> ghn;

    /* loaded from: classes.dex */
    private static final class a {
        private static final b gho = new b();
    }

    private b() {
        this.ghn = new HashMap();
    }

    public static b bLq() {
        return a.gho;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.ghn.get(downloadCacheKey) == null) {
            this.ghn.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.ghn.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> EG(String str) {
        HashMap hashMap = new HashMap(this.ghn.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.ghn.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
