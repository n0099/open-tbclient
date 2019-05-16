package com.baidu.tbadk.p.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aGl;
    private long mStartTime;
    private long cyh = 0;
    private int cyi = 0;
    private int mFps = -1;
    private boolean cyj = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aGl = this.mStartTime + 1000;
        this.cyh = 0L;
        this.cyi = 0;
        this.mFps = -1;
        this.cyj = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cyj = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bi(System.currentTimeMillis());
        this.cyi = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cyh != 0) {
            long j2 = (j - this.cyh) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cyi = (int) ((j2 / 16) + this.cyi);
            }
        }
        this.cyh = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aGl && !this.cyj) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bi(currentTimeMillis);
        this.cyi = 0;
        this.mStartTime = 0L;
    }

    private void bi(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cyi * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
