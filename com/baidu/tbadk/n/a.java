package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long eRy = 0;
    private int eRz = 0;
    private int mFps = -1;
    private boolean eRA = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.eRy = 0L;
        this.eRz = 0;
        this.mFps = -1;
        this.eRA = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.eRA = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cZ(System.currentTimeMillis());
        this.eRz = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.eRy != 0) {
            long j2 = (j - this.eRy) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.eRz = (int) ((j2 / 16) + this.eRz);
            }
        }
        this.eRy = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.eRA) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cZ(currentTimeMillis);
        this.eRz = 0;
        this.mStartTime = 0L;
    }

    private void cZ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.eRz * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
