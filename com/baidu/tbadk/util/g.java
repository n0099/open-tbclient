package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cOM;
    private long cON;
    private long cOO;
    private long cOP;
    private long cOQ;
    private a cOR;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean xT = false;
    private Runnable cOS = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cOQ > g.this.cOP) {
                g.this.cOP = currentTimeMillis - g.this.cOO;
                g.this.cOQ = g.this.cOP;
            }
            long j = currentTimeMillis - g.this.cOP;
            g.this.cON += g.this.cOO;
            if (g.this.cON < g.this.cOM) {
                g.this.handler.postDelayed(g.this.cOS, (2 * g.this.cOO) - j);
                if (g.this.cOR != null) {
                    g.this.cOR.b(g.this.cOM, g.this.cOM - g.this.cON);
                }
            } else {
                g.this.cON = g.this.cOM;
                g.this.finish();
            }
            g.this.cOP = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void p(long j);
    }

    public g(long j, long j2) {
        this.cOM = j;
        this.cOO = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cOP = this.startTime;
        if (this.cOR != null) {
            this.cOR.b(this.cOM, this.cOM - this.cON);
        }
        this.handler.postDelayed(this.cOS, this.cOO);
    }

    public void pause() {
        if (!this.xT) {
            this.xT = true;
            this.cOQ = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cOS);
        }
    }

    public void resume() {
        if (this.xT) {
            this.xT = false;
            this.handler.postDelayed(this.cOS, this.cOO - (this.cOQ - this.cOP));
        }
    }

    public void stop() {
        this.xT = false;
        this.cOP = this.startTime;
        this.cOQ = this.cOP;
        this.handler.removeCallbacks(this.cOS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cOR != null) {
            this.cOR.p(this.cOM);
        }
    }

    public void a(a aVar) {
        this.cOR = aVar;
    }

    public long axw() {
        return this.cON;
    }
}
