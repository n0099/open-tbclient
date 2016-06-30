package com.baidu.tbadk.performanceLog;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "time_t");
            a(dH, vVar);
            dH.q("ishttp", vVar.ayA ? "1" : "0");
            dH.q("issuccess", vVar.isSuccess ? "1" : "0");
            dH.q("nettype", aa.EW().getNetType());
            dH.q("ct", String.valueOf(vVar.ayn));
            dH.q("wt", String.valueOf(vVar.ayv));
            dH.q("qt", String.valueOf(vVar.ayo));
            dH.q("connt", String.valueOf(vVar.ayp));
            dH.q("rwt", String.valueOf(vVar.ayq));
            dH.q("dect", String.valueOf(vVar.ayr));
            dH.q("parset", String.valueOf(vVar.ays));
            dH.q("rendert", String.valueOf(vVar.ayu));
            dH.q("ss", String.valueOf(vVar.ayy));
            dH.q("hs", String.valueOf(vVar.ayz));
            if (vVar.ayA && vVar.socketErrNo != 0) {
                dH.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dH.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                dH.b("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.ayA) {
                dH.q("c_logid", String.valueOf(vVar.ayE));
            } else {
                dH.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.EW().EX() && vVar.ayw > 0) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "readCache_t");
            a(dH, vVar);
            dH.q("rct", String.valueOf(vVar.ayw));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.EW().EX() && vVar.ayx > 0) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "writeCache_t");
            a(dH, vVar);
            dH.q("wct", String.valueOf(vVar.ayx));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "resource_t");
            dH.q("actype", str);
            dH.q("issuccess", uVar.isSuccess ? "1" : "0");
            dH.q("isfs", uVar.ayl ? "1" : "0");
            dH.q("ct", String.valueOf(uVar.xM));
            dH.q("from", String.valueOf(uVar.xL));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "fluency_t");
            a(dH, eVar);
            dH.q("fps", String.valueOf(eVar.EG()));
            dH.q("memp", String.valueOf(eVar.EI()));
            dH.q("cpu", String.valueOf(eVar.EJ()));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "gc_t");
            a(dH, eVar);
            dH.q("gc", String.valueOf(eVar.EH()));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
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
