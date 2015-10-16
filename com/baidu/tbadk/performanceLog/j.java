package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String awW = "dalvikvm";
    private String[] awX = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d awY = null;
    private int awQ = 0;
    private final int awZ = 10000;
    private a axa = null;
    private final Handler axb = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void ew(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.axb.sendEmptyMessageDelayed(0, 10000L);
            DL();
            try {
                d.a(this.awW, new l(this));
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
        if (this.awY == null) {
            this.awY = new d();
        }
        if (!this.awY.dO()) {
            new Thread(this.awY).start();
        }
    }

    private void DM() {
        if (this.awY != null && this.awY.dO()) {
            this.awY.stop();
        }
    }

    public void a(a aVar) {
        if (this.axa == null) {
            this.axa = aVar;
        }
    }
}
