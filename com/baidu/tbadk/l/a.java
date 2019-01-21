package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bgm = 0;
    private int bgn = 0;
    private int mFps = -1;
    private boolean bgo = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bgm = 0L;
        this.bgn = 0;
        this.mFps = -1;
        this.bgo = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bgo = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ar(System.currentTimeMillis());
        this.bgn = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bgm != 0) {
            long j2 = (j - this.bgm) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bgn = (int) ((j2 / 16) + this.bgn);
            }
        }
        this.bgm = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bgo) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ar(currentTimeMillis);
        this.bgn = 0;
        this.mStartTime = 0L;
    }

    private void ar(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bgn * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
