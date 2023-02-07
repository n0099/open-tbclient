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

    public static void b(Context context, m09 m09Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, m09Var) != null) || m09Var == null) {
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
        n09 n09Var = m09Var.f;
        if (n09Var != null) {
            qz5.b(n09Var.b, n09Var.c, "1191003700000000", n09Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(m09Var.d)) {
                str = m09Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = m09Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        i47.a(tbPageContext, m09Var.e);
    }

    public static void c(m09 m09Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, m09Var) != null) || m09Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", m09Var.g);
        if (m09Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", m09Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        n09 n09Var = m09Var.f;
        if (n09Var != null) {
            str = n09Var.c;
        } else {
            str = m09Var.d;
        }
        n09 n09Var2 = m09Var.f;
        if (n09Var2 != null) {
            String str2 = n09Var2.a;
        } else {
            String str3 = m09Var.c;
        }
        statisticItem.param("obj_name", m09Var.c);
        statisticItem.param("obj_param1", m09Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(m09Var.i, 1));
    }

    public static void d(m09 m09Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, m09Var) != null) || m09Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", m09Var.g);
        if (m09Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", m09Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        n09 n09Var = m09Var.f;
        if (n09Var != null) {
            str = n09Var.c;
        } else {
            str = m09Var.d;
        }
        n09 n09Var2 = m09Var.f;
        if (n09Var2 != null) {
            String str2 = n09Var2.a;
        } else {
            String str3 = m09Var.c;
        }
        statisticItem.param("obj_name", m09Var.c);
        statisticItem.param("obj_param1", m09Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(m09Var.i, 0));
    }
}
