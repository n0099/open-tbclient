package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String aoO = "dalvikvm";
    private String[] aoP = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f aoQ = null;
    private int aoI = 0;
    private final int aoR = 10000;
    private q aoS = null;
    private final Handler aoT = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dL()) {
            super.start();
            this.aoT.sendEmptyMessageDelayed(0, 10000L);
            Cu();
            try {
                f.a(this.aoO, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Cv();
    }

    private void Cu() {
        if (this.aoQ == null) {
            this.aoQ = new f();
        }
        if (!this.aoQ.dL()) {
            new Thread(this.aoQ).start();
        }
    }

    private void Cv() {
        if (this.aoQ != null && this.aoQ.dL()) {
            this.aoQ.stop();
        }
    }

    public void a(q qVar) {
        if (this.aoS == null) {
            this.aoS = qVar;
        }
    }
}
