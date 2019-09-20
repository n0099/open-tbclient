package com.baidu.tieba.ad.download;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.a.d;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class c {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> cYS;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        private static final c cYT = new c();
    }

    private c() {
        this.cYS = new HashMap();
    }

    public static c aDA() {
        return a.cYT;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.cYS.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.cYS.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.cYS.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.cYS.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.cYZ.get().b(downloadCacheKey, b.aDx().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void sH(String str) {
        com.baidu.tieba.ad.download.b.a.cYZ.get().sN(str);
    }

    public void sI(String str) {
        com.baidu.tieba.ad.download.b.a.cYZ.get().sO(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.aDx().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.at(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.cYS.get(downloadCacheKey);
            if (aVar != null && aVar.cYW != null && TextUtils.isEmpty(aVar.cYW.mPackageName)) {
                aVar.cYW.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean au = au(context, str);
        if (au && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return au;
    }

    private static boolean au(Context context, String str) {
        if (!av(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.f(context, new File(str));
    }

    private static boolean av(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void aw(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aDx().sG(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : sJ(str)) {
                if (aVar != null && aVar.aDE() != 4) {
                    aVar.setState(4);
                    aVar.aDG();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> sJ(String str) {
        HashSet hashSet = new HashSet(this.cYS.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.cYS.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean ax(Context context, String str) {
        return com.baidu.tieba.ad.download.a.as(context, str);
    }

    public void ay(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aDx().sG(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : sJ(str)) {
                if (aVar != null && aVar.aDE() != 0) {
                    aVar.setState(0);
                    aVar.aDH();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey sK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.cYS.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey sL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.cYS.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.aDx().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData aDz = new AdDownloadData.a(downloadCacheKey).aDz();
            b.aDx().a(downloadCacheKey, aDz);
            return aDz;
        }
        return b;
    }
}
