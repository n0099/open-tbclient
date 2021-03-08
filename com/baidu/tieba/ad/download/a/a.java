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
    public final DownloadCacheKey gjg;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> gjh = new HashSet();
    private final com.baidu.tieba.ad.download.c gjf = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.gjg = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bLH() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.gjh.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.gjh.remove(dVar);
        }
        return remove;
    }

    public boolean bLI() {
        return this.gjh.isEmpty();
    }

    public void bLJ() {
        if (this.gjg != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLC().d(this.gjg);
            this.gjf.j(710, this.gjg.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.f(this.gjg);
                }
            }
        }
    }

    public void bLK() {
        if (this.gjg != null) {
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.g(this.gjg);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ES(String str) {
        if (this.gjg != null) {
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.e(this.gjg);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aC(String str, int i) {
        if (this.gjg != null) {
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.b(this.gjg, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.gjg != null) {
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.a(this.gjg, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.gjg != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bLC().d(this.gjg);
            this.gjf.j(704, this.gjg.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setDownloadPath(str2);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.a(this.gjg, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aD(String str, int i) {
        if (this.gjg != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bLC().d(this.gjg).extra().setPercent(i);
            if (!bLI()) {
                for (d dVar : this.gjh) {
                    dVar.a(this.gjg, this.mPercent);
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
            this.gjf.c(str, i, str2, str3);
        }
    }
}
