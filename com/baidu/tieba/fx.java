package com.baidu.tieba;

import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class fx {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 1;
    public static int b = 3;
    public static int c = 1;
    public static int d = 2;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448304923, "Lcom/baidu/tieba/fx;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448304923, "Lcom/baidu/tieba/fx;");
        }
    }

    public static void a(int i, String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2), Integer.valueOf(i3), str2}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_VIRTUAL_IMAGE_SHOW);
            statisticItem.param("obj_type", i);
            statisticItem.param("tid", str);
            statisticItem.param("obj_locate", i2);
            statisticItem.param("obj_source", i3);
            if (i3 == c) {
                statisticItem.param("obj_name", str2);
            }
            TiebaStatic.log(statisticItem);
        }
    }
}
