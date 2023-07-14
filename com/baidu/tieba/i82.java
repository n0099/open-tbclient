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
/* loaded from: classes6.dex */
public class i82 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947807302, "Lcom/baidu/tieba/i82;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947807302, "Lcom/baidu/tieba/i82;");
                return;
            }
        }
        boolean z = fs1.a;
    }

    @Nullable
    public static <C extends k72> C a(l72 l72Var) {
        InterceptResult invokeL;
        C c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, l72Var)) == null) {
            if (l72Var == null) {
                o82.a("Component-Finder", "find a null component: null model");
                return null;
            }
            String d = l72Var.d();
            String str = l72Var.c;
            if (TextUtils.isEmpty(str)) {
                v82.c("Component-Finder", "find a null " + d + " : slaveId is empty");
                return null;
            }
            l82 d2 = d(str);
            if (d2 == null) {
                v82.c("Component-Finder", "find a null " + d + " : null component context");
                return null;
            }
            String str2 = l72Var.b;
            if (TextUtils.isEmpty(str2)) {
                v82.o("Component-Finder", "find " + d + " with a empty componentId");
                List<k72> list = d2.a().c.get(l72Var.a);
                if (list == null) {
                    v82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are null ");
                    return null;
                } else if (list.size() <= 0) {
                    v82.c("Component-Finder", "find a null " + d + " with a empty componentId: fallbackComponents are empty ");
                    return null;
                } else {
                    v82.o("Component-Finder", "find " + d + " with a empty componentId: fina a fallback component");
                    c = (C) list.get(0);
                }
            } else {
                c = (C) d2.a().b.get(str2);
            }
            if (c == null) {
                v82.c("Component-Finder", "find a null " + d + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeL.objValue;
    }

    @Nullable
    public static <C extends k72> C b(@Nullable String str, @Nullable String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            l82 d = d(str);
            if (d == null) {
                v82.c("Component-Finder", "find a null " + str2 + " : null component context");
                return null;
            }
            C c = (C) d.a().b.get(str2);
            if (c == null) {
                v82.c("Component-Finder", "find a null " + str2 + " : not exist");
                return null;
            }
            return c;
        }
        return (C) invokeLL.objValue;
    }

    @Nullable
    public static l82 c(l72 l72Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, l72Var)) == null) {
            if (l72Var == null) {
                o82.a("Component-Finder", "find component context with a null model");
                return null;
            }
            return d(l72Var.c);
        }
        return (l82) invokeL.objValue;
    }

    @Nullable
    public static l82 d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                v82.c("Component-Finder", "find component context with a null slave id");
                return null;
            }
            dy1 A = ix2.T().A(str);
            if (!(A instanceof by1)) {
                return null;
            }
            return ((by1) A).a0();
        }
        return (l82) invokeL.objValue;
    }
}
