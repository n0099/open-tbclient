package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long dDg = 0;
    private int dDh = 0;
    private int mFps = -1;
    private boolean dDi = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.dDg = 0L;
        this.dDh = 0;
        this.mFps = -1;
        this.dDi = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dDi = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bJ(System.currentTimeMillis());
        this.dDh = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dDg != 0) {
            long j2 = (j - this.dDg) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dDh = (int) ((j2 / 16) + this.dDh);
            }
        }
        this.dDg = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.dDi) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bJ(currentTimeMillis);
        this.dDh = 0;
        this.mStartTime = 0L;
    }

    private void bJ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dDh * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
