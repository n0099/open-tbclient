package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class dd2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static xc2 a(ed2 ed2Var, ud2 ud2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, ed2Var, ud2Var, v8ThreadDelegatePolicy)) == null) {
            fd2 a = wo2.B0().a(ed2Var);
            xc2 a2 = a.a(ed2Var.a(), ud2Var, v8ThreadDelegatePolicy);
            a2.G0(a.getUserAgent());
            return a2;
        }
        return (xc2) invokeLLL.objValue;
    }

    public static xc2 b(ed2 ed2Var, ud2 ud2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, ed2Var, ud2Var, v8ThreadDelegatePolicy)) == null) {
            xc2 a = a(ed2Var, ud2Var, v8ThreadDelegatePolicy);
            a.o0();
            return a;
        }
        return (xc2) invokeLLL.objValue;
    }
}
