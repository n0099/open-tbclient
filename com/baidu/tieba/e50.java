package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class e50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static byte[] a(byte[] bArr, x40 x40Var) throws Exception {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, bArr, x40Var)) == null) {
            m40 b = m40.b();
            b.c(2, x40Var);
            return b.a(bArr);
        }
        return (byte[]) invokeLL.objValue;
    }
}
