package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.k.t
    public void a(m mVar) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "time_t");
            a(nm, mVar);
            nm.append("ishttp", mVar.byt ? "1" : "0");
            nm.append("issuccess", mVar.isSuccess ? "1" : "0");
            nm.append("nettype", r.Oa().getNetType());
            nm.append("ct", String.valueOf(mVar.byg));
            nm.append("wt", String.valueOf(mVar.byo));
            nm.append("qt", String.valueOf(mVar.byh));
            nm.append("connt", String.valueOf(mVar.byi));
            nm.append("rwt", String.valueOf(mVar.byj));
            nm.append("dect", String.valueOf(mVar.byk));
            nm.append("parset", String.valueOf(mVar.byl));
            nm.append("rendert", String.valueOf(mVar.byn));
            nm.append("ss", String.valueOf(mVar.byr));
            nm.append("hs", String.valueOf(mVar.bys));
            if (mVar.byt && mVar.socketErrNo != 0) {
                nm.append("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    nm.append("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                nm.h("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.byt) {
                nm.append("c_logid", String.valueOf(mVar.byx));
            } else {
                nm.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void b(m mVar) {
        if (r.Oa().Ob() && mVar.byp > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "readCache_t");
            a(nm, mVar);
            nm.append("rct", String.valueOf(mVar.byp));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void c(m mVar) {
        if (r.Oa().Ob() && mVar.byq > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "writeCache_t");
            a(nm, mVar);
            nm.append("wct", String.valueOf(mVar.byq));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "resource_t");
            nm.append("actype", str);
            nm.append("issuccess", lVar.isSuccess ? "1" : "0");
            nm.append("isfs", lVar.bye ? "1" : "0");
            nm.append("ct", String.valueOf(lVar.auq));
            nm.append("from", String.valueOf(lVar.aup));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void g(d dVar) {
        if (dVar != null && r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "fluency_t");
            a(nm, dVar);
            nm.append("fps", String.valueOf(dVar.NK()));
            nm.append("memp", String.valueOf(dVar.NM()));
            nm.append("cpu", String.valueOf(dVar.NN()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void h(d dVar) {
        if (r.Oa().Ob()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "gc_t");
            a(nm, dVar);
            nm.append("gc", String.valueOf(dVar.NL()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, d dVar) {
        if (dVar instanceof f) {
            aVar.h("ptype", Integer.valueOf(((f) dVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.a aVar, m mVar) {
        if (mVar instanceof g) {
            aVar.h("ptype", Integer.valueOf(((g) mVar).pageType));
        }
    }
}
