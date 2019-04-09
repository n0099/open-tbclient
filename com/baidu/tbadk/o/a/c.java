package com.baidu.tbadk.o.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aEt;
    private long mStartTime;
    private long cqb = 0;
    private int cqc = 0;
    private int mFps = -1;
    private boolean cqd = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aEt = this.mStartTime + 1000;
        this.cqb = 0L;
        this.cqc = 0;
        this.mFps = -1;
        this.cqd = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cqd = true;
        Choreographer.getInstance().removeFrameCallback(this);
        aT(System.currentTimeMillis());
        this.cqc = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cqb != 0) {
            long j2 = (j - this.cqb) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cqc = (int) ((j2 / 16) + this.cqc);
            }
        }
        this.cqb = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aEt && !this.cqd) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        aT(currentTimeMillis);
        this.cqc = 0;
        this.mStartTime = 0L;
    }

    private void aT(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cqc * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
