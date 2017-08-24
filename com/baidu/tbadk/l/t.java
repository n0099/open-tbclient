package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fV.p("ishttp", mVar.aKq ? "1" : "0");
            fV.p("issuccess", mVar.isSuccess ? "1" : "0");
            fV.p("nettype", r.Gz().getNetType());
            fV.p("wt", String.valueOf(mVar.aKl));
            fV.p("qt", String.valueOf(mVar.aKe));
            fV.p("connt", String.valueOf(mVar.aKf));
            fV.p("rwt", String.valueOf(mVar.aKg));
            fV.p("fbt", String.valueOf(mVar.qu));
            fV.p("abt", String.valueOf(mVar.qv));
            fV.p("dect", String.valueOf(mVar.aKh));
            fV.p("parset", String.valueOf(mVar.aKi));
            fV.p("tqt", String.valueOf(mVar.aKj));
            fV.p("rendert", String.valueOf(mVar.aKk));
            fV.p("ss", String.valueOf(mVar.aKo));
            fV.p("hs", String.valueOf(mVar.aKp));
            if (mVar.aKq && mVar.socketErrNo != 0) {
                fV.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fV.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aKq) {
                fV.p("hrtn", String.valueOf(mVar.aKr));
                fV.p("hrtt", String.valueOf(mVar.aKs));
            }
            if (mVar.errCode != 0) {
                fV.d("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKt) {
                fV.p("pt", "1");
            } else {
                fV.p("sysct", String.valueOf(mVar.aKc));
                fV.p("ct", String.valueOf(mVar.aKd));
            }
            if (mVar.aKq) {
                fV.p("c_logid", String.valueOf(mVar.aKu));
                if (mVar.sequenceID != 0) {
                    fV.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
                }
            } else {
                fV.p("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void b(m mVar) {
        if (r.Gz().GA() && mVar.aKm > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "readCache");
            fV.p("rct", String.valueOf(mVar.aKm));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void c(m mVar) {
        if (r.Gz().GA() && mVar.aKn > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "writeCache");
            fV.p("wct", String.valueOf(mVar.aKn));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "resource");
            fV.p("actype", str);
            fV.p("issuccess", lVar.isSuccess ? "1" : "0");
            fV.p("isfs", lVar.aKb ? "1" : "0");
            fV.p("ct", String.valueOf(lVar.IH));
            fV.p("from", String.valueOf(lVar.IG));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "fluency");
            fV.p("fps", String.valueOf(dVar.Gj()));
            fV.p("memp", String.valueOf(dVar.Gl()));
            fV.p("cpu", String.valueOf(dVar.Gm()));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void h(d dVar) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "gc");
            fV.p("gc", String.valueOf(dVar.Gk()));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }
}
