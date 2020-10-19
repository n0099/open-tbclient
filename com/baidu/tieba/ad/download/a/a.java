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
    public final DownloadCacheKey fEv;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fEw = new HashSet();
    private final com.baidu.tieba.ad.download.c fEu = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fEv = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bFj() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fEw.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fEw.remove(dVar);
        }
        return remove;
    }

    public boolean bFk() {
        return this.fEw.isEmpty();
    }

    public void bFl() {
        if (this.fEv != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(this.fEv);
            this.fEu.g(710, this.fEv.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.f(this.fEv);
                }
            }
        }
    }

    public void bFm() {
        if (this.fEv != null) {
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.g(this.fEv);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void EG(String str) {
        if (this.fEv != null) {
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.e(this.fEv);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void aw(String str, int i) {
        if (this.fEv != null) {
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.b(this.fEv, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fEv != null) {
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.a(this.fEv, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fEv != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bFe().d(this.fEv);
            this.fEu.g(704, this.fEv.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setDownloadPath(str2);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.a(this.fEv, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ax(String str, int i) {
        if (this.fEv != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bFe().d(this.fEv).extra().setPercent(i);
            if (!bFk()) {
                for (d dVar : this.fEw) {
                    dVar.a(this.fEv, this.mPercent);
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
            this.fEu.c(str, i, str2, str3);
        }
    }
}
