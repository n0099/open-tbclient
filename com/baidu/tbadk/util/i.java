package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long egA;
    private long egB;
    private long egC;
    private a egD;
    private long egy;
    private long egz;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean TD = false;
    private Runnable egE = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.egC > i.this.egB) {
                i.this.egB = currentTimeMillis - i.this.egA;
                i.this.egC = i.this.egB;
            }
            long j = currentTimeMillis - i.this.egB;
            i.this.egz += i.this.egA;
            if (i.this.egz < i.this.egy) {
                i.this.handler.postDelayed(i.this.egE, (2 * i.this.egA) - j);
                if (i.this.egD != null) {
                    i.this.egD.b(i.this.egy, i.this.egy - i.this.egz);
                }
            } else {
                i.this.egz = i.this.egy;
                i.this.finish();
            }
            i.this.egB = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.egy = j;
        this.egA = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.egB = this.startTime;
        if (this.egD != null) {
            this.egD.b(this.egy, this.egy - this.egz);
        }
        this.handler.postDelayed(this.egE, this.egA);
    }

    public void pause() {
        if (!this.TD) {
            this.TD = true;
            this.egC = System.currentTimeMillis();
            this.handler.removeCallbacks(this.egE);
        }
    }

    public void resume() {
        if (this.TD) {
            this.TD = false;
            this.handler.postDelayed(this.egE, this.egA - (this.egC - this.egB));
        }
    }

    public void stop() {
        this.TD = false;
        this.egB = this.startTime;
        this.egC = this.egB;
        this.handler.removeCallbacks(this.egE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.egD != null) {
            this.egD.P(this.egy);
        }
    }

    public void a(a aVar) {
        this.egD = aVar;
    }

    public long bal() {
        return this.egz;
    }
}
