package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.a.a.a {
    private String axd = "dalvikvm";
    private String[] axe = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private d axf = null;
    private int awW = 0;
    private final int axg = 10000;
    private a axh = null;
    private final Handler axi = new k(this);

    /* loaded from: classes.dex */
    public interface a {
        void eI(int i);
    }

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!ah()) {
            super.start();
            this.axi.sendEmptyMessageDelayed(0, 10000L);
            EC();
            try {
                d.a(this.axd, new l(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        ED();
    }

    private void EC() {
        if (this.axf == null) {
            this.axf = new d();
        }
        if (!this.axf.ah()) {
            new Thread(this.axf).start();
        }
    }

    private void ED() {
        if (this.axf != null && this.axf.ah()) {
            this.axf.stop();
        }
    }

    public void a(a aVar) {
        if (this.axh == null) {
            this.axh = aVar;
        }
    }
}
