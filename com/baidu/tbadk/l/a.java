package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long bgl = 0;
    private int bgm = 0;
    private int mFps = -1;
    private boolean bgn = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.bgl = 0L;
        this.bgm = 0;
        this.mFps = -1;
        this.bgn = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.bgn = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ar(System.currentTimeMillis());
        this.bgm = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.bgl != 0) {
            long j2 = (j - this.bgl) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.bgm = (int) ((j2 / 16) + this.bgm);
            }
        }
        this.bgl = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.bgn) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ar(currentTimeMillis);
        this.bgm = 0;
        this.mStartTime = 0L;
    }

    private void ar(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.bgm * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
