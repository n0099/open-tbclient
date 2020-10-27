package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long foW = 0;
    private int foX = 0;
    private int mFps = -1;
    private boolean foY = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.foW = 0L;
        this.foX = 0;
        this.mFps = -1;
        this.foY = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.foY = true;
        Choreographer.getInstance().removeFrameCallback(this);
        dk(System.currentTimeMillis());
        this.foX = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.foW != 0) {
            long j2 = (j - this.foW) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.foX = (int) ((j2 / 16) + this.foX);
            }
        }
        this.foW = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.foY) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        dk(currentTimeMillis);
        this.foX = 0;
        this.mStartTime = 0L;
    }

    private void dk(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.foX * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
