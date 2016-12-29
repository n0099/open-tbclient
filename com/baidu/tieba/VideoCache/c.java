package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aPj;
    private long aPk;
    private long aPl;
    private long aPm;
    private long aPn;
    private long aPo;
    private FileInputStream aPp;
    private String aPv;
    private Context mContext;
    private boolean aPq = false;
    private String aPr = "";
    private Object mLock = new Object();
    private boolean aPs = false;
    private long aPt = -1;
    boolean aPu = false;
    private long ajS = 0;
    private Runnable aPx = new d(this);
    private byte[] aPw = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aPj = str;
    }

    public void M(long j) {
        this.ajS = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.aPj != null) {
            this.aPk = j;
            this.aPl = j2;
            this.aPv = o.ha(this.aPj);
            if (this.aPv != null) {
                File file = new File(String.valueOf(j.aPS) + this.aPv);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aPr = file2.getAbsolutePath();
                    this.aPo = this.aPk;
                    this.aPn = this.aPk;
                    this.aPm = this.aPk;
                    this.aPq = false;
                    this.aPs = false;
                    this.aPt = -1L;
                    this.aPu = false;
                    n.Kq().g(this.aPx);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aPj;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aPq = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aPp != null) {
                this.aPp.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aPS) + this.aPv + "/completed");
        if (this.aPu) {
            return;
        }
        if (file == null || !file.exists()) {
            l.Kp().gX(this.aPj);
        }
    }

    public boolean canRead() {
        return !this.aPq && this.aPn <= this.aPl;
    }

    public int e(byte[] bArr, int i) {
        if (this.aPq) {
            return 0;
        }
        do {
            if (this.aPn == this.aPo || !this.aPs) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aPp.read(bArr, 0, (int) (this.aPn + ((long) i) < this.aPo ? i : this.aPo - this.aPn));
                    if (read >= 0) {
                        this.aPn += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aPq);
        return 0;
    }
}
