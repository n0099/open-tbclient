package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
/* loaded from: classes4.dex */
public class h42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947773667, "Lcom/baidu/tieba/h42;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947773667, "Lcom/baidu/tieba/h42;");
                return;
            }
        }
        boolean z = eo1.a;
    }

    @Nullable
    public static <C extends j32> C a(k32 k32Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, k32Var)) == null) {
            if (k32Var == null) {
                n42.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = k32Var.d();
            String str = k32Var.c;
            if (TextUtils.isEmpty(str)) {
                u42.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            k42 d2 = d(str);
            if (d2 == null) {
                u42.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = k32Var.b;
            if (TextUtils.isEmpty(str2)) {
                u42.o("Component-Finder", "find " + d + " with a empty componentId");
                List<j32> list = d2.a().c.get(k32Var.a);
                if (list == null) {
                    u42.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    u42.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    u42.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                u42.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends j32> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            k42 d = d(str);
            if (d == null) {
                u42.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                u42.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static k42 c(k32 k32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, k32Var)) == null) {
            if (k32Var == null) {
                n42.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(k32Var.c);
        }
        return (k42) invokeL.objValue;
    }

    @Nullable
    public static k42 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                u42.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            cu1 A = ht2.U().A(str);
            if (!(A instanceof au1)) {
                return null;
            }
            return ((au1) A).c0();
        }
        return (k42) invokeL.objValue;
    }
}
