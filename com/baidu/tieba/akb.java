package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public final class akb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public akb() {
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

    public static void a(akb akbVar, ujb ujbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, akbVar, ujbVar) == null) {
            int length = akbVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                akbVar.c[i2] = i;
                xjb.n(akbVar.a, akbVar.b, i, ujbVar);
                i += 1080;
            }
        }
    }

    public static void b(akb akbVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, akbVar, i, i2) == null) {
            akbVar.a = i;
            akbVar.b = new int[i2 * 1080];
            akbVar.c = new int[i2];
        }
    }
}
