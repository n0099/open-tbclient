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
    public final DownloadCacheKey ghw;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> ghx = new HashSet();
    private final com.baidu.tieba.ad.download.c ghv = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.ghw = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bLy() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.ghx.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.ghx.remove(dVar);
        }
        return remove;
    }

    public boolean bLz() {
        return this.ghx.isEmpty();
    }

    public void bLA() {
        if (this.ghw != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(this.ghw);
            this.ghv.j(710, this.ghw.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.f(this.ghw);
                }
            }
        }
    }

    public void bLB() {
        if (this.ghw != null) {
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.g(this.ghw);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void EM(String str) {
        if (this.ghw != null) {
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.e(this.ghw);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aC(String str, int i) {
        if (this.ghw != null) {
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.b(this.ghw, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.ghw != null) {
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.a(this.ghw, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.ghw != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLt().d(this.ghw);
            this.ghv.j(704, this.ghw.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setDownloadPath(str2);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.a(this.ghw, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aD(String str, int i) {
        if (this.ghw != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bLt().d(this.ghw).extra().setPercent(i);
            if (!bLz()) {
                for (d dVar : this.ghx) {
                    dVar.a(this.ghw, this.mPercent);
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
            this.ghv.c(str, i, str2, str3);
        }
    }
}
