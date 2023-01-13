package com.baidu.tieba;

import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ThemeColorInfo;
/* loaded from: classes3.dex */
public final class a95 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            if (p95.b.a().a("show_write_tip")) {
                x55 a = o95.b.a().a();
                if (a == null || a.b != 0) {
                    z = false;
                } else {
                    z = true;
                }
                if (!z) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static final int b(boolean z) {
        InterceptResult invokeZ;
        ThemeColorInfo themeColorInfo;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65537, null, z)) == null) {
            if (!z) {
                return SkinManager.getColor(R.color.CAM_X0110);
            }
            x55 a = o95.b.a().a();
            if (a == null) {
                themeColorInfo = null;
            } else {
                themeColorInfo = a.f;
            }
            if (a() && themeColorInfo != null) {
                return SkinManager.getColorFromServerColor(themeColorInfo, R.color.CAM_X0301);
            }
            return SkinManager.getColor(R.color.CAM_X0302);
        }
        return invokeZ.intValue;
    }
}
