package com.baidu.tieba;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ho5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4}) == null) {
            b(str, -1, str2, str3, str4, 0, "", "", "");
        }
    }

    public static void b(String str, int i, String str2, String str3, String str4, int i2, String str5, String str6, String str7) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), str2, str3, str4, Integer.valueOf(i2), str5, str6, str7}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            statisticItem.param("obj_source", str2);
            statisticItem.param("thread_type", i2);
            if (i > 0) {
                statisticItem.param("obj_locate", i);
            }
            if (!StringUtils.isNull(str3)) {
                statisticItem.param("tid", str3);
            }
            if (!StringUtils.isNull(str4)) {
                statisticItem.param("fid", str4);
            }
            if (str5 == null) {
                str5 = "";
            }
            statisticItem.addParam("obj_id", str5);
            if (str6 == null) {
                str6 = "";
            }
            statisticItem.addParam("obj_name", str6);
            if (str7 == null) {
                str7 = "";
            }
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, str7);
            TiebaStatic.log(statisticItem);
        }
    }

    public static void c(String str, String str2, String str3, String str4, String str5, String str6) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{str, str2, str3, str4, str5, str6}) == null) {
            StatisticItem statisticItem = new StatisticItem(str);
            if (str4 == null) {
                str4 = "";
            }
            statisticItem.addParam("obj_id", str4);
            if (str5 == null) {
                str5 = "";
            }
            statisticItem.addParam("obj_name", str5);
            if (str2 == null) {
                str2 = "";
            }
            statisticItem.param("resource_id", str2);
            if (str6 == null) {
                str6 = "";
            }
            statisticItem.addParam(TiebaStatic.Params.OBJ_TO, str6);
            if (str3 == null) {
                str3 = "";
            }
            statisticItem.param("tid", str3);
            TiebaStatic.log(statisticItem);
        }
    }
}
