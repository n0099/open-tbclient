package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long eAz = 0;
    private int eAA = 0;
    private int mFps = -1;
    private boolean eAB = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.eAz = 0L;
        this.eAA = 0;
        this.mFps = -1;
        this.eAB = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.eAB = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cu(System.currentTimeMillis());
        this.eAA = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.eAz != 0) {
            long j2 = (j - this.eAz) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.eAA = (int) ((j2 / 16) + this.eAA);
            }
        }
        this.eAz = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.eAB) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cu(currentTimeMillis);
        this.eAA = 0;
        this.mStartTime = 0L;
    }

    private void cu(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.eAA * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
