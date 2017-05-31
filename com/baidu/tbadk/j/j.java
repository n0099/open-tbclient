package com.baidu.tbadk.j;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aFX = "dalvikvm";
    private String[] aFY = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aFZ = null;
    private int aFQ = 0;
    private final int aGa = 10000;
    private a aGb = null;
    private final Handler aGc = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eY(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aGc.sendEmptyMessageDelayed(0, 10000L);
            Ft();
            try {
                d.a(this.aFX, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Fu();
    }

    private void Ft() {
        if (this.aFZ == null) {
            this.aFZ = new d();
        }
        if (!this.aFZ.ck()) {
            new Thread(this.aFZ).start();
        }
    }

    private void Fu() {
        if (this.aFZ != null && this.aFZ.ck()) {
            this.aFZ.stop();
        }
    }

    public void a(a aVar) {
        if (this.aGb == null) {
            this.aGb = aVar;
        }
    }
}
