package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class i {
    private long dGm;
    private long dGn;
    private long dGo;
    private long dGp;
    private long dGq;
    private a dGr;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Ao = false;
    private Runnable dGs = new Runnable() { // from class: com.baidu.tbadk.util.i.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (i.this.dGq > i.this.dGp) {
                i.this.dGp = currentTimeMillis - i.this.dGo;
                i.this.dGq = i.this.dGp;
            }
            long j = currentTimeMillis - i.this.dGp;
            i.this.dGn += i.this.dGo;
            if (i.this.dGn < i.this.dGm) {
                i.this.handler.postDelayed(i.this.dGs, (2 * i.this.dGo) - j);
                if (i.this.dGr != null) {
                    i.this.dGr.b(i.this.dGm, i.this.dGm - i.this.dGn);
                }
            } else {
                i.this.dGn = i.this.dGm;
                i.this.finish();
            }
            i.this.dGp = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void b(long j, long j2);

        void r(long j);
    }

    public i(long j, long j2) {
        this.dGm = j;
        this.dGo = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.dGp = this.startTime;
        if (this.dGr != null) {
            this.dGr.b(this.dGm, this.dGm - this.dGn);
        }
        this.handler.postDelayed(this.dGs, this.dGo);
    }

    public void pause() {
        if (!this.Ao) {
            this.Ao = true;
            this.dGq = System.currentTimeMillis();
            this.handler.removeCallbacks(this.dGs);
        }
    }

    public void resume() {
        if (this.Ao) {
            this.Ao = false;
            this.handler.postDelayed(this.dGs, this.dGo - (this.dGq - this.dGp));
        }
    }

    public void stop() {
        this.Ao = false;
        this.dGp = this.startTime;
        this.dGq = this.dGp;
        this.handler.removeCallbacks(this.dGs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.dGr != null) {
            this.dGr.r(this.dGm);
        }
    }

    public void a(a aVar) {
        this.dGr = aVar;
    }

    public long aRV() {
        return this.dGn;
    }
}
