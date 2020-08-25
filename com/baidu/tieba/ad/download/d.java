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
/* loaded from: classes15.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> foT;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes15.dex */
    public static final class a {
        private static final d foU = new d();
    }

    private d() {
        this.foT = new HashMap();
    }

    public static d bBf() {
        return a.foU;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.foT.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.foT.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.foT.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.foT.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.bKi.get().b(downloadCacheKey, b.bBc().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void Ds(String str) {
        com.baidu.tieba.ad.download.b.a.bKi.get().Dy(str);
    }

    public void Dt(String str) {
        com.baidu.tieba.ad.download.b.a.bKi.get().Dz(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.bBc().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.av(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.foT.get(downloadCacheKey);
            if (aVar != null && aVar.foZ != null && TextUtils.isEmpty(aVar.foZ.mPackageName)) {
                aVar.foZ.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean aw = aw(context, str);
        if (aw && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return aw;
    }

    private static boolean aw(Context context, String str) {
        if (!ax(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.h(context, new File(str));
    }

    private static boolean ax(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void ay(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bBc().Dr(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Du(str)) {
                if (aVar != null && aVar.bBk() != 4) {
                    aVar.setState(4);
                    aVar.bBm();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> Du(String str) {
        HashSet hashSet = new HashSet(this.foT.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.foT.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean az(Context context, String str) {
        return com.baidu.tieba.ad.download.a.ah(context, str);
    }

    public void aA(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bBc().Dr(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Du(str)) {
                if (aVar != null && aVar.bBk() != 0) {
                    aVar.setState(0);
                    aVar.bBn();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey Dv(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.foT.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey Dw(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.foT.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.bBc().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData bBe = new AdDownloadData.a(downloadCacheKey).bBe();
            b.bBc().a(downloadCacheKey, bBe);
            return bBe;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey Dv = Dv(str);
        if (Dv != null && (aVar = this.foT.get(Dv)) != null) {
            aVar.a(str2, downloadStatus, str3);
        }
    }
}
