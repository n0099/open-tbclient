package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes15.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey fpd;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fpe = new HashSet();
    private final com.baidu.tieba.ad.download.c fpc = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fpd = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bBl() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fpe.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fpe.remove(dVar);
        }
        return remove;
    }

    public boolean bBm() {
        return this.fpe.isEmpty();
    }

    public void bBn() {
        if (this.fpd != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBg().d(this.fpd);
            this.fpc.g(710, this.fpd.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.f(this.fpd);
                }
            }
        }
    }

    public void bBo() {
        if (this.fpd != null) {
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.g(this.fpd);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Dy(String str) {
        if (this.fpd != null) {
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.e(this.fpd);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void av(String str, int i) {
        if (this.fpd != null) {
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.b(this.fpd, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fpd != null) {
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.a(this.fpd, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fpd != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bBg().d(this.fpd);
            this.fpc.g(704, this.fpd.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setDownloadPath(str2);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.a(this.fpd, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aw(String str, int i) {
        if (this.fpd != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bBg().d(this.fpd).extra().setPercent(i);
            if (!bBm()) {
                for (d dVar : this.fpe) {
                    dVar.a(this.fpd, this.mPercent);
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
            this.fpc.c(str, i, str2, str3);
        }
    }
}
