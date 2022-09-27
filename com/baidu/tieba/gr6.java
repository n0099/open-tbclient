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
public class gr6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, qm8 qm8Var) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, context, qm8Var) == null) || qm8Var == null) {
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
        rm8 rm8Var = qm8Var.f;
        if (rm8Var != null) {
            mr5.b(rm8Var.b, rm8Var.c, "1191003700000000", rm8Var.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(qm8Var.d)) {
                str = qm8Var.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = qm8Var.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        gt6.a(tbPageContext, qm8Var.e);
    }

    public static void c(qm8 qm8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, qm8Var) == null) || qm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", qm8Var.g);
        statisticItem.param("obj_type", qm8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", qm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        rm8 rm8Var = qm8Var.f;
        String str = rm8Var != null ? rm8Var.c : qm8Var.d;
        rm8 rm8Var2 = qm8Var.f;
        if (rm8Var2 != null) {
            String str2 = rm8Var2.a;
        } else {
            String str3 = qm8Var.c;
        }
        statisticItem.param("obj_name", qm8Var.c);
        statisticItem.param("obj_param1", qm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(qm8Var.i, 1));
    }

    public static void d(qm8 qm8Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, qm8Var) == null) || qm8Var == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", qm8Var.g);
        statisticItem.param("obj_type", qm8Var.f == null ? 1 : 2);
        statisticItem.param("obj_locate", qm8Var.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        rm8 rm8Var = qm8Var.f;
        String str = rm8Var != null ? rm8Var.c : qm8Var.d;
        rm8 rm8Var2 = qm8Var.f;
        if (rm8Var2 != null) {
            String str2 = rm8Var2.a;
        } else {
            String str3 = qm8Var.c;
        }
        statisticItem.param("obj_name", qm8Var.c);
        statisticItem.param("obj_param1", qm8Var.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(qm8Var.i, 0));
    }
}
