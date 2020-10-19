package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long fgx = 0;
    private int fgy = 0;
    private int mFps = -1;
    private boolean fgz = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.fgx = 0L;
        this.fgy = 0;
        this.mFps = -1;
        this.fgz = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.fgz = true;
        Choreographer.getInstance().removeFrameCallback(this);
        di(System.currentTimeMillis());
        this.fgy = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.fgx != 0) {
            long j2 = (j - this.fgx) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.fgy = (int) ((j2 / 16) + this.fgy);
            }
        }
        this.fgx = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.fgz) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        di(currentTimeMillis);
        this.fgy = 0;
        this.mStartTime = 0L;
    }

    private void di(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.fgy * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
