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
    public final DownloadCacheKey gfi;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> gfj = new HashSet();
    private final com.baidu.tieba.ad.download.c gfh = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.gfi = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bLe() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.gfj.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.gfj.remove(dVar);
        }
        return remove;
    }

    public boolean bLf() {
        return this.gfj.isEmpty();
    }

    public void bLg() {
        if (this.gfi != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(this.gfi);
            this.gfh.j(710, this.gfi.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.f(this.gfi);
                }
            }
        }
    }

    public void bLh() {
        if (this.gfi != null) {
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.g(this.gfi);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Eo(String str) {
        if (this.gfi != null) {
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.e(this.gfi);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aA(String str, int i) {
        if (this.gfi != null) {
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.b(this.gfi, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.gfi != null) {
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.a(this.gfi, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.gfi != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bKZ().d(this.gfi);
            this.gfh.j(704, this.gfi.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setDownloadPath(str2);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.a(this.gfi, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aB(String str, int i) {
        if (this.gfi != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bKZ().d(this.gfi).extra().setPercent(i);
            if (!bLf()) {
                for (d dVar : this.gfj) {
                    dVar.a(this.gfi, this.mPercent);
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
            this.gfh.c(str, i, str2, str3);
        }
    }
}
