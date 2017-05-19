package com.baidu.tbadk.j;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aGk = "dalvikvm";
    private String[] aGl = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aGm = null;
    private int aGd = 0;
    private final int aGn = 10000;
    private a aGo = null;
    private final Handler aGp = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eX(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aGp.sendEmptyMessageDelayed(0, 10000L);
            Fz();
            try {
                d.a(this.aGk, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FA();
    }

    private void Fz() {
        if (this.aGm == null) {
            this.aGm = new d();
        }
        if (!this.aGm.ck()) {
            new Thread(this.aGm).start();
        }
    }

    private void FA() {
        if (this.aGm != null && this.aGm.ck()) {
            this.aGm.stop();
        }
    }

    public void a(a aVar) {
        if (this.aGo == null) {
            this.aGo = aVar;
        }
    }
}
