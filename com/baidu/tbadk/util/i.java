package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes2.dex */
public class i {
    private long eUW;
    private long eUX;
    private long eUY;
    private long eUZ;
    private long eVa;
    private a eVb;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean UW = false;
    private Runnable eVc = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.eVa > i.this.eUZ) {
                i.this.eUZ = currentTimeMillis - i.this.eUY;
                i.this.eVa = i.this.eUZ;
            }
            long j = currentTimeMillis - i.this.eUZ;
            i.this.eUX += i.this.eUY;
            if (i.this.eUX < i.this.eUW) {
                i.this.handler.postDelayed(i.this.eVc, (2 * i.this.eUY) - j);
                if (i.this.eVb != null) {
                    i.this.eVb.b(i.this.eUW, i.this.eUW - i.this.eUX);
                }
            } else {
                i.this.eUX = i.this.eUW;
                i.this.finish();
            }
            i.this.eUZ = currentTimeMillis;
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.eUW = j;
        this.eUY = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.eUZ = this.startTime;
        if (this.eVb != null) {
            this.eVb.b(this.eUW, this.eUW - this.eUX);
        }
        this.handler.postDelayed(this.eVc, this.eUY);
    }

    public void pause() {
        if (!this.UW) {
            this.UW = true;
            this.eVa = System.currentTimeMillis();
            this.handler.removeCallbacks(this.eVc);
        }
    }

    public void resume() {
        if (this.UW) {
            this.UW = false;
            this.handler.postDelayed(this.eVc, this.eUY - (this.eVa - this.eUZ));
        }
    }

    public void stop() {
        this.UW = false;
        this.eUZ = this.startTime;
        this.eVa = this.eUZ;
        this.handler.removeCallbacks(this.eVc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.eVb != null) {
            this.eVb.P(this.eUW);
        }
    }

    public void a(a aVar) {
        this.eVb = aVar;
    }

    public long bvo() {
        return this.eUX;
    }
}
