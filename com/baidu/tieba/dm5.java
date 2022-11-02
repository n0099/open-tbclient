package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class dm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, bo8 bo8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, bo8Var)) == null) {
            if (context == null || bo8Var == null || !bo8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = bo8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.D(a.app_id);
            tiePlusHelper.E(a.title);
            tiePlusHelper.K(true);
            tiePlusHelper.I(a.download_url);
            tiePlusHelper.M(a.app_package);
            tiePlusHelper.N(a.app_power);
            tiePlusHelper.O(a.app_privacy);
            tm5 tm5Var = new tm5(context, tiePlusHelper, true);
            tiePlusHelper.H(tm5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.L(itemData);
            tm5Var.f(a.app_company);
            tm5Var.g(a.app_icon);
            tm5Var.h(a.title);
            tm5Var.i(a.app_version);
            tm5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
