package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fV.p("ishttp", mVar.aKo ? "1" : "0");
            fV.p("issuccess", mVar.isSuccess ? "1" : "0");
            fV.p("nettype", r.Gz().getNetType());
            fV.p("wt", String.valueOf(mVar.aKj));
            fV.p("qt", String.valueOf(mVar.aKc));
            fV.p("connt", String.valueOf(mVar.aKd));
            fV.p("rwt", String.valueOf(mVar.aKe));
            fV.p("fbt", String.valueOf(mVar.qr));
            fV.p("abt", String.valueOf(mVar.qs));
            fV.p("dect", String.valueOf(mVar.aKf));
            fV.p("parset", String.valueOf(mVar.aKg));
            fV.p("tqt", String.valueOf(mVar.aKh));
            fV.p("rendert", String.valueOf(mVar.aKi));
            fV.p("ss", String.valueOf(mVar.aKm));
            fV.p("hs", String.valueOf(mVar.aKn));
            if (mVar.aKo && mVar.socketErrNo != 0) {
                fV.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fV.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aKo) {
                fV.p("hrtn", String.valueOf(mVar.aKp));
                fV.p("hrtt", String.valueOf(mVar.aKq));
            }
            if (mVar.errCode != 0) {
                fV.d("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aKr) {
                fV.p("pt", "1");
            } else {
                fV.p("sysct", String.valueOf(mVar.aKa));
                fV.p("ct", String.valueOf(mVar.aKb));
            }
            if (mVar.aKo) {
                fV.p("c_logid", String.valueOf(mVar.aKs));
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
        if (r.Gz().GA() && mVar.aKk > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "readCache");
            fV.p("rct", String.valueOf(mVar.aKk));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void c(m mVar) {
        if (r.Gz().GA() && mVar.aKl > 0) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "writeCache");
            fV.p("wct", String.valueOf(mVar.aKl));
            BdStatisticsManager.getInstance().performance(this.subType, fV);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gz().GA()) {
            com.baidu.adp.lib.stats.a fV = fV();
            fV.p("action", "resource");
            fV.p("actype", str);
            fV.p("issuccess", lVar.isSuccess ? "1" : "0");
            fV.p("isfs", lVar.aJZ ? "1" : "0");
            fV.p("ct", String.valueOf(lVar.IF));
            fV.p("from", String.valueOf(lVar.IE));
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
