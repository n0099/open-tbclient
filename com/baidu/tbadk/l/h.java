package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.l.t
    public void a(m mVar) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "time_t");
            a(fK, mVar);
            fK.p("ishttp", mVar.aIZ ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gr().getNetType());
            fK.p("ct", String.valueOf(mVar.aIM));
            fK.p("wt", String.valueOf(mVar.aIU));
            fK.p("qt", String.valueOf(mVar.aIN));
            fK.p("connt", String.valueOf(mVar.aIO));
            fK.p("rwt", String.valueOf(mVar.aIP));
            fK.p("dect", String.valueOf(mVar.aIQ));
            fK.p("parset", String.valueOf(mVar.aIR));
            fK.p("rendert", String.valueOf(mVar.aIT));
            fK.p("ss", String.valueOf(mVar.aIX));
            fK.p("hs", String.valueOf(mVar.aIY));
            if (mVar.aIZ && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                fK.d("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aIZ) {
                fK.p("c_logid", String.valueOf(mVar.aJd));
            } else {
                fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void b(m mVar) {
        if (r.Gr().Gs() && mVar.aIV > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache_t");
            a(fK, mVar);
            fK.p("rct", String.valueOf(mVar.aIV));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void c(m mVar) {
        if (r.Gr().Gs() && mVar.aIW > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache_t");
            a(fK, mVar);
            fK.p("wct", String.valueOf(mVar.aIW));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource_t");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aIK ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Hf));
            fK.p("from", String.valueOf(lVar.He));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void g(d dVar) {
        if (dVar != null && r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency_t");
            a(fK, dVar);
            fK.p("fps", String.valueOf(dVar.Gb()));
            fK.p("memp", String.valueOf(dVar.Gd()));
            fK.p("cpu", String.valueOf(dVar.Ge()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    @Override // com.baidu.tbadk.l.t
    public void h(d dVar) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc_t");
            a(fK, dVar);
            fK.p("gc", String.valueOf(dVar.Gc()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
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
