package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aJf ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.FW().getNetType());
            fK.p("wt", String.valueOf(mVar.aJa));
            fK.p("qt", String.valueOf(mVar.aIT));
            fK.p("connt", String.valueOf(mVar.aIU));
            fK.p("rwt", String.valueOf(mVar.aIV));
            fK.p("fbt", String.valueOf(mVar.od));
            fK.p("abt", String.valueOf(mVar.oe));
            fK.p("dect", String.valueOf(mVar.aIW));
            fK.p("parset", String.valueOf(mVar.aIX));
            fK.p("tqt", String.valueOf(mVar.aIY));
            fK.p("rendert", String.valueOf(mVar.aIZ));
            fK.p("ss", String.valueOf(mVar.aJd));
            fK.p("hs", String.valueOf(mVar.aJe));
            if (mVar.aJf && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aJf) {
                fK.p("hrtn", String.valueOf(mVar.aJg));
                fK.p("hrtt", String.valueOf(mVar.aJh));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJi) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aIR));
                fK.p("ct", String.valueOf(mVar.aIS));
            }
            if (mVar.aJf) {
                fK.p("c_logid", String.valueOf(mVar.aJj));
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
        if (r.FW().FX() && mVar.aJb > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aJb));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.FW().FX() && mVar.aJc > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aJc));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aIQ ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.GC));
            fK.p("from", String.valueOf(lVar.GB));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.FG()));
            fK.p("memp", String.valueOf(dVar.FI()));
            fK.p("cpu", String.valueOf(dVar.FJ()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.FW().FX()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.FH()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
