package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey dhD;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dhE = new HashSet();
    private final com.baidu.tieba.ad.download.c dhC = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dhD = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aDL() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dhE.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dhE.remove(dVar);
        }
        return remove;
    }

    public boolean aDM() {
        return this.dhE.isEmpty();
    }

    public void aDN() {
        if (this.dhD != null) {
            this.dhC.N(710, this.dhD.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDG().d(this.dhD);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.f(this.dhD);
                }
            }
        }
    }

    public void aDO() {
        if (this.dhD != null) {
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.g(this.dhD);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void rv(String str) {
        if (this.dhD != null) {
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.e(this.dhD);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Y(String str, int i) {
        if (this.dhD != null) {
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.b(this.dhD, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dhD != null) {
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.a(this.dhD, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dhD != null) {
            this.dhC.N(704, this.dhD.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDG().d(this.dhD);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setDownloadPath(str2);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.a(this.dhD, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Z(String str, int i) {
        if (this.dhD != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aDG().d(this.dhD).extra().setPercent(i);
            if (!aDM()) {
                for (d dVar : this.dhE) {
                    dVar.a(this.dhD, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dhC.j(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_START, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dhC.j(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dhC.j(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dhC.j(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dhC.j(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
