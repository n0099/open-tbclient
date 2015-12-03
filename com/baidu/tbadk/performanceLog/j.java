package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String axQ = "dalvikvm";
    private String[] axR = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d axS = null;
    private int axJ = 0;
    private final int axT = 10000;
    private a axU = null;
    private final Handler axV = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eI(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.axV.sendEmptyMessageDelayed(0, 10000L);
            EC();
            try {
                d.a(this.axQ, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        ED();
    }

    private void EC() {
        if (this.axS == null) {
            this.axS = new d();
        }
        if (!this.axS.dO()) {
            new Thread(this.axS).start();
        }
    }

    private void ED() {
        if (this.axS != null && this.axS.dO()) {
            this.axS.stop();
        }
    }

    public void a(a aVar) {
        if (this.axU == null) {
            this.axU = aVar;
        }
    }
}
