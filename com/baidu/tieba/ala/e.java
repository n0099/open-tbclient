package com.baidu.tieba.ala;

import android.os.CountDownTimer;
/* loaded from: classes10.dex */
public class e extends CountDownTimer {
    private a goi;
    private boolean isRunning;

    /* loaded from: classes10.dex */
    public interface a {
        void onFinish();

        void onTick(long j);
    }

    public e(long j, long j2) {
        super(j, j2);
        this.isRunning = false;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.goi != null) {
            this.goi.onTick(j);
        }
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.goi != null) {
            this.goi.onFinish();
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
        this.goi = aVar;
    }
}
