package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.l.t
    public void a(m mVar) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "time_t");
            a(fL, mVar);
            fL.p("ishttp", mVar.aJR ? "1" : "0");
            fL.p("issuccess", mVar.isSuccess ? "1" : "0");
            fL.p("nettype", r.Gx().getNetType());
            fL.p("ct", String.valueOf(mVar.aJE));
            fL.p("wt", String.valueOf(mVar.aJM));
            fL.p("qt", String.valueOf(mVar.aJF));
            fL.p("connt", String.valueOf(mVar.aJG));
            fL.p("rwt", String.valueOf(mVar.aJH));
            fL.p("dect", String.valueOf(mVar.aJI));
            fL.p("parset", String.valueOf(mVar.aJJ));
            fL.p("rendert", String.valueOf(mVar.aJL));
            fL.p("ss", String.valueOf(mVar.aJP));
            fL.p("hs", String.valueOf(mVar.aJQ));
            if (mVar.aJR && mVar.socketErrNo != 0) {
                fL.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fL.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fL.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJR) {
                fL.p("c_logid", String.valueOf(mVar.aJV));
            } else {
                fL.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void b(m mVar) {
        if (r.Gx().Gy() && mVar.aJN > 0) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "readCache_t");
            a(fL, mVar);
            fL.p("rct", String.valueOf(mVar.aJN));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void c(m mVar) {
        if (r.Gx().Gy() && mVar.aJO > 0) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "writeCache_t");
            a(fL, mVar);
            fL.p("wct", String.valueOf(mVar.aJO));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "resource_t");
            fL.p("actype", str);
            fL.p("issuccess", lVar.isSuccess ? "1" : "0");
            fL.p("isfs", lVar.aJC ? "1" : "0");
            fL.p("ct", String.valueOf(lVar.GA));
            fL.p("from", String.valueOf(lVar.Gz));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void g(d dVar) {
        if (dVar != null && r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "fluency_t");
            a(fL, dVar);
            fL.p("fps", String.valueOf(dVar.Gh()));
            fL.p("memp", String.valueOf(dVar.Gj()));
            fL.p("cpu", String.valueOf(dVar.Gk()));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void h(d dVar) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "gc_t");
            a(fL, dVar);
            fL.p("gc", String.valueOf(dVar.Gi()));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, d dVar) {
        if (dVar instanceof f) {
            aVar.c("ptype", Integer.valueOf(((f) dVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, m mVar) {
        if (mVar instanceof g) {
            aVar.c("ptype", Integer.valueOf(((g) mVar).pageType));
        }
    }
}
