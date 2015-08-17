package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends x {
    public void b(o oVar) {
        if (oVar != null && y.Ee().Ef()) {
            com.baidu.adp.lib.stats.d hd = hd();
            hd.q("action", "live_cpu");
            hd.q("memp", String.valueOf(oVar.DM()));
            hd.q("cpu", String.valueOf(oVar.getCpuString()));
            hd.q("nativeMemp", String.valueOf(oVar.DU()));
            hd.q("isPlayer", String.valueOf(oVar.DS()));
            com.baidu.adp.lib.stats.a.hk().a(this.subType, hd);
        }
    }

    public void d(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null && y.Ee().Ef()) {
            com.baidu.adp.lib.stats.a.hk().a(this.subType, dVar);
        }
    }
}
