package com.baidu.tieba.ad.download;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> ghq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final d ghr = new d();
    }

    private d() {
        this.ghq = new HashMap();
    }

    public static d bLt() {
        return a.ghr;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.ghq.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.ghq.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.ghq.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.ghq.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.ghz.get().b(downloadCacheKey, b.bLq().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void EH(String str) {
        com.baidu.tieba.ad.download.b.a.ghz.get().EN(str);
    }

    public void EI(String str) {
        com.baidu.tieba.ad.download.b.a.ghz.get().EO(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b2 = b.bLq().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b2 != null) {
            if (TextUtils.isEmpty(b2.pkgName())) {
                b2.setupPkgName(com.baidu.tieba.ad.download.a.aJ(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b2.pkgName();
            }
            aVar = this.ghq.get(downloadCacheKey);
            if (aVar != null && aVar.ghw != null && TextUtils.isEmpty(aVar.ghw.mPackageName)) {
                aVar.ghw.mPackageName = b2.pkgName();
            }
            b2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b2.extra().setDownloadPath(str);
        }
        boolean aK = aK(context, str);
        if (aK && b2 != null && aVar != null) {
            aVar.onSuccess(b2.adId(), str);
        }
        return aK;
    }

    private static boolean aK(Context context, String str) {
        if (!aL(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.i(context, new File(str));
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLq().EG(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EJ(str)) {
                if (aVar != null && aVar.bLy() != 4) {
                    aVar.setState(4);
                    aVar.bLA();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> EJ(String str) {
        HashSet hashSet = new HashSet(this.ghq.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghq.entrySet()) {
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLq().EG(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EJ(str)) {
                if (aVar != null && aVar.bLy() != 0) {
                    aVar.setState(0);
                    aVar.bLB();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey EK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghq.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey EL(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghq.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = b.bLq().b(downloadCacheKey);
        if (b2 == null) {
            AdDownloadData bLs = new AdDownloadData.a(downloadCacheKey).bLs();
            b.bLq().a(downloadCacheKey, bLs);
            return bLs;
        }
        return b2;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey EK = EK(str);
        if (EK != null && (aVar = this.ghq.get(EK)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
