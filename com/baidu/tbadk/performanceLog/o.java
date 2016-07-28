package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "time_t");
            a(dG, vVar);
            dG.q("ishttp", vVar.azq ? "1" : "0");
            dG.q("issuccess", vVar.isSuccess ? "1" : "0");
            dG.q("nettype", aa.EV().getNetType());
            dG.q("ct", String.valueOf(vVar.azd));
            dG.q("wt", String.valueOf(vVar.azl));
            dG.q("qt", String.valueOf(vVar.aze));
            dG.q("connt", String.valueOf(vVar.azf));
            dG.q("rwt", String.valueOf(vVar.azg));
            dG.q("dect", String.valueOf(vVar.azh));
            dG.q("parset", String.valueOf(vVar.azi));
            dG.q("rendert", String.valueOf(vVar.azk));
            dG.q("ss", String.valueOf(vVar.azo));
            dG.q("hs", String.valueOf(vVar.azp));
            if (vVar.azq && vVar.socketErrNo != 0) {
                dG.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dG.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                dG.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.azq) {
                dG.q("c_logid", String.valueOf(vVar.azu));
            } else {
                dG.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.EV().EW() && vVar.azm > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "readCache_t");
            a(dG, vVar);
            dG.q("rct", String.valueOf(vVar.azm));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.EV().EW() && vVar.azn > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "writeCache_t");
            a(dG, vVar);
            dG.q("wct", String.valueOf(vVar.azn));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "resource_t");
            dG.q("actype", str);
            dG.q("issuccess", uVar.isSuccess ? "1" : "0");
            dG.q("isfs", uVar.azb ? "1" : "0");
            dG.q("ct", String.valueOf(uVar.yn));
            dG.q("from", String.valueOf(uVar.ym));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "fluency_t");
            a(dG, eVar);
            dG.q("fps", String.valueOf(eVar.EF()));
            dG.q("memp", String.valueOf(eVar.EH()));
            dG.q("cpu", String.valueOf(eVar.EI()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "gc_t");
            a(dG, eVar);
            dG.q("gc", String.valueOf(eVar.EG()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, e eVar) {
        if (eVar instanceof m) {
            dVar.d("ptype", Integer.valueOf(((m) eVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, v vVar) {
        if (vVar instanceof n) {
            dVar.d("ptype", Integer.valueOf(((n) vVar).pageType));
        }
    }
}
