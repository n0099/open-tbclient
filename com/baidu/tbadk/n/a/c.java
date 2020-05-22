package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long erH = 0;
    private int erI = 0;
    private int mFps = -1;
    private boolean erJ = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.erH = 0L;
        this.erI = 0;
        this.mFps = -1;
        this.erJ = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.erJ = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cs(System.currentTimeMillis());
        this.erI = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.erH != 0) {
            long j2 = (j - this.erH) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.erI = (int) ((j2 / 16) + this.erI);
            }
        }
        this.erH = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.erJ) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cs(currentTimeMillis);
        this.erI = 0;
        this.mStartTime = 0L;
    }

    private void cs(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.erI * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
