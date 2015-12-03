package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends x {
    public void b(o oVar) {
        if (oVar != null && y.ES().ET()) {
            com.baidu.adp.lib.stats.d he = he();
            he.q("action", "live_cpu");
            he.q("memp", String.valueOf(oVar.EA()));
            he.q("cpu", String.valueOf(oVar.getCpuString()));
            he.q("nativeMemp", String.valueOf(oVar.EI()));
            he.q("isPlayer", String.valueOf(oVar.EG()));
            com.baidu.adp.lib.stats.a.hl().a(this.subType, he);
        }
    }

    public void d(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null && y.ES().ET()) {
            com.baidu.adp.lib.stats.a.hl().a(this.subType, dVar);
        }
    }
}
