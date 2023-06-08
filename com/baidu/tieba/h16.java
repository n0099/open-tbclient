package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes6.dex */
public class h16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, kx9 kx9Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, kx9Var)) == null) {
            if (context == null || kx9Var == null || !kx9Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = kx9Var.a();
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
            x16 x16Var = new x16(context, tiePlusHelper, true);
            tiePlusHelper.J(x16Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.N(itemData);
            x16Var.f(a.app_company);
            x16Var.g(a.app_icon);
            x16Var.h(a.title);
            x16Var.i(a.app_version);
            x16Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
