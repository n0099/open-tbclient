package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long dDh = 0;
    private int dDi = 0;
    private int mFps = -1;
    private boolean dDj = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.dDh = 0L;
        this.dDi = 0;
        this.mFps = -1;
        this.dDj = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dDj = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bJ(System.currentTimeMillis());
        this.dDi = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dDh != 0) {
            long j2 = (j - this.dDh) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dDi = (int) ((j2 / 16) + this.dDi);
            }
        }
        this.dDh = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.dDj) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bJ(currentTimeMillis);
        this.dDi = 0;
        this.mStartTime = 0L;
    }

    private void bJ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dDi * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
