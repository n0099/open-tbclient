package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class f76 {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public static boolean b;
    public static boolean c;
    public static long d;
    public static String e;
    public static long f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, String str2, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, str2, Long.valueOf(j)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST_SUCCESS_NOT_SHOW);
            statisticItem.param("obj_source", str);
            statisticItem.param("obj_type", "a064");
            if (g76.b.equals(str)) {
                statisticItem.param(TiebaStatic.Params.OBJ_TO, str2);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_DURATION, System.currentTimeMillis());
            statisticItem.param(TiebaStatic.Params.SPLASH_UNI, j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65537, null) == null) && b && a && c) {
            if (g76.b.equals(g)) {
                a(g76.c, null, d);
            } else {
                a(g76.b, e, f);
            }
            c();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            b = false;
            a = false;
            c = false;
            d = 0L;
            e = null;
            f = 0L;
            g = null;
        }
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, str) == null) {
            c = true;
            g = str;
            b();
        }
    }

    public static void e(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j) == null) {
            a = true;
            d = j;
            b();
        }
    }

    public static void f(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65541, null, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            if (i == 3 && !uu5.v()) {
                return;
            }
            b = true;
            e = uu5.m(i);
            f = j;
            b();
        }
    }
}
