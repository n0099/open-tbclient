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
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> gjK;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final d gjL = new d();
    }

    private d() {
        this.gjK = new HashMap();
    }

    public static d bOQ() {
        return a.gjL;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gjK.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.gjK.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gjK.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.gjK.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.ctd.get().b(downloadCacheKey, b.bON().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void Fv(String str) {
        com.baidu.tieba.ad.download.b.a.ctd.get().FB(str);
    }

    public void Fw(String str) {
        com.baidu.tieba.ad.download.b.a.ctd.get().FC(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b2 = b.bON().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b2 != null) {
            if (TextUtils.isEmpty(b2.pkgName())) {
                b2.setupPkgName(com.baidu.tieba.ad.download.a.aK(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b2.pkgName();
            }
            aVar = this.gjK.get(downloadCacheKey);
            if (aVar != null && aVar.gjQ != null && TextUtils.isEmpty(aVar.gjQ.mPackageName)) {
                aVar.gjQ.mPackageName = b2.pkgName();
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bON().Fu(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Fx(str)) {
                if (aVar != null && aVar.bOV() != 4) {
                    aVar.setState(4);
                    aVar.bOX();
                }
            }
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> Fx(String str) {
        HashSet hashSet = new HashSet(this.gjK.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gjK.entrySet()) {
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bON().Fu(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : Fx(str)) {
                if (aVar != null && aVar.bOV() != 0) {
                    aVar.setState(0);
                    aVar.bOY();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey Fy(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gjK.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey Fz(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gjK.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = b.bON().b(downloadCacheKey);
        if (b2 == null) {
            AdDownloadData bOP = new AdDownloadData.a(downloadCacheKey).bOP();
            b.bON().a(downloadCacheKey, bOP);
            return bOP;
        }
        return b2;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey Fy = Fy(str);
        if (Fy != null && (aVar = this.gjK.get(Fy)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
