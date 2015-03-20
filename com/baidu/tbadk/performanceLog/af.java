package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class af extends ag {
    public void b(u uVar) {
        if (uVar != null && ah.CK().CL()) {
            com.baidu.adp.lib.stats.q hC = hC();
            hC.r("action", "live_cpu");
            hC.r("logid", String.valueOf(uVar.apk));
            hC.r("memp", String.valueOf(uVar.Cs()));
            hC.r("cpu", String.valueOf(uVar.getCpuString()));
            hC.r("nativeMemp", String.valueOf(uVar.CA()));
            hC.r("isPlayer", String.valueOf(uVar.Cy()));
            com.baidu.adp.lib.stats.f.hP().b(this.subType, hC);
        }
    }
}
