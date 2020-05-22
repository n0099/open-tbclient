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
    public final DownloadCacheKey eOJ;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eOK = new HashSet();
    private final com.baidu.tieba.ad.download.c eOI = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eOJ = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bmI() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eOK.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eOK.remove(dVar);
        }
        return remove;
    }

    public boolean bmJ() {
        return this.eOK.isEmpty();
    }

    public void bmK() {
        if (this.eOJ != null) {
            this.eOI.as(710, this.eOJ.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmD().d(this.eOJ);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.f(this.eOJ);
                }
            }
        }
    }

    public void bmL() {
        if (this.eOJ != null) {
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.g(this.eOJ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void zZ(String str) {
        if (this.eOJ != null) {
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.e(this.eOJ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.eOJ != null) {
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.b(this.eOJ, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eOJ != null) {
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.a(this.eOJ, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eOJ != null) {
            this.eOI.as(704, this.eOJ.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmD().d(this.eOJ);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setDownloadPath(str2);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.a(this.eOJ, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void au(String str, int i) {
        if (this.eOJ != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bmD().d(this.eOJ).extra().setPercent(i);
            if (!bmJ()) {
                for (d dVar : this.eOK) {
                    dVar.a(this.eOJ, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eOI.l(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eOI.l(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eOI.l(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eOI.l(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eOI.l(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
