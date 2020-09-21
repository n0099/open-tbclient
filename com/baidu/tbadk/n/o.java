package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bvs().bvt()) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "time");
            mS.append("ishttp", iVar.eUR ? "1" : "0");
            mS.append("issuccess", iVar.isSuccess ? "1" : "0");
            mS.append("nettype", m.bvs().getNetType());
            mS.append("wt", String.valueOf(iVar.eUO));
            mS.append("qt", String.valueOf(iVar.bGc));
            mS.append("connt", String.valueOf(iVar.eUH));
            mS.append("rwt", String.valueOf(iVar.eUI));
            mS.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mS.append("abt", String.valueOf(iVar.allDataReadTime));
            mS.append("dect", String.valueOf(iVar.eUJ));
            mS.append("parset", String.valueOf(iVar.eUK));
            mS.append("tqt", String.valueOf(iVar.eUM));
            mS.append("rendert", String.valueOf(iVar.eUN));
            mS.append("ss", String.valueOf(iVar.eUP));
            mS.append("hs", String.valueOf(iVar.eUQ));
            if (iVar.eUR && iVar.socketErrNo != 0) {
                mS.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mS.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.eUR) {
                mS.append("hrtn", String.valueOf(iVar.eUS));
                mS.append("hrtt", String.valueOf(iVar.eUT));
            }
            if (iVar.errCode != 0) {
                mS.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.eUU) {
                mS.append("pt", "1");
            } else {
                mS.append("sysct", String.valueOf(iVar.eUE));
                mS.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.eUG));
                mS.append("lt", String.valueOf(iVar.eUF));
                mS.append("df", String.valueOf(iVar.eUL));
            }
            if (iVar.eUR) {
                mS.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.eUV));
                if (iVar.sequenceID != 0) {
                    mS.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                mS.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            if (iVar.extra != null && !iVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : iVar.extra.entrySet()) {
                    mS.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, mS);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bvs().bvt()) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "resource");
            mS.append("actype", str);
            mS.append("issuccess", hVar.isSuccess ? "1" : "0");
            mS.append("isfs", hVar.eUD ? "1" : "0");
            mS.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mS.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mS);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bvs().bvt()) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "fluency");
            mS.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mS);
            com.baidu.adp.lib.stats.a mS2 = mS();
            mS2.append("action", "mem");
            mS2.append("memp", String.valueOf(m.bvs().bvu()));
            BdStatisticsManager.getInstance().performance(this.subType, mS2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bvs().bvt()) {
            if (!z || iVar.eUW > 0) {
                if (z || iVar.eUX > 0) {
                    com.baidu.adp.lib.stats.a mS = mS();
                    mS.append("action", "time");
                    if (z) {
                        mS.append("put", String.valueOf(iVar.eUW));
                    } else {
                        mS.append("pdt", String.valueOf(iVar.eUX));
                    }
                    mS.append("ishttp", iVar.eUR ? "1" : "0");
                    mS.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mS.append("nettype", m.bvs().getNetType());
                    mS.append("qt", String.valueOf(iVar.bGc));
                    mS.append("connt", String.valueOf(iVar.eUH));
                    mS.append("rwt", String.valueOf(iVar.eUI));
                    mS.append("dect", String.valueOf(iVar.eUJ));
                    mS.append("parset", String.valueOf(iVar.eUK));
                    mS.append("rendert", String.valueOf(iVar.eUN));
                    mS.append("ss", String.valueOf(iVar.eUP));
                    mS.append("hs", String.valueOf(iVar.eUQ));
                    if (iVar.eUR && iVar.socketErrNo != 0) {
                        mS.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            mS.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        mS.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, mS);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.bvs().bvt() && iVar.eUY > 0) {
            com.baidu.adp.lib.stats.a mS = mS();
            mS.append("action", "time");
            mS.append("pct", String.valueOf(iVar.eUY));
            switch (i) {
                case 0:
                    mS.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    mS.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, mS);
        }
    }
}
