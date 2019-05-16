package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cBk;
    private long cBl;
    private long cBm;
    private long cBn;
    private long cBo;
    private a cBq;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean cBp = false;
    private Runnable cBr = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cBo > g.this.cBn) {
                g.this.cBn = currentTimeMillis - g.this.cBm;
                g.this.cBo = g.this.cBn;
            }
            long j = currentTimeMillis - g.this.cBn;
            g.this.cBl += g.this.cBm;
            if (g.this.cBl < g.this.cBk) {
                g.this.handler.postDelayed(g.this.cBr, (2 * g.this.cBm) - j);
                if (g.this.cBq != null) {
                    g.this.cBq.b(g.this.cBk, g.this.cBk - g.this.cBl);
                }
            } else {
                g.this.cBl = g.this.cBk;
                g.this.finish();
            }
            g.this.cBn = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public g(long j, long j2) {
        this.cBk = j;
        this.cBm = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cBn = this.startTime;
        if (this.cBq != null) {
            this.cBq.b(this.cBk, this.cBk - this.cBl);
        }
        this.handler.postDelayed(this.cBr, this.cBm);
    }

    public void pause() {
        if (!this.cBp) {
            this.cBp = true;
            this.cBo = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cBr);
        }
    }

    public void resume() {
        if (this.cBp) {
            this.cBp = false;
            this.handler.postDelayed(this.cBr, this.cBm - (this.cBo - this.cBn));
        }
    }

    public void stop() {
        this.cBp = false;
        this.cBn = this.startTime;
        this.cBo = this.cBn;
        this.handler.removeCallbacks(this.cBr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cBq != null) {
            this.cBq.q(this.cBk);
        }
    }

    public void a(a aVar) {
        this.cBq = aVar;
    }

    public long auU() {
        return this.cBl;
    }
}
