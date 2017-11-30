package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.GA().GB()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aKy ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.GA().getNetType());
            fK.p("wt", String.valueOf(mVar.aKt));
            fK.p("qt", String.valueOf(mVar.aKm));
            fK.p("connt", String.valueOf(mVar.aKn));
            fK.p("rwt", String.valueOf(mVar.aKo));
            fK.p("fbt", String.valueOf(mVar.od));
            fK.p("abt", String.valueOf(mVar.oe));
            fK.p("dect", String.valueOf(mVar.aKp));
            fK.p("parset", String.valueOf(mVar.aKq));
            fK.p("tqt", String.valueOf(mVar.aKr));
            fK.p("rendert", String.valueOf(mVar.aKs));
            fK.p("ss", String.valueOf(mVar.aKw));
            fK.p("hs", String.valueOf(mVar.aKx));
            if (mVar.aKy && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aKy) {
                fK.p("hrtn", String.valueOf(mVar.aKz));
                fK.p("hrtt", String.valueOf(mVar.aKA));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKB) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aKk));
                fK.p("ct", String.valueOf(mVar.aKl));
            }
            if (mVar.aKy) {
                fK.p("c_logid", String.valueOf(mVar.aKC));
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
        if (r.GA().GB() && mVar.aKu > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aKu));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.GA().GB() && mVar.aKv > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aKv));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.GA().GB()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aKj ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.GA().GB()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.Gk()));
            fK.p("memp", String.valueOf(dVar.Gm()));
            fK.p("cpu", String.valueOf(dVar.Gn()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.GA().GB()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.Gl()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
