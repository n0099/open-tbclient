package com.baidu.tbadk.j;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String aHl = "dalvikvm";
    private String[] aHm = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d aHn = null;
    private int aHe = 0;
    private final int aHo = 10000;
    private a aHp = null;
    private final Handler aHq = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void fa(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ck()) {
            super.start();
            this.aHq.sendEmptyMessageDelayed(0, 10000L);
            FQ();
            try {
                d.a(this.aHl, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        FR();
    }

    private void FQ() {
        if (this.aHn == null) {
            this.aHn = new d();
        }
        if (!this.aHn.ck()) {
            new Thread(this.aHn).start();
        }
    }

    private void FR() {
        if (this.aHn != null && this.aHn.ck()) {
            this.aHn.stop();
        }
    }

    public void a(a aVar) {
        if (this.aHp == null) {
            this.aHp = aVar;
        }
    }
}
