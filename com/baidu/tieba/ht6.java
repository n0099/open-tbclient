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
public class ht6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, ro8 ro8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, ro8Var) != null) || ro8Var == null) {
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
        so8 so8Var = ro8Var.f;
        if (so8Var != null) {
            ot5.b(so8Var.b, so8Var.c, "1191003700000000", so8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(ro8Var.d)) {
                str = ro8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = ro8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        gv6.a(tbPageContext, ro8Var.e);
    }

    public static void c(ro8 ro8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, ro8Var) != null) || ro8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", ro8Var.g);
        if (ro8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ro8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        so8 so8Var = ro8Var.f;
        if (so8Var != null) {
            str = so8Var.c;
        } else {
            str = ro8Var.d;
        }
        so8 so8Var2 = ro8Var.f;
        if (so8Var2 != null) {
            String str2 = so8Var2.a;
        } else {
            String str3 = ro8Var.c;
        }
        statisticItem.param("obj_name", ro8Var.c);
        statisticItem.param("obj_param1", ro8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ro8Var.i, 1));
    }

    public static void d(ro8 ro8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, ro8Var) != null) || ro8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", ro8Var.g);
        if (ro8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", ro8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        so8 so8Var = ro8Var.f;
        if (so8Var != null) {
            str = so8Var.c;
        } else {
            str = ro8Var.d;
        }
        so8 so8Var2 = ro8Var.f;
        if (so8Var2 != null) {
            String str2 = so8Var2.a;
        } else {
            String str3 = ro8Var.c;
        }
        statisticItem.param("obj_name", ro8Var.c);
        statisticItem.param("obj_param1", ro8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(ro8Var.i, 0));
    }
}
