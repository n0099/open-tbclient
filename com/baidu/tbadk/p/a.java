package com.baidu.tbadk.p;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long aGT;
    private long mStartTime;
    private long czy = 0;
    private int czz = 0;
    private int mFps = -1;
    private boolean czA = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aGT = this.mStartTime + 1000;
        this.czy = 0L;
        this.czz = 0;
        this.mFps = -1;
        this.czA = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.czA = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bj(System.currentTimeMillis());
        this.czz = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.czy != 0) {
            long j2 = (j - this.czy) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.czz = (int) ((j2 / 16) + this.czz);
            }
        }
        this.czy = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aGT && !this.czA) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bj(currentTimeMillis);
        this.czz = 0;
        this.mStartTime = 0L;
    }

    private void bj(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.czz * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
