package com.baidu.tieba.ad.download;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes8.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> dZy;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class a {
        private static final d dZz = new d();
    }

    private d() {
        this.dZy = new HashMap();
    }

    public static d aYk() {
        return a.dZz;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.dZy.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.dZy.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.dZy.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.dZy.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.dZH.get().b(downloadCacheKey, b.aYh().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void wX(String str) {
        com.baidu.tieba.ad.download.b.a.dZH.get().xd(str);
    }

    public void wY(String str) {
        com.baidu.tieba.ad.download.b.a.dZH.get().xe(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.aYh().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.aJ(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.dZy.get(downloadCacheKey);
            if (aVar != null && aVar.dZE != null && TextUtils.isEmpty(aVar.dZE.mPackageName)) {
                aVar.dZE.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean aK = aK(context, str);
        if (aK && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return aK;
    }

    private static boolean aK(Context context, String str) {
        if (!aL(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.k(context, new File(str));
    }

    private static boolean aL(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void aM(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aYh().wW(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : wZ(str)) {
                if (aVar != null && aVar.aYp() != 4) {
                    aVar.setState(4);
                    aVar.aYr();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> wZ(String str) {
        HashSet hashSet = new HashSet(this.dZy.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dZy.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean aN(Context context, String str) {
        return com.baidu.tieba.ad.download.a.au(context, str);
    }

    public void aO(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aYh().wW(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : wZ(str)) {
                if (aVar != null && aVar.aYp() != 0) {
                    aVar.setState(0);
                    aVar.aYs();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey xa(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dZy.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey xb(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dZy.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.aYh().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData aYj = new AdDownloadData.a(downloadCacheKey).aYj();
            b.aYh().a(downloadCacheKey, aYj);
            return aYj;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey xa = xa(str);
        if (xa != null && (aVar = this.dZy.get(xa)) != null) {
            aVar.a(str2, downloadStatus, str3);
        }
    }
}
