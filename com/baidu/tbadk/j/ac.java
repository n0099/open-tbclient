package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fN.p("ishttp", vVar.aGQ ? "1" : "0");
            fN.p("issuccess", vVar.isSuccess ? "1" : "0");
            fN.p("nettype", aa.FK().getNetType());
            fN.p("wt", String.valueOf(vVar.aGL));
            fN.p("qt", String.valueOf(vVar.aGE));
            fN.p("connt", String.valueOf(vVar.aGF));
            fN.p("rwt", String.valueOf(vVar.aGG));
            fN.p("fbt", String.valueOf(vVar.oJ));
            fN.p("abt", String.valueOf(vVar.oK));
            fN.p("dect", String.valueOf(vVar.aGH));
            fN.p("parset", String.valueOf(vVar.aGI));
            fN.p("tqt", String.valueOf(vVar.aGJ));
            fN.p("rendert", String.valueOf(vVar.aGK));
            fN.p("ss", String.valueOf(vVar.aGO));
            fN.p("hs", String.valueOf(vVar.aGP));
            if (vVar.aGQ && vVar.socketErrNo != 0) {
                fN.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fN.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aGQ) {
                fN.p("hrtn", String.valueOf(vVar.aGR));
                fN.p("hrtt", String.valueOf(vVar.aGS));
            }
            if (vVar.errCode != 0) {
                fN.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGT) {
                fN.p("pt", "1");
            } else {
                fN.p("sysct", String.valueOf(vVar.aGC));
                fN.p("ct", String.valueOf(vVar.aGD));
            }
            if (vVar.aGQ) {
                fN.p("c_logid", String.valueOf(vVar.aGU));
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
        if (aa.FK().FL() && vVar.aGM > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "readCache");
            fN.p("rct", String.valueOf(vVar.aGM));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void c(v vVar) {
        if (aa.FK().FL() && vVar.aGN > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "writeCache");
            fN.p("wct", String.valueOf(vVar.aGN));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "resource");
            fN.p("actype", str);
            fN.p("issuccess", uVar.isSuccess ? "1" : "0");
            fN.p("isfs", uVar.aGB ? "1" : "0");
            fN.p("ct", String.valueOf(uVar.Hg));
            fN.p("from", String.valueOf(uVar.Hf));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "fluency");
            fN.p("fps", String.valueOf(eVar.Fu()));
            fN.p("memp", String.valueOf(eVar.Fw()));
            fN.p("cpu", String.valueOf(eVar.Fx()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void h(e eVar) {
        if (aa.FK().FL()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "gc");
            fN.p("gc", String.valueOf(eVar.Fv()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }
}
