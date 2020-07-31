package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long eKr;
    private long eKs;
    private long eKt;
    private long eKu;
    private long eKv;
    private a eKw;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Uq = false;
    private Runnable eKx = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.eKv > i.this.eKu) {
                i.this.eKu = currentTimeMillis - i.this.eKt;
                i.this.eKv = i.this.eKu;
            }
            long j = currentTimeMillis - i.this.eKu;
            i.this.eKs += i.this.eKt;
            if (i.this.eKs < i.this.eKr) {
                i.this.handler.postDelayed(i.this.eKx, (2 * i.this.eKt) - j);
                if (i.this.eKw != null) {
                    i.this.eKw.b(i.this.eKr, i.this.eKr - i.this.eKs);
                }
            } else {
                i.this.eKs = i.this.eKr;
                i.this.finish();
            }
            i.this.eKu = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.eKr = j;
        this.eKt = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.eKu = this.startTime;
        if (this.eKw != null) {
            this.eKw.b(this.eKr, this.eKr - this.eKs);
        }
        this.handler.postDelayed(this.eKx, this.eKt);
    }

    public void pause() {
        if (!this.Uq) {
            this.Uq = true;
            this.eKv = System.currentTimeMillis();
            this.handler.removeCallbacks(this.eKx);
        }
    }

    public void resume() {
        if (this.Uq) {
            this.Uq = false;
            this.handler.postDelayed(this.eKx, this.eKt - (this.eKv - this.eKu));
        }
    }

    public void stop() {
        this.Uq = false;
        this.eKu = this.startTime;
        this.eKv = this.eKu;
        this.handler.removeCallbacks(this.eKx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.eKw != null) {
            this.eKw.P(this.eKr);
        }
    }

    public void a(a aVar) {
        this.eKw = aVar;
    }

    public long bmB() {
        return this.eKs;
    }
}
