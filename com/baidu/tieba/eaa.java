package com.baidu.tieba;

import android.content.Intent;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.searchbox.launch.utils.SpeedStatsUtils;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class eaa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, intent)) == null) {
            if (intent == null) {
                return false;
            }
            return intent.getBooleanExtra(SpeedStatsUtils.UBC_VALUE_SPLASH, false);
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, intent)) == null) {
            if (intent == null) {
                return false;
            }
            boolean booleanExtra = intent.getBooleanExtra(FrsActivityConfig.FROM_SHORT_CUT, false);
            if (booleanExtra) {
                String stringExtra = intent.getStringExtra("fname");
                if (!StringUtils.isNull(stringExtra)) {
                    TiebaStatic.log(new StatisticItem("c11897").param("fname", stringExtra));
                }
            }
            return booleanExtra;
        }
        return invokeL.booleanValue;
    }
}
