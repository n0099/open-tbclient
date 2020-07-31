package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey fdH;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fdI = new HashSet();
    private final com.baidu.tieba.ad.download.c fdG = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.fdH = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bsn() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fdI.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fdI.remove(dVar);
        }
        return remove;
    }

    public boolean bso() {
        return this.fdI.isEmpty();
    }

    public void bsp() {
        if (this.fdH != null) {
            this.fdG.av(710, this.fdH.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bsi().d(this.fdH);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.f(this.fdH);
                }
            }
        }
    }

    public void bsq() {
        if (this.fdH != null) {
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.g(this.fdH);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Bd(String str) {
        if (this.fdH != null) {
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.e(this.fdH);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void as(String str, int i) {
        if (this.fdH != null) {
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.b(this.fdH, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fdH != null) {
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.a(this.fdH, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fdH != null) {
            this.fdG.av(704, this.fdH.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bsi().d(this.fdH);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setDownloadPath(str2);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.a(this.fdH, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.fdH != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bsi().d(this.fdH).extra().setPercent(i);
            if (!bso()) {
                for (d dVar : this.fdI) {
                    dVar.a(this.fdH, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.fdG.l(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.fdG.l(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.fdG.l(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.fdG.l(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.fdG.l(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
