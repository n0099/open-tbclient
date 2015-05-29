package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class af extends ag {
    public void b(u uVar) {
        if (uVar != null && ah.DB().DC()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "live_cpu");
            hm.r("memp", String.valueOf(uVar.Dj()));
            hm.r("cpu", String.valueOf(uVar.getCpuString()));
            hm.r("nativeMemp", String.valueOf(uVar.Dr()));
            hm.r("isPlayer", String.valueOf(uVar.Dp()));
            com.baidu.adp.lib.stats.f.hz().b(this.subType, hm);
        }
    }

    public void b(com.baidu.adp.lib.stats.q qVar) {
        if (qVar != null && ah.DB().DC()) {
            com.baidu.adp.lib.stats.f.hz().b(this.subType, qVar);
        }
    }
}
