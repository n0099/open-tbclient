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
    public final DownloadCacheKey gaz;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> gaA = new HashSet();
    private final com.baidu.tieba.ad.download.c gay = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.gaz = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bMD() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.gaA.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.gaA.remove(dVar);
        }
        return remove;
    }

    public boolean bME() {
        return this.gaA.isEmpty();
    }

    public void bMF() {
        if (this.gaz != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMy().d(this.gaz);
            this.gay.j(710, this.gaz.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.f(this.gaz);
                }
            }
        }
    }

    public void bMG() {
        if (this.gaz != null) {
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.g(this.gaz);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void FC(String str) {
        if (this.gaz != null) {
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.e(this.gaz);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ay(String str, int i) {
        if (this.gaz != null) {
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.b(this.gaz, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.gaz != null) {
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.a(this.gaz, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.gaz != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bMy().d(this.gaz);
            this.gay.j(704, this.gaz.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setDownloadPath(str2);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.a(this.gaz, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void az(String str, int i) {
        if (this.gaz != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bMy().d(this.gaz).extra().setPercent(i);
            if (!bME()) {
                for (d dVar : this.gaA) {
                    dVar.a(this.gaz, this.mPercent);
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
            this.gay.c(str, i, str2, str3);
        }
    }
}
