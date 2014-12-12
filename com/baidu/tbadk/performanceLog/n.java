package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class n extends com.baidu.adp.a.a.a {
    private String afY = "dalvikvm";
    private String[] afZ = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private f aga = null;
    private int afS = 0;
    private final int agb = TbConfig.BIG_IMAGE_MIN_CAPACITY;
    private q agc = null;
    private final Handler agd = new o(this);

    @Override // com.baidu.adp.a.a.a
    public void start() {
        if (!an()) {
            super.start();
            this.agd.sendEmptyMessageDelayed(0, 10000L);
            yV();
            try {
                f.a(this.afY, new p(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.a.a.a
    public void stop() {
        super.stop();
        yW();
    }

    private void yV() {
        if (this.aga == null) {
            this.aga = new f();
        }
        if (!this.aga.an()) {
            new Thread(this.aga).start();
        }
    }

    private void yW() {
        if (this.aga != null && this.aga.an()) {
            this.aga.stop();
        }
    }

    public void a(q qVar) {
        if (this.agc == null) {
            this.agc = qVar;
        }
    }
}
