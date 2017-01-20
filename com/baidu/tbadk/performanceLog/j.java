package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aAw = "dalvikvm";
    private String[] aAx = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aAy = null;
    private int aAp = 0;
    private final int aAz = 10000;
    private a aAA = null;
    private final Handler aAB = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fe(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bc()) {
            super.start();
            this.aAB.sendEmptyMessageDelayed(0, 10000L);
            FD();
            try {
                d.a(this.aAw, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FE();
    }

    private void FD() {
        if (this.aAy == null) {
            this.aAy = new d();
        }
        if (!this.aAy.bc()) {
            new Thread(this.aAy).start();
        }
    }

    private void FE() {
        if (this.aAy != null && this.aAy.bc()) {
            this.aAy.stop();
        }
    }

    public void a(a aVar) {
        if (this.aAA == null) {
            this.aAA = aVar;
        }
    }
}
