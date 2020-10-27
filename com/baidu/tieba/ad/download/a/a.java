package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes21.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey fMQ;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fMR = new HashSet();
    private final com.baidu.tieba.ad.download.c fMP = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fMQ = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bHc() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fMR.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fMR.remove(dVar);
        }
        return remove;
    }

    public boolean bHd() {
        return this.fMR.isEmpty();
    }

    public void bHe() {
        if (this.fMQ != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bGX().d(this.fMQ);
            this.fMP.h(710, this.fMQ.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.f(this.fMQ);
                }
            }
        }
    }

    public void bHf() {
        if (this.fMQ != null) {
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.g(this.fMQ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void EZ(String str) {
        if (this.fMQ != null) {
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.e(this.fMQ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aw(String str, int i) {
        if (this.fMQ != null) {
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.b(this.fMQ, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fMQ != null) {
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.a(this.fMQ, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fMQ != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bGX().d(this.fMQ);
            this.fMP.h(704, this.fMQ.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setDownloadPath(str2);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.a(this.fMQ, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ax(String str, int i) {
        if (this.fMQ != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bGX().d(this.fMQ).extra().setPercent(i);
            if (!bHd()) {
                for (d dVar : this.fMR) {
                    dVar.a(this.fMQ, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2, String str3) {
        int i;
        switch (downloadStatus) {
            case STATUS_NONE:
                i = 701;
                break;
            case STATUS_DOWNLOADING:
                i = CyberPlayerManager.MEDIA_INFO_BUFFERING_END;
                break;
            case STATUS_PAUSED:
                i = 703;
                break;
            case STATUS_SUCCESS:
                i = 705;
                break;
            case STATUS_INSTALL_SUCCESS:
                i = 706;
                break;
            default:
                i = -1;
                break;
        }
        if (i != -1) {
            this.fMP.c(str, i, str2, str3);
        }
    }
}
