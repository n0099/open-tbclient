package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fxJ;
    private long fxK;
    private long fxL;
    private long fxM;
    private long fxN;
    private a fxO;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean VG = false;
    private Runnable fxP = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fxN > j.this.fxM) {
                j.this.fxM = currentTimeMillis - j.this.fxL;
                j.this.fxN = j.this.fxM;
            }
            long j = currentTimeMillis - j.this.fxM;
            j.this.fxK += j.this.fxL;
            if (j.this.fxK < j.this.fxJ) {
                j.this.handler.postDelayed(j.this.fxP, (2 * j.this.fxL) - j);
                if (j.this.fxO != null) {
                    j.this.fxO.b(j.this.fxJ, j.this.fxJ - j.this.fxK);
                }
            } else {
                j.this.fxK = j.this.fxJ;
                j.this.finish();
            }
            j.this.fxM = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.fxJ = j;
        this.fxL = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fxM = this.startTime;
        if (this.fxO != null) {
            this.fxO.b(this.fxJ, this.fxJ - this.fxK);
        }
        this.handler.postDelayed(this.fxP, this.fxL);
    }

    public void pause() {
        if (!this.VG) {
            this.VG = true;
            this.fxN = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fxP);
        }
    }

    public void resume() {
        if (this.VG) {
            this.VG = false;
            this.handler.postDelayed(this.fxP, this.fxL - (this.fxN - this.fxM));
        }
    }

    public void stop() {
        this.VG = false;
        this.fxM = this.startTime;
        this.fxN = this.fxM;
        this.handler.removeCallbacks(this.fxP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fxO != null) {
            this.fxO.P(this.fxJ);
        }
    }

    public void a(a aVar) {
        this.fxO = aVar;
    }

    public long bCT() {
        return this.fxK;
    }
}
