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
    public final DownloadCacheKey fSn;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> fSo = new HashSet();
    private final com.baidu.tieba.ad.download.c fSm = new com.baidu.tieba.ad.download.c();

    public a(DownloadCacheKey downloadCacheKey) {
        this.fSn = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bIU() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.fSo.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.fSo.remove(dVar);
        }
        return remove;
    }

    public boolean bIV() {
        return this.fSo.isEmpty();
    }

    public void bIW() {
        if (this.fSn != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bIP().d(this.fSn);
            this.fSm.h(710, this.fSn.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.f(this.fSn);
                }
            }
        }
    }

    public void bIX() {
        if (this.fSn != null) {
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.g(this.fSn);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void EO(String str) {
        if (this.fSn != null) {
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.e(this.fSn);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ax(String str, int i) {
        if (this.fSn != null) {
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.b(this.fSn, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.fSn != null) {
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.a(this.fSn, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.fSn != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.d.bIP().d(this.fSn);
            this.fSm.h(704, this.fSn.mPackageName, d.getExtInfo());
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setDownloadPath(str2);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.a(this.fSn, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ay(String str, int i) {
        if (this.fSn != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bIP().d(this.fSn).extra().setPercent(i);
            if (!bIV()) {
                for (d dVar : this.fSo) {
                    dVar.a(this.fSn, this.mPercent);
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
            this.fSm.c(str, i, str2, str3);
        }
    }
}
