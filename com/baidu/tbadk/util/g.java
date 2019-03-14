package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long csY;
    private long csZ;
    private long cta;
    private long ctb;
    private long ctc;
    private a cte;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean ctd = false;
    private Runnable ctf = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.ctc > g.this.ctb) {
                g.this.ctb = currentTimeMillis - g.this.cta;
                g.this.ctc = g.this.ctb;
            }
            long j = currentTimeMillis - g.this.ctb;
            g.this.csZ += g.this.cta;
            if (g.this.csZ < g.this.csY) {
                g.this.handler.postDelayed(g.this.ctf, (2 * g.this.cta) - j);
                if (g.this.cte != null) {
                    g.this.cte.b(g.this.csY, g.this.csY - g.this.csZ);
                }
            } else {
                g.this.csZ = g.this.csY;
                g.this.finish();
            }
            g.this.ctb = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void s(long j);
    }

    public g(long j, long j2) {
        this.csY = j;
        this.cta = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.ctb = this.startTime;
        if (this.cte != null) {
            this.cte.b(this.csY, this.csY - this.csZ);
        }
        this.handler.postDelayed(this.ctf, this.cta);
    }

    public void pause() {
        if (!this.ctd) {
            this.ctd = true;
            this.ctc = System.currentTimeMillis();
            this.handler.removeCallbacks(this.ctf);
        }
    }

    public void resume() {
        if (this.ctd) {
            this.ctd = false;
            this.handler.postDelayed(this.ctf, this.cta - (this.ctc - this.ctb));
        }
    }

    public void stop() {
        this.ctd = false;
        this.ctb = this.startTime;
        this.ctc = this.ctb;
        this.handler.removeCallbacks(this.ctf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cte != null) {
            this.cte.s(this.csY);
        }
    }

    public void a(a aVar) {
        this.cte = aVar;
    }

    public long apT() {
        return this.csZ;
    }
}
