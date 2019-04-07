package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cta;
    private long ctb;
    private long ctc;
    private long ctd;
    private long cte;
    private a ctg;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean ctf = false;
    private Runnable cth = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cte > g.this.ctd) {
                g.this.ctd = currentTimeMillis - g.this.ctc;
                g.this.cte = g.this.ctd;
            }
            long j = currentTimeMillis - g.this.ctd;
            g.this.ctb += g.this.ctc;
            if (g.this.ctb < g.this.cta) {
                g.this.handler.postDelayed(g.this.cth, (2 * g.this.ctc) - j);
                if (g.this.ctg != null) {
                    g.this.ctg.b(g.this.cta, g.this.cta - g.this.ctb);
                }
            } else {
                g.this.ctb = g.this.cta;
                g.this.finish();
            }
            g.this.ctd = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void s(long j);
    }

    public g(long j, long j2) {
        this.cta = j;
        this.ctc = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.ctd = this.startTime;
        if (this.ctg != null) {
            this.ctg.b(this.cta, this.cta - this.ctb);
        }
        this.handler.postDelayed(this.cth, this.ctc);
    }

    public void pause() {
        if (!this.ctf) {
            this.ctf = true;
            this.cte = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cth);
        }
    }

    public void resume() {
        if (this.ctf) {
            this.ctf = false;
            this.handler.postDelayed(this.cth, this.ctc - (this.cte - this.ctd));
        }
    }

    public void stop() {
        this.ctf = false;
        this.ctd = this.startTime;
        this.cte = this.ctd;
        this.handler.removeCallbacks(this.cth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.ctg != null) {
            this.ctg.s(this.cta);
        }
    }

    public void a(a aVar) {
        this.ctg = aVar;
    }

    public long apQ() {
        return this.ctb;
    }
}
