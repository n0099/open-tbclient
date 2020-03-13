package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long dDu = 0;
    private int dDv = 0;
    private int mFps = -1;
    private boolean dDw = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.dDu = 0L;
        this.dDv = 0;
        this.mFps = -1;
        this.dDw = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dDw = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bJ(System.currentTimeMillis());
        this.dDv = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dDu != 0) {
            long j2 = (j - this.dDu) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dDv = (int) ((j2 / 16) + this.dDv);
            }
        }
        this.dDu = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.dDw) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bJ(currentTimeMillis);
        this.dDv = 0;
        this.mStartTime = 0L;
    }

    private void bJ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dDv * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
