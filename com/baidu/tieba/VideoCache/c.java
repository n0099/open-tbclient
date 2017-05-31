package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private long aSn;
    private long aSo;
    private long aSp;
    private long aSq;
    private long aSr;
    private FileInputStream aSs;
    private String aSy;
    private Context mContext;
    private String mVideoUrl;
    private boolean aSt = false;
    private String aSu = "";
    private Object mLock = new Object();
    private boolean aSv = false;
    private long aSw = -1;
    boolean aSx = false;
    private long aoG = 0;
    private Runnable aSA = new d(this);
    private byte[] aSz = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void M(long j) {
        this.aoG = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aSn = j;
            this.aSo = j2;
            this.aSy = o.gN(this.mVideoUrl);
            if (this.aSy != null) {
                File file = new File(String.valueOf(j.aST) + this.aSy);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aSu = file2.getAbsolutePath();
                    this.aSr = this.aSn;
                    this.aSq = this.aSn;
                    this.aSp = this.aSn;
                    this.aSt = false;
                    this.aSv = false;
                    this.aSw = -1L;
                    this.aSx = false;
                    n.JT().g(this.aSA);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aSt = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aSs != null) {
                this.aSs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aST) + this.aSy + "/completed");
        if (this.aSx) {
            return;
        }
        if (file == null || !file.exists()) {
            l.JS().gK(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aSt && this.aSq <= this.aSo;
    }

    public int e(byte[] bArr, int i) {
        if (this.aSt) {
            return 0;
        }
        do {
            if (this.aSq == this.aSr || !this.aSv) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aSs.read(bArr, 0, (int) (this.aSq + ((long) i) < this.aSr ? i : this.aSr - this.aSq));
                    if (read >= 0) {
                        this.aSq += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aSt);
        return 0;
    }
}
