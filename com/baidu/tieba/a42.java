package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class a42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            int indexOf = str.indexOf("_dev");
            if (indexOf > 0) {
                return str.substring(0, indexOf);
            }
            int indexOf2 = str.indexOf("_trial");
            if (indexOf2 > 0) {
                return str.substring(0, indexOf2);
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public static int b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            if (str.contains("_dev")) {
                return 1;
            }
            if (str.endsWith("_trial")) {
                return 3;
            }
            if (!str.contains("_trial")) {
                return 0;
            }
            return 2;
        }
        return invokeL.intValue;
    }

    public static String c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf("_dev");
            if (lastIndexOf >= 0 && lastIndexOf < str.length()) {
                return str.substring(lastIndexOf);
            }
            int lastIndexOf2 = str.lastIndexOf("_trial");
            if (lastIndexOf2 < 0 || lastIndexOf2 >= str.length()) {
                return "";
            }
            return str.substring(lastIndexOf2);
        }
        return (String) invokeL.objValue;
    }

    public static boolean d(vw2 vw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, vw2Var)) == null) {
            if (vw2Var != null && vw2Var.getType() == 1) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(vw2 vw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, vw2Var)) == null) {
            if (vw2Var == null || vw2Var.getType() != 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Deprecated
    public static boolean f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (!TextUtils.isEmpty(str) && !str.contains("_")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean g(vw2 vw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, vw2Var)) == null) {
            if (vw2Var != null && vw2Var.getType() == 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
