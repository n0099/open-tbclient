package com.baidu.tieba.ala;

import android.os.CountDownTimer;
/* loaded from: classes11.dex */
public class f extends CountDownTimer {
    private a gqR;
    private boolean isRunning;

    /* loaded from: classes11.dex */
    public interface a {
        void onFinish();

        void onTick(long j);
    }

    public f(long j, long j2) {
        super(j, j2);
        this.isRunning = false;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.gqR != null) {
            this.gqR.onTick(j);
        }
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.gqR != null) {
            this.gqR.onFinish();
        }
    }

    public void startTimer() {
        this.isRunning = true;
        start();
    }

    public void cancelTimer() {
        this.isRunning = false;
        cancel();
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public void a(a aVar) {
        this.gqR = aVar;
    }
}
