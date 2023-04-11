package com.baidu.tieba;

import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public final class if2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static cf2 a(jf2 jf2Var, zf2 zf2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65536, null, jf2Var, zf2Var, v8ThreadDelegatePolicy)) == null) {
            kf2 a = br2.B0().a(jf2Var);
            cf2 a2 = a.a(jf2Var.a(), zf2Var, v8ThreadDelegatePolicy);
            a2.I0(a.getUserAgent());
            return a2;
        }
        return (cf2) invokeLLL.objValue;
    }

    public static cf2 b(jf2 jf2Var, zf2 zf2Var, V8ThreadDelegatePolicy v8ThreadDelegatePolicy) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, jf2Var, zf2Var, v8ThreadDelegatePolicy)) == null) {
            cf2 a = a(jf2Var, zf2Var, v8ThreadDelegatePolicy);
            a.q0();
            return a;
        }
        return (cf2) invokeLLL.objValue;
    }
}
