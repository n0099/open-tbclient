package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class hzb {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int[] c;

    public hzb() {
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

    public static void a(hzb hzbVar, bzb bzbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, hzbVar, bzbVar) == null) {
            int length = hzbVar.c.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                hzbVar.c[i2] = i;
                ezb.n(hzbVar.a, hzbVar.b, i, bzbVar);
                i += 1080;
            }
        }
    }

    public static void b(hzb hzbVar, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(65538, null, hzbVar, i, i2) == null) {
            hzbVar.a = i;
            hzbVar.b = new int[i2 * 1080];
            hzbVar.c = new int[i2];
        }
    }
}
