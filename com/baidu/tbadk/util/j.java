package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fkd;
    private long fke;
    private long fkf;
    private long fkg;
    private long fkh;
    private a fki;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean VE = false;
    private Runnable fkj = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fkh > j.this.fkg) {
                j.this.fkg = currentTimeMillis - j.this.fkf;
                j.this.fkh = j.this.fkg;
            }
            long j = currentTimeMillis - j.this.fkg;
            j.this.fke += j.this.fkf;
            if (j.this.fke < j.this.fkd) {
                j.this.handler.postDelayed(j.this.fkj, (2 * j.this.fkf) - j);
                if (j.this.fki != null) {
                    j.this.fki.b(j.this.fkd, j.this.fkd - j.this.fke);
                }
            } else {
                j.this.fke = j.this.fkd;
                j.this.finish();
            }
            j.this.fkg = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.fkd = j;
        this.fkf = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fkg = this.startTime;
        if (this.fki != null) {
            this.fki.b(this.fkd, this.fkd - this.fke);
        }
        this.handler.postDelayed(this.fkj, this.fkf);
    }

    public void pause() {
        if (!this.VE) {
            this.VE = true;
            this.fkh = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fkj);
        }
    }

    public void resume() {
        if (this.VE) {
            this.VE = false;
            this.handler.postDelayed(this.fkj, this.fkf - (this.fkh - this.fkg));
        }
    }

    public void stop() {
        this.VE = false;
        this.fkg = this.startTime;
        this.fkh = this.fkg;
        this.handler.removeCallbacks(this.fkj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fki != null) {
            this.fki.P(this.fkd);
        }
    }

    public void a(a aVar) {
        this.fki = aVar;
    }

    public long bzi() {
        return this.fke;
    }
}
