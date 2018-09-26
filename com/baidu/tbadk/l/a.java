package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long ack;
    private long mStartTime;
    private long aWL = 0;
    private int aWM = 0;
    private int mFps = -1;
    private boolean aWN = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.ack = this.mStartTime + 1000;
        this.aWL = 0L;
        this.aWM = 0;
        this.mFps = -1;
        this.aWN = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.aWN = true;
        Choreographer.getInstance().removeFrameCallback(this);
        af(System.currentTimeMillis());
        this.aWM = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.aWL != 0) {
            long j2 = (j - this.aWL) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.aWM = (int) ((j2 / 16) + this.aWM);
            }
        }
        this.aWL = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.ack && !this.aWN) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        af(currentTimeMillis);
        this.aWM = 0;
        this.mStartTime = 0L;
    }

    private void af(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.aWM * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
