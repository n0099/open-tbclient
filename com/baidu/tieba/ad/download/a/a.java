package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey dVz;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dVA = new HashSet();
    private final com.baidu.tieba.ad.download.c dVy = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dVz = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aVY() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dVA.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dVA.remove(dVar);
        }
        return remove;
    }

    public boolean aVZ() {
        return this.dVA.isEmpty();
    }

    public void aWa() {
        if (this.dVz != null) {
            this.dVy.X(710, this.dVz.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVT().d(this.dVz);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.f(this.dVz);
                }
            }
        }
    }

    public void aWb() {
        if (this.dVz != null) {
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.g(this.dVz);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void wI(String str) {
        if (this.dVz != null) {
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.e(this.dVz);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void al(String str, int i) {
        if (this.dVz != null) {
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.b(this.dVz, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dVz != null) {
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.a(this.dVz, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dVz != null) {
            this.dVy.X(704, this.dVz.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVT().d(this.dVz);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setDownloadPath(str2);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.a(this.dVz, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void am(String str, int i) {
        if (this.dVz != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aVT().d(this.dVz).extra().setPercent(i);
            if (!aVZ()) {
                for (d dVar : this.dVA) {
                    dVar.a(this.dVz, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dVy.m(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_START, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dVy.m(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dVy.m(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dVy.m(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dVy.m(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
