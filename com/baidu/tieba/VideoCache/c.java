package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aOm;
    private long aOn;
    private long aOo;
    private long aOp;
    private long aOq;
    private long aOr;
    private FileInputStream aOs;
    private String aOy;
    private Context mContext;
    private boolean aOt = false;
    private String aOu = "";
    private Object mLock = new Object();
    private boolean aOv = false;
    private long aOw = -1;
    boolean aOx = false;
    private long ajf = 0;
    private Runnable aOA = new d(this);
    private byte[] aOz = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aOm = str;
    }

    public void L(long j) {
        this.ajf = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.aOm != null) {
            this.aOn = j;
            this.aOo = j2;
            this.aOy = o.hb(this.aOm);
            if (this.aOy != null) {
                File file = new File(String.valueOf(j.aOV) + this.aOy);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aOu = file2.getAbsolutePath();
                    this.aOr = this.aOn;
                    this.aOq = this.aOn;
                    this.aOp = this.aOn;
                    this.aOt = false;
                    this.aOv = false;
                    this.aOw = -1L;
                    this.aOx = false;
                    n.KF().g(this.aOA);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aOm;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aOt = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aOs != null) {
                this.aOs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aOV) + this.aOy + "/completed");
        if (this.aOx) {
            return;
        }
        if (file == null || !file.exists()) {
            l.KE().gY(this.aOm);
        }
    }

    public boolean canRead() {
        return !this.aOt && this.aOq <= this.aOo;
    }

    public int e(byte[] bArr, int i) {
        if (this.aOt) {
            return 0;
        }
        do {
            if (this.aOq == this.aOr || !this.aOv) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aOs.read(bArr, 0, (int) (this.aOq + ((long) i) < this.aOr ? i : this.aOr - this.aOq));
                    if (read >= 0) {
                        this.aOq += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aOt);
        return 0;
    }
}
