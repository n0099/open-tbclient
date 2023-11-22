package com.baidu.tieba;

import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class d09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static StatisticItem a(String str, String str2, long j, String str3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j), str3})) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", j);
            statisticItem.param("fname", str3);
            if (!StringUtils.isNull(str2)) {
                statisticItem.param("room_id", str2);
            }
            return statisticItem;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public static void b(String str, long j, String str2, String str3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Long.valueOf(j), str2, str3, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            StatisticItem a = a(str, str3, j, str2);
            a.param("obj_locate", i);
            a.param("obj_type", i2);
            TiebaStatic.log(a);
        }
    }

    public static void c(String str, long j, String str2, String str3, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, Long.valueOf(j), str2, str3, Integer.valueOf(i), Integer.valueOf(i2)}) == null) {
            StatisticItem a = a(str, str3, j, str2);
            a.param("obj_locate", i2);
            a.param("obj_type", i);
            TiebaStatic.log(a);
        }
    }

    public static void e(String str, long j, String str2, String str3, int i, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j), str2, str3, Integer.valueOf(i), str4}) == null) {
            StatisticItem a = a(str, str3, j, str2);
            a.param("obj_locate", i);
            if (!StringUtils.isNull(str4)) {
                a.param("obj_type", str4);
            }
            TiebaStatic.log(a);
        }
    }

    public static void d(long j, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            StatisticItem param = StatisticItem.make("c15289").param("uid", TbadkCoreApplication.getCurrentAccount()).param("fid", j);
            if (z) {
                i = 1;
            } else {
                i = 2;
            }
            param.param("obj_type", i).eventStat();
        }
    }
}
