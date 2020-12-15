package com.baidu.tieba.ala;

import android.os.CountDownTimer;
/* loaded from: classes4.dex */
public class d extends CountDownTimer {
    private a gis;
    private boolean isRunning;

    /* loaded from: classes4.dex */
    public interface a {
        void onFinish();

        void onTick(long j);
    }

    public d(long j, long j2) {
        super(j, j2);
        this.isRunning = false;
    }

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
        if (this.gis != null) {
            this.gis.onTick(j);
        }
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        if (this.gis != null) {
            this.gis.onFinish();
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
        this.gis = aVar;
    }
}
