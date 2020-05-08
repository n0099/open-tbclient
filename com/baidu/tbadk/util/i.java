package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long egD;
    private long egE;
    private long egF;
    private long egG;
    private long egH;
    private a egI;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean TH = false;
    private Runnable egJ = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.egH > i.this.egG) {
                i.this.egG = currentTimeMillis - i.this.egF;
                i.this.egH = i.this.egG;
            }
            long j = currentTimeMillis - i.this.egG;
            i.this.egE += i.this.egF;
            if (i.this.egE < i.this.egD) {
                i.this.handler.postDelayed(i.this.egJ, (2 * i.this.egF) - j);
                if (i.this.egI != null) {
                    i.this.egI.b(i.this.egD, i.this.egD - i.this.egE);
                }
            } else {
                i.this.egE = i.this.egD;
                i.this.finish();
            }
            i.this.egG = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.egD = j;
        this.egF = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.egG = this.startTime;
        if (this.egI != null) {
            this.egI.b(this.egD, this.egD - this.egE);
        }
        this.handler.postDelayed(this.egJ, this.egF);
    }

    public void pause() {
        if (!this.TH) {
            this.TH = true;
            this.egH = System.currentTimeMillis();
            this.handler.removeCallbacks(this.egJ);
        }
    }

    public void resume() {
        if (this.TH) {
            this.TH = false;
            this.handler.postDelayed(this.egJ, this.egF - (this.egH - this.egG));
        }
    }

    public void stop() {
        this.TH = false;
        this.egG = this.startTime;
        this.egH = this.egG;
        this.handler.removeCallbacks(this.egJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.egI != null) {
            this.egI.P(this.egD);
        }
    }

    public void a(a aVar) {
        this.egI = aVar;
    }

    public long baj() {
        return this.egE;
    }
}
