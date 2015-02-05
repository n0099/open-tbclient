package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String agt = "dalvikvm";
    private String[] agu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f agv = null;
    private int agn = 0;
    private final int agw = TbConfig.BIG_IMAGE_MIN_CAPACITY;
    private q agx = null;
    private final Handler agy = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!an()) {
            super.start();
            this.agy.sendEmptyMessageDelayed(0, 10000L);
            zg();
            try {
                f.a(this.agt, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        zh();
    }

    private void zg() {
        if (this.agv == null) {
            this.agv = new f();
        }
        if (!this.agv.an()) {
            new Thread(this.agv).start();
        }
    }

    private void zh() {
        if (this.agv != null && this.agv.an()) {
            this.agv.stop();
        }
    }

    public void a(q qVar) {
        if (this.agx == null) {
            this.agx = qVar;
        }
    }
}
