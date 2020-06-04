package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes8.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey eOU;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> eOV = new HashSet();
    private final com.baidu.tieba.ad.download.c eOT = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.eOU = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int bmK() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.eOV.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.eOV.remove(dVar);
        }
        return remove;
    }

    public boolean bmL() {
        return this.eOV.isEmpty();
    }

    public void bmM() {
        if (this.eOU != null) {
            this.eOT.as(710, this.eOU.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(this.eOU);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.f(this.eOU);
                }
            }
        }
    }

    public void bmN() {
        if (this.eOU != null) {
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.g(this.eOU);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void zZ(String str) {
        if (this.eOU != null) {
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.e(this.eOU);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void at(String str, int i) {
        if (this.eOU != null) {
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.b(this.eOU, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.eOU != null) {
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.a(this.eOU, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.eOU != null) {
            this.eOT.as(704, this.eOU.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.bmF().d(this.eOU);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setDownloadPath(str2);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.a(this.eOU, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void au(String str, int i) {
        if (this.eOU != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.bmF().d(this.eOU).extra().setPercent(i);
            if (!bmL()) {
                for (d dVar : this.eOV) {
                    dVar.a(this.eOU, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.eOT.l(str, 701, str2);
                return;
            case STATUS_DOWNLOADING:
                this.eOT.l(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.eOT.l(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.eOT.l(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.eOT.l(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
