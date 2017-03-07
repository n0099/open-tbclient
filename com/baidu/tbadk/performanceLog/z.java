package com.baidu.tbadk.performanceLog;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class z {
    public String subType = null;

    public static com.baidu.adp.lib.stats.c fH() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
