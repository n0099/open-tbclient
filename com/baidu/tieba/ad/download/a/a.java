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
    public final DownloadCacheKey eAj;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eAk = new HashSet();
    private final com.baidu.tieba.ad.download.c eAi = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eAj = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bgx() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eAk.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eAk.remove(dVar);
        }
        return remove;
    }

    public boolean bgy() {
        return this.eAk.isEmpty();
    }

    public void bgz() {
        if (this.eAj != null) {
            this.eAi.an(710, this.eAj.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgs().d(this.eAj);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.f(this.eAj);
                }
            }
        }
    }

    public void bgA() {
        if (this.eAj != null) {
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.g(this.eAj);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void yt(String str) {
        if (this.eAj != null) {
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.e(this.eAj);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void as(String str, int i) {
        if (this.eAj != null) {
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.b(this.eAj, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eAj != null) {
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.a(this.eAj, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eAj != null) {
            this.eAi.an(704, this.eAj.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bgs().d(this.eAj);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setDownloadPath(str2);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.a(this.eAj, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.eAj != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bgs().d(this.eAj).extra().setPercent(i);
            if (!bgy()) {
                for (d dVar : this.eAk) {
                    dVar.a(this.eAj, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eAi.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eAi.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eAi.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eAi.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eAi.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
