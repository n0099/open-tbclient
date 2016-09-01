package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "time_t");
            a(eB, vVar);
            eB.q("ishttp", vVar.aCx ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.Gp().getNetType());
            eB.q("ct", String.valueOf(vVar.aCk));
            eB.q("wt", String.valueOf(vVar.aCs));
            eB.q("qt", String.valueOf(vVar.aCl));
            eB.q("connt", String.valueOf(vVar.aCm));
            eB.q("rwt", String.valueOf(vVar.aCn));
            eB.q("dect", String.valueOf(vVar.aCo));
            eB.q("parset", String.valueOf(vVar.aCp));
            eB.q("rendert", String.valueOf(vVar.aCr));
            eB.q("ss", String.valueOf(vVar.aCv));
            eB.q("hs", String.valueOf(vVar.aCw));
            if (vVar.aCx && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCx) {
                eB.q("c_logid", String.valueOf(vVar.aCB));
            } else {
                eB.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.Gp().Gq() && vVar.aCt > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache_t");
            a(eB, vVar);
            eB.q("rct", String.valueOf(vVar.aCt));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.Gp().Gq() && vVar.aCu > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache_t");
            a(eB, vVar);
            eB.q("wct", String.valueOf(vVar.aCu));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource_t");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aCi ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency_t");
            a(eB, eVar);
            eB.q("fps", String.valueOf(eVar.FZ()));
            eB.q("memp", String.valueOf(eVar.Gb()));
            eB.q("cpu", String.valueOf(eVar.Gc()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.Gp().Gq()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc_t");
            a(eB, eVar);
            eB.q("gc", String.valueOf(eVar.Ga()));
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
