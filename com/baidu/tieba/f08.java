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
public class f08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, ara araVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, araVar) != null) || araVar == null) {
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
        bra braVar = araVar.f;
        if (braVar != null) {
            TbAiappsLaunchUtil.launch(braVar.b, braVar.c, "1191003700000000", braVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(araVar.d)) {
                str = araVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = araVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        s38.a(tbPageContext, araVar.e);
    }

    public static void c(ara araVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, araVar) != null) || araVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", araVar.g);
        if (araVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", araVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        bra braVar = araVar.f;
        if (braVar != null) {
            str = braVar.c;
        } else {
            str = araVar.d;
        }
        bra braVar2 = araVar.f;
        if (braVar2 != null) {
            String str2 = braVar2.a;
        } else {
            String str3 = araVar.c;
        }
        statisticItem.param("obj_name", araVar.c);
        statisticItem.param("obj_param1", araVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(araVar.i, 1));
    }

    public static void d(ara araVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, araVar) != null) || araVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", araVar.g);
        if (araVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", araVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        bra braVar = araVar.f;
        if (braVar != null) {
            str = braVar.c;
        } else {
            str = araVar.d;
        }
        bra braVar2 = araVar.f;
        if (braVar2 != null) {
            String str2 = braVar2.a;
        } else {
            String str3 = araVar.c;
        }
        statisticItem.param("obj_name", araVar.c);
        statisticItem.param("obj_param1", araVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(araVar.i, 0));
    }
}
