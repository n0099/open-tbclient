package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> giX;

    /* loaded from: classes.dex */
    private static final class a {
        private static final b giY = new b();
    }

    private b() {
        this.giX = new HashMap();
    }

    public static b bLz() {
        return a.giY;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.giX.get(downloadCacheKey) == null) {
            this.giX.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.giX.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> EM(String str) {
        HashMap hashMap = new HashMap(this.giX.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.giX.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
