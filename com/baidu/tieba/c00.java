package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class c00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g00[] a;

    public c00() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new g00[]{new h00(8, 0), new i00(0, 1), new i00(1, 1), new h00(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        f00 f00Var = new f00();
        byte[] b = d00.b(bArr, bArr.length + ((this.a.length + 1) * f00.b));
        d00.a(b, f00Var.b(), bArr.length);
        int i = 0;
        while (true) {
            g00[] g00VarArr = this.a;
            if (i >= g00VarArr.length) {
                return Arrays.copyOf(f00Var.b(), f00.b);
            }
            g00 g00Var = g00VarArr[i];
            i++;
            int length = bArr.length + (f00.b * i);
            f00Var.a(g00Var.b(b, 0, length), g00Var.a(), g00Var.c(), g00Var.d());
            d00.a(b, f00Var.b(), length);
        }
    }
}
