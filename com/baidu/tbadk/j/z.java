package com.baidu.tbadk.j;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class z {
    public String subType = null;

    public static com.baidu.adp.lib.stats.c fN() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
