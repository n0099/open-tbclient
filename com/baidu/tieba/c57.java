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
/* loaded from: classes3.dex */
public class c57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, c59 c59Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, c59Var) != null) || c59Var == null) {
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
        d59 d59Var = c59Var.f;
        if (d59Var != null) {
            h16.b(d59Var.b, d59Var.c, "1191003700000000", d59Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(c59Var.d)) {
                str = c59Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = c59Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        e77.a(tbPageContext, c59Var.e);
    }

    public static void c(c59 c59Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, c59Var) != null) || c59Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", c59Var.g);
        if (c59Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", c59Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        d59 d59Var = c59Var.f;
        if (d59Var != null) {
            str = d59Var.c;
        } else {
            str = c59Var.d;
        }
        d59 d59Var2 = c59Var.f;
        if (d59Var2 != null) {
            String str2 = d59Var2.a;
        } else {
            String str3 = c59Var.c;
        }
        statisticItem.param("obj_name", c59Var.c);
        statisticItem.param("obj_param1", c59Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(c59Var.i, 1));
    }

    public static void d(c59 c59Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, c59Var) != null) || c59Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", c59Var.g);
        if (c59Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", c59Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        d59 d59Var = c59Var.f;
        if (d59Var != null) {
            str = d59Var.c;
        } else {
            str = c59Var.d;
        }
        d59 d59Var2 = c59Var.f;
        if (d59Var2 != null) {
            String str2 = d59Var2.a;
        } else {
            String str3 = c59Var.c;
        }
        statisticItem.param("obj_name", c59Var.c);
        statisticItem.param("obj_param1", c59Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(c59Var.i, 0));
    }
}
