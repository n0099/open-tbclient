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
public class du6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, rr8 rr8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, rr8Var) != null) || rr8Var == null) {
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
        sr8 sr8Var = rr8Var.f;
        if (sr8Var != null) {
            ku5.b(sr8Var.b, sr8Var.c, "1191003700000000", sr8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(rr8Var.d)) {
                str = rr8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = rr8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        dw6.a(tbPageContext, rr8Var.e);
    }

    public static void c(rr8 rr8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, rr8Var) != null) || rr8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", rr8Var.g);
        if (rr8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", rr8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        sr8 sr8Var = rr8Var.f;
        if (sr8Var != null) {
            str = sr8Var.c;
        } else {
            str = rr8Var.d;
        }
        sr8 sr8Var2 = rr8Var.f;
        if (sr8Var2 != null) {
            String str2 = sr8Var2.a;
        } else {
            String str3 = rr8Var.c;
        }
        statisticItem.param("obj_name", rr8Var.c);
        statisticItem.param("obj_param1", rr8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(rr8Var.i, 1));
    }

    public static void d(rr8 rr8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, rr8Var) != null) || rr8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", rr8Var.g);
        if (rr8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", rr8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        sr8 sr8Var = rr8Var.f;
        if (sr8Var != null) {
            str = sr8Var.c;
        } else {
            str = rr8Var.d;
        }
        sr8 sr8Var2 = rr8Var.f;
        if (sr8Var2 != null) {
            String str2 = sr8Var2.a;
        } else {
            String str3 = rr8Var.c;
        }
        statisticItem.param("obj_name", rr8Var.c);
        statisticItem.param("obj_param1", rr8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(rr8Var.i, 0));
    }
}
