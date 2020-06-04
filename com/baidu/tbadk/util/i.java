package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long euR;
    private long euS;
    private long euT;
    private long euU;
    private long euV;
    private a euW;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean TT = false;
    private Runnable euX = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.euV > i.this.euU) {
                i.this.euU = currentTimeMillis - i.this.euT;
                i.this.euV = i.this.euU;
            }
            long j = currentTimeMillis - i.this.euU;
            i.this.euS += i.this.euT;
            if (i.this.euS < i.this.euR) {
                i.this.handler.postDelayed(i.this.euX, (2 * i.this.euT) - j);
                if (i.this.euW != null) {
                    i.this.euW.b(i.this.euR, i.this.euR - i.this.euS);
                }
            } else {
                i.this.euS = i.this.euR;
                i.this.finish();
            }
            i.this.euU = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.euR = j;
        this.euT = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.euU = this.startTime;
        if (this.euW != null) {
            this.euW.b(this.euR, this.euR - this.euS);
        }
        this.handler.postDelayed(this.euX, this.euT);
    }

    public void pause() {
        if (!this.TT) {
            this.TT = true;
            this.euV = System.currentTimeMillis();
            this.handler.removeCallbacks(this.euX);
        }
    }

    public void resume() {
        if (this.TT) {
            this.TT = false;
            this.handler.postDelayed(this.euX, this.euT - (this.euV - this.euU));
        }
    }

    public void stop() {
        this.TT = false;
        this.euU = this.startTime;
        this.euV = this.euU;
        this.handler.removeCallbacks(this.euX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.euW != null) {
            this.euW.P(this.euR);
        }
    }

    public void a(a aVar) {
        this.euW = aVar;
    }

    public long bgu() {
        return this.euS;
    }
}
