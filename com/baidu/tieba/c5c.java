package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class c5c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public c5c() {
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

    public static void a(c5c c5cVar, w4c w4cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, c5cVar, w4cVar) == null) {
            int length = c5cVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                c5cVar.c[i2] = i;
                z4c.n(c5cVar.a, c5cVar.b, i, w4cVar);
                i += 1080;
            }
        }
    }

    public static void b(c5c c5cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, c5cVar, i, i2) == null) {
            c5cVar.a = i;
            c5cVar.b = new int[i2 * 1080];
            c5cVar.c = new int[i2];
        }
    }
}
