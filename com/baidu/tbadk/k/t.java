package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
/* loaded from: classes.dex */
public class t extends q {
    public void a(m mVar) {
        if (r.NO().NP()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            nm.append("ishttp", mVar.byC ? "1" : "0");
            nm.append("issuccess", mVar.isSuccess ? "1" : "0");
            nm.append("nettype", r.NO().getNetType());
            nm.append("wt", String.valueOf(mVar.byx));
            nm.append("qt", String.valueOf(mVar.byq));
            nm.append("connt", String.valueOf(mVar.byr));
            nm.append("rwt", String.valueOf(mVar.bys));
            nm.append("fbt", String.valueOf(mVar.acN));
            nm.append("abt", String.valueOf(mVar.acO));
            nm.append("dect", String.valueOf(mVar.byt));
            nm.append("parset", String.valueOf(mVar.byu));
            nm.append("tqt", String.valueOf(mVar.byv));
            nm.append("rendert", String.valueOf(mVar.byw));
            nm.append("ss", String.valueOf(mVar.byA));
            nm.append("hs", String.valueOf(mVar.byB));
            if (mVar.byC && mVar.socketErrNo != 0) {
                nm.append("salno", String.valueOf(mVar.socketErrNo));
                if (mVar.socketCostTime != 0) {
                    nm.append("scosttime", String.valueOf(mVar.socketCostTime));
                }
            }
            if (mVar.byC) {
                nm.append("hrtn", String.valueOf(mVar.byD));
                nm.append("hrtt", String.valueOf(mVar.byE));
            }
            if (mVar.errCode != 0) {
                nm.h("errcode", Integer.valueOf(mVar.errCode));
            }
            if (mVar.byF) {
                nm.append("pt", "1");
            } else {
                nm.append("sysct", String.valueOf(mVar.byo));
                nm.append("ct", String.valueOf(mVar.byp));
            }
            if (mVar.byC) {
                nm.append("c_logid", String.valueOf(mVar.byG));
                if (mVar.sequenceID != 0) {
                    nm.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
                }
            } else {
                nm.append("seq_id", String.valueOf(mVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void b(m mVar) {
        if (r.NO().NP() && mVar.byy > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "readCache");
            nm.append("rct", String.valueOf(mVar.byy));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void c(m mVar) {
        if (r.NO().NP() && mVar.byz > 0) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "writeCache");
            nm.append("wct", String.valueOf(mVar.byz));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void a(l lVar, String str) {
        if (lVar != null && str != null && r.NO().NP()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "resource");
            nm.append("actype", str);
            nm.append("issuccess", lVar.isSuccess ? "1" : "0");
            nm.append("isfs", lVar.byn ? "1" : "0");
            nm.append("ct", String.valueOf(lVar.aup));
            nm.append("from", String.valueOf(lVar.auo));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void g(d dVar) {
        if (dVar != null && r.NO().NP()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "fluency");
            nm.append("fps", String.valueOf(dVar.Ny()));
            nm.append("memp", String.valueOf(dVar.NA()));
            nm.append("cpu", String.valueOf(dVar.NB()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }

    public void h(d dVar) {
        if (r.NO().NP()) {
            com.baidu.adp.lib.stats.a nm = nm();
            nm.append("action", "gc");
            nm.append("gc", String.valueOf(dVar.Nz()));
            BdStatisticsManager.getInstance().performance(this.subType, nm);
        }
    }
}
