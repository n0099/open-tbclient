package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bfy = 0;
    private int bfz = 0;
    private int mFps = -1;
    private boolean bfA = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bfy = 0L;
        this.bfz = 0;
        this.mFps = -1;
        this.bfA = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bfA = true;
        Choreographer.getInstance().removeFrameCallback(this);
        aq(System.currentTimeMillis());
        this.bfz = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bfy != 0) {
            long j2 = (j - this.bfy) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bfz = (int) ((j2 / 16) + this.bfz);
            }
        }
        this.bfy = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bfA) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        aq(currentTimeMillis);
        this.bfz = 0;
        this.mStartTime = 0L;
    }

    private void aq(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bfz * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
