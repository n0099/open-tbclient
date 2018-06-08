package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a ih() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
