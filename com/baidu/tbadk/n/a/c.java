package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long fub = 0;
    private int fuc = 0;
    private int mFps = -1;
    private boolean fud = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.fub = 0L;
        this.fuc = 0;
        this.mFps = -1;
        this.fud = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.fud = true;
        Choreographer.getInstance().removeFrameCallback(this);
        dG(System.currentTimeMillis());
        this.fuc = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.fub != 0) {
            long j2 = (j - this.fub) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.fuc = (int) ((j2 / 16) + this.fuc);
            }
        }
        this.fub = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.fud) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        dG(currentTimeMillis);
        this.fuc = 0;
        this.mStartTime = 0L;
    }

    private void dG(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.fuc * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
