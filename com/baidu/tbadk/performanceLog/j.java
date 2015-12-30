package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String azu = "dalvikvm";
    private String[] azv = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d azw = null;
    private int azn = 0;
    private final int azx = 10000;
    private a azy = null;
    private final Handler azz = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eC(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!dO()) {
            super.start();
            this.azz.sendEmptyMessageDelayed(0, 10000L);
            Er();
            try {
                d.a(this.azu, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        Es();
    }

    private void Er() {
        if (this.azw == null) {
            this.azw = new d();
        }
        if (!this.azw.dO()) {
            new Thread(this.azw).start();
        }
    }

    private void Es() {
        if (this.azw != null && this.azw.dO()) {
            this.azw.stop();
        }
    }

    public void a(a aVar) {
        if (this.azy == null) {
            this.azy = aVar;
        }
    }
}
