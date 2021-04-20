package com.baidu.tieba.flutter.plugin.tiebaUtility.android;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityStatisticAuto;
import d.b.c.e.n.a;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class UtilityStatistic implements TiebaUtilityStatisticAuto.HostUtilityStatistic {
    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityStatisticAuto.HostUtilityStatistic
    public void debugLog(TiebaUtilityStatisticAuto.StatisticParam statisticParam) {
        String key = statisticParam.getKey();
        HashMap params = statisticParam.getParams();
        a aVar = new a("dbg");
        if (params != null && !params.isEmpty()) {
            for (Map.Entry entry : params.entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().debug(key, aVar);
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebaUtility.TiebaUtilityStatisticAuto.HostUtilityStatistic
    public void statLogEvent(TiebaUtilityStatisticAuto.StatisticParam statisticParam) {
        String key = statisticParam.getKey();
        HashMap params = statisticParam.getParams();
        StatisticItem statisticItem = new StatisticItem(key);
        if (params != null && !params.isEmpty()) {
            for (Map.Entry entry : params.entrySet()) {
                if (entry.getValue() instanceof String) {
                    statisticItem.param((String) entry.getKey(), (String) entry.getValue());
                } else if (entry.getValue() instanceof Integer) {
                    statisticItem.param((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Long) {
                    statisticItem.param((String) entry.getKey(), ((Long) entry.getValue()).longValue());
                } else if (entry.getValue() instanceof Double) {
                    statisticItem.param((String) entry.getKey(), ((Double) entry.getValue()).doubleValue());
                }
            }
        }
        TiebaStatic.log(statisticItem);
    }
}
