package com.baidu.tbadk.p.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long ban;
    private long mStartTime;
    private long cKT = 0;
    private int cKU = 0;
    private int mFps = -1;
    private boolean cKV = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.ban = this.mStartTime + 1000;
        this.cKT = 0L;
        this.cKU = 0;
        this.mFps = -1;
        this.cKV = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cKV = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ba(System.currentTimeMillis());
        this.cKU = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cKT != 0) {
            long j2 = (j - this.cKT) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cKU = (int) ((j2 / 16) + this.cKU);
            }
        }
        this.cKT = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.ban && !this.cKV) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ba(currentTimeMillis);
        this.cKU = 0;
        this.mStartTime = 0L;
    }

    private void ba(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cKU * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
