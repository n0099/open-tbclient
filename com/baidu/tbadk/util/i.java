package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long eVa;
    private long eVb;
    private long eVc;
    private long eVd;
    private long eVe;
    private a eVf;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean UW = false;
    private Runnable eVg = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.eVe > i.this.eVd) {
                i.this.eVd = currentTimeMillis - i.this.eVc;
                i.this.eVe = i.this.eVd;
            }
            long j = currentTimeMillis - i.this.eVd;
            i.this.eVb += i.this.eVc;
            if (i.this.eVb < i.this.eVa) {
                i.this.handler.postDelayed(i.this.eVg, (2 * i.this.eVc) - j);
                if (i.this.eVf != null) {
                    i.this.eVf.b(i.this.eVa, i.this.eVa - i.this.eVb);
                }
            } else {
                i.this.eVb = i.this.eVa;
                i.this.finish();
            }
            i.this.eVd = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.eVa = j;
        this.eVc = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.eVd = this.startTime;
        if (this.eVf != null) {
            this.eVf.b(this.eVa, this.eVa - this.eVb);
        }
        this.handler.postDelayed(this.eVg, this.eVc);
    }

    public void pause() {
        if (!this.UW) {
            this.UW = true;
            this.eVe = System.currentTimeMillis();
            this.handler.removeCallbacks(this.eVg);
        }
    }

    public void resume() {
        if (this.UW) {
            this.UW = false;
            this.handler.postDelayed(this.eVg, this.eVc - (this.eVe - this.eVd));
        }
    }

    public void stop() {
        this.UW = false;
        this.eVd = this.startTime;
        this.eVe = this.eVd;
        this.handler.removeCallbacks(this.eVg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.eVf != null) {
            this.eVf.P(this.eVa);
        }
    }

    public void a(a aVar) {
        this.eVf = aVar;
    }

    public long bvp() {
        return this.eVb;
    }
}
