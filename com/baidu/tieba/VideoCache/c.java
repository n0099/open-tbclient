package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private long aUo;
    private long aUp;
    private long aUq;
    private long aUr;
    private long aUs;
    private FileInputStream aUt;
    private String aUz;
    private Context mContext;
    private String mVideoUrl;
    private boolean aUu = false;
    private String aUv = "";
    private Object mLock = new Object();
    private boolean aUw = false;
    private long aUx = -1;
    boolean aUy = false;
    private long aoR = 0;
    private Runnable aUB = new d(this);
    private byte[] aUA = new byte[10240];

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
            this.aUo = j;
            this.aUp = j2;
            this.aUz = o.gU(this.mVideoUrl);
            if (this.aUz != null) {
                File file = new File(String.valueOf(j.aUU) + this.aUz);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aUv = file2.getAbsolutePath();
                    this.aUs = this.aUo;
                    this.aUr = this.aUo;
                    this.aUq = this.aUo;
                    this.aUu = false;
                    this.aUw = false;
                    this.aUx = -1L;
                    this.aUy = false;
                    n.LK().g(this.aUB);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aUu = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aUt != null) {
                this.aUt.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aUU) + this.aUz + "/completed");
        if (this.aUy) {
            return;
        }
        if (file == null || !file.exists()) {
            l.LJ().gR(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aUu && this.aUr <= this.aUp;
    }

    public int e(byte[] bArr, int i) {
        if (this.aUu) {
            return 0;
        }
        do {
            if (this.aUr == this.aUs || !this.aUw) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aUt.read(bArr, 0, (int) (this.aUr + ((long) i) < this.aUs ? i : this.aUs - this.aUr));
                    if (read >= 0) {
                        this.aUr += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aUu);
        return 0;
    }
}
