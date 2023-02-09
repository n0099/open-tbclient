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
public class g27 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, q19 q19Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, q19Var) != null) || q19Var == null) {
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
        r19 r19Var = q19Var.f;
        if (r19Var != null) {
            qz5.b(r19Var.b, r19Var.c, "1191003700000000", r19Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(q19Var.d)) {
                str = q19Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = q19Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        i47.a(tbPageContext, q19Var.e);
    }

    public static void c(q19 q19Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, q19Var) != null) || q19Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", q19Var.g);
        if (q19Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", q19Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        r19 r19Var = q19Var.f;
        if (r19Var != null) {
            str = r19Var.c;
        } else {
            str = q19Var.d;
        }
        r19 r19Var2 = q19Var.f;
        if (r19Var2 != null) {
            String str2 = r19Var2.a;
        } else {
            String str3 = q19Var.c;
        }
        statisticItem.param("obj_name", q19Var.c);
        statisticItem.param("obj_param1", q19Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(q19Var.i, 1));
    }

    public static void d(q19 q19Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, q19Var) != null) || q19Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", q19Var.g);
        if (q19Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", q19Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        r19 r19Var = q19Var.f;
        if (r19Var != null) {
            str = r19Var.c;
        } else {
            str = q19Var.d;
        }
        r19 r19Var2 = q19Var.f;
        if (r19Var2 != null) {
            String str2 = r19Var2.a;
        } else {
            String str3 = q19Var.c;
        }
        statisticItem.param("obj_name", q19Var.c);
        statisticItem.param("obj_param1", q19Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(q19Var.i, 0));
    }
}
