package com.baidu.tbadk.l;

import android.annotation.TargetApi;
import android.view.Choreographer;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long ZJ;
    private long mStartTime;
    private long aTw = 0;
    private int aTx = 0;
    private int mFps = -1;
    private boolean aTy = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.ZJ = this.mStartTime + 1000;
        this.aTw = 0L;
        this.aTx = 0;
        this.mFps = -1;
        this.aTy = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.aTy = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ab(System.currentTimeMillis());
        this.aTx = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.aTw != 0) {
            long j2 = (j - this.aTw) / 1000000;
            if (j2 > 16 && j2 < 960) {
                this.aTx = (int) ((j2 / 16) + this.aTx);
            }
        }
        this.aTw = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.ZJ && !this.aTy) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ab(currentTimeMillis);
        this.aTx = 0;
        this.mStartTime = 0L;
    }

    private void ab(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.aTx * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
