package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.debug.a.a {
    private String gt = "dalvikvm";
    private String[] gu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private com.baidu.adp.lib.debug.a.k YH = null;
    private int YB = 0;
    private final int YI = TbConfig.BIG_IMAGE_MIN_CAPACITY;
    private j YJ = null;
    private final Handler YK = new h(this);

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        if (!cJ()) {
            super.start();
            this.YK.sendEmptyMessageDelayed(0, 10000L);
            uB();
            try {
                com.baidu.adp.lib.debug.a.k.a(this.gt, new i(this));
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    @Override // com.baidu.adp.lib.debug.a.a
    public void stop() {
        super.stop();
        uC();
    }

    private void uB() {
        if (this.YH == null) {
            this.YH = new com.baidu.adp.lib.debug.a.k();
        }
        if (!this.YH.cJ()) {
            new Thread(this.YH).start();
        }
    }

    private void uC() {
        if (this.YH != null && this.YH.cJ()) {
            this.YH.stop();
        }
    }

    public void a(j jVar) {
        if (this.YJ == null) {
            this.YJ = jVar;
        }
    }
}
