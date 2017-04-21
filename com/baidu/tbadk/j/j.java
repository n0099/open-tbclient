package com.baidu.tbadk.j;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aGg = "dalvikvm";
    private String[] aGh = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aGi = null;
    private int aFZ = 0;
    private final int aGj = 10000;
    private a aGk = null;
    private final Handler aGl = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fb(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aGl.sendEmptyMessageDelayed(0, 10000L);
            Gv();
            try {
                d.a(this.aGg, new l(this));
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
        if (this.aGi == null) {
            this.aGi = new d();
        }
        if (!this.aGi.ck()) {
            new Thread(this.aGi).start();
        }
    }

    private void Gw() {
        if (this.aGi != null && this.aGi.ck()) {
            this.aGi.stop();
        }
    }

    public void a(a aVar) {
        if (this.aGk == null) {
            this.aGk = aVar;
        }
    }
}
