package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time");
            iF.append("ishttp", iVar.cBc ? "1" : "0");
            iF.append("issuccess", iVar.isSuccess ? "1" : "0");
            iF.append("nettype", m.avH().getNetType());
            iF.append("wt", String.valueOf(iVar.cAZ));
            iF.append("qt", String.valueOf(iVar.cAS));
            iF.append("connt", String.valueOf(iVar.cAT));
            iF.append("rwt", String.valueOf(iVar.cAU));
            iF.append("fbt", String.valueOf(iVar.ud));
            iF.append("abt", String.valueOf(iVar.ue));
            iF.append("dect", String.valueOf(iVar.cAV));
            iF.append("parset", String.valueOf(iVar.cAW));
            iF.append("tqt", String.valueOf(iVar.cAX));
            iF.append("rendert", String.valueOf(iVar.cAY));
            iF.append("ss", String.valueOf(iVar.cBa));
            iF.append("hs", String.valueOf(iVar.cBb));
            if (iVar.cBc && iVar.socketErrNo != 0) {
                iF.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.cBc) {
                iF.append("hrtn", String.valueOf(iVar.cBd));
                iF.append("hrtt", String.valueOf(iVar.cBe));
            }
            if (iVar.errCode != 0) {
                iF.c("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.cBf) {
                iF.append(Config.PLATFORM_TYPE, "1");
            } else {
                iF.append("sysct", String.valueOf(iVar.cAQ));
                iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.cAR));
            }
            if (iVar.cBc) {
                iF.append("c_logid", String.valueOf(iVar.cBg));
                if (iVar.sequenceID != 0) {
                    iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                iF.append("seq_id", String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "resource");
            iF.append("actype", str);
            iF.append("issuccess", hVar.isSuccess ? "1" : "0");
            iF.append("isfs", hVar.cAP ? "1" : "0");
            iF.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.Me));
            iF.append("from", String.valueOf(hVar.Md));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.avH().avI()) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "fluency");
            iF.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, iF);
            com.baidu.adp.lib.stats.a iF2 = iF();
            iF2.append("action", "mem");
            iF2.append("memp", String.valueOf(m.avH().avJ()));
            BdStatisticsManager.getInstance().performance(this.subType, iF2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.avH().avI()) {
            if (!z || iVar.cBh > 0) {
                if (z || iVar.cBi > 0) {
                    com.baidu.adp.lib.stats.a iF = iF();
                    iF.append("action", "time");
                    if (z) {
                        iF.append("put", String.valueOf(iVar.cBh));
                    } else {
                        iF.append("pdt", String.valueOf(iVar.cBi));
                    }
                    iF.append("ishttp", iVar.cBc ? "1" : "0");
                    iF.append("issuccess", iVar.isSuccess ? "1" : "0");
                    iF.append("nettype", m.avH().getNetType());
                    iF.append("qt", String.valueOf(iVar.cAS));
                    iF.append("connt", String.valueOf(iVar.cAT));
                    iF.append("rwt", String.valueOf(iVar.cAU));
                    iF.append("dect", String.valueOf(iVar.cAV));
                    iF.append("parset", String.valueOf(iVar.cAW));
                    iF.append("rendert", String.valueOf(iVar.cAY));
                    iF.append("ss", String.valueOf(iVar.cBa));
                    iF.append("hs", String.valueOf(iVar.cBb));
                    if (iVar.cBc && iVar.socketErrNo != 0) {
                        iF.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            iF.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        iF.c("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, iF);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.avH().avI() && iVar.cBj > 0) {
            com.baidu.adp.lib.stats.a iF = iF();
            iF.append("action", "time");
            iF.append("pct", String.valueOf(iVar.cBj));
            switch (i) {
                case 0:
                    iF.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    iF.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, iF);
        }
    }
}
