package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class i5a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public i5a() {
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

    public static void a(i5a i5aVar, c5a c5aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, i5aVar, c5aVar) == null) {
            int length = i5aVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i5aVar.c[i2] = i;
                f5a.n(i5aVar.a, i5aVar.b, i, c5aVar);
                i += 1080;
            }
        }
    }

    public static void b(i5a i5aVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, i5aVar, i, i2) == null) {
            i5aVar.a = i;
            i5aVar.b = new int[i2 * 1080];
            i5aVar.c = new int[i2];
        }
    }
}
