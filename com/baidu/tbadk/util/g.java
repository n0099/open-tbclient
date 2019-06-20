package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cBl;
    private long cBm;
    private long cBn;
    private long cBo;
    private long cBp;
    private a cBr;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean cBq = false;
    private Runnable cBs = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cBp > g.this.cBo) {
                g.this.cBo = currentTimeMillis - g.this.cBn;
                g.this.cBp = g.this.cBo;
            }
            long j = currentTimeMillis - g.this.cBo;
            g.this.cBm += g.this.cBn;
            if (g.this.cBm < g.this.cBl) {
                g.this.handler.postDelayed(g.this.cBs, (2 * g.this.cBn) - j);
                if (g.this.cBr != null) {
                    g.this.cBr.b(g.this.cBl, g.this.cBl - g.this.cBm);
                }
            } else {
                g.this.cBm = g.this.cBl;
                g.this.finish();
            }
            g.this.cBo = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public g(long j, long j2) {
        this.cBl = j;
        this.cBn = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cBo = this.startTime;
        if (this.cBr != null) {
            this.cBr.b(this.cBl, this.cBl - this.cBm);
        }
        this.handler.postDelayed(this.cBs, this.cBn);
    }

    public void pause() {
        if (!this.cBq) {
            this.cBq = true;
            this.cBp = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cBs);
        }
    }

    public void resume() {
        if (this.cBq) {
            this.cBq = false;
            this.handler.postDelayed(this.cBs, this.cBn - (this.cBp - this.cBo));
        }
    }

    public void stop() {
        this.cBq = false;
        this.cBo = this.startTime;
        this.cBp = this.cBo;
        this.handler.removeCallbacks(this.cBs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cBr != null) {
            this.cBr.q(this.cBl);
        }
    }

    public void a(a aVar) {
        this.cBr = aVar;
    }

    public long auU() {
        return this.cBm;
    }
}
