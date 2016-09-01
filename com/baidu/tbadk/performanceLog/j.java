package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aBQ = "dalvikvm";
    private String[] aBR = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aBS = null;
    private int aBJ = 0;
    private final int aBT = 10000;
    private a aBU = null;
    private final Handler aBV = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bc()) {
            super.start();
            this.aBV.sendEmptyMessageDelayed(0, 10000L);
            Ge();
            try {
                d.a(this.aBQ, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gf();
    }

    private void Ge() {
        if (this.aBS == null) {
            this.aBS = new d();
        }
        if (!this.aBS.bc()) {
            new Thread(this.aBS).start();
        }
    }

    private void Gf() {
        if (this.aBS != null && this.aBS.bc()) {
            this.aBS.stop();
        }
    }

    public void a(a aVar) {
        if (this.aBU == null) {
            this.aBU = aVar;
        }
    }
}
