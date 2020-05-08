package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.aZy().aZz()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "time");
            kW.append("ishttp", iVar.edX ? "1" : "0");
            kW.append("issuccess", iVar.isSuccess ? "1" : "0");
            kW.append("nettype", m.aZy().getNetType());
            kW.append("wt", String.valueOf(iVar.edU));
            kW.append("qt", String.valueOf(iVar.edM));
            kW.append("connt", String.valueOf(iVar.edN));
            kW.append("rwt", String.valueOf(iVar.edO));
            kW.append("fbt", String.valueOf(iVar.firstByteReachTime));
            kW.append("abt", String.valueOf(iVar.allDataReadTime));
            kW.append("dect", String.valueOf(iVar.edP));
            kW.append("parset", String.valueOf(iVar.edQ));
            kW.append("tqt", String.valueOf(iVar.edS));
            kW.append("rendert", String.valueOf(iVar.edT));
            kW.append("ss", String.valueOf(iVar.edV));
            kW.append("hs", String.valueOf(iVar.edW));
            if (iVar.edX && iVar.socketErrNo != 0) {
                kW.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    kW.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.edX) {
                kW.append("hrtn", String.valueOf(iVar.edY));
                kW.append("hrtt", String.valueOf(iVar.edZ));
            }
            if (iVar.errCode != 0) {
                kW.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eea) {
                kW.append("pt", "1");
            } else {
                kW.append("sysct", String.valueOf(iVar.edJ));
                kW.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.edL));
                kW.append("lt", String.valueOf(iVar.edK));
                kW.append("df", String.valueOf(iVar.edR));
            }
            if (iVar.edX) {
                kW.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eeb));
                if (iVar.sequenceID != 0) {
                    kW.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                kW.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.aZy().aZz()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "resource");
            kW.append("actype", str);
            kW.append("issuccess", hVar.isSuccess ? "1" : "0");
            kW.append("isfs", hVar.edI ? "1" : "0");
            kW.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            kW.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.aZy().aZz()) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "fluency");
            kW.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, kW);
            com.baidu.adp.lib.stats.a kW2 = kW();
            kW2.append("action", "mem");
            kW2.append("memp", String.valueOf(m.aZy().aZA()));
            BdStatisticsManager.getInstance().performance(this.subType, kW2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.aZy().aZz()) {
            if (!z || iVar.eec > 0) {
                if (z || iVar.eed > 0) {
                    com.baidu.adp.lib.stats.a kW = kW();
                    kW.append("action", "time");
                    if (z) {
                        kW.append("put", String.valueOf(iVar.eec));
                    } else {
                        kW.append("pdt", String.valueOf(iVar.eed));
                    }
                    kW.append("ishttp", iVar.edX ? "1" : "0");
                    kW.append("issuccess", iVar.isSuccess ? "1" : "0");
                    kW.append("nettype", m.aZy().getNetType());
                    kW.append("qt", String.valueOf(iVar.edM));
                    kW.append("connt", String.valueOf(iVar.edN));
                    kW.append("rwt", String.valueOf(iVar.edO));
                    kW.append("dect", String.valueOf(iVar.edP));
                    kW.append("parset", String.valueOf(iVar.edQ));
                    kW.append("rendert", String.valueOf(iVar.edT));
                    kW.append("ss", String.valueOf(iVar.edV));
                    kW.append("hs", String.valueOf(iVar.edW));
                    if (iVar.edX && iVar.socketErrNo != 0) {
                        kW.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            kW.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        kW.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, kW);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.aZy().aZz() && iVar.eee > 0) {
            com.baidu.adp.lib.stats.a kW = kW();
            kW.append("action", "time");
            kW.append("pct", String.valueOf(iVar.eee));
            switch (i) {
                case 0:
                    kW.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    kW.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, kW);
        }
    }
}
