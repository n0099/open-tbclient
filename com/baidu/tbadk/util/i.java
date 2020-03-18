package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dGQ;
    private long dGR;
    private long dGS;
    private long dGT;
    private long dGU;
    private a dGV;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Ao = false;
    private Runnable dGW = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dGU > i.this.dGT) {
                i.this.dGT = currentTimeMillis - i.this.dGS;
                i.this.dGU = i.this.dGT;
            }
            long j = currentTimeMillis - i.this.dGT;
            i.this.dGR += i.this.dGS;
            if (i.this.dGR < i.this.dGQ) {
                i.this.handler.postDelayed(i.this.dGW, (2 * i.this.dGS) - j);
                if (i.this.dGV != null) {
                    i.this.dGV.b(i.this.dGQ, i.this.dGQ - i.this.dGR);
                }
            } else {
                i.this.dGR = i.this.dGQ;
                i.this.finish();
            }
            i.this.dGT = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void r(long j);
    }

    public i(long j, long j2) {
        this.dGQ = j;
        this.dGS = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dGT = this.startTime;
        if (this.dGV != null) {
            this.dGV.b(this.dGQ, this.dGQ - this.dGR);
        }
        this.handler.postDelayed(this.dGW, this.dGS);
    }

    public void pause() {
        if (!this.Ao) {
            this.Ao = true;
            this.dGU = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dGW);
        }
    }

    public void resume() {
        if (this.Ao) {
            this.Ao = false;
            this.handler.postDelayed(this.dGW, this.dGS - (this.dGU - this.dGT));
        }
    }

    public void stop() {
        this.Ao = false;
        this.dGT = this.startTime;
        this.dGU = this.dGT;
        this.handler.removeCallbacks(this.dGW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dGV != null) {
            this.dGV.r(this.dGQ);
        }
    }

    public void a(a aVar) {
        this.dGV = aVar;
    }

    public long aSc() {
        return this.dGR;
    }
}
