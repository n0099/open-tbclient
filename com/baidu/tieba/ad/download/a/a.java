package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes5.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey dVq;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dVr = new HashSet();
    private final com.baidu.tieba.ad.download.c dVp = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dVq = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aVF() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dVr.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dVr.remove(dVar);
        }
        return remove;
    }

    public boolean aVG() {
        return this.dVr.isEmpty();
    }

    public void aVH() {
        if (this.dVq != null) {
            this.dVp.V(710, this.dVq.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVA().d(this.dVq);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.f(this.dVq);
                }
            }
        }
    }

    public void aVI() {
        if (this.dVq != null) {
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.g(this.dVq);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void wE(String str) {
        if (this.dVq != null) {
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.e(this.dVq);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ak(String str, int i) {
        if (this.dVq != null) {
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.b(this.dVq, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dVq != null) {
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.a(this.dVq, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dVq != null) {
            this.dVp.V(704, this.dVq.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aVA().d(this.dVq);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setDownloadPath(str2);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.a(this.dVq, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void al(String str, int i) {
        if (this.dVq != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aVA().d(this.dVq).extra().setPercent(i);
            if (!aVG()) {
                for (d dVar : this.dVr) {
                    dVar.a(this.dVq, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dVp.m(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_START, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dVp.m(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dVp.m(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dVp.m(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dVp.m(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
