package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fL.p("ishttp", mVar.aJU ? "1" : "0");
            fL.p("issuccess", mVar.isSuccess ? "1" : "0");
            fL.p("nettype", r.Gx().getNetType());
            fL.p("wt", String.valueOf(mVar.aJP));
            fL.p("qt", String.valueOf(mVar.aJI));
            fL.p("connt", String.valueOf(mVar.aJJ));
            fL.p("rwt", String.valueOf(mVar.aJK));
            fL.p("fbt", String.valueOf(mVar.ob));
            fL.p("abt", String.valueOf(mVar.oc));
            fL.p("dect", String.valueOf(mVar.aJL));
            fL.p("parset", String.valueOf(mVar.aJM));
            fL.p("tqt", String.valueOf(mVar.aJN));
            fL.p("rendert", String.valueOf(mVar.aJO));
            fL.p("ss", String.valueOf(mVar.aJS));
            fL.p("hs", String.valueOf(mVar.aJT));
            if (mVar.aJU && mVar.socketErrNo != 0) {
                fL.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fL.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aJU) {
                fL.p("hrtn", String.valueOf(mVar.aJV));
                fL.p("hrtt", String.valueOf(mVar.aJW));
            }
            if (mVar.errCode != 0) {
                fL.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJX) {
                fL.p("pt", "1");
            } else {
                fL.p("sysct", String.valueOf(mVar.aJG));
                fL.p("ct", String.valueOf(mVar.aJH));
            }
            if (mVar.aJU) {
                fL.p("c_logid", String.valueOf(mVar.aJY));
                if (mVar.sequenceID != 0) {
                    fL.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
                }
            } else {
                fL.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    public void b(m mVar) {
        if (r.Gx().Gy() && mVar.aJQ > 0) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "readCache");
            fL.p("rct", String.valueOf(mVar.aJQ));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    public void c(m mVar) {
        if (r.Gx().Gy() && mVar.aJR > 0) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "writeCache");
            fL.p("wct", String.valueOf(mVar.aJR));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "resource");
            fL.p("actype", str);
            fL.p("issuccess", lVar.isSuccess ? "1" : "0");
            fL.p("isfs", lVar.aJF ? "1" : "0");
            fL.p("ct", String.valueOf(lVar.GA));
            fL.p("from", String.valueOf(lVar.Gz));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "fluency");
            fL.p("fps", String.valueOf(dVar.Gh()));
            fL.p("memp", String.valueOf(dVar.Gj()));
            fL.p("cpu", String.valueOf(dVar.Gk()));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }

    public void h(d dVar) {
        if (r.Gx().Gy()) {
            com.baidu.adp.lib.stats.a fL = fL();
            fL.p("action", "gc");
            fL.p("gc", String.valueOf(dVar.Gi()));
            BdStatisticsManager.getInstance().performance(this.subType, fL);
        }
    }
}
