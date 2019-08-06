package com.baidu.tbadk.p.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aGT;
    private long mStartTime;
    private long czF = 0;
    private int czG = 0;
    private int mFps = -1;
    private boolean czH = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aGT = this.mStartTime + 1000;
        this.czF = 0L;
        this.czG = 0;
        this.mFps = -1;
        this.czH = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.czH = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bj(System.currentTimeMillis());
        this.czG = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.czF != 0) {
            long j2 = (j - this.czF) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.czG = (int) ((j2 / 16) + this.czG);
            }
        }
        this.czF = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aGT && !this.czH) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bj(currentTimeMillis);
        this.czG = 0;
        this.mStartTime = 0L;
    }

    private void bj(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.czG * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
