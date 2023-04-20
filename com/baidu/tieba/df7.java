package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.ThirdStatisticHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class df7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, gl9 gl9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, gl9Var) != null) || gl9Var == null) {
            return;
        }
        TbPageContext<BaseFragmentActivity> tbPageContext = null;
        if (context instanceof BaseActivity) {
            tbPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            tbPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        if (tbPageContext == null) {
            return;
        }
        hl9 hl9Var = gl9Var.f;
        if (hl9Var != null) {
            u16.b(hl9Var.b, hl9Var.c, "1191003700000000", hl9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(gl9Var.d)) {
                str = gl9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = gl9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        ii7.a(tbPageContext, gl9Var.e);
    }

    public static void c(gl9 gl9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, gl9Var) != null) || gl9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", gl9Var.g);
        if (gl9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", gl9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hl9 hl9Var = gl9Var.f;
        if (hl9Var != null) {
            str = hl9Var.c;
        } else {
            str = gl9Var.d;
        }
        hl9 hl9Var2 = gl9Var.f;
        if (hl9Var2 != null) {
            String str2 = hl9Var2.a;
        } else {
            String str3 = gl9Var.c;
        }
        statisticItem.param("obj_name", gl9Var.c);
        statisticItem.param("obj_param1", gl9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gl9Var.i, 1));
    }

    public static void d(gl9 gl9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, gl9Var) != null) || gl9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", gl9Var.g);
        if (gl9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", gl9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        hl9 hl9Var = gl9Var.f;
        if (hl9Var != null) {
            str = hl9Var.c;
        } else {
            str = gl9Var.d;
        }
        hl9 hl9Var2 = gl9Var.f;
        if (hl9Var2 != null) {
            String str2 = hl9Var2.a;
        } else {
            String str3 = gl9Var.c;
        }
        statisticItem.param("obj_name", gl9Var.c);
        statisticItem.param("obj_param1", gl9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(gl9Var.i, 0));
    }
}
