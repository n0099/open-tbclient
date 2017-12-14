package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aKC ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.GB().getNetType());
            fK.p("wt", String.valueOf(mVar.aKx));
            fK.p("qt", String.valueOf(mVar.aKq));
            fK.p("connt", String.valueOf(mVar.aKr));
            fK.p("rwt", String.valueOf(mVar.aKs));
            fK.p("fbt", String.valueOf(mVar.oc));
            fK.p("abt", String.valueOf(mVar.od));
            fK.p("dect", String.valueOf(mVar.aKt));
            fK.p("parset", String.valueOf(mVar.aKu));
            fK.p("tqt", String.valueOf(mVar.aKv));
            fK.p("rendert", String.valueOf(mVar.aKw));
            fK.p("ss", String.valueOf(mVar.aKA));
            fK.p("hs", String.valueOf(mVar.aKB));
            if (mVar.aKC && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aKC) {
                fK.p("hrtn", String.valueOf(mVar.aKD));
                fK.p("hrtt", String.valueOf(mVar.aKE));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKF) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aKo));
                fK.p("ct", String.valueOf(mVar.aKp));
            }
            if (mVar.aKC) {
                fK.p("c_logid", String.valueOf(mVar.aKG));
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
        if (r.GB().GC() && mVar.aKy > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aKy));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.GB().GC() && mVar.aKz > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aKz));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.GB().GC()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aKn ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Gn));
            fK.p("from", String.valueOf(lVar.Gm));
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
