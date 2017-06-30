package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private long aTG;
    private long aTH;
    private long aTI;
    private long aTJ;
    private long aTK;
    private FileInputStream aTL;
    private String aTR;
    private Context mContext;
    private String mVideoUrl;
    private boolean aTM = false;
    private String aTN = "";
    private Object mLock = new Object();
    private boolean aTO = false;
    private long aTP = -1;
    boolean aTQ = false;
    private long apH = 0;
    private Runnable aTT = new d(this);
    private byte[] aTS = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void N(long j) {
        this.apH = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aTG = j;
            this.aTH = j2;
            this.aTR = o.hk(this.mVideoUrl);
            if (this.aTR != null) {
                File file = new File(String.valueOf(j.aUm) + this.aTR);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aTN = file2.getAbsolutePath();
                    this.aTK = this.aTG;
                    this.aTJ = this.aTG;
                    this.aTI = this.aTG;
                    this.aTM = false;
                    this.aTO = false;
                    this.aTP = -1L;
                    this.aTQ = false;
                    n.Kr().g(this.aTT);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aTM = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aTL != null) {
                this.aTL.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aUm) + this.aTR + "/completed");
        if (this.aTQ) {
            return;
        }
        if (file == null || !file.exists()) {
            l.Kq().hh(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aTM && this.aTJ <= this.aTH;
    }

    public int e(byte[] bArr, int i) {
        if (this.aTM) {
            return 0;
        }
        do {
            if (this.aTJ == this.aTK || !this.aTO) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aTL.read(bArr, 0, (int) (this.aTJ + ((long) i) < this.aTK ? i : this.aTK - this.aTJ));
                    if (read >= 0) {
                        this.aTJ += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aTM);
        return 0;
    }
}
