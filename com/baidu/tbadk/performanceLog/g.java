package com.baidu.tbadk.performanceLog;

import android.os.Handler;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
/* loaded from: classes.dex */
public class g extends com.baidu.adp.lib.debug.a.a {
    private String gt = "dalvikvm";
    private String[] gu = {"GC_FOR_ALLOC", "GC_FOR_MALLOC", "GC_CONCURRENT", "GC_EXPLICIT", "GC_EXTERNAL_ALLOC", "GC_HPROF_DUMP_HEAP"};
    private com.baidu.adp.lib.debug.a.k YL = null;
    private int YF = 0;
    private final int YM = TbConfig.BIG_IMAGE_MIN_CAPACITY;
    private j YN = null;
    private final Handler YO = new h(this);

    @Override // com.baidu.adp.lib.debug.a.a
    public void start() {
        if (!cJ()) {
            super.start();
            this.YO.sendEmptyMessageDelayed(0, 10000L);
            uD();
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
        uE();
    }

    private void uD() {
        if (this.YL == null) {
            this.YL = new com.baidu.adp.lib.debug.a.k();
        }
        if (!this.YL.cJ()) {
            new Thread(this.YL).start();
        }
    }

    private void uE() {
        if (this.YL != null && this.YL.cJ()) {
            this.YL.stop();
        }
    }

    public void a(j jVar) {
        if (this.YN == null) {
            this.YN = jVar;
        }
    }
}
