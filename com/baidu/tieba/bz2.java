package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public final class bz2 {
    public static /* synthetic */ Interceptable $ic;
    public static ArrayList<az2> a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947662191, "Lcom/baidu/tieba/bz2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947662191, "Lcom/baidu/tieba/bz2;");
                return;
            }
        }
        a = new ArrayList<>();
    }

    public static void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            a.clear();
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null) {
                    az2Var.onDestroy();
                }
            }
        }
    }

    public static void a(az2 az2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, az2Var) == null) && az2Var != null && !a.contains(az2Var)) {
            a.add(az2Var);
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null) {
                    az2Var.j(z);
                }
            }
        }
    }

    public static void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65546, null, z) == null) {
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null) {
                    az2Var.k(z);
                }
            }
        }
    }

    public static void k(az2 az2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65547, null, az2Var) != null) || az2Var == null) {
            return;
        }
        a.remove(az2Var);
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            az2 az2Var = a.get(size);
            if (az2Var != null && TextUtils.equals(str, az2Var.b())) {
                az2Var.onDestroy();
            }
        }
    }

    public static az2 e(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null && TextUtils.equals(str, az2Var.c())) {
                    return az2Var;
                }
            }
            return null;
        }
        return (az2) invokeL.objValue;
    }

    public static boolean g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null && TextUtils.equals(str, az2Var.b()) && az2Var.onBackPressed()) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static az2 f(@Nullable String str, @Nullable String str2, @NonNull String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65542, null, str, str2, str3)) == null) {
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            for (int size = a.size() - 1; size >= 0; size--) {
                az2 az2Var = a.get(size);
                if (az2Var != null && ((TextUtils.isEmpty(str) || TextUtils.equals(str, az2Var.b())) && ((!TextUtils.isEmpty(str2) && TextUtils.equals(str2, az2Var.f())) || TextUtils.equals(str3, az2Var.c())))) {
                    return az2Var;
                }
            }
            return null;
        }
        return (az2) invokeLLL.objValue;
    }

    public static void i(String str, boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(65545, null, str, z) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        for (int size = a.size() - 1; size >= 0; size--) {
            az2 az2Var = a.get(size);
            if (az2Var != null && TextUtils.equals(str, az2Var.b())) {
                az2Var.k(z);
            }
        }
    }
}
