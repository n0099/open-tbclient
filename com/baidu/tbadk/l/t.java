package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fK.p("ishttp", mVar.aIZ ? "1" : "0");
            fK.p("issuccess", mVar.isSuccess ? "1" : "0");
            fK.p("nettype", r.Gr().getNetType());
            fK.p("wt", String.valueOf(mVar.aIU));
            fK.p("qt", String.valueOf(mVar.aIN));
            fK.p("connt", String.valueOf(mVar.aIO));
            fK.p("rwt", String.valueOf(mVar.aIP));
            fK.p("fbt", String.valueOf(mVar.oJ));
            fK.p("abt", String.valueOf(mVar.oK));
            fK.p("dect", String.valueOf(mVar.aIQ));
            fK.p("parset", String.valueOf(mVar.aIR));
            fK.p("tqt", String.valueOf(mVar.aIS));
            fK.p("rendert", String.valueOf(mVar.aIT));
            fK.p("ss", String.valueOf(mVar.aIX));
            fK.p("hs", String.valueOf(mVar.aIY));
            if (mVar.aIZ && mVar.socketErrNo != 0) {
                fK.p("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    fK.p("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.aIZ) {
                fK.p("hrtn", String.valueOf(mVar.aJa));
                fK.p("hrtt", String.valueOf(mVar.aJb));
            }
            if (mVar.errCode != 0) {
                fK.d("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.aJc) {
                fK.p("pt", "1");
            } else {
                fK.p("sysct", String.valueOf(mVar.aIL));
                fK.p("ct", String.valueOf(mVar.aIM));
            }
            if (mVar.aIZ) {
                fK.p("c_logid", String.valueOf(mVar.aJd));
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
        if (r.Gr().Gs() && mVar.aIV > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "readCache");
            fK.p("rct", String.valueOf(mVar.aIV));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void c(m mVar) {
        if (r.Gr().Gs() && mVar.aIW > 0) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "writeCache");
            fK.p("wct", String.valueOf(mVar.aIW));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "resource");
            fK.p("actype", str);
            fK.p("issuccess", lVar.isSuccess ? "1" : "0");
            fK.p("isfs", lVar.aIK ? "1" : "0");
            fK.p("ct", String.valueOf(lVar.Hf));
            fK.p("from", String.valueOf(lVar.He));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "fluency");
            fK.p("fps", String.valueOf(dVar.Gb()));
            fK.p("memp", String.valueOf(dVar.Gd()));
            fK.p("cpu", String.valueOf(dVar.Ge()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }

    public void h(d dVar) {
        if (r.Gr().Gs()) {
            com.baidu.adp.lib.stats.a fK = fK();
            fK.p("action", "gc");
            fK.p("gc", String.valueOf(dVar.Gc()));
            BdStatisticsManager.getInstance().performance(this.subType, fK);
        }
    }
}
