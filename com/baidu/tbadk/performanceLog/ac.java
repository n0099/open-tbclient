package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.EM().EN()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            dG.q("ishttp", vVar.axK ? "1" : "0");
            dG.q("issuccess", vVar.isSuccess ? "1" : "0");
            dG.q("nettype", aa.EM().getNetType());
            dG.q("wt", String.valueOf(vVar.axF));
            dG.q("qt", String.valueOf(vVar.axy));
            dG.q("connt", String.valueOf(vVar.axz));
            dG.q("rwt", String.valueOf(vVar.axA));
            dG.q("fbt", String.valueOf(vVar.eD));
            dG.q("abt", String.valueOf(vVar.eE));
            dG.q("dect", String.valueOf(vVar.axB));
            dG.q("parset", String.valueOf(vVar.axC));
            dG.q("tqt", String.valueOf(vVar.axD));
            dG.q("rendert", String.valueOf(vVar.axE));
            dG.q("ss", String.valueOf(vVar.axI));
            dG.q("hs", String.valueOf(vVar.axJ));
            if (vVar.axK && vVar.socketErrNo != 0) {
                dG.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dG.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.axK) {
                dG.q("hrtn", String.valueOf(vVar.axL));
                dG.q("hrtt", String.valueOf(vVar.axM));
            }
            if (vVar.errCode != 0) {
                dG.b("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.axN) {
                dG.q("pt", "1");
            } else {
                dG.q("sysct", String.valueOf(vVar.axw));
                dG.q("ct", String.valueOf(vVar.axx));
            }
            if (vVar.axK) {
                dG.q("c_logid", String.valueOf(vVar.axO));
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
        if (aa.EM().EN() && vVar.axG > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "readCache");
            dG.q("rct", String.valueOf(vVar.axG));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void c(v vVar) {
        if (aa.EM().EN() && vVar.axH > 0) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "writeCache");
            dG.q("wct", String.valueOf(vVar.axH));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EM().EN()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "resource");
            dG.q("actype", str);
            dG.q("issuccess", uVar.isSuccess ? "1" : "0");
            dG.q("isfs", uVar.axv ? "1" : "0");
            dG.q("ct", String.valueOf(uVar.xK));
            dG.q("from", String.valueOf(uVar.xJ));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.EM().EN()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "fluency");
            dG.q("fps", String.valueOf(eVar.Ew()));
            dG.q("memp", String.valueOf(eVar.Ey()));
            dG.q("cpu", String.valueOf(eVar.Ez()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }

    public void h(e eVar) {
        if (aa.EM().EN()) {
            com.baidu.adp.lib.stats.d dG = dG();
            dG.q("action", "gc");
            dG.q("gc", String.valueOf(eVar.Ex()));
            com.baidu.adp.lib.stats.a.dN().a(this.subType, dG);
        }
    }
}
