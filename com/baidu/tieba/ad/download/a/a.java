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
    public final DownloadCacheKey fSG;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fSH = new HashSet();
    private final com.baidu.tieba.ad.download.c fSF = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fSG = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bJB() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fSH.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fSH.remove(dVar);
        }
        return remove;
    }

    public boolean bJC() {
        return this.fSH.isEmpty();
    }

    public void bJD() {
        if (this.fSG != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(this.fSG);
            this.fSF.h(710, this.fSG.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.f(this.fSG);
                }
            }
        }
    }

    public void bJE() {
        if (this.fSG != null) {
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.g(this.fSG);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Fn(String str) {
        if (this.fSG != null) {
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.e(this.fSG);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ay(String str, int i) {
        if (this.fSG != null) {
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.b(this.fSG, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fSG != null) {
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.a(this.fSG, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fSG != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bJw().d(this.fSG);
            this.fSF.h(704, this.fSG.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setDownloadPath(str2);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.a(this.fSG, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void az(String str, int i) {
        if (this.fSG != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bJw().d(this.fSG).extra().setPercent(i);
            if (!bJC()) {
                for (d dVar : this.fSH) {
                    dVar.a(this.fSG, this.mPercent);
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
            this.fSF.c(str, i, str2, str3);
        }
    }
}
