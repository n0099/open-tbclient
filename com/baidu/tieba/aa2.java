package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public class aa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947608375, "Lcom/baidu/tieba/aa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947608375, "Lcom/baidu/tieba/aa2;");
                return;
            }
        }
        a = do1.a;
    }

    public static boolean a(r62 r62Var, String str) {
        InterceptResult invokeLL;
        t73 b0;
        v92 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, r62Var, str)) == null) {
            if (a) {
                Log.d("MasterIsolationHelper", "JS CALL - " + str);
            }
            boolean z = false;
            if (s33.D()) {
                return false;
            }
            if (r62Var != null && !TextUtils.isEmpty(r62Var.getContainerId())) {
                if (ia2.i().k(r62Var.getContainerId())) {
                    return true;
                }
                if (!tb2.h()) {
                    return false;
                }
                String containerId = r62Var.getContainerId();
                if (!z92.a(containerId) || (b0 = t73.b0()) == null || !b(r62Var) || (a2 = ca2.b().a()) == null) {
                    return false;
                }
                String h = a2.h();
                if (TextUtils.isEmpty(h)) {
                    return false;
                }
                z = (TextUtils.equals(a2.i().a(), r62Var.getContainerId()) && TextUtils.equals(h, b0.b)) ? true : true;
                if (a && z) {
                    Log.w("MasterIsolationHelper", "master id - " + containerId + ",can not call API - " + str + ", intercept for preload/prefetch");
                }
            }
            return z;
        }
        return invokeLL.booleanValue;
    }

    public static boolean b(r62 r62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, r62Var)) == null) {
            if ((r62Var instanceof bf2) && ((bf2) r62Var).getInvokeSourceType() == 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
