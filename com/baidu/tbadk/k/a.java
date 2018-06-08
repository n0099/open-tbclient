package com.baidu.tbadk.k;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long aab;
    private long mStartTime;
    private long aSA = 0;
    private int aSB = 0;
    private int mFps = -1;
    private boolean isStop = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aab = this.mStartTime + 1000;
        this.aSA = 0L;
        this.aSB = 0;
        this.mFps = -1;
        this.isStop = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.isStop = true;
        Choreographer.getInstance().removeFrameCallback(this);
        Y(System.currentTimeMillis());
        this.aSB = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.aSA != 0) {
            long j2 = (j - this.aSA) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.aSB = (int) ((j2 / 16) + this.aSB);
            }
        }
        this.aSA = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aab && !this.isStop) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        Y(currentTimeMillis);
        this.aSB = 0;
        this.mStartTime = 0L;
    }

    private void Y(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.aSB * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
