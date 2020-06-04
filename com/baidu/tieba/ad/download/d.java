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
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> eOO;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static final class a {
        private static final d eOP = new d();
    }

    private d() {
        this.eOO = new HashMap();
    }

    public static d bmF() {
        return a.eOP;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.eOO.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.eOO.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.eOO.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.eOO.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.bzx.get().b(downloadCacheKey, b.bmC().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void zU(String str) {
        com.baidu.tieba.ad.download.b.a.bzx.get().Aa(str);
    }

    public void zV(String str) {
        com.baidu.tieba.ad.download.b.a.bzx.get().Ab(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.bmC().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.as(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.eOO.get(downloadCacheKey);
            if (aVar != null && aVar.eOU != null && TextUtils.isEmpty(aVar.eOU.mPackageName)) {
                aVar.eOU.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean at = at(context, str);
        if (at && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return at;
    }

    private static boolean at(Context context, String str) {
        if (!au(context, str)) {
            return false;
        }
        return com.baidu.tieba.ad.download.a.h(context, new File(str));
    }

    private static boolean au(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        return (packageManager == null ? null : packageManager.getPackageArchiveInfo(str, 1)) != null;
    }

    public void av(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bmC().zT(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : zW(str)) {
                if (aVar != null && aVar.bmK() != 4) {
                    aVar.setState(4);
                    aVar.bmM();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> zW(String str) {
        HashSet hashSet = new HashSet(this.eOO.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.eOO.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean aw(Context context, String str) {
        return com.baidu.tieba.ad.download.a.ac(context, str);
    }

    public void ax(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bmC().zT(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : zW(str)) {
                if (aVar != null && aVar.bmK() != 0) {
                    aVar.setState(0);
                    aVar.bmN();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey zX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.eOO.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey zY(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.eOO.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.bmC().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData bmE = new AdDownloadData.a(downloadCacheKey).bmE();
            b.bmC().a(downloadCacheKey, bmE);
            return bmE;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey zX = zX(str);
        if (zX != null && (aVar = this.eOO.get(zX)) != null) {
            aVar.a(str2, downloadStatus, str3);
        }
    }
}
