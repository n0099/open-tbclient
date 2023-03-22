package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class hf2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static bf2 a(if2 if2Var, yf2 yf2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, if2Var, yf2Var, v8ThreadDelegatePolicy)) == null) {
            jf2 a = ar2.B0().a(if2Var);
            bf2 a2 = a.a(if2Var.a(), yf2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (bf2) invokeLLL.objValue;
    }

    public static bf2 b(if2 if2Var, yf2 yf2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, if2Var, yf2Var, v8ThreadDelegatePolicy)) == null) {
            bf2 a = a(if2Var, yf2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (bf2) invokeLLL.objValue;
    }
}
