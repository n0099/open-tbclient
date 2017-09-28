package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gc().Gd()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aJs ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gc().getNetType());
            fK.p("wt", String.valueOf(mVar.aJn));
            fK.p("qt", String.valueOf(mVar.aJg));
            fK.p("connt", String.valueOf(mVar.aJh));
            fK.p("rwt", String.valueOf(mVar.aJi));
            fK.p("fbt", String.valueOf(mVar.oc));
            fK.p("abt", String.valueOf(mVar.od));
            fK.p("dect", String.valueOf(mVar.aJj));
            fK.p("parset", String.valueOf(mVar.aJk));
            fK.p("tqt", String.valueOf(mVar.aJl));
            fK.p("rendert", String.valueOf(mVar.aJm));
            fK.p("ss", String.valueOf(mVar.aJq));
            fK.p("hs", String.valueOf(mVar.aJr));
            if (mVar.aJs && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aJs) {
                fK.p("hrtn", String.valueOf(mVar.aJt));
                fK.p("hrtt", String.valueOf(mVar.aJu));
            }
            if (mVar.errCode != 0) {
                fK.c("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJv) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aJe));
                fK.p("ct", String.valueOf(mVar.aJf));
            }
            if (mVar.aJs) {
                fK.p("c_logid", String.valueOf(mVar.aJw));
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
        if (r.Gc().Gd() && mVar.aJo > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aJo));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.Gc().Gd() && mVar.aJp > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aJp));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gc().Gd()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aJd ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.GB));
            fK.p("from", String.valueOf(lVar.GA));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Gc().Gd()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.FM()));
            fK.p("memp", String.valueOf(dVar.FO()));
            fK.p("cpu", String.valueOf(dVar.FP()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.Gc().Gd()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.FN()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
