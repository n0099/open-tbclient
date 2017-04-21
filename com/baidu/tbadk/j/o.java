package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.j.ac
    public void a(v vVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "time_t");
            a(fN, vVar);
            fN.p("ishttp", vVar.aGM ? "1" : "0");
            fN.p("issuccess", vVar.isSuccess ? "1" : "0");
            fN.p("nettype", aa.GG().getNetType());
            fN.p("ct", String.valueOf(vVar.aGz));
            fN.p("wt", String.valueOf(vVar.aGH));
            fN.p("qt", String.valueOf(vVar.aGA));
            fN.p("connt", String.valueOf(vVar.aGB));
            fN.p("rwt", String.valueOf(vVar.aGC));
            fN.p("dect", String.valueOf(vVar.aGD));
            fN.p("parset", String.valueOf(vVar.aGE));
            fN.p("rendert", String.valueOf(vVar.aGG));
            fN.p("ss", String.valueOf(vVar.aGK));
            fN.p("hs", String.valueOf(vVar.aGL));
            if (vVar.aGM && vVar.socketErrNo != 0) {
                fN.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fN.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                fN.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGM) {
                fN.p("c_logid", String.valueOf(vVar.aGQ));
            } else {
                fN.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void b(v vVar) {
        if (aa.GG().GH() && vVar.aGI > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "readCache_t");
            a(fN, vVar);
            fN.p("rct", String.valueOf(vVar.aGI));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void c(v vVar) {
        if (aa.GG().GH() && vVar.aGJ > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "writeCache_t");
            a(fN, vVar);
            fN.p("wct", String.valueOf(vVar.aGJ));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "resource_t");
            fN.p("actype", str);
            fN.p("issuccess", uVar.isSuccess ? "1" : "0");
            fN.p("isfs", uVar.aGx ? "1" : "0");
            fN.p("ct", String.valueOf(uVar.Hg));
            fN.p("from", String.valueOf(uVar.Hf));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void g(e eVar) {
        if (eVar != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "fluency_t");
            a(fN, eVar);
            fN.p("fps", String.valueOf(eVar.Gq()));
            fN.p("memp", String.valueOf(eVar.Gs()));
            fN.p("cpu", String.valueOf(eVar.Gt()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    @Override // com.baidu.tbadk.j.ac
    public void h(e eVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "gc_t");
            a(fN, eVar);
            fN.p("gc", String.valueOf(eVar.Gr()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
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
