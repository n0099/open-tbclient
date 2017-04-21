package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private String aUB;
    private long aUq;
    private long aUr;
    private long aUs;
    private long aUt;
    private long aUu;
    private FileInputStream aUv;
    private Context mContext;
    private String mVideoUrl;
    private boolean aUw = false;
    private String aUx = "";
    private Object mLock = new Object();
    private boolean aUy = false;
    private long aUz = -1;
    boolean aUA = false;
    private long aoR = 0;
    private Runnable aUD = new d(this);
    private byte[] aUC = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void L(long j) {
        this.aoR = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aUq = j;
            this.aUr = j2;
            this.aUB = o.gU(this.mVideoUrl);
            if (this.aUB != null) {
                File file = new File(String.valueOf(j.aUW) + this.aUB);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aUx = file2.getAbsolutePath();
                    this.aUu = this.aUq;
                    this.aUt = this.aUq;
                    this.aUs = this.aUq;
                    this.aUw = false;
                    this.aUy = false;
                    this.aUz = -1L;
                    this.aUA = false;
                    n.LK().g(this.aUD);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aUw = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aUv != null) {
                this.aUv.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aUW) + this.aUB + "/completed");
        if (this.aUA) {
            return;
        }
        if (file == null || !file.exists()) {
            l.LJ().gR(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aUw && this.aUt <= this.aUr;
    }

    public int e(byte[] bArr, int i) {
        if (this.aUw) {
            return 0;
        }
        do {
            if (this.aUt == this.aUu || !this.aUy) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aUv.read(bArr, 0, (int) (this.aUt + ((long) i) < this.aUu ? i : this.aUu - this.aUt));
                    if (read >= 0) {
                        this.aUt += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aUw);
        return 0;
    }
}
