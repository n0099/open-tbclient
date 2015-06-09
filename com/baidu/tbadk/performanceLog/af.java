package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class af extends ag {
    public void b(u uVar) {
        if (uVar != null && ah.DC().DD()) {
            com.baidu.adp.lib.stats.q hm = hm();
            hm.r("action", "live_cpu");
            hm.r("memp", String.valueOf(uVar.Dk()));
            hm.r("cpu", String.valueOf(uVar.getCpuString()));
            hm.r("nativeMemp", String.valueOf(uVar.Ds()));
            hm.r("isPlayer", String.valueOf(uVar.Dq()));
            com.baidu.adp.lib.stats.f.hz().b(this.subType, hm);
        }
    }

    public void b(com.baidu.adp.lib.stats.q qVar) {
        if (qVar != null && ah.DC().DD()) {
            com.baidu.adp.lib.stats.f.hz().b(this.subType, qVar);
        }
    }
}
