package com.baidu.tbadk.util;

import android.os.Handler;
import android.os.Looper;
/* loaded from: classes.dex */
public class j {
    private long eXR;
    private long eXS;
    private long eXT;
    private long eXU;
    private long eXV;
    private a eXW;
    private long startTime;
    private Handler handler = new Handler(Looper.getMainLooper());
    private boolean Vo = false;
    private Runnable eXX = new Runnable() { // from class: com.baidu.tbadk.util.j.1
        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (j.this.eXV > j.this.eXU) {
                j.this.eXU = currentTimeMillis - j.this.eXT;
                j.this.eXV = j.this.eXU;
            }
            long j = currentTimeMillis - j.this.eXU;
            j.this.eXS += j.this.eXT;
            if (j.this.eXS < j.this.eXR) {
                j.this.handler.postDelayed(j.this.eXX, (2 * j.this.eXT) - j);
                if (j.this.eXW != null) {
                    j.this.eXW.b(j.this.eXR, j.this.eXR - j.this.eXS);
                }
            } else {
                j.this.eXS = j.this.eXR;
                j.this.finish();
            }
            j.this.eXU = currentTimeMillis;
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void P(long j);

        void b(long j, long j2);
    }

    public j(long j, long j2) {
        this.eXR = j;
        this.eXT = j2;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.eXU = this.startTime;
        if (this.eXW != null) {
            this.eXW.b(this.eXR, this.eXR - this.eXS);
        }
        this.handler.postDelayed(this.eXX, this.eXT);
    }

    public void pause() {
        if (!this.Vo) {
            this.Vo = true;
            this.eXV = System.currentTimeMillis();
            this.handler.removeCallbacks(this.eXX);
        }
    }

    public void resume() {
        if (this.Vo) {
            this.Vo = false;
            this.handler.postDelayed(this.eXX, this.eXT - (this.eXV - this.eXU));
        }
    }

    public void stop() {
        this.Vo = false;
        this.eXU = this.startTime;
        this.eXV = this.eXU;
        this.handler.removeCallbacks(this.eXX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        if (this.eXW != null) {
            this.eXW.P(this.eXR);
        }
    }

    public void a(a aVar) {
        this.eXW = aVar;
    }

    public long bwy() {
        return this.eXS;
    }
}
