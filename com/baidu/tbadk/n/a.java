package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long eUp = 0;
    private int eUq = 0;
    private int mFps = -1;
    private boolean eUr = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.eUp = 0L;
        this.eUq = 0;
        this.mFps = -1;
        this.eUr = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.eUr = true;
        Choreographer.getInstance().removeFrameCallback(this);
        da(System.currentTimeMillis());
        this.eUq = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.eUp != 0) {
            long j2 = (j - this.eUp) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.eUq = (int) ((j2 / 16) + this.eUq);
            }
        }
        this.eUp = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.eUr) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        da(currentTimeMillis);
        this.eUq = 0;
        this.mStartTime = 0L;
    }

    private void da(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.eUq * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
