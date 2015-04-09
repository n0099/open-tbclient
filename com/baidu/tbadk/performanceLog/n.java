package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String aoW = "dalvikvm";
    private String[] aoX = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f aoY = null;
    private int aoQ = 0;
    private final int aoZ = 10000;
    private q apa = null;
    private final Handler apb = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dL()) {
            super.start();
            this.apb.sendEmptyMessageDelayed(0, 10000L);
            CA();
            try {
                f.a(this.aoW, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        CB();
    }

    private void CA() {
        if (this.aoY == null) {
            this.aoY = new f();
        }
        if (!this.aoY.dL()) {
            new Thread(this.aoY).start();
        }
    }

    private void CB() {
        if (this.aoY != null && this.aoY.dL()) {
            this.aoY.stop();
        }
    }

    public void a(q qVar) {
        if (this.apa == null) {
            this.apa = qVar;
        }
    }
}
