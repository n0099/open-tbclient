package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String awO = "dalvikvm";
    private String[] awP = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d awQ = null;
    private int awI = 0;
    private final int awR = 10000;
    private a awS = null;
    private final Handler awT = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void en(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.awT.sendEmptyMessageDelayed(0, 10000L);
            DO();
            try {
                d.a(this.awO, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        DP();
    }

    private void DO() {
        if (this.awQ == null) {
            this.awQ = new d();
        }
        if (!this.awQ.dO()) {
            new Thread(this.awQ).start();
        }
    }

    private void DP() {
        if (this.awQ != null && this.awQ.dO()) {
            this.awQ.stop();
        }
    }

    public void a(a aVar) {
        if (this.awS == null) {
            this.awS = aVar;
        }
    }
}
