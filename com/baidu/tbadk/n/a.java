package com.baidu.tbadk.n;

import android.annotation.TargetApi;
import android.view.Choreographer;
import com.baidu.searchbox.v8engine.util.TimeUtils;
@TargetApi(16)
/* loaded from: classes2.dex */
public class a implements Choreographer.FrameCallback {
    private long mEndTime;
    private long mStartTime;
    private long eRu = 0;
    private int eRv = 0;
    private int mFps = -1;
    private boolean eRw = false;

    public void start() {
        this.mStartTime = System.currentTimeMillis();
        this.mEndTime = this.mStartTime + 1000;
        this.eRu = 0L;
        this.eRv = 0;
        this.mFps = -1;
        this.eRw = false;
        Choreographer.getInstance().postFrameCallback(this);
    }

    public void stop() {
        this.eRw = true;
        Choreographer.getInstance().removeFrameCallback(this);
        cZ(System.currentTimeMillis());
        this.eRv = 0;
        this.mStartTime = 0L;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        if (this.eRu != 0) {
            long j2 = (j - this.eRu) / TimeUtils.NANOS_PER_MS;
            if (j2 > 16 && j2 < 960) {
                this.eRv = (int) ((j2 / 16) + this.eRv);
            }
        }
        this.eRu = j;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.mEndTime && !this.eRw) {
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        cZ(currentTimeMillis);
        this.eRv = 0;
        this.mStartTime = 0L;
    }

    private void cZ(long j) {
        if (this.mStartTime > 0) {
            long j2 = j - this.mStartTime;
            if (j2 > 0 && this.mFps <= 0) {
                this.mFps = (int) (60 - ((this.eRv * 1000) / j2));
            }
        }
    }

    public int getFps() {
        return this.mFps;
    }
}
