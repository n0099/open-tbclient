package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aCk = "dalvikvm";
    private String[] aCl = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aCm = null;
    private int aCd = 0;
    private final int aCn = 10000;
    private a aCo = null;
    private final Handler aCp = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fd(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bc()) {
            super.start();
            this.aCp.sendEmptyMessageDelayed(0, 10000L);
            Gj();
            try {
                d.a(this.aCk, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gk();
    }

    private void Gj() {
        if (this.aCm == null) {
            this.aCm = new d();
        }
        if (!this.aCm.bc()) {
            new Thread(this.aCm).start();
        }
    }

    private void Gk() {
        if (this.aCm != null && this.aCm.bc()) {
            this.aCm.stop();
        }
    }

    public void a(a aVar) {
        if (this.aCo == null) {
            this.aCo = aVar;
        }
    }
}
