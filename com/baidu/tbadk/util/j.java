package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fMF;
    private long fMG;
    private long fMH;
    private long fMI;
    private long fMJ;
    private a fMK;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Wv = false;
    private Runnable fML = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fMJ > j.this.fMI) {
                j.this.fMI = currentTimeMillis - j.this.fMH;
                j.this.fMJ = j.this.fMI;
            }
            long j = currentTimeMillis - j.this.fMI;
            j.this.fMG += j.this.fMH;
            if (j.this.fMG < j.this.fMF) {
                j.this.handler.postDelayed(j.this.fML, (2 * j.this.fMH) - j);
                if (j.this.fMK != null) {
                    j.this.fMK.e(j.this.fMF, j.this.fMF - j.this.fMG);
                }
            } else {
                j.this.fMG = j.this.fMF;
                j.this.finish();
            }
            j.this.fMI = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void N(long j);

        void e(long j, long j2);
    }

    public j(long j, long j2) {
        this.fMF = j;
        this.fMH = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fMI = this.startTime;
        if (this.fMK != null) {
            this.fMK.e(this.fMF, this.fMF - this.fMG);
        }
        this.handler.postDelayed(this.fML, this.fMH);
    }

    public void pause() {
        if (!this.Wv) {
            this.Wv = true;
            this.fMJ = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fML);
        }
    }

    public void resume() {
        if (this.Wv) {
            this.Wv = false;
            this.handler.postDelayed(this.fML, this.fMH - (this.fMJ - this.fMI));
        }
    }

    public void stop() {
        this.Wv = false;
        this.fMI = this.startTime;
        this.fMJ = this.fMI;
        this.handler.removeCallbacks(this.fML);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fMK != null) {
            this.fMK.N(this.fMF);
        }
    }

    public void a(a aVar) {
        this.fMK = aVar;
    }

    public long bFp() {
        return this.fMG;
    }
}
