package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.k.t
    public void a(m mVar) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "time_t");
            a(fK, mVar);
            fK.p("ishttp", mVar.aKC ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.GB().getNetType());
            fK.p("ct", String.valueOf(mVar.aKp));
            fK.p("wt", String.valueOf(mVar.aKx));
            fK.p("qt", String.valueOf(mVar.aKq));
            fK.p("connt", String.valueOf(mVar.aKr));
            fK.p("rwt", String.valueOf(mVar.aKs));
            fK.p("dect", String.valueOf(mVar.aKt));
            fK.p("parset", String.valueOf(mVar.aKu));
            fK.p("rendert", String.valueOf(mVar.aKw));
            fK.p("ss", String.valueOf(mVar.aKA));
            fK.p("hs", String.valueOf(mVar.aKB));
            if (mVar.aKC && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKC) {
                fK.p("c_logid", String.valueOf(mVar.aKG));
            } else {
                fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void b(m mVar) {
        if (r.GB().GC() && mVar.aKy > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache_t");
            a(fK, mVar);
            fK.p("rct", String.valueOf(mVar.aKy));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void c(m mVar) {
        if (r.GB().GC() && mVar.aKz > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache_t");
            a(fK, mVar);
            fK.p("wct", String.valueOf(mVar.aKz));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource_t");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aKn ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void g(d dVar) {
        if (dVar != null && r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency_t");
            a(fK, dVar);
            fK.p("fps", String.valueOf(dVar.Gl()));
            fK.p("memp", String.valueOf(dVar.Gn()));
            fK.p("cpu", String.valueOf(dVar.Go()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void h(d dVar) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc_t");
            a(fK, dVar);
            fK.p("gc", String.valueOf(dVar.Gm()));
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
