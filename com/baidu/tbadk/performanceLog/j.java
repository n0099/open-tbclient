package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aBE = "dalvikvm";
    private String[] aBF = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aBG = null;
    private int aBx = 0;
    private final int aBH = 10000;
    private a aBI = null;
    private final Handler aBJ = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fd(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bc()) {
            super.start();
            this.aBJ.sendEmptyMessageDelayed(0, 10000L);
            FJ();
            try {
                d.a(this.aBE, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FK();
    }

    private void FJ() {
        if (this.aBG == null) {
            this.aBG = new d();
        }
        if (!this.aBG.bc()) {
            new Thread(this.aBG).start();
        }
    }

    private void FK() {
        if (this.aBG != null && this.aBG.bc()) {
            this.aBG.stop();
        }
    }

    public void a(a aVar) {
        if (this.aBI == null) {
            this.aBI = aVar;
        }
    }
}
