package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends x {
    public void b(o oVar) {
        if (oVar != null && y.DR().DS()) {
            com.baidu.adp.lib.stats.d hc = hc();
            hc.q("action", "live_cpu");
            hc.q("memp", String.valueOf(oVar.Dz()));
            hc.q("cpu", String.valueOf(oVar.getCpuString()));
            hc.q("nativeMemp", String.valueOf(oVar.DH()));
            hc.q("isPlayer", String.valueOf(oVar.DF()));
            com.baidu.adp.lib.stats.a.hj().a(this.subType, hc);
        }
    }

    public void d(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null && y.DR().DS()) {
            com.baidu.adp.lib.stats.a.hj().a(this.subType, dVar);
        }
    }
}
