package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cCC;
    private long cCD;
    private long cCE;
    private long cCF;
    private long cCG;
    private a cCI;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean cCH = false;
    private Runnable cCJ = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cCG > g.this.cCF) {
                g.this.cCF = currentTimeMillis - g.this.cCE;
                g.this.cCG = g.this.cCF;
            }
            long j = currentTimeMillis - g.this.cCF;
            g.this.cCD += g.this.cCE;
            if (g.this.cCD < g.this.cCC) {
                g.this.handler.postDelayed(g.this.cCJ, (2 * g.this.cCE) - j);
                if (g.this.cCI != null) {
                    g.this.cCI.b(g.this.cCC, g.this.cCC - g.this.cCD);
                }
            } else {
                g.this.cCD = g.this.cCC;
                g.this.finish();
            }
            g.this.cCF = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public g(long j, long j2) {
        this.cCC = j;
        this.cCE = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cCF = this.startTime;
        if (this.cCI != null) {
            this.cCI.b(this.cCC, this.cCC - this.cCD);
        }
        this.handler.postDelayed(this.cCJ, this.cCE);
    }

    public void pause() {
        if (!this.cCH) {
            this.cCH = true;
            this.cCG = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cCJ);
        }
    }

    public void resume() {
        if (this.cCH) {
            this.cCH = false;
            this.handler.postDelayed(this.cCJ, this.cCE - (this.cCG - this.cCF));
        }
    }

    public void stop() {
        this.cCH = false;
        this.cCF = this.startTime;
        this.cCG = this.cCF;
        this.handler.removeCallbacks(this.cCJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cCI != null) {
            this.cCI.q(this.cCC);
        }
    }

    public void a(a aVar) {
        this.cCI = aVar;
    }

    public long awd() {
        return this.cCD;
    }
}
