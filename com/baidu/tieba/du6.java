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

    public static void b(Context context, sr8 sr8Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, sr8Var) != null) || sr8Var == null) {
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
        tr8 tr8Var = sr8Var.f;
        if (tr8Var != null) {
            ku5.b(tr8Var.b, tr8Var.c, "1191003700000000", tr8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(sr8Var.d)) {
                str = sr8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = sr8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        dw6.a(tbPageContext, sr8Var.e);
    }

    public static void c(sr8 sr8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, sr8Var) != null) || sr8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", sr8Var.g);
        if (sr8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", sr8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        tr8 tr8Var = sr8Var.f;
        if (tr8Var != null) {
            str = tr8Var.c;
        } else {
            str = sr8Var.d;
        }
        tr8 tr8Var2 = sr8Var.f;
        if (tr8Var2 != null) {
            String str2 = tr8Var2.a;
        } else {
            String str3 = sr8Var.c;
        }
        statisticItem.param("obj_name", sr8Var.c);
        statisticItem.param("obj_param1", sr8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(sr8Var.i, 1));
    }

    public static void d(sr8 sr8Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, sr8Var) != null) || sr8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", sr8Var.g);
        if (sr8Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", sr8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        tr8 tr8Var = sr8Var.f;
        if (tr8Var != null) {
            str = tr8Var.c;
        } else {
            str = sr8Var.d;
        }
        tr8 tr8Var2 = sr8Var.f;
        if (tr8Var2 != null) {
            String str2 = tr8Var2.a;
        } else {
            String str3 = sr8Var.c;
        }
        statisticItem.param("obj_name", sr8Var.c);
        statisticItem.param("obj_param1", sr8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(sr8Var.i, 0));
    }
}
