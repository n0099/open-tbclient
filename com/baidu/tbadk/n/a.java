package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long fLt = 0;
    private int fLu = 0;
    private int mFps = -1;
    private boolean fLv = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.fLt = 0L;
        this.fLu = 0;
        this.mFps = -1;
        this.fLv = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.fLv = true;
        Choreographer.getInstance().removeFrameCallback(this);
        ef(System.currentTimeMillis());
        this.fLu = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.fLt != 0) {
            long j2 = (j - this.fLt) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.fLu = (int) ((j2 / 16) + this.fLu);
            }
        }
        this.fLt = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.fLv) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        ef(currentTimeMillis);
        this.fLu = 0;
        this.mStartTime = 0L;
    }

    private void ef(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.fLu * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
