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
    private final Map<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> gja;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static final d gjb = new d();
    }

    private d() {
        this.gja = new HashMap();
    }

    public static d bLC() {
        return a.gjb;
    }

    public void a(@NonNull DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gja.get(downloadCacheKey);
        if (aVar == null) {
            aVar = new com.baidu.tieba.ad.download.a.a(downloadCacheKey);
            this.gja.put(downloadCacheKey, aVar);
        }
        if (dVar != null) {
            aVar.a(dVar);
        }
    }

    public void b(DownloadCacheKey downloadCacheKey, com.baidu.tieba.ad.download.a.d dVar) {
        com.baidu.tieba.ad.download.a.a aVar = this.gja.get(downloadCacheKey);
        if (aVar != null) {
            aVar.b(dVar);
        }
    }

    public com.baidu.tieba.ad.download.a.a c(DownloadCacheKey downloadCacheKey) {
        return this.gja.get(downloadCacheKey);
    }

    public String c(@NonNull DownloadCacheKey downloadCacheKey, @Nullable com.baidu.tieba.ad.download.a.d dVar) {
        if (dVar != null) {
            a(downloadCacheKey, dVar);
        }
        com.baidu.tieba.ad.download.b.a.gjj.get().b(downloadCacheKey, b.bLz().b(downloadCacheKey));
        return downloadCacheKey.mAdId;
    }

    public void EN(String str) {
        com.baidu.tieba.ad.download.b.a.gjj.get().ET(str);
    }

    public void EO(String str) {
        com.baidu.tieba.ad.download.b.a.gjj.get().EU(str);
    }

    public boolean a(Context context, @NonNull DownloadCacheKey downloadCacheKey, String str) {
        AdDownloadData b = b.bLz().b(downloadCacheKey);
        com.baidu.tieba.ad.download.a.a aVar = null;
        if (b != null) {
            if (TextUtils.isEmpty(b.pkgName())) {
                b.setupPkgName(com.baidu.tieba.ad.download.a.aJ(context, str));
            }
            if (TextUtils.isEmpty(downloadCacheKey.mPackageName)) {
                downloadCacheKey.mPackageName = b.pkgName();
            }
            aVar = this.gja.get(downloadCacheKey);
            if (aVar != null && aVar.gjg != null && TextUtils.isEmpty(aVar.gjg.mPackageName)) {
                aVar.gjg.mPackageName = b.pkgName();
            }
            b.extra().setPercentAndStatus(100, DownloadStatus.STATUS_SUCCESS);
            b.extra().setDownloadPath(str);
        }
        boolean RD = t.RD(str);
        if (!RD) {
            com.baidu.tieba.recapp.b.deleteFileOrDir(new File(str));
        }
        if (RD && b != null && aVar != null) {
            aVar.onSuccess(b.adId(), str);
        }
        return RD;
    }

    public void aK(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLz().EM(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EP(str)) {
                if (aVar != null && aVar.bLH() != 4) {
                    aVar.setState(4);
                    aVar.bLJ();
                }
            }
            com.baidu.tieba.recapp.b.Rv(str);
        }
    }

    private Set<com.baidu.tieba.ad.download.a.a> EP(String str) {
        HashSet hashSet = new HashSet(this.gja.size());
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gja.entrySet()) {
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
            for (Map.Entry<DownloadCacheKey, AdDownloadData> entry : b.bLz().EM(str).entrySet()) {
                AdDownloadData value = entry.getValue();
                if (value != null) {
                    value.extra().setStatus(DownloadStatus.STATUS_NONE);
                }
            }
            for (com.baidu.tieba.ad.download.a.a aVar : EP(str)) {
                if (aVar != null && aVar.bLH() != 0) {
                    aVar.setState(0);
                    aVar.bLK();
                }
            }
        }
    }

    @Nullable
    public DownloadCacheKey EQ(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gja.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameAd(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Nullable
    public DownloadCacheKey ER(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (Map.Entry<DownloadCacheKey, com.baidu.tieba.ad.download.a.a> entry : this.gja.entrySet()) {
            if (entry.getKey() != null && entry.getKey().sameUrl(str)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @NonNull
    public AdDownloadData d(@NonNull DownloadCacheKey downloadCacheKey) {
        AdDownloadData b = b.bLz().b(downloadCacheKey);
        if (b == null) {
            AdDownloadData bLB = new AdDownloadData.a(downloadCacheKey).bLB();
            b.bLz().a(downloadCacheKey, bLB);
            return bLB;
        }
        return b;
    }

    public void a(@NonNull String str, String str2, DownloadStatus downloadStatus, String str3, String str4) {
        com.baidu.tieba.ad.download.a.a aVar;
        DownloadCacheKey EQ = EQ(str);
        if (EQ != null && (aVar = this.gja.get(EQ)) != null) {
            aVar.a(str2, downloadStatus, str3, str4);
        }
    }
}
