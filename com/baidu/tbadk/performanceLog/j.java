package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String axT = "dalvikvm";
    private String[] axU = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d axV = null;
    private int axM = 0;
    private final int axW = 10000;
    private a axX = null;
    private final Handler axY = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eN(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ah()) {
            super.start();
            this.axY.sendEmptyMessageDelayed(0, 10000L);
            EL();
            try {
                d.a(this.axT, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        EM();
    }

    private void EL() {
        if (this.axV == null) {
            this.axV = new d();
        }
        if (!this.axV.ah()) {
            new Thread(this.axV).start();
        }
    }

    private void EM() {
        if (this.axV != null && this.axV.ah()) {
            this.axV.stop();
        }
    }

    public void a(a aVar) {
        if (this.axX == null) {
            this.axX = aVar;
        }
    }
}
