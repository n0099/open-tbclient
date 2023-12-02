package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class fs8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, int i2, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.BIG_PAGE_ADD_EMOTION);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i);
            statisticItem.param("obj_source", i2);
            statisticItem.param("room_id", j);
            statisticItem.param("fid", j2);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(int i, long j, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2)}) == null) {
            StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.BIG_PAGE_AI_EMOTION_BORAD);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
            statisticItem.param("obj_type", i);
            statisticItem.param("room_id", j);
            statisticItem.param("fid", j2);
            TiebaStatic.log(statisticItem);
        }
    }
}
