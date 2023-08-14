package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes5.dex */
public class f06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, taa taaVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, taaVar)) == null) {
            if (context == null || taaVar == null || !taaVar.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = taaVar.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.F(a.app_id);
            tiePlusHelper.G(a.title);
            tiePlusHelper.M(true);
            tiePlusHelper.K(a.download_url);
            tiePlusHelper.O(a.app_package);
            tiePlusHelper.P(a.app_power);
            tiePlusHelper.Q(a.app_privacy);
            v06 v06Var = new v06(context, tiePlusHelper, true);
            tiePlusHelper.J(v06Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.N(itemData);
            v06Var.f(a.app_company);
            v06Var.g(a.app_icon);
            v06Var.h(a.title);
            v06Var.i(a.app_version);
            v06Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
