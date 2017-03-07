package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aFO = "dalvikvm";
    private String[] aFP = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aFQ = null;
    private int aFH = 0;
    private final int aFR = 10000;
    private a aFS = null;
    private final Handler aFT = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eY(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!cl()) {
            super.start();
            this.aFT.sendEmptyMessageDelayed(0, 10000L);
            FX();
            try {
                d.a(this.aFO, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FY();
    }

    private void FX() {
        if (this.aFQ == null) {
            this.aFQ = new d();
        }
        if (!this.aFQ.cl()) {
            new Thread(this.aFQ).start();
        }
    }

    private void FY() {
        if (this.aFQ != null && this.aFQ.cl()) {
            this.aFQ.stop();
        }
    }

    public void a(a aVar) {
        if (this.aFS == null) {
            this.aFS = aVar;
        }
    }
}
