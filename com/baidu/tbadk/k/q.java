package com.baidu.tbadk.k;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a nm() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
