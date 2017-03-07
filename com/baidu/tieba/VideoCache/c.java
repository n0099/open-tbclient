package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aTZ;
    private long aUa;
    private long aUb;
    private long aUc;
    private long aUd;
    private long aUe;
    private FileInputStream aUf;
    private String aUl;
    private Context mContext;
    private boolean aUg = false;
    private String aUh = "";
    private Object mLock = new Object();
    private boolean aUi = false;
    private long aUj = -1;
    boolean aUk = false;
    private long aoC = 0;
    private Runnable aUn = new d(this);
    private byte[] aUm = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aTZ = str;
    }

    public void L(long j) {
        this.aoC = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.aTZ != null) {
            this.aUa = j;
            this.aUb = j2;
            this.aUl = o.gQ(this.aTZ);
            if (this.aUl != null) {
                File file = new File(String.valueOf(j.aUH) + this.aUl);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aUh = file2.getAbsolutePath();
                    this.aUe = this.aUa;
                    this.aUd = this.aUa;
                    this.aUc = this.aUa;
                    this.aUg = false;
                    this.aUi = false;
                    this.aUj = -1L;
                    this.aUk = false;
                    n.Lk().g(this.aUn);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aTZ;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aUg = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aUf != null) {
                this.aUf.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aUH) + this.aUl + "/completed");
        if (this.aUk) {
            return;
        }
        if (file == null || !file.exists()) {
            l.Lj().gN(this.aTZ);
        }
    }

    public boolean canRead() {
        return !this.aUg && this.aUd <= this.aUb;
    }

    public int e(byte[] bArr, int i) {
        if (this.aUg) {
            return 0;
        }
        do {
            if (this.aUd == this.aUe || !this.aUi) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aUf.read(bArr, 0, (int) (this.aUd + ((long) i) < this.aUe ? i : this.aUe - this.aUd));
                    if (read >= 0) {
                        this.aUd += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aUg);
        return 0;
    }
}
