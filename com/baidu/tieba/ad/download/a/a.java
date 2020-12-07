package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes21.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey gax;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> gay = new HashSet();
    private final com.baidu.tieba.ad.download.c gaw = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.gax = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bMC() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.gay.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.gay.remove(dVar);
        }
        return remove;
    }

    public boolean bMD() {
        return this.gay.isEmpty();
    }

    public void bME() {
        if (this.gax != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMx().d(this.gax);
            this.gaw.j(710, this.gax.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.f(this.gax);
                }
            }
        }
    }

    public void bMF() {
        if (this.gax != null) {
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.g(this.gax);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void FC(String str) {
        if (this.gax != null) {
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.e(this.gax);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ay(String str, int i) {
        if (this.gax != null) {
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.b(this.gax, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.gax != null) {
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.a(this.gax, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.gax != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMx().d(this.gax);
            this.gaw.j(704, this.gax.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setDownloadPath(str2);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.a(this.gax, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void az(String str, int i) {
        if (this.gax != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bMx().d(this.gax).extra().setPercent(i);
            if (!bMD()) {
                for (d dVar : this.gay) {
                    dVar.a(this.gax, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2, String str3) {
        int i;
        switch (downloadStatus) {
            case STATUS_NONE:
                i = 701;
                break;
            case STATUS_DOWNLOADING:
                i = CyberPlayerManager.MEDIA_INFO_BUFFERING_END;
                break;
            case STATUS_PAUSED:
                i = 703;
                break;
            case STATUS_SUCCESS:
                i = 705;
                break;
            case STATUS_INSTALL_SUCCESS:
                i = 706;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            this.gaw.c(str, i, str2, str3);
        }
    }
}
