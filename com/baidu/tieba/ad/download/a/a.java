package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey dZR;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dZS = new HashSet();
    private final com.baidu.tieba.ad.download.c dZQ = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dZR = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aYq() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dZS.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dZS.remove(dVar);
        }
        return remove;
    }

    public boolean aYr() {
        return this.dZS.isEmpty();
    }

    public void aYs() {
        if (this.dZR != null) {
            this.dZQ.Y(710, this.dZR.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYl().d(this.dZR);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.f(this.dZR);
                }
            }
        }
    }

    public void aYt() {
        if (this.dZR != null) {
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.g(this.dZR);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void xd(String str) {
        if (this.dZR != null) {
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.e(this.dZR);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aj(String str, int i) {
        if (this.dZR != null) {
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.b(this.dZR, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dZR != null) {
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.a(this.dZR, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dZR != null) {
            this.dZQ.Y(704, this.dZR.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYl().d(this.dZR);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setDownloadPath(str2);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.a(this.dZR, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ak(String str, int i) {
        if (this.dZR != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aYl().d(this.dZR).extra().setPercent(i);
            if (!aYr()) {
                for (d dVar : this.dZS) {
                    dVar.a(this.dZR, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dZQ.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dZQ.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dZQ.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dZQ.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dZQ.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
