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
/* loaded from: classes5.dex */
public class eo7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(StatisticItem statisticItem, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, statisticItem, str) == null) && YYLiveUtil.isYYLiveLink(str)) {
            YYLiveUtil.addYyExtData(statisticItem, str);
        }
    }

    public static void b(Context context, t3a t3aVar) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, context, t3aVar) != null) || t3aVar == null) {
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
        u3a u3aVar = t3aVar.f;
        if (u3aVar != null) {
            x86.b(u3aVar.b, u3aVar.c, "1191003700000000", u3aVar.d);
        } else {
            if (YYLiveUtil.isYYLiveLink(t3aVar.d)) {
                str = t3aVar.d + "&source=" + YYLiveUtil.SOURCE_FRS_SERVICE_AREA;
            } else {
                str = t3aVar.d;
            }
            UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{str});
        }
        jr7.a(tbPageContext, t3aVar.e);
    }

    public static void c(t3a t3aVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, t3aVar) != null) || t3aVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13626");
        statisticItem.param("fid", t3aVar.g);
        if (t3aVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", t3aVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        u3a u3aVar = t3aVar.f;
        if (u3aVar != null) {
            str = u3aVar.c;
        } else {
            str = t3aVar.d;
        }
        u3a u3aVar2 = t3aVar.f;
        if (u3aVar2 != null) {
            String str2 = u3aVar2.a;
        } else {
            String str3 = t3aVar.c;
        }
        statisticItem.param("obj_name", t3aVar.c);
        statisticItem.param("obj_param1", t3aVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(t3aVar.i, 1));
    }

    public static void d(t3a t3aVar) {
        int i;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65539, null, t3aVar) != null) || t3aVar == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13627");
        statisticItem.param("fid", t3aVar.g);
        if (t3aVar.f == null) {
            i = 1;
        } else {
            i = 2;
        }
        statisticItem.param("obj_type", i);
        statisticItem.param("obj_locate", t3aVar.h);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        u3a u3aVar = t3aVar.f;
        if (u3aVar != null) {
            str = u3aVar.c;
        } else {
            str = t3aVar.d;
        }
        u3a u3aVar2 = t3aVar.f;
        if (u3aVar2 != null) {
            String str2 = u3aVar2.a;
        } else {
            String str3 = t3aVar.c;
        }
        statisticItem.param("obj_name", t3aVar.c);
        statisticItem.param("obj_param1", t3aVar.d);
        a(statisticItem, str);
        TiebaStatic.log(statisticItem);
        ThirdStatisticHelper.sendReq((String) ListUtils.getItem(t3aVar.i, 0));
    }
}
