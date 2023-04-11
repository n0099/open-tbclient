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
public class cf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, yk9 yk9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, yk9Var) != null) || yk9Var == null) {
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
        zk9 zk9Var = yk9Var.f;
        if (zk9Var != null) {
            t16.b(zk9Var.b, zk9Var.c, "1191003700000000", zk9Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(yk9Var.d)) {
                str = yk9Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = yk9Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        hi7.a(tbPageContext, yk9Var.e);
    }

    public static void c(yk9 yk9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, yk9Var) != null) || yk9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", yk9Var.g);
        if (yk9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yk9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zk9 zk9Var = yk9Var.f;
        if (zk9Var != null) {
            str = zk9Var.c;
        } else {
            str = yk9Var.d;
        }
        zk9 zk9Var2 = yk9Var.f;
        if (zk9Var2 != null) {
            String str2 = zk9Var2.a;
        } else {
            String str3 = yk9Var.c;
        }
        statisticItem.param("obj_name", yk9Var.c);
        statisticItem.param("obj_param1", yk9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yk9Var.i, 1));
    }

    public static void d(yk9 yk9Var) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, yk9Var) != null) || yk9Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", yk9Var.g);
        if (yk9Var.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", yk9Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        zk9 zk9Var = yk9Var.f;
        if (zk9Var != null) {
            str = zk9Var.c;
        } else {
            str = yk9Var.d;
        }
        zk9 zk9Var2 = yk9Var.f;
        if (zk9Var2 != null) {
            String str2 = zk9Var2.a;
        } else {
            String str3 = yk9Var.c;
        }
        statisticItem.param("obj_name", yk9Var.c);
        statisticItem.param("obj_param1", yk9Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(yk9Var.i, 0));
    }
}
