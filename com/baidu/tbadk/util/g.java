package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class g {
    private long cDF;
    private long cDG;
    private long cDH;
    private long cDI;
    private long cDJ;
    private a cDK;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Nb = false;
    private Runnable cDL = new Runnable() { // from class: com.baidu.tbadk.util.g.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (g.this.cDJ > g.this.cDI) {
                g.this.cDI = currentTimeMillis - g.this.cDH;
                g.this.cDJ = g.this.cDI;
            }
            long j = currentTimeMillis - g.this.cDI;
            g.this.cDG += g.this.cDH;
            if (g.this.cDG < g.this.cDF) {
                g.this.handler.postDelayed(g.this.cDL, (2 * g.this.cDH) - j);
                if (g.this.cDK != null) {
                    g.this.cDK.b(g.this.cDF, g.this.cDF - g.this.cDG);
                }
            } else {
                g.this.cDG = g.this.cDF;
                g.this.finish();
            }
            g.this.cDI = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public g(long j, long j2) {
        this.cDF = j;
        this.cDH = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.cDI = this.startTime;
        if (this.cDK != null) {
            this.cDK.b(this.cDF, this.cDF - this.cDG);
        }
        this.handler.postDelayed(this.cDL, this.cDH);
    }

    public void pause() {
        if (!this.Nb) {
            this.Nb = true;
            this.cDJ = System.currentTimeMillis();
            this.handler.removeCallbacks(this.cDL);
        }
    }

    public void resume() {
        if (this.Nb) {
            this.Nb = false;
            this.handler.postDelayed(this.cDL, this.cDH - (this.cDJ - this.cDI));
        }
    }

    public void stop() {
        this.Nb = false;
        this.cDI = this.startTime;
        this.cDJ = this.cDI;
        this.handler.removeCallbacks(this.cDL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.cDK != null) {
            this.cDK.q(this.cDF);
        }
    }

    public void a(a aVar) {
        this.cDK = aVar;
    }

    public long awr() {
        return this.cDG;
    }
}
