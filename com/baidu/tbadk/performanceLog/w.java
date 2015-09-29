package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends x {
    public void b(o oVar) {
        if (oVar != null && y.Eb().Ec()) {
            com.baidu.adp.lib.stats.d hb = hb();
            hb.q("action", "live_cpu");
            hb.q("memp", String.valueOf(oVar.DJ()));
            hb.q("cpu", String.valueOf(oVar.getCpuString()));
            hb.q("nativeMemp", String.valueOf(oVar.DR()));
            hb.q("isPlayer", String.valueOf(oVar.DP()));
            com.baidu.adp.lib.stats.a.hi().a(this.subType, hb);
        }
    }

    public void d(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null && y.Eb().Ec()) {
            com.baidu.adp.lib.stats.a.hi().a(this.subType, dVar);
        }
    }
}
