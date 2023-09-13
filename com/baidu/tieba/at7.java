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
public class at7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, zga zgaVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, zgaVar) != null) || zgaVar == null) {
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
        aha ahaVar = zgaVar.f;
        if (ahaVar != null) {
            TbAiappsLaunchUtil.launch(ahaVar.b, ahaVar.c, "1191003700000000", ahaVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(zgaVar.d)) {
                str = zgaVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = zgaVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        lw7.a(tbPageContext, zgaVar.e);
    }

    public static void c(zga zgaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, zgaVar) != null) || zgaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", zgaVar.g);
        if (zgaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", zgaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        aha ahaVar = zgaVar.f;
        if (ahaVar != null) {
            str = ahaVar.c;
        } else {
            str = zgaVar.d;
        }
        aha ahaVar2 = zgaVar.f;
        if (ahaVar2 != null) {
            String str2 = ahaVar2.a;
        } else {
            String str3 = zgaVar.c;
        }
        statisticItem.param("obj_name", zgaVar.c);
        statisticItem.param("obj_param1", zgaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(zgaVar.i, 1));
    }

    public static void d(zga zgaVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, zgaVar) != null) || zgaVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", zgaVar.g);
        if (zgaVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", zgaVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        aha ahaVar = zgaVar.f;
        if (ahaVar != null) {
            str = ahaVar.c;
        } else {
            str = zgaVar.d;
        }
        aha ahaVar2 = zgaVar.f;
        if (ahaVar2 != null) {
            String str2 = ahaVar2.a;
        } else {
            String str3 = zgaVar.c;
        }
        statisticItem.param("obj_name", zgaVar.c);
        statisticItem.param("obj_param1", zgaVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(zgaVar.i, 0));
    }
}
