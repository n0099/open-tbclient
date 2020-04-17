package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long edp = 0;
    private int edq = 0;
    private int mFps = -1;
    private boolean edr = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.edp = 0L;
        this.edq = 0;
        this.mFps = -1;
        this.edr = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.edr = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cq(System.currentTimeMillis());
        this.edq = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.edp != 0) {
            long j2 = (j - this.edp) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.edq = (int) ((j2 / 16) + this.edq);
            }
        }
        this.edp = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.edr) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cq(currentTimeMillis);
        this.edq = 0;
        this.mStartTime = 0L;
    }

    private void cq(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.edq * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
