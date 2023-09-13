package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public final class g8c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public byte[] a;
    public int[] b;

    public g8c() {
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

    public static void a(g8c g8cVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65537, null, g8cVar, i) == null) {
            for (int i2 = 0; i2 < i; i2++) {
                int[] iArr = g8cVar.b;
                byte[] bArr = g8cVar.a;
                int i3 = i2 * 4;
                iArr[i2] = ((bArr[i3 + 3] & 255) << 24) | (bArr[i3] & 255) | ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3 + 2] & 255) << 16);
            }
        }
    }

    public static void b(g8c g8cVar, byte[] bArr, int[] iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, g8cVar, bArr, iArr) == null) {
            g8cVar.a = bArr;
            g8cVar.b = iArr;
        }
    }
}
