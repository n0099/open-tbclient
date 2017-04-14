package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fM.p("ishttp", vVar.aGK ? "1" : "0");
            fM.p("issuccess", vVar.isSuccess ? "1" : "0");
            fM.p("nettype", aa.GG().getNetType());
            fM.p("wt", String.valueOf(vVar.aGF));
            fM.p("qt", String.valueOf(vVar.aGy));
            fM.p("connt", String.valueOf(vVar.aGz));
            fM.p("rwt", String.valueOf(vVar.aGA));
            fM.p("fbt", String.valueOf(vVar.oI));
            fM.p("abt", String.valueOf(vVar.oJ));
            fM.p("dect", String.valueOf(vVar.aGB));
            fM.p("parset", String.valueOf(vVar.aGC));
            fM.p("tqt", String.valueOf(vVar.aGD));
            fM.p("rendert", String.valueOf(vVar.aGE));
            fM.p("ss", String.valueOf(vVar.aGI));
            fM.p("hs", String.valueOf(vVar.aGJ));
            if (vVar.aGK && vVar.socketErrNo != 0) {
                fM.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fM.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aGK) {
                fM.p("hrtn", String.valueOf(vVar.aGL));
                fM.p("hrtt", String.valueOf(vVar.aGM));
            }
            if (vVar.errCode != 0) {
                fM.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGN) {
                fM.p("pt", "1");
            } else {
                fM.p("sysct", String.valueOf(vVar.aGw));
                fM.p("ct", String.valueOf(vVar.aGx));
            }
            if (vVar.aGK) {
                fM.p("c_logid", String.valueOf(vVar.aGO));
                if (vVar.sequenceID != 0) {
                    fM.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                fM.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    public void b(v vVar) {
        if (aa.GG().GH() && vVar.aGG > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "readCache");
            fM.p("rct", String.valueOf(vVar.aGG));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    public void c(v vVar) {
        if (aa.GG().GH() && vVar.aGH > 0) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "writeCache");
            fM.p("wct", String.valueOf(vVar.aGH));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "resource");
            fM.p("actype", str);
            fM.p("issuccess", uVar.isSuccess ? "1" : "0");
            fM.p("isfs", uVar.aGv ? "1" : "0");
            fM.p("ct", String.valueOf(uVar.He));
            fM.p("from", String.valueOf(uVar.Hd));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "fluency");
            fM.p("fps", String.valueOf(eVar.Gq()));
            fM.p("memp", String.valueOf(eVar.Gs()));
            fM.p("cpu", String.valueOf(eVar.Gt()));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }

    public void h(e eVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fM = fM();
            fM.p("action", "gc");
            fM.p("gc", String.valueOf(eVar.Gr()));
            BdStatisticsManager.getInstance().performance(this.subType, fM);
        }
    }
}
