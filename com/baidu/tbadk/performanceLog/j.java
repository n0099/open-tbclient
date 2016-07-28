package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String ayJ = "dalvikvm";
    private String[] ayK = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d ayL = null;
    private int ayC = 0;
    private final int ayM = 10000;
    private a ayN = null;
    private final Handler ayO = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ah()) {
            super.start();
            this.ayO.sendEmptyMessageDelayed(0, 10000L);
            EK();
            try {
                d.a(this.ayJ, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        EL();
    }

    private void EK() {
        if (this.ayL == null) {
            this.ayL = new d();
        }
        if (!this.ayL.ah()) {
            new Thread(this.ayL).start();
        }
    }

    private void EL() {
        if (this.ayL != null && this.ayL.ah()) {
            this.ayL.stop();
        }
    }

    public void a(a aVar) {
        if (this.ayN == null) {
            this.ayN = aVar;
        }
    }
}
