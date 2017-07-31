package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.l.t
    public void a(m mVar) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "time_t");
            a(fV, mVar);
            fV.p("ishttp", mVar.aKo ? "1" : "0");
            fV.p("issuccess", mVar.isSuccess ? "1" : "0");
            fV.p("nettype", r.Gz().getNetType());
            fV.p("ct", String.valueOf(mVar.aKb));
            fV.p("wt", String.valueOf(mVar.aKj));
            fV.p("qt", String.valueOf(mVar.aKc));
            fV.p("connt", String.valueOf(mVar.aKd));
            fV.p("rwt", String.valueOf(mVar.aKe));
            fV.p("dect", String.valueOf(mVar.aKf));
            fV.p("parset", String.valueOf(mVar.aKg));
            fV.p("rendert", String.valueOf(mVar.aKi));
            fV.p("ss", String.valueOf(mVar.aKm));
            fV.p("hs", String.valueOf(mVar.aKn));
            if (mVar.aKo && mVar.socketErrNo != 0) {
                fV.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fV.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fV.d("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKo) {
                fV.p("c_logid", String.valueOf(mVar.aKs));
            } else {
                fV.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void b(m mVar) {
        if (r.Gz().GA() && mVar.aKk > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "readCache_t");
            a(fV, mVar);
            fV.p("rct", String.valueOf(mVar.aKk));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void c(m mVar) {
        if (r.Gz().GA() && mVar.aKl > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "writeCache_t");
            a(fV, mVar);
            fV.p("wct", String.valueOf(mVar.aKl));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "resource_t");
            fV.p("actype", str);
            fV.p("issuccess", lVar.isSuccess ? "1" : "0");
            fV.p("isfs", lVar.aJZ ? "1" : "0");
            fV.p("ct", String.valueOf(lVar.IF));
            fV.p("from", String.valueOf(lVar.IE));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void g(d dVar) {
        if (dVar != null && r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "fluency_t");
            a(fV, dVar);
            fV.p("fps", String.valueOf(dVar.Gj()));
            fV.p("memp", String.valueOf(dVar.Gl()));
            fV.p("cpu", String.valueOf(dVar.Gm()));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void h(d dVar) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "gc_t");
            a(fV, dVar);
            fV.p("gc", String.valueOf(dVar.Gk()));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, d dVar) {
        if (dVar instanceof f) {
            aVar.d("ptype", Integer.valueOf(((f) dVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, m mVar) {
        if (mVar instanceof g) {
            aVar.d("ptype", Integer.valueOf(((g) mVar).pageType));
        }
    }
}
