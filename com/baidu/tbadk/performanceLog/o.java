package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "time_t");
            a(eB, vVar);
            eB.q("ishttp", vVar.aCl ? "1" : "0");
            eB.q("issuccess", vVar.isSuccess ? "1" : "0");
            eB.q("nettype", aa.FU().getNetType());
            eB.q("ct", String.valueOf(vVar.aBY));
            eB.q("wt", String.valueOf(vVar.aCg));
            eB.q("qt", String.valueOf(vVar.aBZ));
            eB.q("connt", String.valueOf(vVar.aCa));
            eB.q("rwt", String.valueOf(vVar.aCb));
            eB.q("dect", String.valueOf(vVar.aCc));
            eB.q("parset", String.valueOf(vVar.aCd));
            eB.q("rendert", String.valueOf(vVar.aCf));
            eB.q("ss", String.valueOf(vVar.aCj));
            eB.q("hs", String.valueOf(vVar.aCk));
            if (vVar.aCl && vVar.socketErrNo != 0) {
                eB.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    eB.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                eB.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aCl) {
                eB.q("c_logid", String.valueOf(vVar.aCp));
            } else {
                eB.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.FU().FV() && vVar.aCh > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "readCache_t");
            a(eB, vVar);
            eB.q("rct", String.valueOf(vVar.aCh));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.FU().FV() && vVar.aCi > 0) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "writeCache_t");
            a(eB, vVar);
            eB.q("wct", String.valueOf(vVar.aCi));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "resource_t");
            eB.q("actype", str);
            eB.q("issuccess", uVar.isSuccess ? "1" : "0");
            eB.q("isfs", uVar.aBW ? "1" : "0");
            eB.q("ct", String.valueOf(uVar.AA));
            eB.q("from", String.valueOf(uVar.Az));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "fluency_t");
            a(eB, eVar);
            eB.q("fps", String.valueOf(eVar.FE()));
            eB.q("memp", String.valueOf(eVar.FG()));
            eB.q("cpu", String.valueOf(eVar.FH()));
            com.baidu.adp.lib.stats.a.eI().a(this.subType, eB);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.FU().FV()) {
            com.baidu.adp.lib.stats.d eB = eB();
            eB.q("action", "gc_t");
            a(eB, eVar);
            eB.q("gc", String.valueOf(eVar.FF()));
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
