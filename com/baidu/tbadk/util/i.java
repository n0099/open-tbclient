package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dGn;
    private long dGo;
    private long dGp;
    private long dGq;
    private long dGr;
    private a dGs;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Ao = false;
    private Runnable dGt = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dGr > i.this.dGq) {
                i.this.dGq = currentTimeMillis - i.this.dGp;
                i.this.dGr = i.this.dGq;
            }
            long j = currentTimeMillis - i.this.dGq;
            i.this.dGo += i.this.dGp;
            if (i.this.dGo < i.this.dGn) {
                i.this.handler.postDelayed(i.this.dGt, (2 * i.this.dGp) - j);
                if (i.this.dGs != null) {
                    i.this.dGs.b(i.this.dGn, i.this.dGn - i.this.dGo);
                }
            } else {
                i.this.dGo = i.this.dGn;
                i.this.finish();
            }
            i.this.dGq = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void r(long j);
    }

    public i(long j, long j2) {
        this.dGn = j;
        this.dGp = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dGq = this.startTime;
        if (this.dGs != null) {
            this.dGs.b(this.dGn, this.dGn - this.dGo);
        }
        this.handler.postDelayed(this.dGt, this.dGp);
    }

    public void pause() {
        if (!this.Ao) {
            this.Ao = true;
            this.dGr = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dGt);
        }
    }

    public void resume() {
        if (this.Ao) {
            this.Ao = false;
            this.handler.postDelayed(this.dGt, this.dGp - (this.dGr - this.dGq));
        }
    }

    public void stop() {
        this.Ao = false;
        this.dGq = this.startTime;
        this.dGr = this.dGq;
        this.handler.removeCallbacks(this.dGt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dGs != null) {
            this.dGs.r(this.dGn);
        }
    }

    public void a(a aVar) {
        this.dGs = aVar;
    }

    public long aRX() {
        return this.dGo;
    }
}
