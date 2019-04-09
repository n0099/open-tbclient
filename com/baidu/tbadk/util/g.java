package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long ctb;
    private long ctc;
    private long ctd;
    private long cte;
    private long ctf;
    private a cth;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean ctg = false;
    private Runnable cti = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.ctf > g.this.cte) {
                g.this.cte = currentTimeMillis - g.this.ctd;
                g.this.ctf = g.this.cte;
            }
            long j = currentTimeMillis - g.this.cte;
            g.this.ctc += g.this.ctd;
            if (g.this.ctc < g.this.ctb) {
                g.this.handler.postDelayed(g.this.cti, (2 * g.this.ctd) - j);
                if (g.this.cth != null) {
                    g.this.cth.b(g.this.ctb, g.this.ctb - g.this.ctc);
                }
            } else {
                g.this.ctc = g.this.ctb;
                g.this.finish();
            }
            g.this.cte = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void s(long j);
    }

    public g(long j, long j2) {
        this.ctb = j;
        this.ctd = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cte = this.startTime;
        if (this.cth != null) {
            this.cth.b(this.ctb, this.ctb - this.ctc);
        }
        this.handler.postDelayed(this.cti, this.ctd);
    }

    public void pause() {
        if (!this.ctg) {
            this.ctg = true;
            this.ctf = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cti);
        }
    }

    public void resume() {
        if (this.ctg) {
            this.ctg = false;
            this.handler.postDelayed(this.cti, this.ctd - (this.ctf - this.cte));
        }
    }

    public void stop() {
        this.ctg = false;
        this.cte = this.startTime;
        this.ctf = this.cte;
        this.handler.removeCallbacks(this.cti);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cth != null) {
            this.cth.s(this.ctb);
        }
    }

    public void a(a aVar) {
        this.cth = aVar;
    }

    public long apQ() {
        return this.ctc;
    }
}
