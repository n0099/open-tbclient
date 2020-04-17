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
    public final DownloadCacheKey eAe;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eAf = new HashSet();
    private final com.baidu.tieba.ad.download.c eAd = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eAe = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bgz() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eAf.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eAf.remove(dVar);
        }
        return remove;
    }

    public boolean bgA() {
        return this.eAf.isEmpty();
    }

    public void bgB() {
        if (this.eAe != null) {
            this.eAd.an(710, this.eAe.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgu().d(this.eAe);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.f(this.eAe);
                }
            }
        }
    }

    public void bgC() {
        if (this.eAe != null) {
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.g(this.eAe);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void yq(String str) {
        if (this.eAe != null) {
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.e(this.eAe);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void as(String str, int i) {
        if (this.eAe != null) {
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.b(this.eAe, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eAe != null) {
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.a(this.eAe, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eAe != null) {
            this.eAd.an(704, this.eAe.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgu().d(this.eAe);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setDownloadPath(str2);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.a(this.eAe, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.eAe != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bgu().d(this.eAe).extra().setPercent(i);
            if (!bgA()) {
                for (d dVar : this.eAf) {
                    dVar.a(this.eAe, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eAd.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eAd.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eAd.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eAd.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eAd.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
