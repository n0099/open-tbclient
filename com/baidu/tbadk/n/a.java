package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long fKy = 0;
    private int fKz = 0;
    private int mFps = -1;
    private boolean fKA = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.fKy = 0L;
        this.fKz = 0;
        this.mFps = -1;
        this.fKA = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.fKA = true;
        Choreographer.getInstance().removeFrameCallback(this);
        el(System.currentTimeMillis());
        this.fKz = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.fKy != 0) {
            long j2 = (j - this.fKy) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.fKz = (int) ((j2 / 16) + this.fKz);
            }
        }
        this.fKy = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.fKA) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        el(currentTimeMillis);
        this.fKz = 0;
        this.mStartTime = 0L;
    }

    private void el(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.fKz * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
