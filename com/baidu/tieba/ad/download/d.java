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
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> gfc;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final d gfd = new d();
    }

    private d() {
        this.gfc = new HashMap();
    }

    public static d bKZ() {
        return a.gfd;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gfc.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.gfc.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gfc.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.gfc.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.cop.get().b(downloadCacheKey, b.bKW().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void Ej(String str) {
        com.baidu.tieba.ad.download.b.a.cop.get().Ep(str);
    }

    public void Ek(String str) {
        com.baidu.tieba.ad.download.b.a.cop.get().Eq(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b2 = b.bKW().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b2 != null) {
            if (TextUtils.isEmpty(b2.pkgName())) {
                b2.setupPkgName(com.baidu.tieba.ad.download.a.aK(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b2.pkgName();
            }
            aVar = this.gfc.get(downloadCacheKey);
            if (aVar != null && aVar.gfi != null && TextUtils.isEmpty(aVar.gfi.mPackageName)) {
                aVar.gfi.mPackageName = b2.pkgName();
            }
            b2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b2.extra().setDownloadPath(str);
        }
        boolean aL = aL(context, str);
        if (aL && b2 != null && aVar != null) {
            aVar.onSuccess(b2.adId(), str);
        }
        return aL;
    }

    private static boolean aL(Context context, String str) {
        if (!aM(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.i(context, new File(str));
    }

    private static boolean aM(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void aN(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bKW().Ei(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : El(str)) {
                if (aVar != null && aVar.bLe() != 4) {
                    aVar.setState(4);
                    aVar.bLg();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> El(String str) {
        HashSet hashSet = new HashSet(this.gfc.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gfc.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean aO(Context context, String str) {
        return com.baidu.tieba.ad.download.a.aw(context, str);
    }

    public void aP(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bKW().Ei(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : El(str)) {
                if (aVar != null && aVar.bLe() != 0) {
                    aVar.setState(0);
                    aVar.bLh();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey Em(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gfc.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey En(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gfc.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = b.bKW().b(downloadCacheKey);
        if (b2 == null) {
            AdDownloadData bKY = new AdDownloadData.a(downloadCacheKey).bKY();
            b.bKW().a(downloadCacheKey, bKY);
            return bKY;
        }
        return b2;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey Em = Em(str);
        if (Em != null && (aVar = this.gfc.get(Em)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
