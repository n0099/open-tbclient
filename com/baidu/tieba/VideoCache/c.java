package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public class c {
    private static final String TAG = c.class.getSimpleName();
    private long aUL;
    private long aUM;
    private long aUN;
    private long aUO;
    private long aUP;
    private FileInputStream aUQ;
    private String aUW;
    private Context mContext;
    private String mVideoUrl;
    private boolean aUR = false;
    private String aUS = "";
    private Object mLock = new Object();
    private boolean aUT = false;
    private long aUU = -1;
    boolean aUV = false;
    private long aoW = 0;
    private Runnable aUY = new d(this);
    private byte[] aUX = new byte[10240];

    public c(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.mVideoUrl = str;
    }

    public void M(long j) {
        this.aoW = j;
    }

    public void b(long j, long j2) {
        k.log(TAG, "open *************************************************************" + this);
        if (this.mVideoUrl != null) {
            this.aUL = j;
            this.aUM = j2;
            this.aUW = o.gS(this.mVideoUrl);
            if (this.aUW != null) {
                File file = new File(String.valueOf(j.aVr) + this.aUW);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aUS = file2.getAbsolutePath();
                    this.aUP = this.aUL;
                    this.aUO = this.aUL;
                    this.aUN = this.aUL;
                    this.aUR = false;
                    this.aUT = false;
                    this.aUU = -1L;
                    this.aUV = false;
                    n.KY().g(this.aUY);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.mVideoUrl;
    }

    public void close() {
        k.log(TAG, "close ***********************************************************************" + this);
        this.aUR = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aUQ != null) {
                this.aUQ.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(j.aVr) + this.aUW + "/completed");
        if (this.aUV) {
            return;
        }
        if (file == null || !file.exists()) {
            l.KX().gP(this.mVideoUrl);
        }
    }

    public boolean canRead() {
        return !this.aUR && this.aUO <= this.aUM;
    }

    public int e(byte[] bArr, int i) {
        if (this.aUR) {
            return 0;
        }
        do {
            if (this.aUO == this.aUP || !this.aUT) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                try {
                    int read = this.aUQ.read(bArr, 0, (int) (this.aUO + ((long) i) < this.aUP ? i : this.aUP - this.aUO));
                    if (read >= 0) {
                        this.aUO += read;
                        return read;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return 0;
            }
        } while (!this.aUR);
        return 0;
    }
}
