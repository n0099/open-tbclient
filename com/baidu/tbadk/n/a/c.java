package com.baidu.tbadk.n.a;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class c implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long fGM = 0;
    private int fGN = 0;
    private int mFps = -1;
    private boolean fGO = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.fGM = 0L;
        this.fGN = 0;
        this.mFps = -1;
        this.fGO = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.fGO = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ef(System.currentTimeMillis());
        this.fGN = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.fGM != 0) {
            long j2 = (j - this.fGM) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.fGN = (int) ((j2 / 16) + this.fGN);
            }
        }
        this.fGM = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.fGO) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ef(currentTimeMillis);
        this.fGN = 0;
        this.mStartTime = 0L;
    }

    private void ef(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.fGN * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
