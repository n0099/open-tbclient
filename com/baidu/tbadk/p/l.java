package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
/* loaded from: classes.dex */
public class l {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a fU() {
        return BdStatisticsManager.getInstance().getStatsItem(BdStatsConstant.StatsType.PERFORMANCE);
    }
}
