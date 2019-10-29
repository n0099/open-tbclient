package com.baidu.tieba.ad.download.a;

import android.support.annotation.Nullable;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey div;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> diw = new HashSet();
    private final com.baidu.tieba.ad.download.c diu = new com.baidu.tieba.ad.download.c("DOWNLOAD_PAGE", "DOWNLOAD_BUTTON", "");

    public a(DownloadCacheKey downloadCacheKey) {
        this.div = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aDN() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.diw.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.diw.remove(dVar);
        }
        return remove;
    }

    public boolean aDO() {
        return this.diw.isEmpty();
    }

    public void aDP() {
        if (this.div != null) {
            this.diu.O(710, this.div.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDI().d(this.div);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.f(this.div);
                }
            }
        }
    }

    public void aDQ() {
        if (this.div != null) {
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.g(this.div);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void rv(String str) {
        if (this.div != null) {
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.e(this.div);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Y(String str, int i) {
        if (this.div != null) {
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.b(this.div, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.div != null) {
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.a(this.div, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.div != null) {
            this.diu.O(704, this.div.mPackageName);
            AdDownloadData d = com.baidu.tieba.ad.download.d.aDI().d(this.div);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setDownloadPath(str2);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.a(this.div, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void Z(String str, int i) {
        if (this.div != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.d.aDI().d(this.div).extra().setPercent(i);
            if (!aDO()) {
                for (d dVar : this.diw) {
                    dVar.a(this.div, this.mPercent);
                }
            }
        }
    }

    public void a(String str, DownloadStatus downloadStatus, @Nullable String str2) {
        switch (downloadStatus) {
            case STATUS_NONE:
                this.diu.j(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_START, str2);
                return;
            case STATUS_DOWNLOADING:
                this.diu.j(str, CyberPlayerManager.MEDIA_INFO_BUFFERING_END, str2);
                return;
            case STATUS_PAUSED:
                this.diu.j(str, 703, str2);
                return;
            case STATUS_SUCCESS:
                this.diu.j(str, 705, str2);
                return;
            case STATUS_INSTALL_SUCCESS:
                this.diu.j(str, 706, str2);
                return;
            default:
                return;
        }
    }
}
