package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class a5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public a5c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static void a(a5c a5cVar, u4c u4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, a5cVar, u4cVar) == null) {
            int length = a5cVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                a5cVar.c[i2] = i;
                x4c.n(a5cVar.a, a5cVar.b, i, u4cVar);
                i += 1080;
            }
        }
    }

    public static void b(a5c a5cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, a5cVar, i, i2) == null) {
            a5cVar.a = i;
            a5cVar.b = new int[i2 * 1080];
            a5cVar.c = new int[i2];
        }
    }
}
