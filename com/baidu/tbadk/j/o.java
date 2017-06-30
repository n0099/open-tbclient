package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.j.ac
    public void a(v vVar) {
        if (aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "time_t");
            a(fM, vVar);
            fM.p("ishttp", vVar.aHR ? "1" : "0");
            fM.p("issuccess", vVar.isSuccess ? "1" : "0");
            fM.p("nettype", aa.Gb().getNetType());
            fM.p("ct", String.valueOf(vVar.aHE));
            fM.p("wt", String.valueOf(vVar.aHM));
            fM.p("qt", String.valueOf(vVar.aHF));
            fM.p("connt", String.valueOf(vVar.aHG));
            fM.p("rwt", String.valueOf(vVar.aHH));
            fM.p("dect", String.valueOf(vVar.aHI));
            fM.p("parset", String.valueOf(vVar.aHJ));
            fM.p("rendert", String.valueOf(vVar.aHL));
            fM.p("ss", String.valueOf(vVar.aHP));
            fM.p("hs", String.valueOf(vVar.aHQ));
            if (vVar.aHR && vVar.socketErrNo != 0) {
                fM.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fM.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                fM.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aHR) {
                fM.p("c_logid", String.valueOf(vVar.aHV));
            } else {
                fM.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void b(v vVar) {
        if (aa.Gb().Gc() && vVar.aHN > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "readCache_t");
            a(fM, vVar);
            fM.p("rct", String.valueOf(vVar.aHN));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void c(v vVar) {
        if (aa.Gb().Gc() && vVar.aHO > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "writeCache_t");
            a(fM, vVar);
            fM.p("wct", String.valueOf(vVar.aHO));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "resource_t");
            fM.p("actype", str);
            fM.p("issuccess", uVar.isSuccess ? "1" : "0");
            fM.p("isfs", uVar.aHC ? "1" : "0");
            fM.p("ct", String.valueOf(uVar.Hf));
            fM.p("from", String.valueOf(uVar.He));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void g(e eVar) {
        if (eVar != null && aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "fluency_t");
            a(fM, eVar);
            fM.p("fps", String.valueOf(eVar.FL()));
            fM.p("memp", String.valueOf(eVar.FN()));
            fM.p("cpu", String.valueOf(eVar.FO()));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void h(e eVar) {
        if (aa.Gb().Gc()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "gc_t");
            a(fM, eVar);
            fM.p("gc", String.valueOf(eVar.FM()));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    private void a(com.baidu.adp.lib.stats.c cVar, e eVar) {
        if (eVar instanceof m) {
            cVar.d("ptype", Integer.valueOf(((m) eVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.c cVar, v vVar) {
        if (vVar instanceof n) {
            cVar.d("ptype", Integer.valueOf(((n) vVar).pageType));
        }
    }
}
