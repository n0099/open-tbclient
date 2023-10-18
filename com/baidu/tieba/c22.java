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
/* loaded from: classes5.dex */
public class c22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622790, "Lcom/baidu/tieba/c22;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622790, "Lcom/baidu/tieba/c22;");
                return;
            }
        }
        boolean z = am1.a;
    }

    @Nullable
    public static <C extends f12> C a(g12 g12Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, g12Var)) == null) {
            if (g12Var == null) {
                i22.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = g12Var.d();
            String str = g12Var.c;
            if (TextUtils.isEmpty(str)) {
                p22.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            f22 d2 = d(str);
            if (d2 == null) {
                p22.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = g12Var.b;
            if (TextUtils.isEmpty(str2)) {
                p22.o("Component-Finder", "find " + d + " with a empty componentId");
                List<f12> list = d2.a().c.get(g12Var.a);
                if (list == null) {
                    p22.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    p22.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    p22.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                p22.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends f12> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            f22 d = d(str);
            if (d == null) {
                p22.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                p22.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static f22 c(g12 g12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, g12Var)) == null) {
            if (g12Var == null) {
                i22.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(g12Var.c);
        }
        return (f22) invokeL.objValue;
    }

    @Nullable
    public static f22 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                p22.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            yr1 B = cr2.V().B(str);
            if (!(B instanceof wr1)) {
                return null;
            }
            return ((wr1) B).Z();
        }
        return (f22) invokeL.objValue;
    }
}
