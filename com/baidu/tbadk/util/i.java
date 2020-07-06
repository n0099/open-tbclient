package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long eDV;
    private long eDW;
    private long eDX;
    private long eDY;
    private long eDZ;
    private a eEa;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Uw = false;
    private Runnable eEb = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.eDZ > i.this.eDY) {
                i.this.eDY = currentTimeMillis - i.this.eDX;
                i.this.eDZ = i.this.eDY;
            }
            long j = currentTimeMillis - i.this.eDY;
            i.this.eDW += i.this.eDX;
            if (i.this.eDW < i.this.eDV) {
                i.this.handler.postDelayed(i.this.eEb, (2 * i.this.eDX) - j);
                if (i.this.eEa != null) {
                    i.this.eEa.b(i.this.eDV, i.this.eDV - i.this.eDW);
                }
            } else {
                i.this.eDW = i.this.eDV;
                i.this.finish();
            }
            i.this.eDY = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public i(long j, long j2) {
        this.eDV = j;
        this.eDX = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.eDY = this.startTime;
        if (this.eEa != null) {
            this.eEa.b(this.eDV, this.eDV - this.eDW);
        }
        this.handler.postDelayed(this.eEb, this.eDX);
    }

    public void pause() {
        if (!this.Uw) {
            this.Uw = true;
            this.eDZ = System.currentTimeMillis();
            this.handler.removeCallbacks(this.eEb);
        }
    }

    public void resume() {
        if (this.Uw) {
            this.Uw = false;
            this.handler.postDelayed(this.eEb, this.eDX - (this.eDZ - this.eDY));
        }
    }

    public void stop() {
        this.Uw = false;
        this.eDY = this.startTime;
        this.eDZ = this.eDY;
        this.handler.removeCallbacks(this.eEb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.eEa != null) {
            this.eEa.P(this.eDV);
        }
    }

    public void a(a aVar) {
        this.eEa = aVar;
    }

    public long biI() {
        return this.eDW;
    }
}
