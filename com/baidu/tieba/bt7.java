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
import com.baidu.tieba.aiapps.TbAiappsLaunchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class bt7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, fja fjaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, fjaVar) != null) || fjaVar == null) {
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
        gja gjaVar = fjaVar.f;
        if (gjaVar != null) {
            TbAiappsLaunchUtil.launch(gjaVar.b, gjaVar.c, "1191003700000000", gjaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(fjaVar.d)) {
                str = fjaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = fjaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        nw7.a(tbPageContext, fjaVar.e);
    }

    public static void c(fja fjaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, fjaVar) != null) || fjaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", fjaVar.g);
        if (fjaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", fjaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        gja gjaVar = fjaVar.f;
        if (gjaVar != null) {
            str = gjaVar.c;
        } else {
            str = fjaVar.d;
        }
        gja gjaVar2 = fjaVar.f;
        if (gjaVar2 != null) {
            String str2 = gjaVar2.a;
        } else {
            String str3 = fjaVar.c;
        }
        statisticItem.param("obj_name", fjaVar.c);
        statisticItem.param("obj_param1", fjaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fjaVar.i, 1));
    }

    public static void d(fja fjaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, fjaVar) != null) || fjaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", fjaVar.g);
        if (fjaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", fjaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        gja gjaVar = fjaVar.f;
        if (gjaVar != null) {
            str = gjaVar.c;
        } else {
            str = fjaVar.d;
        }
        gja gjaVar2 = fjaVar.f;
        if (gjaVar2 != null) {
            String str2 = gjaVar2.a;
        } else {
            String str3 = fjaVar.c;
        }
        statisticItem.param("obj_name", fjaVar.c);
        statisticItem.param("obj_param1", fjaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(fjaVar.i, 0));
    }
}
