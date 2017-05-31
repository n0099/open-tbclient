package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.FE().FF()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fN.p("ishttp", vVar.aGD ? "1" : "0");
            fN.p("issuccess", vVar.isSuccess ? "1" : "0");
            fN.p("nettype", aa.FE().getNetType());
            fN.p("wt", String.valueOf(vVar.aGy));
            fN.p("qt", String.valueOf(vVar.aGr));
            fN.p("connt", String.valueOf(vVar.aGs));
            fN.p("rwt", String.valueOf(vVar.aGt));
            fN.p("fbt", String.valueOf(vVar.oJ));
            fN.p("abt", String.valueOf(vVar.oK));
            fN.p("dect", String.valueOf(vVar.aGu));
            fN.p("parset", String.valueOf(vVar.aGv));
            fN.p("tqt", String.valueOf(vVar.aGw));
            fN.p("rendert", String.valueOf(vVar.aGx));
            fN.p("ss", String.valueOf(vVar.aGB));
            fN.p("hs", String.valueOf(vVar.aGC));
            if (vVar.aGD && vVar.socketErrNo != 0) {
                fN.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fN.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aGD) {
                fN.p("hrtn", String.valueOf(vVar.aGE));
                fN.p("hrtt", String.valueOf(vVar.aGF));
            }
            if (vVar.errCode != 0) {
                fN.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGG) {
                fN.p("pt", "1");
            } else {
                fN.p("sysct", String.valueOf(vVar.aGp));
                fN.p("ct", String.valueOf(vVar.aGq));
            }
            if (vVar.aGD) {
                fN.p("c_logid", String.valueOf(vVar.aGH));
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
        if (aa.FE().FF() && vVar.aGz > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "readCache");
            fN.p("rct", String.valueOf(vVar.aGz));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void c(v vVar) {
        if (aa.FE().FF() && vVar.aGA > 0) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "writeCache");
            fN.p("wct", String.valueOf(vVar.aGA));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FE().FF()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "resource");
            fN.p("actype", str);
            fN.p("issuccess", uVar.isSuccess ? "1" : "0");
            fN.p("isfs", uVar.aGo ? "1" : "0");
            fN.p("ct", String.valueOf(uVar.Hg));
            fN.p("from", String.valueOf(uVar.Hf));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.FE().FF()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "fluency");
            fN.p("fps", String.valueOf(eVar.Fo()));
            fN.p("memp", String.valueOf(eVar.Fq()));
            fN.p("cpu", String.valueOf(eVar.Fr()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }

    public void h(e eVar) {
        if (aa.FE().FF()) {
            com.baidu.adp.lib.stats.c fN = fN();
            fN.p("action", "gc");
            fN.p("gc", String.valueOf(eVar.Fp()));
            BdStatisticsManager.getInstance().performance(this.subType, fN);
        }
    }
}
