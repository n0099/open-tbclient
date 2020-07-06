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
    public final DownloadCacheKey eZf;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eZg = new HashSet();
    private final com.baidu.tieba.ad.download.c eZe = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eZf = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bpl() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eZg.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eZg.remove(dVar);
        }
        return remove;
    }

    public boolean bpm() {
        return this.eZg.isEmpty();
    }

    public void bpn() {
        if (this.eZf != null) {
            this.eZe.au(710, this.eZf.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bpg().d(this.eZf);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.f(this.eZf);
                }
            }
        }
    }

    public void bpo() {
        if (this.eZf != null) {
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.g(this.eZf);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void As(String str) {
        if (this.eZf != null) {
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.e(this.eZf);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.eZf != null) {
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.b(this.eZf, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eZf != null) {
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.a(this.eZf, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eZf != null) {
            this.eZe.au(704, this.eZf.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bpg().d(this.eZf);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setDownloadPath(str2);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.a(this.eZf, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void au(String str, int i) {
        if (this.eZf != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bpg().d(this.eZf).extra().setPercent(i);
            if (!bpm()) {
                for (d dVar : this.eZg) {
                    dVar.a(this.eZf, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eZe.l(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eZe.l(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eZe.l(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eZe.l(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eZe.l(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
