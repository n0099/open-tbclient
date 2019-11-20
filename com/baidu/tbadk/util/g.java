package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cNV;
    private long cNW;
    private long cNX;
    private long cNY;
    private long cNZ;
    private a cOa;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean xt = false;
    private Runnable cOb = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cNZ > g.this.cNY) {
                g.this.cNY = currentTimeMillis - g.this.cNX;
                g.this.cNZ = g.this.cNY;
            }
            long j = currentTimeMillis - g.this.cNY;
            g.this.cNW += g.this.cNX;
            if (g.this.cNW < g.this.cNV) {
                g.this.handler.postDelayed(g.this.cOb, (2 * g.this.cNX) - j);
                if (g.this.cOa != null) {
                    g.this.cOa.b(g.this.cNV, g.this.cNV - g.this.cNW);
                }
            } else {
                g.this.cNW = g.this.cNV;
                g.this.finish();
            }
            g.this.cNY = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void o(long j);
    }

    public g(long j, long j2) {
        this.cNV = j;
        this.cNX = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cNY = this.startTime;
        if (this.cOa != null) {
            this.cOa.b(this.cNV, this.cNV - this.cNW);
        }
        this.handler.postDelayed(this.cOb, this.cNX);
    }

    public void pause() {
        if (!this.xt) {
            this.xt = true;
            this.cNZ = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cOb);
        }
    }

    public void resume() {
        if (this.xt) {
            this.xt = false;
            this.handler.postDelayed(this.cOb, this.cNX - (this.cNZ - this.cNY));
        }
    }

    public void stop() {
        this.xt = false;
        this.cNY = this.startTime;
        this.cNZ = this.cNY;
        this.handler.removeCallbacks(this.cOb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cOa != null) {
            this.cOa.o(this.cNV);
        }
    }

    public void a(a aVar) {
        this.cOa = aVar;
    }

    public long axu() {
        return this.cNW;
    }
}
