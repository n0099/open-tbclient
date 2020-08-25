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
    public final DownloadCacheKey foZ;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fpa = new HashSet();
    private final com.baidu.tieba.ad.download.c foY = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.foZ = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bBk() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fpa.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fpa.remove(dVar);
        }
        return remove;
    }

    public boolean bBl() {
        return this.fpa.isEmpty();
    }

    public void bBm() {
        if (this.foZ != null) {
            this.foY.at(710, this.foZ.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(this.foZ);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.f(this.foZ);
                }
            }
        }
    }

    public void bBn() {
        if (this.foZ != null) {
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.g(this.foZ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Dx(String str) {
        if (this.foZ != null) {
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.e(this.foZ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void av(String str, int i) {
        if (this.foZ != null) {
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.b(this.foZ, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.foZ != null) {
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.a(this.foZ, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.foZ != null) {
            this.foY.at(704, this.foZ.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBf().d(this.foZ);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setDownloadPath(str2);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.a(this.foZ, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aw(String str, int i) {
        if (this.foZ != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bBf().d(this.foZ).extra().setPercent(i);
            if (!bBl()) {
                for (d dVar : this.fpa) {
                    dVar.a(this.foZ, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.foY.l(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.foY.l(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.foY.l(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.foY.l(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.foY.l(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
