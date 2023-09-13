package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class f8c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public f8c() {
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

    public static void a(f8c f8cVar, z7c z7cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, f8cVar, z7cVar) == null) {
            int length = f8cVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                f8cVar.c[i2] = i;
                c8c.n(f8cVar.a, f8cVar.b, i, z7cVar);
                i += 1080;
            }
        }
    }

    public static void b(f8c f8cVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, f8cVar, i, i2) == null) {
            f8cVar.a = i;
            f8cVar.b = new int[i2 * 1080];
            f8cVar.c = new int[i2];
        }
    }
}
