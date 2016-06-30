package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            dH.q("ishttp", vVar.ayA ? "1" : "0");
            dH.q("issuccess", vVar.isSuccess ? "1" : "0");
            dH.q("nettype", aa.EW().getNetType());
            dH.q("wt", String.valueOf(vVar.ayv));
            dH.q("qt", String.valueOf(vVar.ayo));
            dH.q("connt", String.valueOf(vVar.ayp));
            dH.q("rwt", String.valueOf(vVar.ayq));
            dH.q("fbt", String.valueOf(vVar.eC));
            dH.q("abt", String.valueOf(vVar.eD));
            dH.q("dect", String.valueOf(vVar.ayr));
            dH.q("parset", String.valueOf(vVar.ays));
            dH.q("tqt", String.valueOf(vVar.ayt));
            dH.q("rendert", String.valueOf(vVar.ayu));
            dH.q("ss", String.valueOf(vVar.ayy));
            dH.q("hs", String.valueOf(vVar.ayz));
            if (vVar.ayA && vVar.socketErrNo != 0) {
                dH.q("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    dH.q("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.ayA) {
                dH.q("hrtn", String.valueOf(vVar.ayB));
                dH.q("hrtt", String.valueOf(vVar.ayC));
            }
            if (vVar.errCode != 0) {
                dH.b("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.ayD) {
                dH.q("pt", "1");
            } else {
                dH.q("sysct", String.valueOf(vVar.aym));
                dH.q("ct", String.valueOf(vVar.ayn));
            }
            if (vVar.ayA) {
                dH.q("c_logid", String.valueOf(vVar.ayE));
                if (vVar.sequenceID != 0) {
                    dH.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
                }
            } else {
                dH.q("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    public void b(v vVar) {
        if (aa.EW().EX() && vVar.ayw > 0) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "readCache");
            dH.q("rct", String.valueOf(vVar.ayw));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    public void c(v vVar) {
        if (aa.EW().EX() && vVar.ayx > 0) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "writeCache");
            dH.q("wct", String.valueOf(vVar.ayx));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "resource");
            dH.q("actype", str);
            dH.q("issuccess", uVar.isSuccess ? "1" : "0");
            dH.q("isfs", uVar.ayl ? "1" : "0");
            dH.q("ct", String.valueOf(uVar.xM));
            dH.q("from", String.valueOf(uVar.xL));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "fluency");
            dH.q("fps", String.valueOf(eVar.EG()));
            dH.q("memp", String.valueOf(eVar.EI()));
            dH.q("cpu", String.valueOf(eVar.EJ()));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }

    public void h(e eVar) {
        if (aa.EW().EX()) {
            com.baidu.adp.lib.stats.d dH = dH();
            dH.q("action", "gc");
            dH.q("gc", String.valueOf(eVar.EH()));
            com.baidu.adp.lib.stats.a.dO().a(this.subType, dH);
        }
    }
}
