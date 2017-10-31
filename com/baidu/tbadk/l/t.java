package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aJP ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gi().getNetType());
            fK.p("wt", String.valueOf(mVar.aJK));
            fK.p("qt", String.valueOf(mVar.aJD));
            fK.p("connt", String.valueOf(mVar.aJE));
            fK.p("rwt", String.valueOf(mVar.aJF));
            fK.p("fbt", String.valueOf(mVar.od));
            fK.p("abt", String.valueOf(mVar.oe));
            fK.p("dect", String.valueOf(mVar.aJG));
            fK.p("parset", String.valueOf(mVar.aJH));
            fK.p("tqt", String.valueOf(mVar.aJI));
            fK.p("rendert", String.valueOf(mVar.aJJ));
            fK.p("ss", String.valueOf(mVar.aJN));
            fK.p("hs", String.valueOf(mVar.aJO));
            if (mVar.aJP && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aJP) {
                fK.p("hrtn", String.valueOf(mVar.aJQ));
                fK.p("hrtt", String.valueOf(mVar.aJR));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJS) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aJB));
                fK.p("ct", String.valueOf(mVar.aJC));
            }
            if (mVar.aJP) {
                fK.p("c_logid", String.valueOf(mVar.aJT));
                if (mVar.sequenceID != 0) {
                    fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
                }
            } else {
                fK.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void b(m mVar) {
        if (r.Gi().Gj() && mVar.aJL > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aJL));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.Gi().Gj() && mVar.aJM > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aJM));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aJA ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.FS()));
            fK.p("memp", String.valueOf(dVar.FU()));
            fK.p("cpu", String.valueOf(dVar.FV()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.Gi().Gj()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.FT()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
