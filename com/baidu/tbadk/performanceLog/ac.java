package com.baidu.tbadk.performanceLog;

import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class ac extends z {
    public void a(v vVar) {
        if (aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            hs.r("ishttp", vVar.aBH ? "1" : "0");
            hs.r("issuccess", vVar.isSuccess ? "1" : "0");
            hs.r("nettype", aa.GU().getNetType());
            hs.r("wt", String.valueOf(vVar.aBC));
            hs.r("qt", String.valueOf(vVar.aBv));
            hs.r("connt", String.valueOf(vVar.aBw));
            hs.r("rwt", String.valueOf(vVar.aBx));
            hs.r("fbt", String.valueOf(vVar.oL));
            hs.r("abt", String.valueOf(vVar.oM));
            hs.r("dect", String.valueOf(vVar.aBy));
            hs.r("parset", String.valueOf(vVar.aBz));
            hs.r("tqt", String.valueOf(vVar.aBA));
            hs.r("rendert", String.valueOf(vVar.aBB));
            hs.r("ss", String.valueOf(vVar.aBF));
            hs.r("hs", String.valueOf(vVar.aBG));
            if (vVar.aBH && vVar.socketErrNo != 0) {
                hs.r("salno", String.valueOf(vVar.socketErrNo));
                if (vVar.socketCostTime != 0) {
                    hs.r("scosttime", String.valueOf(vVar.socketCostTime));
                }
            }
            if (vVar.aBH) {
                hs.r("hrtn", String.valueOf(vVar.aBI));
                hs.r("hrtt", String.valueOf(vVar.aBJ));
            }
            if (vVar.errCode != 0) {
                hs.b("errcode", Integer.valueOf(vVar.errCode));
            }
            if (vVar.aBK) {
                hs.r("pt", "1");
            } else {
                hs.r("sysct", String.valueOf(vVar.aBt));
                hs.r("ct", String.valueOf(vVar.aBu));
            }
            if (vVar.aBH) {
                hs.r("c_logid", String.valueOf(vVar.aBL));
            } else {
                hs.r("seq_id", String.valueOf(vVar.sequenceID & 4294967295L));
            }
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }

    public void b(v vVar) {
        if (aa.GU().GV() && vVar.aBD > 0) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "readCache");
            hs.r("rct", String.valueOf(vVar.aBD));
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }

    public void c(v vVar) {
        if (aa.GU().GV() && vVar.aBE > 0) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "writeCache");
            hs.r("wct", String.valueOf(vVar.aBE));
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }

    public void a(u uVar, String str) {
        if (uVar != null && str != null && aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "resource");
            hs.r("actype", str);
            hs.r("issuccess", uVar.isSuccess ? "1" : "0");
            hs.r("isfs", uVar.aBs ? "1" : "0");
            hs.r("ct", String.valueOf(uVar.Hs));
            hs.r("from", String.valueOf(uVar.Hr));
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }

    public void g(e eVar) {
        if (eVar != null && aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "fluency");
            hs.r("fps", String.valueOf(eVar.GE()));
            hs.r("memp", String.valueOf(eVar.GG()));
            hs.r("cpu", String.valueOf(eVar.GH()));
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }

    public void h(e eVar) {
        if (aa.GU().GV()) {
            com.baidu.adp.lib.stats.d hs = hs();
            hs.r("action", "gc");
            hs.r("gc", String.valueOf(eVar.GF()));
            com.baidu.adp.lib.stats.a.hz().a(this.subType, hs);
        }
    }
}
