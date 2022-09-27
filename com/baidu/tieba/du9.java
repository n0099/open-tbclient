package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public final class du9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public du9() {
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

    public static void a(du9 du9Var, xt9 xt9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, du9Var, xt9Var) == null) {
            int length = du9Var.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                du9Var.c[i2] = i;
                au9.n(du9Var.a, du9Var.b, i, xt9Var);
                i += 1080;
            }
        }
    }

    public static void b(du9 du9Var, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, du9Var, i, i2) == null) {
            du9Var.a = i;
            du9Var.b = new int[i2 * 1080];
            du9Var.c = new int[i2];
        }
    }
}
