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
    public final DownloadCacheKey dZD;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> dZE = new HashSet();
    private final com.baidu.tieba.ad.download.c dZC = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.dZD = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aYn() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.dZE.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.dZE.remove(dVar);
        }
        return remove;
    }

    public boolean aYo() {
        return this.dZE.isEmpty();
    }

    public void aYp() {
        if (this.dZD != null) {
            this.dZC.Y(710, this.dZD.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYi().d(this.dZD);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.f(this.dZD);
                }
            }
        }
    }

    public void aYq() {
        if (this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.g(this.dZD);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void xc(String str) {
        if (this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.e(this.dZD);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aj(String str, int i) {
        if (this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.b(this.dZD, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.dZD != null) {
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.a(this.dZD, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.dZD != null) {
            this.dZC.Y(704, this.dZD.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYi().d(this.dZD);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setDownloadPath(str2);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.a(this.dZD, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ak(String str, int i) {
        if (this.dZD != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aYi().d(this.dZD).extra().setPercent(i);
            if (!aYo()) {
                for (d dVar : this.dZE) {
                    dVar.a(this.dZD, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.dZC.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.dZC.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.dZC.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.dZC.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.dZC.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
