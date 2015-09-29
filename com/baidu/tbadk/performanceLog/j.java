package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String awV = "dalvikvm";
    private String[] awW = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d awX = null;
    private int awP = 0;
    private final int awY = 10000;
    private a awZ = null;
    private final Handler axa = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.axa.sendEmptyMessageDelayed(0, 10000L);
            DL();
            try {
                d.a(this.awV, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        DM();
    }

    private void DL() {
        if (this.awX == null) {
            this.awX = new d();
        }
        if (!this.awX.dO()) {
            new Thread(this.awX).start();
        }
    }

    private void DM() {
        if (this.awX != null && this.awX.dO()) {
            this.awX.stop();
        }
    }

    public void a(a aVar) {
        if (this.awZ == null) {
            this.awZ = aVar;
        }
    }
}
