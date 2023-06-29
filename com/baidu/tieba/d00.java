package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class d00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h00[] a;

    public d00() {
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
        this.a = new h00[]{new i00(8, 0), new j00(0, 1), new j00(1, 1), new i00(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        g00 g00Var = new g00();
        byte[] b = e00.b(bArr, bArr.length + ((this.a.length + 1) * g00.b));
        e00.a(b, g00Var.b(), bArr.length);
        int i = 0;
        while (true) {
            h00[] h00VarArr = this.a;
            if (i >= h00VarArr.length) {
                return Arrays.copyOf(g00Var.b(), g00.b);
            }
            h00 h00Var = h00VarArr[i];
            i++;
            int length = bArr.length + (g00.b * i);
            g00Var.a(h00Var.b(b, 0, length), h00Var.a(), h00Var.c(), h00Var.d());
            e00.a(b, g00Var.b(), length);
        }
    }
}
