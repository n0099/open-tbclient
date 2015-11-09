package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String avL = "dalvikvm";
    private String[] avM = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d avN = null;
    private int avE = 0;
    private final int avO = 10000;
    private a avP = null;
    private final Handler avQ = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eu(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.avQ.sendEmptyMessageDelayed(0, 10000L);
            DB();
            try {
                d.a(this.avL, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        DC();
    }

    private void DB() {
        if (this.avN == null) {
            this.avN = new d();
        }
        if (!this.avN.dO()) {
            new Thread(this.avN).start();
        }
    }

    private void DC() {
        if (this.avN != null && this.avN.dO()) {
            this.avN.stop();
        }
    }

    public void a(a aVar) {
        if (this.avP == null) {
            this.avP = aVar;
        }
    }
}
