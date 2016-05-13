package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "time_t");
            a(dG, vVar);
            dG.q("ishttp", vVar.axK ? "1" : "0");
            dG.q("issuccess", vVar.isSuccess ? "1" : "0");
            dG.q("nettype", aa.EN().getNetType());
            dG.q("ct", String.valueOf(vVar.axx));
            dG.q("wt", String.valueOf(vVar.axF));
            dG.q("qt", String.valueOf(vVar.axy));
            dG.q("connt", String.valueOf(vVar.axz));
            dG.q("rwt", String.valueOf(vVar.axA));
            dG.q("dect", String.valueOf(vVar.axB));
            dG.q("parset", String.valueOf(vVar.axC));
            dG.q("rendert", String.valueOf(vVar.axE));
            dG.q("ss", String.valueOf(vVar.axI));
            dG.q("hs", String.valueOf(vVar.axJ));
            if (vVar.axK && vVar.socketErrNo != 0) {
                dG.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dG.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                dG.b("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.axK) {
                dG.q("c_logid", String.valueOf(vVar.axO));
            } else {
                dG.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.EN().EO() && vVar.axG > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "readCache_t");
            a(dG, vVar);
            dG.q("rct", String.valueOf(vVar.axG));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.EN().EO() && vVar.axH > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "writeCache_t");
            a(dG, vVar);
            dG.q("wct", String.valueOf(vVar.axH));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "resource_t");
            dG.q("actype", str);
            dG.q("issuccess", uVar.isSuccess ? "1" : "0");
            dG.q("isfs", uVar.axv ? "1" : "0");
            dG.q("ct", String.valueOf(uVar.xK));
            dG.q("from", String.valueOf(uVar.xJ));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "fluency_t");
            a(dG, eVar);
            dG.q("fps", String.valueOf(eVar.Ex()));
            dG.q("memp", String.valueOf(eVar.Ez()));
            dG.q("cpu", String.valueOf(eVar.EA()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.EN().EO()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "gc_t");
            a(dG, eVar);
            dG.q("gc", String.valueOf(eVar.Ey()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, e eVar) {
        if (eVar instanceof m) {
            dVar.b("ptype", Integer.valueOf(((m) eVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.d dVar, v vVar) {
        if (vVar instanceof n) {
            dVar.b("ptype", Integer.valueOf(((n) vVar).pageType));
        }
    }
}
