package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String aqb = "dalvikvm";
    private String[] aqc = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f aqd = null;
    private int apV = 0;
    private final int aqe = 10000;
    private q aqf = null;
    private final Handler aqg = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dN()) {
            super.start();
            this.aqg.sendEmptyMessageDelayed(0, 10000L);
            Dm();
            try {
                f.a(this.aqb, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Dn();
    }

    private void Dm() {
        if (this.aqd == null) {
            this.aqd = new f();
        }
        if (!this.aqd.dN()) {
            new Thread(this.aqd).start();
        }
    }

    private void Dn() {
        if (this.aqd != null && this.aqd.dN()) {
            this.aqd.stop();
        }
    }

    public void a(q qVar) {
        if (this.aqf == null) {
            this.aqf = qVar;
        }
    }
}
