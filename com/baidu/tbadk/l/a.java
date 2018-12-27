package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bfB = 0;
    private int bfC = 0;
    private int mFps = -1;
    private boolean bfD = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bfB = 0L;
        this.bfC = 0;
        this.mFps = -1;
        this.bfD = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bfD = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ar(System.currentTimeMillis());
        this.bfC = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bfB != 0) {
            long j2 = (j - this.bfB) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bfC = (int) ((j2 / 16) + this.bfC);
            }
        }
        this.bfB = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bfD) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ar(currentTimeMillis);
        this.bfC = 0;
        this.mStartTime = 0L;
    }

    private void ar(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bfC * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
