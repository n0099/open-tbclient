package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class o extends ac {
    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(v vVar) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "time_t");
            a(fH, vVar);
            fH.p("ishttp", vVar.aGv ? "1" : "0");
            fH.p("issuccess", vVar.isSuccess ? "1" : "0");
            fH.p("nettype", aa.Gi().getNetType());
            fH.p("ct", String.valueOf(vVar.aGi));
            fH.p("wt", String.valueOf(vVar.aGq));
            fH.p("qt", String.valueOf(vVar.aGj));
            fH.p("connt", String.valueOf(vVar.aGk));
            fH.p("rwt", String.valueOf(vVar.aGl));
            fH.p("dect", String.valueOf(vVar.aGm));
            fH.p("parset", String.valueOf(vVar.aGn));
            fH.p("rendert", String.valueOf(vVar.aGp));
            fH.p("ss", String.valueOf(vVar.aGt));
            fH.p("hs", String.valueOf(vVar.aGu));
            if (vVar.aGv && vVar.socketErrNo != 0) {
                fH.p("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    fH.p("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                fH.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aGv) {
                fH.p("c_logid", String.valueOf(vVar.aGz));
            } else {
                fH.p("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void b(v vVar) {
        if (aa.Gi().Gj() && vVar.aGr > 0) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "readCache_t");
            a(fH, vVar);
            fH.p("rct", String.valueOf(vVar.aGr));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void c(v vVar) {
        if (aa.Gi().Gj() && vVar.aGs > 0) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "writeCache_t");
            a(fH, vVar);
            fH.p("wct", String.valueOf(vVar.aGs));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "resource_t");
            fH.p("actype", str);
            fH.p("issuccess", uVar.isSuccess ? "1" : "0");
            fH.p("isfs", uVar.aGg ? "1" : "0");
            fH.p("ct", String.valueOf(uVar.HD));
            fH.p("from", String.valueOf(uVar.HC));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void g(e eVar) {
        if (eVar != null && aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "fluency_t");
            a(fH, eVar);
            fH.p("fps", String.valueOf(eVar.FS()));
            fH.p("memp", String.valueOf(eVar.FU()));
            fH.p("cpu", String.valueOf(eVar.FV()));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    @Override // com.baidu.tbadk.performanceLog.ac
    public void h(e eVar) {
        if (aa.Gi().Gj()) {
            com.baidu.adp.lib.stats.c fH = fH();
            fH.p("action", "gc_t");
            a(fH, eVar);
            fH.p("gc", String.valueOf(eVar.FT()));
            BdStatisticsManager.getInstance().performance(this.subType, fH);
        }
    }

    private void a(com.baidu.adp.lib.stats.c cVar, e eVar) {
        if (eVar instanceof m) {
            cVar.d("ptype", Integer.valueOf(((m) eVar).pageType));
        }
    }

    private void a(com.baidu.adp.lib.stats.c cVar, v vVar) {
        if (vVar instanceof n) {
            cVar.d("ptype", Integer.valueOf(((n) vVar).pageType));
        }
    }
}
