package com.baidu.tieba;

import android.content.Context;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.util.TiePlusHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.TiebaPlusInfo;
/* loaded from: classes3.dex */
public class di5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Context context, kk8 kk8Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, context, kk8Var)) == null) {
            if (context == null || kk8Var == null || !kk8Var.b()) {
                return false;
            }
            TiePlusHelper tiePlusHelper = new TiePlusHelper(context);
            TiebaPlusInfo a = kk8Var.a();
            if (a == null) {
                return false;
            }
            tiePlusHelper.E(a.app_id);
            tiePlusHelper.F(a.title);
            tiePlusHelper.L(true);
            tiePlusHelper.K(a.download_url);
            tiePlusHelper.N(a.app_package);
            tiePlusHelper.O(a.app_power);
            tiePlusHelper.P(a.app_privacy);
            ui5 ui5Var = new ui5(context, tiePlusHelper, true);
            tiePlusHelper.J(ui5Var);
            ItemData itemData = new ItemData();
            itemData.parseProto(a);
            tiePlusHelper.M(itemData);
            ui5Var.f(a.app_company);
            ui5Var.g(a.app_icon);
            ui5Var.h(a.title);
            ui5Var.i(a.app_version);
            ui5Var.show();
            return true;
        }
        return invokeLL.booleanValue;
    }
}
