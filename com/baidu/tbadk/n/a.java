package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes.dex */
public class a implements Choreographer.FrameCallback {
    private long bDL;
    private long mStartTime;
    private long dze = 0;
    private int dzf = 0;
    private int mFps = -1;
    private boolean dzg = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.bDL = this.mStartTime + 1000;
        this.dze = 0L;
        this.dzf = 0;
        this.mFps = -1;
        this.dzg = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.dzg = true;
        Choreographer.getInstance().removeFrameCallback(this);
        bF(System.currentTimeMillis());
        this.dzf = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.dze != 0) {
            long j2 = (j - this.dze) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.dzf = (int) ((j2 / 16) + this.dzf);
            }
        }
        this.dze = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.bDL && !this.dzg) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        bF(currentTimeMillis);
        this.dzf = 0;
        this.mStartTime = 0L;
    }

    private void bF(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.dzf * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
