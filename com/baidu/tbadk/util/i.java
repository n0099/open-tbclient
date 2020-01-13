package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dCi;
    private long dCj;
    private long dCk;
    private long dCl;
    private long dCm;
    private a dCn;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean zV = false;
    private Runnable dCo = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dCm > i.this.dCl) {
                i.this.dCl = currentTimeMillis - i.this.dCk;
                i.this.dCm = i.this.dCl;
            }
            long j = currentTimeMillis - i.this.dCl;
            i.this.dCj += i.this.dCk;
            if (i.this.dCj < i.this.dCi) {
                i.this.handler.postDelayed(i.this.dCo, (2 * i.this.dCk) - j);
                if (i.this.dCn != null) {
                    i.this.dCn.b(i.this.dCi, i.this.dCi - i.this.dCj);
                }
            } else {
                i.this.dCj = i.this.dCi;
                i.this.finish();
            }
            i.this.dCl = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public i(long j, long j2) {
        this.dCi = j;
        this.dCk = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dCl = this.startTime;
        if (this.dCn != null) {
            this.dCn.b(this.dCi, this.dCi - this.dCj);
        }
        this.handler.postDelayed(this.dCo, this.dCk);
    }

    public void pause() {
        if (!this.zV) {
            this.zV = true;
            this.dCm = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dCo);
        }
    }

    public void resume() {
        if (this.zV) {
            this.zV = false;
            this.handler.postDelayed(this.dCo, this.dCk - (this.dCm - this.dCl));
        }
    }

    public void stop() {
        this.zV = false;
        this.dCl = this.startTime;
        this.dCm = this.dCl;
        this.handler.removeCallbacks(this.dCo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dCn != null) {
            this.dCn.q(this.dCi);
        }
    }

    public void a(a aVar) {
        this.dCn = aVar;
    }

    public long aPE() {
        return this.dCj;
    }
}
