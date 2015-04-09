package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class af extends ag {
    public void b(u uVar) {
        if (uVar != null && ah.CQ().CR()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "live_cpu");
            hC.r("logid", String.valueOf(uVar.apt));
            hC.r("memp", String.valueOf(uVar.Cy()));
            hC.r("cpu", String.valueOf(uVar.getCpuString()));
            hC.r("nativeMemp", String.valueOf(uVar.CG()));
            hC.r("isPlayer", String.valueOf(uVar.CE()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }
}
