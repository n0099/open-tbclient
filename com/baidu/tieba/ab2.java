package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class ab2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ua2 a(bb2 bb2Var, rb2 rb2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, bb2Var, rb2Var, v8ThreadDelegatePolicy)) == null) {
            cb2 a = tm2.B0().a(bb2Var);
            ua2 a2 = a.a(bb2Var.a(), rb2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (ua2) invokeLLL.objValue;
    }

    public static ua2 b(bb2 bb2Var, rb2 rb2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bb2Var, rb2Var, v8ThreadDelegatePolicy)) == null) {
            ua2 a = a(bb2Var, rb2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (ua2) invokeLLL.objValue;
    }
}
