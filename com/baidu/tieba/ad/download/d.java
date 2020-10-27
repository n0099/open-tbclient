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
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> fMK;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static final class a {
        private static final d fML = new d();
    }

    private d() {
        this.fMK = new HashMap();
    }

    public static d bGX() {
        return a.fML;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.fMK.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.fMK.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.fMK.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.fMK.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.cbs.get().b(downloadCacheKey, b.bGU().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void EU(String str) {
        com.baidu.tieba.ad.download.b.a.cbs.get().Fa(str);
    }

    public void EV(String str) {
        com.baidu.tieba.ad.download.b.a.cbs.get().Fb(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.bGU().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.aC(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.fMK.get(downloadCacheKey);
            if (aVar != null && aVar.fMQ != null && TextUtils.isEmpty(aVar.fMQ.mPackageName)) {
                aVar.fMQ.mPackageName = b.pkgName();
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bGU().ET(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EW(str)) {
                if (aVar != null && aVar.bHc() != 4) {
                    aVar.setState(4);
                    aVar.bHe();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> EW(String str) {
        HashSet hashSet = new HashSet(this.fMK.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.fMK.entrySet()) {
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bGU().ET(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EW(str)) {
                if (aVar != null && aVar.bHc() != 0) {
                    aVar.setState(0);
                    aVar.bHf();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey EX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.fMK.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey EY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.fMK.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.bGU().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData bGW = new AdDownloadData.a(downloadCacheKey).bGW();
            b.bGU().a(downloadCacheKey, bGW);
            return bGW;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey EX = EX(str);
        if (EX != null && (aVar = this.fMK.get(EX)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
