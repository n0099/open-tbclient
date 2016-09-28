package com.baidu.tieba.VideoCache;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes.dex */
public class d {
    private static final String TAG = d.class.getSimpleName();
    private String aNM;
    private long aNN;
    private long aNO;
    private long aNP;
    private long aNQ;
    private long aNR;
    private FileInputStream aNS;
    private String aNY;
    private Context mContext;
    private boolean aNT = false;
    private String aNU = "";
    private Object mLock = new Object();
    private boolean aNV = false;
    private long aNW = -1;
    boolean aNX = false;
    private long ajy = 0;
    private Runnable aOa = new e(this);
    private byte[] aNZ = new byte[10240];

    public d(Context context) {
        this.mContext = context;
    }

    public void setVideoUrl(String str) {
        this.aNM = str;
    }

    public void O(long j) {
        this.ajy = j;
    }

    public void b(long j, long j2) {
        m.log(TAG, "open *************************************************************" + this);
        if (this.aNM != null) {
            this.aNN = j;
            this.aNO = j2;
            this.aNY = q.he(this.aNM);
            if (this.aNY != null) {
                File file = new File(String.valueOf(l.aOv) + this.aNY);
                File file2 = new File(String.valueOf(file.getAbsolutePath()) + "/segments");
                if (file != null && file2 != null) {
                    if (!file.exists()) {
                        file.mkdir();
                    }
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    this.aNU = file2.getAbsolutePath();
                    this.aNR = this.aNN;
                    this.aNQ = this.aNN;
                    this.aNP = this.aNN;
                    this.aNT = false;
                    this.aNV = false;
                    this.aNW = -1L;
                    this.aNX = false;
                    p.Kt().g(this.aOa);
                }
            }
        }
    }

    public String getVideoUrl() {
        return this.aNM;
    }

    public void close() {
        m.log(TAG, "close ***********************************************************************" + this);
        this.aNT = true;
        synchronized (this.mLock) {
            this.mLock.notify();
        }
        try {
            if (this.aNS != null) {
                this.aNS.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        File file = new File(String.valueOf(l.aOv) + this.aNY + "/completed");
        if (this.aNX) {
            return;
        }
        if (file == null || !file.exists()) {
            n.Ks().hb(this.aNM);
        }
    }

    public boolean canRead() {
        return !this.aNT && this.aNQ <= this.aNO;
    }

    public int e(byte[] bArr, int i) {
        if (this.aNT) {
            return 0;
        }
        do {
            if (this.aNQ == this.aNR || !this.aNV) {
                synchronized (this.mLock) {
                    try {
                        this.mLock.wait(1000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                int i2 = (int) (this.aNQ + ((long) i) < this.aNR ? i : this.aNR - this.aNQ);
                try {
                    this.aNS.read(bArr, 0, i2);
                    this.aNQ += i2;
                    return i2;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        } while (!this.aNT);
        return 0;
    }
}
