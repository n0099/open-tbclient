package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private String aMC;
    private long aMD;
    private long aME;
    private long aMF;
    private long aMG;
    private long aMH;
    private FileInputStream aMI;
    private String aMO;
    private Context mContext;
    private boolean aMJ = false;
    private String aMK = "";
    private Object mLock = new Object();
    private boolean aML = false;
    private long aMM = -1;
    boolean aMN = false;
    private long ajS = 0;
    private Runnable aMQ = new e(this);
    private byte[] aMP = new byte[10240];

    public d(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aMC = str;
    }

    public void N(long j) {
        this.ajS = j;
    }

    public void b(long j, long j2) {
        m.log(TAG, "open *************************************************************" + this);
        if (this.aMC != null) {
            this.aMD = j;
            this.aME = j2;
            this.aMO = q.gX(this.aMC);
            if (this.aMO != null) {
                File file = new File(String.valueOf(l.aNl) + this.aMO);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aMK = file2.getAbsolutePath();
                    this.aMH = this.aMD;
                    this.aMG = this.aMD;
                    this.aMF = this.aMD;
                    this.aMJ = false;
                    this.aML = false;
                    this.aMM = -1L;
                    this.aMN = false;
                    p.JH().g(this.aMQ);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aMC;
    }

    public void close() {
        m.log(TAG, "close ***********************************************************************" + this);
        this.aMJ = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aMI != null) {
                this.aMI.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(l.aNl) + this.aMO + "/completed");
        if (this.aMN) {
            return;
        }
        if (file == null || !file.exists()) {
            n.JG().gU(this.aMC);
        }
    }

    public boolean canRead() {
        return !this.aMJ && this.aMG <= this.aME;
    }

    public int e(byte[] bArr, int i) {
        if (this.aMJ) {
            return 0;
        }
        do {
            if (this.aMG == this.aMH || !this.aML) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.aMG + ((long) i) < this.aMH ? i : this.aMH - this.aMG);
                try {
                    this.aMI.read(bArr, 0, i2);
                    this.aMG += i2;
                    return i2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        } while (!this.aMJ);
        return 0;
    }
}
