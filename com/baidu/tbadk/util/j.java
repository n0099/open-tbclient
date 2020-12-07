package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fFA;
    private long fFB;
    private long fFC;
    private a fFD;
    private long fFy;
    private long fFz;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean WE = false;
    private Runnable fFE = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fFC > j.this.fFB) {
                j.this.fFB = currentTimeMillis - j.this.fFA;
                j.this.fFC = j.this.fFB;
            }
            long j = currentTimeMillis - j.this.fFB;
            j.this.fFz += j.this.fFA;
            if (j.this.fFz < j.this.fFy) {
                j.this.handler.postDelayed(j.this.fFE, (2 * j.this.fFA) - j);
                if (j.this.fFD != null) {
                    j.this.fFD.b(j.this.fFy, j.this.fFy - j.this.fFz);
                }
            } else {
                j.this.fFz = j.this.fFy;
                j.this.finish();
            }
            j.this.fFB = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void N(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.fFy = j;
        this.fFA = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fFB = this.startTime;
        if (this.fFD != null) {
            this.fFD.b(this.fFy, this.fFy - this.fFz);
        }
        this.handler.postDelayed(this.fFE, this.fFA);
    }

    public void pause() {
        if (!this.WE) {
            this.WE = true;
            this.fFC = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fFE);
        }
    }

    public void resume() {
        if (this.WE) {
            this.WE = false;
            this.handler.postDelayed(this.fFE, this.fFA - (this.fFC - this.fFB));
        }
    }

    public void stop() {
        this.WE = false;
        this.fFB = this.startTime;
        this.fFC = this.fFB;
        this.handler.removeCallbacks(this.fFE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fFD != null) {
            this.fFD.N(this.fFy);
        }
    }

    public void a(a aVar) {
        this.fFD = aVar;
    }

    public long bGu() {
        return this.fFz;
    }
}
