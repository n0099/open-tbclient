package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes3.dex */
public final class ah2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ug2 a(bh2 bh2Var, rh2 rh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, bh2Var, rh2Var, v8ThreadDelegatePolicy)) == null) {
            ch2 a = ts2.B0().a(bh2Var);
            ug2 a2 = a.a(bh2Var.a(), rh2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (ug2) invokeLLL.objValue;
    }

    public static ug2 b(bh2 bh2Var, rh2 rh2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, bh2Var, rh2Var, v8ThreadDelegatePolicy)) == null) {
            ug2 a = a(bh2Var, rh2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (ug2) invokeLLL.objValue;
    }
}
