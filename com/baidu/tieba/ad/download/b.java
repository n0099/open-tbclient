package com.baidu.tieba.ad.download;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class b {
    private Map<DownloadCacheKey, AdDownloadData> gjH;

    /* loaded from: classes.dex */
    private static final class a {
        private static final b gjI = new b();
    }

    private b() {
        this.gjH = new HashMap();
    }

    public static b bON() {
        return a.gjI;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, @NonNull AdDownloadData adDownloadData) {
        if (this.gjH.get(downloadCacheKey) == null) {
            this.gjH.put(downloadCacheKey, adDownloadData);
        }
    }

    public AdDownloadData b(@NonNull DownloadCacheKey downloadCacheKey) {
        return this.gjH.get(downloadCacheKey);
    }

    public Map<DownloadCacheKey, AdDownloadData> Fu(String str) {
        HashMap hashMap = new HashMap(this.gjH.size());
        if (TextUtils.isEmpty(str)) {
            return hashMap;
        }
        for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : this.gjH.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }
}
