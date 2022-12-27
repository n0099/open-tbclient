package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class a0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public a0a() {
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

    public static void a(a0a a0aVar, uz9 uz9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, a0aVar, uz9Var) == null) {
            int length = a0aVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                a0aVar.c[i2] = i;
                xz9.n(a0aVar.a, a0aVar.b, i, uz9Var);
                i += 1080;
            }
        }
    }

    public static void b(a0a a0aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, a0aVar, i, i2) == null) {
            a0aVar.a = i;
            a0aVar.b = new int[i2 * 1080];
            a0aVar.c = new int[i2];
        }
    }
}
