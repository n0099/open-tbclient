package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aKF ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.GB().getNetType());
            fK.p("wt", String.valueOf(mVar.aKA));
            fK.p("qt", String.valueOf(mVar.aKt));
            fK.p("connt", String.valueOf(mVar.aKu));
            fK.p("rwt", String.valueOf(mVar.aKv));
            fK.p("fbt", String.valueOf(mVar.od));
            fK.p("abt", String.valueOf(mVar.oe));
            fK.p("dect", String.valueOf(mVar.aKw));
            fK.p("parset", String.valueOf(mVar.aKx));
            fK.p("tqt", String.valueOf(mVar.aKy));
            fK.p("rendert", String.valueOf(mVar.aKz));
            fK.p("ss", String.valueOf(mVar.aKD));
            fK.p("hs", String.valueOf(mVar.aKE));
            if (mVar.aKF && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aKF) {
                fK.p("hrtn", String.valueOf(mVar.aKG));
                fK.p("hrtt", String.valueOf(mVar.aKH));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKI) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aKr));
                fK.p("ct", String.valueOf(mVar.aKs));
            }
            if (mVar.aKF) {
                fK.p("c_logid", String.valueOf(mVar.aKJ));
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
        if (r.GB().GC() && mVar.aKB > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aKB));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.GB().GC() && mVar.aKC > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aKC));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aKq ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Go));
            fK.p("from", String.valueOf(lVar.Gn));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.Gl()));
            fK.p("memp", String.valueOf(dVar.Gn()));
            fK.p("cpu", String.valueOf(dVar.Go()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.Gm()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
