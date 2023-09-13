package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class fb1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947758260, "Lcom/baidu/tieba/fb1;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947758260, "Lcom/baidu/tieba/fb1;");
        }
    }

    @JvmStatic
    public static final cb1 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            cb1 cb1Var = cb1.a;
            Intrinsics.checkNotNullExpressionValue(cb1Var, "INativeWebViewCreator.EMPTY");
            return cb1Var;
        }
        return (cb1) invokeV.objValue;
    }
}
