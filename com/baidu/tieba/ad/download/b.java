package com.baidu.tieba.ad.download;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> dht;

    /* loaded from: classes3.dex */
    private static final class a {
        private static final b dhu = new b();
    }

    private b() {
        this.dht = new HashMap();
    }

    public static b aDD() {
        return a.dhu;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.dht.get(downloadCacheKey) == null) {
            this.dht.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.dht.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> rp(String str) {
        HashMap hashMap = new HashMap(this.dht.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.dht.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
