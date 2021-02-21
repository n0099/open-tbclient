package com.baidu.tieba.ad.download;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.t;
import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class d {
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> ghw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final d ghx = new d();
    }

    private d() {
        this.ghw = new HashMap();
    }

    public static d bLy() {
        return a.ghx;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.ghw.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.ghw.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.ghw.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.ghw.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.ghF.get().b(downloadCacheKey, b.bLv().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void EG(String str) {
        com.baidu.tieba.ad.download.b.a.ghF.get().EM(str);
    }

    public void EH(String str) {
        com.baidu.tieba.ad.download.b.a.ghF.get().EN(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b2 = b.bLv().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b2 != null) {
            if (TextUtils.isEmpty(b2.pkgName())) {
                b2.setupPkgName(com.baidu.tieba.ad.download.a.aJ(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b2.pkgName();
            }
            aVar = this.ghw.get(downloadCacheKey);
            if (aVar != null && aVar.ghC != null && TextUtils.isEmpty(aVar.ghC.mPackageName)) {
                aVar.ghC.mPackageName = b2.pkgName();
            }
            b2.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b2.extra().setDownloadPath(str);
        }
        boolean Rx = t.Rx(str);
        if (!Rx) {
            com.baidu.tieba.recapp.b.deleteFileOrDir(new File(str));
        }
        if (Rx && b2 != null && aVar != null) {
            aVar.onSuccess(b2.adId(), str);
        }
        return Rx;
    }

    public void aK(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLv().EF(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EI(str)) {
                if (aVar != null && aVar.bLD() != 4) {
                    aVar.setState(4);
                    aVar.bLF();
                }
            }
            com.baidu.tieba.recapp.b.Rp(str);
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> EI(String str) {
        HashSet hashSet = new HashSet(this.ghw.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghw.entrySet()) {
            if (entry.getKey() != null && entry.getKey().samePackage(str)) {
                hashSet.add(entry.getValue());
            }
        }
        return hashSet;
    }

    public boolean aL(Context context, String str) {
        return com.baidu.tieba.ad.download.a.au(context, str);
    }

    public void aM(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLv().EF(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EI(str)) {
                if (aVar != null && aVar.bLD() != 0) {
                    aVar.setState(0);
                    aVar.bLG();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey EJ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghw.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey EK(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.ghw.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b2 = b.bLv().b(downloadCacheKey);
        if (b2 == null) {
            AdDownloadData bLx = new AdDownloadData.a(downloadCacheKey).bLx();
            b.bLv().a(downloadCacheKey, bLx);
            return bLx;
        }
        return b2;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey EJ = EJ(str);
        if (EJ != null && (aVar = this.ghw.get(EJ)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
