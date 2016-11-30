package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "time_t");
            a(eB, vVar);
            eB.q("ishttp", vVar.aCR ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.Gu().getNetType());
            eB.q("ct", String.valueOf(vVar.aCE));
            eB.q("wt", String.valueOf(vVar.aCM));
            eB.q("qt", String.valueOf(vVar.aCF));
            eB.q("connt", String.valueOf(vVar.aCG));
            eB.q("rwt", String.valueOf(vVar.aCH));
            eB.q("dect", String.valueOf(vVar.aCI));
            eB.q("parset", String.valueOf(vVar.aCJ));
            eB.q("rendert", String.valueOf(vVar.aCL));
            eB.q("ss", String.valueOf(vVar.aCP));
            eB.q("hs", String.valueOf(vVar.aCQ));
            if (vVar.aCR && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCR) {
                eB.q("c_logid", String.valueOf(vVar.aCV));
            } else {
                eB.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.Gu().Gv() && vVar.aCN > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache_t");
            a(eB, vVar);
            eB.q("rct", String.valueOf(vVar.aCN));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.Gu().Gv() && vVar.aCO > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache_t");
            a(eB, vVar);
            eB.q("wct", String.valueOf(vVar.aCO));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource_t");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aCC ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency_t");
            a(eB, eVar);
            eB.q("fps", String.valueOf(eVar.Ge()));
            eB.q("memp", String.valueOf(eVar.Gg()));
            eB.q("cpu", String.valueOf(eVar.Gh()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.Gu().Gv()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc_t");
            a(eB, eVar);
            eB.q("gc", String.valueOf(eVar.Gf()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
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
