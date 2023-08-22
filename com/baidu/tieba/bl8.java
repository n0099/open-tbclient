package com.baidu.tieba;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bl8 {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "1";
    public static String b = "2";
    public static String c = "3";
    public static String d = "1";
    public static String e = "2";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947648923, "Lcom/baidu/tieba/bl8;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947648923, "Lcom/baidu/tieba/bl8;");
        }
    }

    public static void a(long j, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Long.valueOf(j), str, str2, str3}) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_CHAT_GROUP_DIALOG_SHOW);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", j);
            statisticItem.param("fname", str);
            statisticItem.param("obj_source", str2);
            statisticItem.param("obj_locate", str3);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void b(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65538, null, j, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_LIST_CREATE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", j);
            statisticItem.param("obj_locate", str);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(65539, null, j, str) == null) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_GROUP_LIST_MANAGE_CLICK);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("fid", j);
            statisticItem.param("obj_locate", str);
            TiebaStatic.log(statisticItem);
        }
    }
}
