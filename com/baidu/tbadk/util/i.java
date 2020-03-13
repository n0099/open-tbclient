package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dGA;
    private long dGB;
    private long dGC;
    private long dGD;
    private long dGE;
    private a dGF;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Ao = false;
    private Runnable dGG = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dGE > i.this.dGD) {
                i.this.dGD = currentTimeMillis - i.this.dGC;
                i.this.dGE = i.this.dGD;
            }
            long j = currentTimeMillis - i.this.dGD;
            i.this.dGB += i.this.dGC;
            if (i.this.dGB < i.this.dGA) {
                i.this.handler.postDelayed(i.this.dGG, (2 * i.this.dGC) - j);
                if (i.this.dGF != null) {
                    i.this.dGF.b(i.this.dGA, i.this.dGA - i.this.dGB);
                }
            } else {
                i.this.dGB = i.this.dGA;
                i.this.finish();
            }
            i.this.dGD = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void r(long j);
    }

    public i(long j, long j2) {
        this.dGA = j;
        this.dGC = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dGD = this.startTime;
        if (this.dGF != null) {
            this.dGF.b(this.dGA, this.dGA - this.dGB);
        }
        this.handler.postDelayed(this.dGG, this.dGC);
    }

    public void pause() {
        if (!this.Ao) {
            this.Ao = true;
            this.dGE = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dGG);
        }
    }

    public void resume() {
        if (this.Ao) {
            this.Ao = false;
            this.handler.postDelayed(this.dGG, this.dGC - (this.dGE - this.dGD));
        }
    }

    public void stop() {
        this.Ao = false;
        this.dGD = this.startTime;
        this.dGE = this.dGD;
        this.handler.removeCallbacks(this.dGG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dGF != null) {
            this.dGF.r(this.dGA);
        }
    }

    public void a(a aVar) {
        this.dGF = aVar;
    }

    public long aRY() {
        return this.dGB;
    }
}
