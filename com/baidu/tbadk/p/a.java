package com.baidu.tbadk.p;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long baF;
    private long mStartTime;
    private long cLK = 0;
    private int cLL = 0;
    private int mFps = -1;
    private boolean cLM = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.baF = this.mStartTime + 1000;
        this.cLK = 0L;
        this.cLL = 0;
        this.mFps = -1;
        this.cLM = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.cLM = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bb(System.currentTimeMillis());
        this.cLL = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.cLK != 0) {
            long j2 = (j - this.cLK) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.cLL = (int) ((j2 / 16) + this.cLL);
            }
        }
        this.cLK = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.baF && !this.cLM) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bb(currentTimeMillis);
        this.cLL = 0;
        this.mStartTime = 0L;
    }

    private void bb(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.cLL * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
