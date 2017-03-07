package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            fH.p("ishttp", vVar.aGv ? "1" : "0");
            fH.p("issuccess", vVar.isSuccess ? "1" : "0");
            fH.p("nettype", aa.Gi().getNetType());
            fH.p("wt", String.valueOf(vVar.aGq));
            fH.p("qt", String.valueOf(vVar.aGj));
            fH.p("connt", String.valueOf(vVar.aGk));
            fH.p("rwt", String.valueOf(vVar.aGl));
            fH.p("fbt", String.valueOf(vVar.po));
            fH.p("abt", String.valueOf(vVar.pp));
            fH.p("dect", String.valueOf(vVar.aGm));
            fH.p("parset", String.valueOf(vVar.aGn));
            fH.p("tqt", String.valueOf(vVar.aGo));
            fH.p("rendert", String.valueOf(vVar.aGp));
            fH.p("ss", String.valueOf(vVar.aGt));
            fH.p("hs", String.valueOf(vVar.aGu));
            if (vVar.aGv && vVar.socketErrNo != 0) {
                fH.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fH.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aGv) {
                fH.p("hrtn", String.valueOf(vVar.aGw));
                fH.p("hrtt", String.valueOf(vVar.aGx));
            }
            if (vVar.errCode != 0) {
                fH.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGy) {
                fH.p("pt", "1");
            } else {
                fH.p("sysct", String.valueOf(vVar.aGh));
                fH.p("ct", String.valueOf(vVar.aGi));
            }
            if (vVar.aGv) {
                fH.p("c_logid", String.valueOf(vVar.aGz));
                if (vVar.sequenceID != 0) {
                    fH.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                fH.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    public void b(v vVar) {
        if (aa.Gi().Gj() && vVar.aGr > 0) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "readCache");
            fH.p("rct", String.valueOf(vVar.aGr));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    public void c(v vVar) {
        if (aa.Gi().Gj() && vVar.aGs > 0) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "writeCache");
            fH.p("wct", String.valueOf(vVar.aGs));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "resource");
            fH.p("actype", str);
            fH.p("issuccess", uVar.isSuccess ? "1" : "0");
            fH.p("isfs", uVar.aGg ? "1" : "0");
            fH.p("ct", String.valueOf(uVar.HD));
            fH.p("from", String.valueOf(uVar.HC));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "fluency");
            fH.p("fps", String.valueOf(eVar.FS()));
            fH.p("memp", String.valueOf(eVar.FU()));
            fH.p("cpu", String.valueOf(eVar.FV()));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    public void h(e eVar) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "gc");
            fH.p("gc", String.valueOf(eVar.FT()));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }
}
