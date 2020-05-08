package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long edu = 0;
    private int edv = 0;
    private int mFps = -1;
    private boolean edw = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.edu = 0L;
        this.edv = 0;
        this.mFps = -1;
        this.edw = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.edw = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cq(System.currentTimeMillis());
        this.edv = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.edu != 0) {
            long j2 = (j - this.edu) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.edv = (int) ((j2 / 16) + this.edv);
            }
        }
        this.edu = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.edw) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cq(currentTimeMillis);
        this.edv = 0;
        this.mStartTime = 0L;
    }

    private void cq(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.edv * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
