package com.baidu.tbadk.o.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long aEp;
    private long mStartTime;
    private long cpY = 0;
    private int cpZ = 0;
    private int mFps = -1;
    private boolean cqa = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.aEp = this.mStartTime + 1000;
        this.cpY = 0L;
        this.cpZ = 0;
        this.mFps = -1;
        this.cqa = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cqa = true;
        Choreographer.getInstance().removeFrameCallback(this);
        aT(System.currentTimeMillis());
        this.cpZ = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cpY != 0) {
            long j2 = (j - this.cpY) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cpZ = (int) ((j2 / 16) + this.cpZ);
            }
        }
        this.cpY = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.aEp && !this.cqa) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        aT(currentTimeMillis);
        this.cpZ = 0;
        this.mStartTime = 0L;
    }

    private void aT(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cpZ * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
