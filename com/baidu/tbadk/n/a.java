package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long eGO = 0;
    private int eGP = 0;
    private int mFps = -1;
    private boolean eGQ = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.eGO = 0L;
        this.eGP = 0;
        this.mFps = -1;
        this.eGQ = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.eGQ = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cO(System.currentTimeMillis());
        this.eGP = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.eGO != 0) {
            long j2 = (j - this.eGO) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.eGP = (int) ((j2 / 16) + this.eGP);
            }
        }
        this.eGO = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.eGQ) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cO(currentTimeMillis);
        this.eGP = 0;
        this.mStartTime = 0L;
    }

    private void cO(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.eGP * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
