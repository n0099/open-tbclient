package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes4.dex */
public class do5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, jw8 jw8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, jw8Var)) == null) {
            if (context == null || jw8Var == null || !jw8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = jw8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.D(a.app_id);
            tiePlusHelper.E(a.title);
            tiePlusHelper.K(true);
            tiePlusHelper.J(a.download_url);
            tiePlusHelper.M(a.app_package);
            tiePlusHelper.N(a.app_power);
            tiePlusHelper.O(a.app_privacy);
            to5 to5Var = new to5(context, tiePlusHelper, true);
            tiePlusHelper.H(to5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.L(itemData);
            to5Var.f(a.app_company);
            to5Var.g(a.app_icon);
            to5Var.h(a.title);
            to5Var.i(a.app_version);
            to5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
