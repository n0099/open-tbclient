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
/* loaded from: classes21.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> gar;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static final class a {
        private static final d gas = new d();
    }

    private d() {
        this.gar = new HashMap();
    }

    public static d bMx() {
        return a.gas;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gar.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.gar.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gar.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.gar.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.clZ.get().b(downloadCacheKey, b.bMu().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void Fx(String str) {
        com.baidu.tieba.ad.download.b.a.clZ.get().FD(str);
    }

    public void Fy(String str) {
        com.baidu.tieba.ad.download.b.a.clZ.get().FE(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.bMu().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.aC(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.gar.get(downloadCacheKey);
            if (aVar != null && aVar.gax != null && TextUtils.isEmpty(aVar.gax.mPackageName)) {
                aVar.gax.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean aD = aD(context, str);
        if (aD && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return aD;
    }

    private static boolean aD(Context context, String str) {
        if (!aE(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.i(context, new File(str));
    }

    private static boolean aE(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void aF(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bMu().Fw(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Fz(str)) {
                if (aVar != null && aVar.bMC() != 4) {
                    aVar.setState(4);
                    aVar.bME();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> Fz(String str) {
        HashSet hashSet = new HashSet(this.gar.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gar.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean aG(Context context, String str) {
        return com.baidu.tieba.ad.download.a.ao(context, str);
    }

    public void aH(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bMu().Fw(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Fz(str)) {
                if (aVar != null && aVar.bMC() != 0) {
                    aVar.setState(0);
                    aVar.bMF();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey FA(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gar.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey FB(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gar.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.bMu().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData bMw = new AdDownloadData.a(downloadCacheKey).bMw();
            b.bMu().a(downloadCacheKey, bMw);
            return bMw;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey FA = FA(str);
        if (FA != null && (aVar = this.gar.get(FA)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
