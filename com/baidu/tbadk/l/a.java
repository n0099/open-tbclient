package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bbl = 0;
    private int bbm = 0;
    private int mFps = -1;
    private boolean bbn = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bbl = 0L;
        this.bbm = 0;
        this.mFps = -1;
        this.bbn = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bbn = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ah(System.currentTimeMillis());
        this.bbm = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bbl != 0) {
            long j2 = (j - this.bbl) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bbm = (int) ((j2 / 16) + this.bbm);
            }
        }
        this.bbl = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bbn) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ah(currentTimeMillis);
        this.bbm = 0;
        this.mStartTime = 0L;
    }

    private void ah(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bbm * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
