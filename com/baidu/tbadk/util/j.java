package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fOf;
    private long fOg;
    private long fOh;
    private long fOi;
    private long fOj;
    private a fOk;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean XP = false;
    private Runnable fOl = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fOj > j.this.fOi) {
                j.this.fOi = currentTimeMillis - j.this.fOh;
                j.this.fOj = j.this.fOi;
            }
            long j = currentTimeMillis - j.this.fOi;
            j.this.fOg += j.this.fOh;
            if (j.this.fOg < j.this.fOf) {
                j.this.handler.postDelayed(j.this.fOl, (2 * j.this.fOh) - j);
                if (j.this.fOk != null) {
                    j.this.fOk.e(j.this.fOf, j.this.fOf - j.this.fOg);
                }
            } else {
                j.this.fOg = j.this.fOf;
                j.this.finish();
            }
            j.this.fOi = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void N(long j);

        void e(long j, long j2);
    }

    public j(long j, long j2) {
        this.fOf = j;
        this.fOh = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fOi = this.startTime;
        if (this.fOk != null) {
            this.fOk.e(this.fOf, this.fOf - this.fOg);
        }
        this.handler.postDelayed(this.fOl, this.fOh);
    }

    public void pause() {
        if (!this.XP) {
            this.XP = true;
            this.fOj = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fOl);
        }
    }

    public void resume() {
        if (this.XP) {
            this.XP = false;
            this.handler.postDelayed(this.fOl, this.fOh - (this.fOj - this.fOi));
        }
    }

    public void stop() {
        this.XP = false;
        this.fOi = this.startTime;
        this.fOj = this.fOi;
        this.handler.removeCallbacks(this.fOl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fOk != null) {
            this.fOk.N(this.fOf);
        }
    }

    public void a(a aVar) {
        this.fOk = aVar;
    }

    public long bFt() {
        return this.fOg;
    }
}
