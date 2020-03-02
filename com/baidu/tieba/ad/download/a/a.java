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
    public final DownloadCacheKey dZE;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dZF = new HashSet();
    private final com.baidu.tieba.ad.download.c dZD = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dZE = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aYp() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dZF.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dZF.remove(dVar);
        }
        return remove;
    }

    public boolean aYq() {
        return this.dZF.isEmpty();
    }

    public void aYr() {
        if (this.dZE != null) {
            this.dZD.Y(710, this.dZE.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYk().d(this.dZE);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.f(this.dZE);
                }
            }
        }
    }

    public void aYs() {
        if (this.dZE != null) {
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.g(this.dZE);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void xc(String str) {
        if (this.dZE != null) {
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.e(this.dZE);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aj(String str, int i) {
        if (this.dZE != null) {
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.b(this.dZE, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dZE != null) {
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.a(this.dZE, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dZE != null) {
            this.dZD.Y(704, this.dZE.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYk().d(this.dZE);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setDownloadPath(str2);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.a(this.dZE, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ak(String str, int i) {
        if (this.dZE != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aYk().d(this.dZE).extra().setPercent(i);
            if (!aYq()) {
                for (d dVar : this.dZF) {
                    dVar.a(this.dZE, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dZD.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dZD.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dZD.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dZD.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dZD.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
