package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> ght;

    /* loaded from: classes.dex */
    private static final class a {
        private static final b ghu = new b();
    }

    private b() {
        this.ght = new HashMap();
    }

    public static b bLv() {
        return a.ghu;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.ght.get(downloadCacheKey) == null) {
            this.ght.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.ght.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> EF(String str) {
        HashMap hashMap = new HashMap(this.ght.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.ght.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
