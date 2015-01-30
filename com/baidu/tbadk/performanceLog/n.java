package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String agw = "dalvikvm";
    private String[] agx = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f agy = null;
    private int agq = 0;
    private final int agz = TbConfig.BIG_IMAGE_MIN_CAPACITY;
    private q agA = null;
    private final Handler agB = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!an()) {
            super.start();
            this.agB.sendEmptyMessageDelayed(0, 10000L);
            zm();
            try {
                f.a(this.agw, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        zn();
    }

    private void zm() {
        if (this.agy == null) {
            this.agy = new f();
        }
        if (!this.agy.an()) {
            new Thread(this.agy).start();
        }
    }

    private void zn() {
        if (this.agy != null && this.agy.an()) {
            this.agy.stop();
        }
    }

    public void a(q qVar) {
        if (this.agA == null) {
            this.agA = qVar;
        }
    }
}
