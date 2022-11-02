package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public final class ew9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public ew9() {
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

    public static void a(ew9 ew9Var, yv9 yv9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, ew9Var, yv9Var) == null) {
            int length = ew9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                ew9Var.c[i2] = i;
                bw9.n(ew9Var.a, ew9Var.b, i, yv9Var);
                i += 1080;
            }
        }
    }

    public static void b(ew9 ew9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, ew9Var, i, i2) == null) {
            ew9Var.a = i;
            ew9Var.b = new int[i2 * 1080];
            ew9Var.c = new int[i2];
        }
    }
}
