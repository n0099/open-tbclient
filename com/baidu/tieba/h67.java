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
public class h67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, hb9 hb9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, hb9Var) != null) || hb9Var == null) {
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
        ib9 ib9Var = hb9Var.f;
        if (ib9Var != null) {
            n06.b(ib9Var.b, ib9Var.c, "1191003700000000", ib9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(hb9Var.d)) {
                str = hb9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = hb9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        k87.a(tbPageContext, hb9Var.e);
    }

    public static void c(hb9 hb9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, hb9Var) != null) || hb9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", hb9Var.g);
        if (hb9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", hb9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ib9 ib9Var = hb9Var.f;
        if (ib9Var != null) {
            str = ib9Var.c;
        } else {
            str = hb9Var.d;
        }
        ib9 ib9Var2 = hb9Var.f;
        if (ib9Var2 != null) {
            String str2 = ib9Var2.a;
        } else {
            String str3 = hb9Var.c;
        }
        statisticItem.param("obj_name", hb9Var.c);
        statisticItem.param("obj_param1", hb9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hb9Var.i, 1));
    }

    public static void d(hb9 hb9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, hb9Var) != null) || hb9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", hb9Var.g);
        if (hb9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", hb9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        ib9 ib9Var = hb9Var.f;
        if (ib9Var != null) {
            str = ib9Var.c;
        } else {
            str = hb9Var.d;
        }
        ib9 ib9Var2 = hb9Var.f;
        if (ib9Var2 != null) {
            String str2 = ib9Var2.a;
        } else {
            String str3 = hb9Var.c;
        }
        statisticItem.param("obj_name", hb9Var.c);
        statisticItem.param("obj_param1", hb9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(hb9Var.i, 0));
    }
}
