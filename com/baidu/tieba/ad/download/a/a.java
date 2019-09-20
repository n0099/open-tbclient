package com.baidu.tieba.ad.download.a;

import com.baidu.tieba.ad.download.AdDownloadData;
import com.baidu.tieba.ad.download.DownloadCacheKey;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.ad.download.state.StopStatus;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public class a implements c {
    private static final String TAG = a.class.getSimpleName();
    public final DownloadCacheKey cYW;
    private final Object mLock = new Object();
    private int mPercent = 0;
    private int mState = 0;
    private final Set<d> cYX = new HashSet();

    public a(DownloadCacheKey downloadCacheKey) {
        this.cYW = downloadCacheKey;
    }

    public void setState(int i) {
        this.mState = i;
    }

    public int aDE() {
        return this.mState;
    }

    public boolean a(d dVar) {
        boolean add;
        synchronized (this.mLock) {
            add = this.cYX.add(dVar);
        }
        return add;
    }

    public boolean b(d dVar) {
        boolean remove;
        synchronized (this.mLock) {
            remove = this.cYX.remove(dVar);
        }
        return remove;
    }

    public boolean aDF() {
        return this.cYX.isEmpty();
    }

    public void aDG() {
        if (this.cYW != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.c.aDA().d(this.cYW);
            d.extra().setStatus(DownloadStatus.STATUS_INSTALL_SUCCESS);
            d.extra().setPercent(100);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.f(this.cYW);
                }
            }
        }
    }

    public void aDH() {
        if (this.cYW != null) {
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.g(this.cYW);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void sM(String str) {
        if (this.cYW != null) {
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setStatus(DownloadStatus.STATUS_DOWNLOADING);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.e(this.cYW);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ah(String str, int i) {
        if (this.cYW != null) {
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setStatus(DownloadStatus.STATUS_PAUSED);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.b(this.cYW, this.mPercent);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void a(String str, StopStatus stopStatus) {
        if (this.cYW != null) {
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setStatus(DownloadStatus.STATUS_NONE);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.a(this.cYW, stopStatus);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void onSuccess(String str, String str2) {
        if (this.cYW != null) {
            AdDownloadData d = com.baidu.tieba.ad.download.c.aDA().d(this.cYW);
            d.extra().setStatus(DownloadStatus.STATUS_SUCCESS);
            d.extra().setPercent(100);
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setDownloadPath(str2);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.a(this.cYW, str2, false);
                }
            }
        }
    }

    @Override // com.baidu.tieba.ad.download.a.c
    public void ai(String str, int i) {
        if (this.cYW != null) {
            this.mPercent = i;
            com.baidu.tieba.ad.download.c.aDA().d(this.cYW).extra().setPercent(i);
            if (!aDF()) {
                for (d dVar : this.cYX) {
                    dVar.a(this.cYW, this.mPercent);
                }
            }
        }
    }
}
