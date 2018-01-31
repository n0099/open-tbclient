package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class h extends t {
    @Override // com.baidu.tbadk.k.t
    public void a(m mVar) {
        if (r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "time_t");
            a(nn, mVar);
            nn.append("ishttp", mVar.byL ? "1" : "0");
            nn.append("issuccess", mVar.isSuccess ? "1" : "0");
            nn.append("nettype", r.NQ().getNetType());
            nn.append("ct", String.valueOf(mVar.byy));
            nn.append("wt", String.valueOf(mVar.byG));
            nn.append("qt", String.valueOf(mVar.byz));
            nn.append("connt", String.valueOf(mVar.byA));
            nn.append("rwt", String.valueOf(mVar.byB));
            nn.append("dect", String.valueOf(mVar.byC));
            nn.append("parset", String.valueOf(mVar.byD));
            nn.append("rendert", String.valueOf(mVar.byF));
            nn.append("ss", String.valueOf(mVar.byJ));
            nn.append("hs", String.valueOf(mVar.byK));
            if (mVar.byL && mVar.socketErrNo != 0) {
                nn.append("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    nn.append("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.errCode != 0) {
                nn.h("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.byL) {
                nn.append("c_logid", String.valueOf(mVar.byP));
            } else {
                nn.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void b(m mVar) {
        if (r.NQ().NR() && mVar.byH > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "readCache_t");
            a(nn, mVar);
            nn.append("rct", String.valueOf(mVar.byH));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void c(m mVar) {
        if (r.NQ().NR() && mVar.byI > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "writeCache_t");
            a(nn, mVar);
            nn.append("wct", String.valueOf(mVar.byI));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "resource_t");
            nn.append("actype", str);
            nn.append("issuccess", lVar.isSuccess ? "1" : "0");
            nn.append("isfs", lVar.byw ? "1" : "0");
            nn.append("ct", String.valueOf(lVar.aus));
            nn.append("from", String.valueOf(lVar.aur));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void g(d dVar) {
        if (dVar != null && r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "fluency_t");
            a(nn, dVar);
            nn.append("fps", String.valueOf(dVar.NA()));
            nn.append("memp", String.valueOf(dVar.NC()));
            nn.append("cpu", String.valueOf(dVar.ND()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    @Override // com.baidu.tbadk.k.t
    public void h(d dVar) {
        if (r.NQ().NR()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append("action", "gc_t");
            a(nn, dVar);
            nn.append("gc", String.valueOf(dVar.NB()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
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
