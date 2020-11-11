package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long fyu;
    private long fyv;
    private long fyw;
    private long fyx;
    private long fyy;
    private a fyz;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean VF = false;
    private Runnable fyA = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.fyy > j.this.fyx) {
                j.this.fyx = currentTimeMillis - j.this.fyw;
                j.this.fyy = j.this.fyx;
            }
            long j = currentTimeMillis - j.this.fyx;
            j.this.fyv += j.this.fyw;
            if (j.this.fyv < j.this.fyu) {
                j.this.handler.postDelayed(j.this.fyA, (2 * j.this.fyw) - j);
                if (j.this.fyz != null) {
                    j.this.fyz.b(j.this.fyu, j.this.fyu - j.this.fyv);
                }
            } else {
                j.this.fyv = j.this.fyu;
                j.this.finish();
            }
            j.this.fyx = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.fyu = j;
        this.fyw = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.fyx = this.startTime;
        if (this.fyz != null) {
            this.fyz.b(this.fyu, this.fyu - this.fyv);
        }
        this.handler.postDelayed(this.fyA, this.fyw);
    }

    public void pause() {
        if (!this.VF) {
            this.VF = true;
            this.fyy = System.currentTimeMillis();
            this.handler.removeCallbacks(this.fyA);
        }
    }

    public void resume() {
        if (this.VF) {
            this.VF = false;
            this.handler.postDelayed(this.fyA, this.fyw - (this.fyy - this.fyx));
        }
    }

    public void stop() {
        this.VF = false;
        this.fyx = this.startTime;
        this.fyy = this.fyx;
        this.handler.removeCallbacks(this.fyA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.fyz != null) {
            this.fyz.P(this.fyu);
        }
    }

    public void a(a aVar) {
        this.fyz = aVar;
    }

    public long bDA() {
        return this.fyv;
    }
}
