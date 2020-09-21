package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes20.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey fsk;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fsl = new HashSet();
    private final com.baidu.tieba.ad.download.c fsj = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fsk = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bCx() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fsl.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fsl.remove(dVar);
        }
        return remove;
    }

    public boolean bCy() {
        return this.fsl.isEmpty();
    }

    public void bCz() {
        if (this.fsk != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(this.fsk);
            this.fsj.g(710, this.fsk.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.f(this.fsk);
                }
            }
        }
    }

    public void bCA() {
        if (this.fsk != null) {
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.g(this.fsk);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void DV(String str) {
        if (this.fsk != null) {
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.e(this.fsk);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void av(String str, int i) {
        if (this.fsk != null) {
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.b(this.fsk, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fsk != null) {
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.a(this.fsk, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fsk != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bCs().d(this.fsk);
            this.fsj.g(704, this.fsk.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setDownloadPath(str2);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.a(this.fsk, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aw(String str, int i) {
        if (this.fsk != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bCs().d(this.fsk).extra().setPercent(i);
            if (!bCy()) {
                for (d dVar : this.fsl) {
                    dVar.a(this.fsk, this.mPercent);
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
            this.fsj.c(str, i, str2, str3);
        }
    }
}
