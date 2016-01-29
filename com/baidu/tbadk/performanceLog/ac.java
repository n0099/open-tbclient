package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.FY().FZ()) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hm.r("ishttp", vVar.aAQ ? "1" : "0");
            hm.r("issuccess", vVar.isSuccess ? "1" : "0");
            hm.r("nettype", aa.FY().getNetType());
            hm.r("ct", String.valueOf(vVar.aAE));
            hm.r("wt", String.valueOf(vVar.aAL));
            hm.r("qt", String.valueOf(vVar.aAF));
            hm.r("connt", String.valueOf(vVar.aAG));
            hm.r("rwt", String.valueOf(vVar.aAH));
            hm.r("dect", String.valueOf(vVar.aAI));
            hm.r("parset", String.valueOf(vVar.aAJ));
            hm.r("rendert", String.valueOf(vVar.aAK));
            hm.r("ss", String.valueOf(vVar.aAO));
            hm.r("hs", String.valueOf(vVar.aAP));
            if (vVar.aAQ && vVar.socketErrNo != 0) {
                hm.r("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    hm.r("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.errCode != 0) {
                hm.b("errcode", Integer.valueOf(vVar.errCode));
            }
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void b(v vVar) {
        if (aa.FY().FZ() && vVar.aAL > 0) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "white");
            hm.r("ct", String.valueOf(vVar.aAE));
            hm.r("wt", String.valueOf(vVar.aAL));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void c(v vVar) {
        if (aa.FY().FZ() && vVar.aAM > 0) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "readCache");
            hm.r("rct", String.valueOf(vVar.aAM));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void d(v vVar) {
        if (aa.FY().FZ() && vVar.aAN > 0) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "writeCache");
            hm.r("wct", String.valueOf(vVar.aAN));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.FY().FZ()) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "resource");
            hm.r("actype", str);
            hm.r("issuccess", uVar.isSuccess ? "1" : "0");
            hm.r("isfs", uVar.aAD ? "1" : "0");
            hm.r("ct", String.valueOf(uVar.Hm));
            hm.r("from", String.valueOf(uVar.Hl));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.FY().FZ()) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "fluency");
            hm.r("fps", String.valueOf(eVar.FI()));
            hm.r("memp", String.valueOf(eVar.FK()));
            hm.r("cpu", String.valueOf(eVar.getCpuString()));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }

    public void h(e eVar) {
        if (aa.FY().FZ()) {
            com.baidu.adp.lib.stats.d hm = hm();
            hm.r("action", "gc");
            hm.r("gc", String.valueOf(eVar.FJ()));
            com.baidu.adp.lib.stats.a.ht().a(this.subType, hm);
        }
    }
}
