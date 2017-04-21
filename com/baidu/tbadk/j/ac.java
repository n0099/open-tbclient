package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fN.p("ishttp", vVar.aGM ? "1" : "0");
            fN.p("issuccess", vVar.isSuccess ? "1" : "0");
            fN.p("nettype", aa.GG().getNetType());
            fN.p("wt", String.valueOf(vVar.aGH));
            fN.p("qt", String.valueOf(vVar.aGA));
            fN.p("connt", String.valueOf(vVar.aGB));
            fN.p("rwt", String.valueOf(vVar.aGC));
            fN.p("fbt", String.valueOf(vVar.oI));
            fN.p("abt", String.valueOf(vVar.oJ));
            fN.p("dect", String.valueOf(vVar.aGD));
            fN.p("parset", String.valueOf(vVar.aGE));
            fN.p("tqt", String.valueOf(vVar.aGF));
            fN.p("rendert", String.valueOf(vVar.aGG));
            fN.p("ss", String.valueOf(vVar.aGK));
            fN.p("hs", String.valueOf(vVar.aGL));
            if (vVar.aGM && vVar.socketErrNo != 0) {
                fN.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fN.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aGM) {
                fN.p("hrtn", String.valueOf(vVar.aGN));
                fN.p("hrtt", String.valueOf(vVar.aGO));
            }
            if (vVar.errCode != 0) {
                fN.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGP) {
                fN.p("pt", "1");
            } else {
                fN.p("sysct", String.valueOf(vVar.aGy));
                fN.p("ct", String.valueOf(vVar.aGz));
            }
            if (vVar.aGM) {
                fN.p("c_logid", String.valueOf(vVar.aGQ));
                if (vVar.sequenceID != 0) {
                    fN.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                fN.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void b(v vVar) {
        if (aa.GG().GH() && vVar.aGI > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "readCache");
            fN.p("rct", String.valueOf(vVar.aGI));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void c(v vVar) {
        if (aa.GG().GH() && vVar.aGJ > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "writeCache");
            fN.p("wct", String.valueOf(vVar.aGJ));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "resource");
            fN.p("actype", str);
            fN.p("issuccess", uVar.isSuccess ? "1" : "0");
            fN.p("isfs", uVar.aGx ? "1" : "0");
            fN.p("ct", String.valueOf(uVar.Hg));
            fN.p("from", String.valueOf(uVar.Hf));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "fluency");
            fN.p("fps", String.valueOf(eVar.Gq()));
            fN.p("memp", String.valueOf(eVar.Gs()));
            fN.p("cpu", String.valueOf(eVar.Gt()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void h(e eVar) {
        if (aa.GG().GH()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "gc");
            fN.p("gc", String.valueOf(eVar.Gr()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }
}
