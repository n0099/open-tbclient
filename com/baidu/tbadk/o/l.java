package com.baidu.tbadk.o;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a jC() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
