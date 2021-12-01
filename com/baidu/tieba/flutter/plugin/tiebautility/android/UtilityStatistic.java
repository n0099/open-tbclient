package com.baidu.tieba.flutter.plugin.tiebautility.android;

import c.a.d.f.n.a;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityStatisticAuto;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes10.dex */
public class UtilityStatistic implements TiebaUtilityStatisticAuto.HostUtilityStatistic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public UtilityStatistic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityStatisticAuto.HostUtilityStatistic
    public void debugLog(TiebaUtilityStatisticAuto.StatisticParam statisticParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, statisticParam) == null) {
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
    }

    @Override // com.baidu.tieba.flutter.plugin.tiebautility.TiebaUtilityStatisticAuto.HostUtilityStatistic
    public void statLogEvent(TiebaUtilityStatisticAuto.StatisticParam statisticParam) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, statisticParam) == null) {
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
}
