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
/* loaded from: classes6.dex */
public class g08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, bra braVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, braVar) != null) || braVar == null) {
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
        cra craVar = braVar.f;
        if (craVar != null) {
            TbAiappsLaunchUtil.launch(craVar.b, craVar.c, "1191003700000000", craVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(braVar.d)) {
                str = braVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = braVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        t38.a(tbPageContext, braVar.e);
    }

    public static void c(bra braVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, braVar) != null) || braVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", braVar.g);
        if (braVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", braVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        cra craVar = braVar.f;
        if (craVar != null) {
            str = craVar.c;
        } else {
            str = braVar.d;
        }
        cra craVar2 = braVar.f;
        if (craVar2 != null) {
            String str2 = craVar2.a;
        } else {
            String str3 = braVar.c;
        }
        statisticItem.param("obj_name", braVar.c);
        statisticItem.param("obj_param1", braVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(braVar.i, 1));
    }

    public static void d(bra braVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, braVar) != null) || braVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", braVar.g);
        if (braVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", braVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        cra craVar = braVar.f;
        if (craVar != null) {
            str = craVar.c;
        } else {
            str = braVar.d;
        }
        cra craVar2 = braVar.f;
        if (craVar2 != null) {
            String str2 = craVar2.a;
        } else {
            String str3 = braVar.c;
        }
        statisticItem.param("obj_name", braVar.c);
        statisticItem.param("obj_param1", braVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(braVar.i, 0));
    }
}
