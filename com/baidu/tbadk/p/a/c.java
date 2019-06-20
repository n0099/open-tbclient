package com.baidu.tbadk.p.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aGl;
    private long mStartTime;
    private long cyi = 0;
    private int cyj = 0;
    private int mFps = -1;
    private boolean cyk = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aGl = this.mStartTime + 1000;
        this.cyi = 0L;
        this.cyj = 0;
        this.mFps = -1;
        this.cyk = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cyk = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bi(System.currentTimeMillis());
        this.cyj = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cyi != 0) {
            long j2 = (j - this.cyi) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cyj = (int) ((j2 / 16) + this.cyj);
            }
        }
        this.cyi = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aGl && !this.cyk) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bi(currentTimeMillis);
        this.cyj = 0;
        this.mStartTime = 0L;
    }

    private void bi(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cyj * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
