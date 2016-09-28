package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aBt = "dalvikvm";
    private String[] aBu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aBv = null;
    private int aBm = 0;
    private final int aBw = 10000;
    private a aBx = null;
    private final Handler aBy = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fa(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!bc()) {
            super.start();
            this.aBy.sendEmptyMessageDelayed(0, 10000L);
            Gd();
            try {
                d.a(this.aBt, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Ge();
    }

    private void Gd() {
        if (this.aBv == null) {
            this.aBv = new d();
        }
        if (!this.aBv.bc()) {
            new Thread(this.aBv).start();
        }
    }

    private void Ge() {
        if (this.aBv != null && this.aBv.bc()) {
            this.aBv.stop();
        }
    }

    public void a(a aVar) {
        if (this.aBx == null) {
            this.aBx = aVar;
        }
    }
}
