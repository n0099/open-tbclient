package com.baidu.tbadk.coreExtra.util;

import android.os.Handler;
import android.os.SystemClock;
/* loaded from: classes.dex */
public abstract class TbCountDownTimer {
    private static final int MSG = 1;
    private final long mCountdownInterval;
    private Handler mHandler = new b(this);
    private long mMillisInFuture;
    private long mStopTimeInFuture;

    public abstract void onFinish();

    public abstract void onTick(long j);

    public TbCountDownTimer(long j, long j2) {
        this.mMillisInFuture = j;
        this.mCountdownInterval = j2;
    }

    public final void cancel() {
        this.mHandler.removeMessages(1);
    }

    public final synchronized TbCountDownTimer start() {
        TbCountDownTimer tbCountDownTimer;
        if (this.mMillisInFuture <= 0) {
            onFinish();
            tbCountDownTimer = this;
        } else {
            this.mStopTimeInFuture = SystemClock.elapsedRealtime() + this.mMillisInFuture;
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1));
            tbCountDownTimer = this;
        }
        return tbCountDownTimer;
    }

    public final synchronized void pause() {
        long elapsedRealtime = this.mStopTimeInFuture - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            onFinish();
        }
        this.mHandler.removeMessages(1);
        this.mMillisInFuture = elapsedRealtime;
    }

    public final synchronized void restart(long j) {
        cancel();
        this.mMillisInFuture = j;
        start();
    }
}
