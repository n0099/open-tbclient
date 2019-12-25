package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dBY;
    private long dBZ;
    private long dCa;
    private long dCb;
    private long dCc;
    private a dCd;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean zR = false;
    private Runnable dCe = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dCc > i.this.dCb) {
                i.this.dCb = currentTimeMillis - i.this.dCa;
                i.this.dCc = i.this.dCb;
            }
            long j = currentTimeMillis - i.this.dCb;
            i.this.dBZ += i.this.dCa;
            if (i.this.dBZ < i.this.dBY) {
                i.this.handler.postDelayed(i.this.dCe, (2 * i.this.dCa) - j);
                if (i.this.dCd != null) {
                    i.this.dCd.b(i.this.dBY, i.this.dBY - i.this.dBZ);
                }
            } else {
                i.this.dBZ = i.this.dBY;
                i.this.finish();
            }
            i.this.dCb = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void q(long j);
    }

    public i(long j, long j2) {
        this.dBY = j;
        this.dCa = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dCb = this.startTime;
        if (this.dCd != null) {
            this.dCd.b(this.dBY, this.dBY - this.dBZ);
        }
        this.handler.postDelayed(this.dCe, this.dCa);
    }

    public void pause() {
        if (!this.zR) {
            this.zR = true;
            this.dCc = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dCe);
        }
    }

    public void resume() {
        if (this.zR) {
            this.zR = false;
            this.handler.postDelayed(this.dCe, this.dCa - (this.dCc - this.dCb));
        }
    }

    public void stop() {
        this.zR = false;
        this.dCb = this.startTime;
        this.dCc = this.dCb;
        this.handler.removeCallbacks(this.dCe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dCd != null) {
            this.dCd.q(this.dBY);
        }
    }

    public void a(a aVar) {
        this.dCd = aVar;
    }

    public long aPl() {
        return this.dBZ;
    }
}
