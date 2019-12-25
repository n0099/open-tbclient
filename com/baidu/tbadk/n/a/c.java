package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long bDa;
    private long mStartTime;
    private long dyW = 0;
    private int dyX = 0;
    private int mFps = -1;
    private boolean dyY = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.bDa = this.mStartTime + 1000;
        this.dyW = 0L;
        this.dyX = 0;
        this.mFps = -1;
        this.dyY = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dyY = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bC(System.currentTimeMillis());
        this.dyX = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dyW != 0) {
            long j2 = (j - this.dyW) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dyX = (int) ((j2 / 16) + this.dyX);
            }
        }
        this.dyW = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.bDa && !this.dyY) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bC(currentTimeMillis);
        this.dyX = 0;
        this.mStartTime = 0L;
    }

    private void bC(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dyX * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
