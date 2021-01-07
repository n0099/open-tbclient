package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long fPb;
    private long fPc;
    private long fPd;
    private long fPe;
    private long fPf;
    private a fPg;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean WB = false;
    private Runnable fPh = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.fPf > i.this.fPe) {
                i.this.fPe = currentTimeMillis - i.this.fPd;
                i.this.fPf = i.this.fPe;
            }
            long j = currentTimeMillis - i.this.fPe;
            i.this.fPc += i.this.fPd;
            if (i.this.fPc < i.this.fPb) {
                i.this.handler.postDelayed(i.this.fPh, (2 * i.this.fPd) - j);
                if (i.this.fPg != null) {
                    i.this.fPg.e(i.this.fPb, i.this.fPb - i.this.fPc);
                }
            } else {
                i.this.fPc = i.this.fPb;
                i.this.finish();
            }
            i.this.fPe = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void N(long j);

        void e(long j, long j2);
    }

    public i(long j, long j2) {
        this.fPb = j;
        this.fPd = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fPe = this.startTime;
        if (this.fPg != null) {
            this.fPg.e(this.fPb, this.fPb - this.fPc);
        }
        this.handler.postDelayed(this.fPh, this.fPd);
    }

    public void pause() {
        if (!this.WB) {
            this.WB = true;
            this.fPf = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fPh);
        }
    }

    public void resume() {
        if (this.WB) {
            this.WB = false;
            this.handler.postDelayed(this.fPh, this.fPd - (this.fPf - this.fPe));
        }
    }

    public void stop() {
        this.WB = false;
        this.fPe = this.startTime;
        this.fPf = this.fPe;
        this.handler.removeCallbacks(this.fPh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fPg != null) {
            this.fPg.N(this.fPb);
        }
    }

    public void a(a aVar) {
        this.fPg = aVar;
    }

    public long bIO() {
        return this.fPc;
    }
}
