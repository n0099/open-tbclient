package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.tencent.tauth.AuthActivity;
/* loaded from: classes.dex */
public class r extends o {
    public void a(l lVar) {
        if (p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, CreateGroupActivityActivityConfig.GROUP_ACTIVITY_TIME);
            nn.append("ishttp", lVar.bAP ? "1" : "0");
            nn.append("issuccess", lVar.isSuccess ? "1" : "0");
            nn.append("nettype", p.Ow().getNetType());
            nn.append("wt", String.valueOf(lVar.bAK));
            nn.append("qt", String.valueOf(lVar.bAD));
            nn.append("connt", String.valueOf(lVar.bAE));
            nn.append("rwt", String.valueOf(lVar.bAF));
            nn.append("fbt", String.valueOf(lVar.acL));
            nn.append("abt", String.valueOf(lVar.acM));
            nn.append("dect", String.valueOf(lVar.bAG));
            nn.append("parset", String.valueOf(lVar.bAH));
            nn.append("tqt", String.valueOf(lVar.bAI));
            nn.append("rendert", String.valueOf(lVar.bAJ));
            nn.append("ss", String.valueOf(lVar.bAN));
            nn.append("hs", String.valueOf(lVar.bAO));
            if (lVar.bAP && lVar.socketErrNo != 0) {
                nn.append("salno", String.valueOf(lVar.socketErrNo));
                if (lVar.socketCostTime != 0) {
                    nn.append("scosttime", String.valueOf(lVar.socketCostTime));
                }
            }
            if (lVar.bAP) {
                nn.append("hrtn", String.valueOf(lVar.bAQ));
                nn.append("hrtt", String.valueOf(lVar.bAR));
            }
            if (lVar.errCode != 0) {
                nn.h("errcode", Integer.valueOf(lVar.errCode));
            }
            if (lVar.bAS) {
                nn.append("pt", "1");
            } else {
                nn.append("sysct", String.valueOf(lVar.bAB));
                nn.append("ct", String.valueOf(lVar.bAC));
            }
            if (lVar.bAP) {
                nn.append("c_logid", String.valueOf(lVar.bAT));
                if (lVar.sequenceID != 0) {
                    nn.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
                }
            } else {
                nn.append("seq_id", String.valueOf(lVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void b(l lVar) {
        if (p.Ow().Ox() && lVar.bAL > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "readCache");
            nn.append("rct", String.valueOf(lVar.bAL));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void c(l lVar) {
        if (p.Ow().Ox() && lVar.bAM > 0) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "writeCache");
            nn.append("wct", String.valueOf(lVar.bAM));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void a(k kVar, String str) {
        if (kVar != null && str != null && p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "resource");
            nn.append("actype", str);
            nn.append("issuccess", kVar.isSuccess ? "1" : "0");
            nn.append("isfs", kVar.bAA ? "1" : "0");
            nn.append("ct", String.valueOf(kVar.aun));
            nn.append("from", String.valueOf(kVar.aum));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void g(d dVar) {
        if (dVar != null && p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "fluency");
            nn.append("fps", String.valueOf(dVar.Og()));
            nn.append("memp", String.valueOf(dVar.Oi()));
            nn.append(com.baidu.fsg.biometrics.base.b.c.i, String.valueOf(dVar.Oj()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }

    public void h(d dVar) {
        if (p.Ow().Ox()) {
            com.baidu.adp.lib.stats.a nn = nn();
            nn.append(AuthActivity.ACTION_KEY, "gc");
            nn.append("gc", String.valueOf(dVar.Oh()));
            BdStatisticsManager.getInstance().performance(this.subType, nn);
        }
    }
}
