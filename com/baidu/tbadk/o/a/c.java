package com.baidu.tbadk.o.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aEs;
    private long mStartTime;
    private long cqa = 0;
    private int cqb = 0;
    private int mFps = -1;
    private boolean cqc = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aEs = this.mStartTime + 1000;
        this.cqa = 0L;
        this.cqb = 0;
        this.mFps = -1;
        this.cqc = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cqc = true;
        Choreographer.getInstance().removeFrameCallback(this);
        aT(System.currentTimeMillis());
        this.cqb = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cqa != 0) {
            long j2 = (j - this.cqa) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cqb = (int) ((j2 / 16) + this.cqb);
            }
        }
        this.cqa = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aEs && !this.cqc) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        aT(currentTimeMillis);
        this.cqb = 0;
        this.mStartTime = 0L;
    }

    private void aT(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cqb * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
