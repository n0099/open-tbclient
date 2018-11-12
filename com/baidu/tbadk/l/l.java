package com.baidu.tbadk.l;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a jB() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
