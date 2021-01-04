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
    public final DownloadCacheKey gjQ;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> gjR = new HashSet();
    private final com.baidu.tieba.ad.download.c gjP = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.gjQ = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bOV() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.gjR.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.gjR.remove(dVar);
        }
        return remove;
    }

    public boolean bOW() {
        return this.gjR.isEmpty();
    }

    public void bOX() {
        if (this.gjQ != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ);
            this.gjP.j(710, this.gjQ.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.f(this.gjQ);
                }
            }
        }
    }

    public void bOY() {
        if (this.gjQ != null) {
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.g(this.gjQ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void FA(String str) {
        if (this.gjQ != null) {
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.e(this.gjQ);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aA(String str, int i) {
        if (this.gjQ != null) {
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.b(this.gjQ, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.gjQ != null) {
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.a(this.gjQ, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.gjQ != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ);
            this.gjP.j(704, this.gjQ.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setDownloadPath(str2);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.a(this.gjQ, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aB(String str, int i) {
        if (this.gjQ != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bOQ().d(this.gjQ).extra().setPercent(i);
            if (!bOW()) {
                for (d dVar : this.gjR) {
                    dVar.a(this.gjQ, this.mPercent);
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
            this.gjP.c(str, i, str2, str3);
        }
    }
}
