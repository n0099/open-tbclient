package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long fKu;
    private long fKv;
    private long fKw;
    private long fKx;
    private long fKy;
    private a fKz;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Wz = false;
    private Runnable fKA = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.fKy > i.this.fKx) {
                i.this.fKx = currentTimeMillis - i.this.fKw;
                i.this.fKy = i.this.fKx;
            }
            long j = currentTimeMillis - i.this.fKx;
            i.this.fKv += i.this.fKw;
            if (i.this.fKv < i.this.fKu) {
                i.this.handler.postDelayed(i.this.fKA, (2 * i.this.fKw) - j);
                if (i.this.fKz != null) {
                    i.this.fKz.e(i.this.fKu, i.this.fKu - i.this.fKv);
                }
            } else {
                i.this.fKv = i.this.fKu;
                i.this.finish();
            }
            i.this.fKx = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void N(long j);

        void e(long j, long j2);
    }

    public i(long j, long j2) {
        this.fKu = j;
        this.fKw = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fKx = this.startTime;
        if (this.fKz != null) {
            this.fKz.e(this.fKu, this.fKu - this.fKv);
        }
        this.handler.postDelayed(this.fKA, this.fKw);
    }

    public void pause() {
        if (!this.Wz) {
            this.Wz = true;
            this.fKy = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fKA);
        }
    }

    public void resume() {
        if (this.Wz) {
            this.Wz = false;
            this.handler.postDelayed(this.fKA, this.fKw - (this.fKy - this.fKx));
        }
    }

    public void stop() {
        this.Wz = false;
        this.fKx = this.startTime;
        this.fKy = this.fKx;
        this.handler.removeCallbacks(this.fKA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fKz != null) {
            this.fKz.N(this.fKu);
        }
    }

    public void a(a aVar) {
        this.fKz = aVar;
    }

    public long bEW() {
        return this.fKv;
    }
}
