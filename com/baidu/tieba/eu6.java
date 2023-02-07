package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class eu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65536, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65537, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_ENTER_GAME_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65538, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_RETRY_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void d(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65539, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_RETRY_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void f(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65541, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_STOP_BTN_CLICK);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65542, null, j) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_STOP_BTN_SHOW);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void e(String str, long j, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{str, Long.valueOf(j), Integer.valueOf(i)}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_ACCELERATOR_PAGE_SHOW);
            statisticItem.addParam("fid", str);
            statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.addParam("obj_id", j);
            statisticItem.addParam("obj_source", i);
            TiebaStatic.log(statisticItem);
        }
    }
}
