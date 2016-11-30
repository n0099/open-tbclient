package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private String aPS;
    private long aPT;
    private long aPU;
    private long aPV;
    private long aPW;
    private long aPX;
    private FileInputStream aPY;
    private String aQe;
    private Context mContext;
    private boolean aPZ = false;
    private String aQa = "";
    private Object mLock = new Object();
    private boolean aQb = false;
    private long aQc = -1;
    boolean aQd = false;
    private long akq = 0;
    private Runnable aQg = new e(this);
    private byte[] aQf = new byte[10240];

    public d(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aPS = str;
    }

    public void N(long j) {
        this.akq = j;
    }

    public void b(long j, long j2) {
        m.log(TAG, "open *************************************************************" + this);
        if (this.aPS != null) {
            this.aPT = j;
            this.aPU = j2;
            this.aQe = q.hf(this.aPS);
            if (this.aQe != null) {
                File file = new File(String.valueOf(l.aQB) + this.aQe);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aQa = file2.getAbsolutePath();
                    this.aPX = this.aPT;
                    this.aPW = this.aPT;
                    this.aPV = this.aPT;
                    this.aPZ = false;
                    this.aQb = false;
                    this.aQc = -1L;
                    this.aQd = false;
                    p.KX().g(this.aQg);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aPS;
    }

    public void close() {
        m.log(TAG, "close ***********************************************************************" + this);
        this.aPZ = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aPY != null) {
                this.aPY.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(l.aQB) + this.aQe + "/completed");
        if (this.aQd) {
            return;
        }
        if (file == null || !file.exists()) {
            n.KW().hc(this.aPS);
        }
    }

    public boolean canRead() {
        return !this.aPZ && this.aPW <= this.aPU;
    }

    public int e(byte[] bArr, int i) {
        if (this.aPZ) {
            return 0;
        }
        do {
            if (this.aPW == this.aPX || !this.aQb) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aPY.read(bArr, 0, (int) (this.aPW + ((long) i) < this.aPX ? i : this.aPX - this.aPW));
                    if (read >= 0) {
                        this.aPW += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aPZ);
        return 0;
    }
}
