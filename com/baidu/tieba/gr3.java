package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class gr3 {
    public static /* synthetic */ Interceptable $ic;
    public static String a;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            String str = a;
            if (str != null) {
                return TextUtils.equals(str, "HUAWEI");
            }
            String upperCase = Build.BRAND.toUpperCase();
            if (!TextUtils.equals("HUAWEI", upperCase) && !TextUtils.equals("HONOR", upperCase)) {
                String upperCase2 = Build.MANUFACTURER.toUpperCase();
                if (!upperCase2.contains("HUAWEI") && !upperCase2.contains("HONOR")) {
                    return false;
                }
                a = "HUAWEI";
                return true;
            }
            a = "HUAWEI";
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            String str = a;
            if (str != null) {
                return TextUtils.equals(str, "OPPO");
            }
            if (TextUtils.equals("OPPO", Build.BRAND.toUpperCase())) {
                a = "OPPO";
                return true;
            } else if (Build.MANUFACTURER.toUpperCase().contains("OPPO")) {
                a = "OPPO";
                return true;
            } else {
                return false;
            }
        }
        return invokeV.booleanValue;
    }
}
