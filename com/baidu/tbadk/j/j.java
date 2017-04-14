package com.baidu.tbadk.j;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aGe = "dalvikvm";
    private String[] aGf = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aGg = null;
    private int aFX = 0;
    private final int aGh = 10000;
    private a aGi = null;
    private final Handler aGj = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aGj.sendEmptyMessageDelayed(0, 10000L);
            Gv();
            try {
                d.a(this.aGe, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Gw();
    }

    private void Gv() {
        if (this.aGg == null) {
            this.aGg = new d();
        }
        if (!this.aGg.ck()) {
            new Thread(this.aGg).start();
        }
    }

    private void Gw() {
        if (this.aGg != null && this.aGg.ck()) {
            this.aGg.stop();
        }
    }

    public void a(a aVar) {
        if (this.aGi == null) {
            this.aGi = aVar;
        }
    }
}
