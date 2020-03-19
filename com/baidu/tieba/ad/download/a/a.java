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
    public final DownloadCacheKey eah;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eai = new HashSet();
    private final com.baidu.tieba.ad.download.c eag = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eah = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aYu() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eai.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eai.remove(dVar);
        }
        return remove;
    }

    public boolean aYv() {
        return this.eai.isEmpty();
    }

    public void aYw() {
        if (this.eah != null) {
            this.eag.Y(710, this.eah.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYp().d(this.eah);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.f(this.eah);
                }
            }
        }
    }

    public void aYx() {
        if (this.eah != null) {
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.g(this.eah);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void xe(String str) {
        if (this.eah != null) {
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.e(this.eah);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aj(String str, int i) {
        if (this.eah != null) {
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.b(this.eah, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eah != null) {
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.a(this.eah, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eah != null) {
            this.eag.Y(704, this.eah.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aYp().d(this.eah);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setDownloadPath(str2);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.a(this.eah, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ak(String str, int i) {
        if (this.eah != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aYp().d(this.eah).extra().setPercent(i);
            if (!aYv()) {
                for (d dVar : this.eai) {
                    dVar.a(this.eah, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eag.n(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eag.n(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eag.n(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eag.n(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eag.n(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
