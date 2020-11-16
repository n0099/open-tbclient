package com.baidu.tbadk.n;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.mobstat.Config;
import java.util.Map;
/* loaded from: classes.dex */
public class o extends l {
    public void a(i iVar) {
        if (m.bBK().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("ishttp", iVar.fuE ? "1" : "0");
            mT.append("issuccess", iVar.isSuccess ? "1" : "0");
            mT.append("nettype", m.bBK().getNetType());
            mT.append("wt", String.valueOf(iVar.fuB));
            mT.append("qt", String.valueOf(iVar.fut));
            mT.append("connt", String.valueOf(iVar.fuu));
            mT.append("rwt", String.valueOf(iVar.fuv));
            mT.append("fbt", String.valueOf(iVar.firstByteReachTime));
            mT.append("abt", String.valueOf(iVar.allDataReadTime));
            mT.append("dect", String.valueOf(iVar.fuw));
            mT.append("parset", String.valueOf(iVar.fux));
            mT.append("tqt", String.valueOf(iVar.fuz));
            mT.append("rendert", String.valueOf(iVar.fuA));
            mT.append("ss", String.valueOf(iVar.fuC));
            mT.append("hs", String.valueOf(iVar.fuD));
            if (iVar.fuE && iVar.socketErrNo != 0) {
                mT.append("salno", String.valueOf(iVar.socketErrNo));
                if (iVar.socketCostTime != 0) {
                    mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                }
            }
            if (iVar.fuE) {
                mT.append("hrtn", String.valueOf(iVar.fuF));
                mT.append("hrtt", String.valueOf(iVar.fuG));
            }
            if (iVar.errCode != 0) {
                mT.append("errcode", Integer.valueOf(iVar.errCode));
            }
            if (iVar.fuH) {
                mT.append("pt", "1");
            } else {
                mT.append("sysct", String.valueOf(iVar.fuq));
                mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(iVar.fus));
                mT.append("lt", String.valueOf(iVar.fur));
                mT.append("df", String.valueOf(iVar.fuy));
            }
            if (iVar.fuE) {
                mT.append(BdStatsConstant.StatsKey.LOGID, String.valueOf(iVar.fuI));
                if (iVar.sequenceID != 0) {
                    mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
                }
            } else {
                mT.append(BdStatsConstant.StatsKey.SEQUENCEID, String.valueOf(iVar.sequenceID & 4294967295L));
            }
            if (iVar.extra != null && !iVar.extra.isEmpty()) {
                for (Map.Entry<String, String> entry : iVar.extra.entrySet()) {
                    mT.append(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(h hVar, String str) {
        if (hVar != null && str != null && m.bBK().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "resource");
            mT.append("actype", str);
            mT.append("issuccess", hVar.isSuccess ? "1" : "0");
            mT.append("isfs", hVar.fup ? "1" : "0");
            mT.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hVar.costTime));
            mT.append("from", String.valueOf(hVar.resourceFromType));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }

    public void a(b bVar) {
        if (bVar != null && m.bBK().isSmallFlow()) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "fluency");
            mT.append("fps", String.valueOf(bVar.getFps()));
            BdStatisticsManager.getInstance().performance(this.subType, mT);
            com.baidu.adp.lib.stats.a mT2 = mT();
            mT2.append("action", "mem");
            mT2.append("memp", String.valueOf(m.bBK().bBL()));
            BdStatisticsManager.getInstance().performance(this.subType, mT2);
        }
    }

    public void a(i iVar, boolean z) {
        if (m.bBK().isSmallFlow()) {
            if (!z || iVar.fuJ > 0) {
                if (z || iVar.fuK > 0) {
                    com.baidu.adp.lib.stats.a mT = mT();
                    mT.append("action", "time");
                    if (z) {
                        mT.append("put", String.valueOf(iVar.fuJ));
                    } else {
                        mT.append("pdt", String.valueOf(iVar.fuK));
                    }
                    mT.append("ishttp", iVar.fuE ? "1" : "0");
                    mT.append("issuccess", iVar.isSuccess ? "1" : "0");
                    mT.append("nettype", m.bBK().getNetType());
                    mT.append("qt", String.valueOf(iVar.fut));
                    mT.append("connt", String.valueOf(iVar.fuu));
                    mT.append("rwt", String.valueOf(iVar.fuv));
                    mT.append("dect", String.valueOf(iVar.fuw));
                    mT.append("parset", String.valueOf(iVar.fux));
                    mT.append("rendert", String.valueOf(iVar.fuA));
                    mT.append("ss", String.valueOf(iVar.fuC));
                    mT.append("hs", String.valueOf(iVar.fuD));
                    if (iVar.fuE && iVar.socketErrNo != 0) {
                        mT.append("salno", String.valueOf(iVar.socketErrNo));
                        if (iVar.socketCostTime != 0) {
                            mT.append("scosttime", String.valueOf(iVar.socketCostTime));
                        }
                    }
                    if (iVar.errCode != 0) {
                        mT.append("errcode", Integer.valueOf(iVar.errCode));
                    }
                    BdStatisticsManager.getInstance().performance(this.subType, mT);
                }
            }
        }
    }

    public void a(i iVar, int i) {
        if (m.bBK().isSmallFlow() && iVar.fuL > 0) {
            com.baidu.adp.lib.stats.a mT = mT();
            mT.append("action", "time");
            mT.append("pct", String.valueOf(iVar.fuL));
            switch (i) {
                case 0:
                    mT.append("pct_type", String.valueOf(100));
                    break;
                case 40:
                    mT.append("pct_type", String.valueOf(101));
                    break;
                default:
                    return;
            }
            BdStatisticsManager.getInstance().performance(this.subType, mT);
        }
    }
}
