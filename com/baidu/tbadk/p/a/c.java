package com.baidu.tbadk.p.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aHr;
    private long mStartTime;
    private long cAB = 0;
    private int cAC = 0;
    private int mFps = -1;
    private boolean cAD = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aHr = this.mStartTime + 1000;
        this.cAB = 0L;
        this.cAC = 0;
        this.mFps = -1;
        this.cAD = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cAD = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bm(System.currentTimeMillis());
        this.cAC = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cAB != 0) {
            long j2 = (j - this.cAB) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cAC = (int) ((j2 / 16) + this.cAC);
            }
        }
        this.cAB = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aHr && !this.cAD) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bm(currentTimeMillis);
        this.cAC = 0;
        this.mStartTime = 0L;
    }

    private void bm(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cAC * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
