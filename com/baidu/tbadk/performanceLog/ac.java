package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            dG.q("ishttp", vVar.azq ? "1" : "0");
            dG.q("issuccess", vVar.isSuccess ? "1" : "0");
            dG.q("nettype", aa.EV().getNetType());
            dG.q("wt", String.valueOf(vVar.azl));
            dG.q("qt", String.valueOf(vVar.aze));
            dG.q("connt", String.valueOf(vVar.azf));
            dG.q("rwt", String.valueOf(vVar.azg));
            dG.q("fbt", String.valueOf(vVar.fe));
            dG.q("abt", String.valueOf(vVar.ff));
            dG.q("dect", String.valueOf(vVar.azh));
            dG.q("parset", String.valueOf(vVar.azi));
            dG.q("tqt", String.valueOf(vVar.azj));
            dG.q("rendert", String.valueOf(vVar.azk));
            dG.q("ss", String.valueOf(vVar.azo));
            dG.q("hs", String.valueOf(vVar.azp));
            if (vVar.azq && vVar.socketErrNo != 0) {
                dG.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dG.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.azq) {
                dG.q("hrtn", String.valueOf(vVar.azr));
                dG.q("hrtt", String.valueOf(vVar.azs));
            }
            if (vVar.errCode != 0) {
                dG.d("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.azt) {
                dG.q("pt", "1");
            } else {
                dG.q("sysct", String.valueOf(vVar.azc));
                dG.q("ct", String.valueOf(vVar.azd));
            }
            if (vVar.azq) {
                dG.q("c_logid", String.valueOf(vVar.azu));
                if (vVar.sequenceID != 0) {
                    dG.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                dG.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void b(v vVar) {
        if (aa.EV().EW() && vVar.azm > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "readCache");
            dG.q("rct", String.valueOf(vVar.azm));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void c(v vVar) {
        if (aa.EV().EW() && vVar.azn > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "writeCache");
            dG.q("wct", String.valueOf(vVar.azn));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "resource");
            dG.q("actype", str);
            dG.q("issuccess", uVar.isSuccess ? "1" : "0");
            dG.q("isfs", uVar.azb ? "1" : "0");
            dG.q("ct", String.valueOf(uVar.yn));
            dG.q("from", String.valueOf(uVar.ym));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "fluency");
            dG.q("fps", String.valueOf(eVar.EF()));
            dG.q("memp", String.valueOf(eVar.EH()));
            dG.q("cpu", String.valueOf(eVar.EI()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void h(e eVar) {
        if (aa.EV().EW()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "gc");
            dG.q("gc", String.valueOf(eVar.EG()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }
}
