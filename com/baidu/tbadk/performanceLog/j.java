package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aAl = "dalvikvm";
    private String[] aAm = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aAn = null;
    private int aAe = 0;
    private final int aAo = 10000;
    private a aAp = null;
    private final Handler aAq = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eW(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dR()) {
            super.start();
            this.aAq.sendEmptyMessageDelayed(0, 10000L);
            FM();
            try {
                d.a(this.aAl, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FN();
    }

    private void FM() {
        if (this.aAn == null) {
            this.aAn = new d();
        }
        if (!this.aAn.dR()) {
            new Thread(this.aAn).start();
        }
    }

    private void FN() {
        if (this.aAn != null && this.aAn.dR()) {
            this.aAn.stop();
        }
    }

    public void a(a aVar) {
        if (this.aAp == null) {
            this.aAp = aVar;
        }
    }
}
