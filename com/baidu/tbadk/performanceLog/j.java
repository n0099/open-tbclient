package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String ayw = "dalvikvm";
    private String[] ayx = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d ayy = null;
    private int ayq = 0;
    private final int ayz = 10000;
    private a ayA = null;
    private final Handler ayB = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void ev(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.ayB.sendEmptyMessageDelayed(0, 10000L);
            DY();
            try {
                d.a(this.ayw, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        DZ();
    }

    private void DY() {
        if (this.ayy == null) {
            this.ayy = new d();
        }
        if (!this.ayy.dO()) {
            new Thread(this.ayy).start();
        }
    }

    private void DZ() {
        if (this.ayy != null && this.ayy.dO()) {
            this.ayy.stop();
        }
    }

    public void a(a aVar) {
        if (this.ayA == null) {
            this.ayA = aVar;
        }
    }
}
