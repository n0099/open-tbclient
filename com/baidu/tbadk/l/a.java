package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bbY = 0;
    private int bbZ = 0;
    private int mFps = -1;
    private boolean bca = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bbY = 0L;
        this.bbZ = 0;
        this.mFps = -1;
        this.bca = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bca = true;
        Choreographer.getInstance().removeFrameCallback(this);
        aj(System.currentTimeMillis());
        this.bbZ = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bbY != 0) {
            long j2 = (j - this.bbY) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bbZ = (int) ((j2 / 16) + this.bbZ);
            }
        }
        this.bbY = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bca) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        aj(currentTimeMillis);
        this.bbZ = 0;
        this.mStartTime = 0L;
    }

    private void aj(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bbZ * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
