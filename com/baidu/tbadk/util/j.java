package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fsC;
    private long fsD;
    private long fsE;
    private long fsF;
    private long fsG;
    private a fsH;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean VF = false;
    private Runnable fsI = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fsG > j.this.fsF) {
                j.this.fsF = currentTimeMillis - j.this.fsE;
                j.this.fsG = j.this.fsF;
            }
            long j = currentTimeMillis - j.this.fsF;
            j.this.fsD += j.this.fsE;
            if (j.this.fsD < j.this.fsC) {
                j.this.handler.postDelayed(j.this.fsI, (2 * j.this.fsE) - j);
                if (j.this.fsH != null) {
                    j.this.fsH.b(j.this.fsC, j.this.fsC - j.this.fsD);
                }
            } else {
                j.this.fsD = j.this.fsC;
                j.this.finish();
            }
            j.this.fsF = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.fsC = j;
        this.fsE = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fsF = this.startTime;
        if (this.fsH != null) {
            this.fsH.b(this.fsC, this.fsC - this.fsD);
        }
        this.handler.postDelayed(this.fsI, this.fsE);
    }

    public void pause() {
        if (!this.VF) {
            this.VF = true;
            this.fsG = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fsI);
        }
    }

    public void resume() {
        if (this.VF) {
            this.VF = false;
            this.handler.postDelayed(this.fsI, this.fsE - (this.fsG - this.fsF));
        }
    }

    public void stop() {
        this.VF = false;
        this.fsF = this.startTime;
        this.fsG = this.fsF;
        this.handler.removeCallbacks(this.fsI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fsH != null) {
            this.fsH.P(this.fsC);
        }
    }

    public void a(a aVar) {
        this.fsH = aVar;
    }

    public long bBb() {
        return this.fsD;
    }
}
