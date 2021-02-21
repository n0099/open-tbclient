package com.baidu.tieba.ad.download.a;

import androidx.annotation.Nullable;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import com.kwai.video.player.PlayerPostEvent;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey ghC;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> ghD = new HashSet();
    private final com.baidu.tieba.ad.download.c ghB = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.ghC = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bLD() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.ghD.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.ghD.remove(dVar);
        }
        return remove;
    }

    public boolean bLE() {
        return this.ghD.isEmpty();
    }

    public void bLF() {
        if (this.ghC != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(this.ghC);
            this.ghB.j(710, this.ghC.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.f(this.ghC);
                }
            }
        }
    }

    public void bLG() {
        if (this.ghC != null) {
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.g(this.ghC);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void EL(String str) {
        if (this.ghC != null) {
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.e(this.ghC);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aC(String str, int i) {
        if (this.ghC != null) {
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.b(this.ghC, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.ghC != null) {
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.a(this.ghC, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.ghC != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLy().d(this.ghC);
            this.ghB.j(704, this.ghC.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setDownloadPath(str2);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.a(this.ghC, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aD(String str, int i) {
        if (this.ghC != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bLy().d(this.ghC).extra().setPercent(i);
            if (!bLE()) {
                for (d dVar : this.ghD) {
                    dVar.a(this.ghC, this.mPercent);
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
                i = 702;
                break;
            case STATUS_PAUSED:
                i = PlayerPostEvent.MEDIA_INFO_NETWORK_BANDWIDTH;
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
            this.ghB.c(str, i, str2, str3);
        }
    }
}
