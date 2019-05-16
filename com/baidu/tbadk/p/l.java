package com.baidu.tbadk.p;

import com.baidu.adp.lib.stats.BdStatisticsManager;
/* loaded from: classes.dex */
public class l {
    public String subType = null;

    public static com.baidu.adp.lib.stats.a iw() {
        return BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
    }
}
