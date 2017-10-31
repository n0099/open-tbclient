package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.l.t
    public void a(m mVar) {
        if (r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "time_t");
            a(fK, mVar);
            fK.p("ishttp", mVar.aJP ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gi().getNetType());
            fK.p("ct", String.valueOf(mVar.aJC));
            fK.p("wt", String.valueOf(mVar.aJK));
            fK.p("qt", String.valueOf(mVar.aJD));
            fK.p("connt", String.valueOf(mVar.aJE));
            fK.p("rwt", String.valueOf(mVar.aJF));
            fK.p("dect", String.valueOf(mVar.aJG));
            fK.p("parset", String.valueOf(mVar.aJH));
            fK.p("rendert", String.valueOf(mVar.aJJ));
            fK.p("ss", String.valueOf(mVar.aJN));
            fK.p("hs", String.valueOf(mVar.aJO));
            if (mVar.aJP && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJP) {
                fK.p("c_logid", String.valueOf(mVar.aJT));
            } else {
                fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void b(m mVar) {
        if (r.Gi().Gj() && mVar.aJL > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache_t");
            a(fK, mVar);
            fK.p("rct", String.valueOf(mVar.aJL));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void c(m mVar) {
        if (r.Gi().Gj() && mVar.aJM > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache_t");
            a(fK, mVar);
            fK.p("wct", String.valueOf(mVar.aJM));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource_t");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aJA ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void g(d dVar) {
        if (dVar != null && r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency_t");
            a(fK, dVar);
            fK.p("fps", String.valueOf(dVar.FS()));
            fK.p("memp", String.valueOf(dVar.FU()));
            fK.p("cpu", String.valueOf(dVar.FV()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void h(d dVar) {
        if (r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc_t");
            a(fK, dVar);
            fK.p("gc", String.valueOf(dVar.FT()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
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
