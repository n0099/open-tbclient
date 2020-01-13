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
/* loaded from: classes6.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> dVt;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class a {
        private static final d dVu = new d();
    }

    private d() {
        this.dVt = new HashMap();
    }

    public static d aVT() {
        return a.dVu;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.dVt.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.dVt.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.dVt.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.dVt.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.dVC.get().b(downloadCacheKey, b.aVQ().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void wD(String str) {
        com.baidu.tieba.ad.download.b.a.dVC.get().wJ(str);
    }

    public void wE(String str) {
        com.baidu.tieba.ad.download.b.a.dVC.get().wK(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.aVQ().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.aJ(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.dVt.get(downloadCacheKey);
            if (aVar != null && aVar.dVz != null && TextUtils.isEmpty(aVar.dVz.mPackageName)) {
                aVar.dVz.mPackageName = b.pkgName();
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aVQ().wC(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : wF(str)) {
                if (aVar != null && aVar.aVY() != 4) {
                    aVar.setState(4);
                    aVar.aWa();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> wF(String str) {
        HashSet hashSet = new HashSet(this.dVt.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dVt.entrySet()) {
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.aVQ().wC(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : wF(str)) {
                if (aVar != null && aVar.aVY() != 0) {
                    aVar.setState(0);
                    aVar.aWb();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey wG(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dVt.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey wH(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.dVt.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.aVQ().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData aVS = new AdDownloadData.a(downloadCacheKey).aVS();
            b.aVQ().a(downloadCacheKey, aVS);
            return aVS;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey wG = wG(str);
        if (wG != null && (aVar = this.dVt.get(wG)) != null) {
            aVar.a(str2, downloadStatus, str3);
        }
    }
}
