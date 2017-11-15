package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.l.t
    public void a(m mVar) {
        if (r.Gt().Gu()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "time_t");
            a(fK, mVar);
            fK.p("ishttp", mVar.aJX ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gt().getNetType());
            fK.p("ct", String.valueOf(mVar.aJK));
            fK.p("wt", String.valueOf(mVar.aJS));
            fK.p("qt", String.valueOf(mVar.aJL));
            fK.p("connt", String.valueOf(mVar.aJM));
            fK.p("rwt", String.valueOf(mVar.aJN));
            fK.p("dect", String.valueOf(mVar.aJO));
            fK.p("parset", String.valueOf(mVar.aJP));
            fK.p("rendert", String.valueOf(mVar.aJR));
            fK.p("ss", String.valueOf(mVar.aJV));
            fK.p("hs", String.valueOf(mVar.aJW));
            if (mVar.aJX && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJX) {
                fK.p("c_logid", String.valueOf(mVar.aKb));
            } else {
                fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void b(m mVar) {
        if (r.Gt().Gu() && mVar.aJT > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache_t");
            a(fK, mVar);
            fK.p("rct", String.valueOf(mVar.aJT));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void c(m mVar) {
        if (r.Gt().Gu() && mVar.aJU > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache_t");
            a(fK, mVar);
            fK.p("wct", String.valueOf(mVar.aJU));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gt().Gu()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource_t");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aJI ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void g(d dVar) {
        if (dVar != null && r.Gt().Gu()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency_t");
            a(fK, dVar);
            fK.p("fps", String.valueOf(dVar.Gd()));
            fK.p("memp", String.valueOf(dVar.Gf()));
            fK.p("cpu", String.valueOf(dVar.Gg()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void h(d dVar) {
        if (r.Gt().Gu()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc_t");
            a(fK, dVar);
            fK.p("gc", String.valueOf(dVar.Ge()));
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
