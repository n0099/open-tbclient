package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aBa = "dalvikvm";
    private String[] aBb = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aBc = null;
    private int aAT = 0;
    private final int aBd = 10000;
    private a aBe = null;
    private final Handler aBf = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fe(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dR()) {
            super.start();
            this.aBf.sendEmptyMessageDelayed(0, 10000L);
            GJ();
            try {
                d.a(this.aBa, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        GK();
    }

    private void GJ() {
        if (this.aBc == null) {
            this.aBc = new d();
        }
        if (!this.aBc.dR()) {
            new Thread(this.aBc).start();
        }
    }

    private void GK() {
        if (this.aBc != null && this.aBc.dR()) {
            this.aBc.stop();
        }
    }

    public void a(a aVar) {
        if (this.aBe == null) {
            this.aBe = aVar;
        }
    }
}
