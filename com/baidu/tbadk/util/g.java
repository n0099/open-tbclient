package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cCJ;
    private long cCK;
    private long cCL;
    private long cCM;
    private long cCN;
    private a cCP;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean cCO = false;
    private Runnable cCQ = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cCN > g.this.cCM) {
                g.this.cCM = currentTimeMillis - g.this.cCL;
                g.this.cCN = g.this.cCM;
            }
            long j = currentTimeMillis - g.this.cCM;
            g.this.cCK += g.this.cCL;
            if (g.this.cCK < g.this.cCJ) {
                g.this.handler.postDelayed(g.this.cCQ, (2 * g.this.cCL) - j);
                if (g.this.cCP != null) {
                    g.this.cCP.b(g.this.cCJ, g.this.cCJ - g.this.cCK);
                }
            } else {
                g.this.cCK = g.this.cCJ;
                g.this.finish();
            }
            g.this.cCM = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public g(long j, long j2) {
        this.cCJ = j;
        this.cCL = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cCM = this.startTime;
        if (this.cCP != null) {
            this.cCP.b(this.cCJ, this.cCJ - this.cCK);
        }
        this.handler.postDelayed(this.cCQ, this.cCL);
    }

    public void pause() {
        if (!this.cCO) {
            this.cCO = true;
            this.cCN = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cCQ);
        }
    }

    public void resume() {
        if (this.cCO) {
            this.cCO = false;
            this.handler.postDelayed(this.cCQ, this.cCL - (this.cCN - this.cCM));
        }
    }

    public void stop() {
        this.cCO = false;
        this.cCM = this.startTime;
        this.cCN = this.cCM;
        this.handler.removeCallbacks(this.cCQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cCP != null) {
            this.cCP.q(this.cCJ);
        }
    }

    public void a(a aVar) {
        this.cCP = aVar;
    }

    public long awf() {
        return this.cCK;
    }
}
