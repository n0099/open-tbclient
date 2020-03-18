package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long dDI = 0;
    private int dDJ = 0;
    private int mFps = -1;
    private boolean dDK = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.dDI = 0L;
        this.dDJ = 0;
        this.mFps = -1;
        this.dDK = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dDK = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bJ(System.currentTimeMillis());
        this.dDJ = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dDI != 0) {
            long j2 = (j - this.dDI) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dDJ = (int) ((j2 / 16) + this.dDJ);
            }
        }
        this.dDI = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.dDK) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bJ(currentTimeMillis);
        this.dDJ = 0;
        this.mStartTime = 0L;
    }

    private void bJ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dDJ * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
