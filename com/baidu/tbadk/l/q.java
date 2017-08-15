package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class q {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a fV() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
