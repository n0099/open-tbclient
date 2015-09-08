package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class w extends x {
    public void b(o oVar) {
        if (oVar != null && y.Eo().Ep()) {
            com.baidu.adp.lib.stats.d ha = ha();
            ha.q("action", "live_cpu");
            ha.q("memp", String.valueOf(oVar.DW()));
            ha.q("cpu", String.valueOf(oVar.getCpuString()));
            ha.q("nativeMemp", String.valueOf(oVar.Ee()));
            ha.q("isPlayer", String.valueOf(oVar.Ec()));
            com.baidu.adp.lib.stats.a.hh().a(this.subType, ha);
        }
    }

    public void d(com.baidu.adp.lib.stats.d dVar) {
        if (dVar != null && y.Eo().Ep()) {
            com.baidu.adp.lib.stats.a.hh().a(this.subType, dVar);
        }
    }
}
