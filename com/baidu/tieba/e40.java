package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class e40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public h40[] a;

    public e40() {
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
        this.a = new h40[]{new i40(8, 0), new j40(0, 1), new j40(1, 1), new i40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        g40 g40Var = new g40();
        byte[] b = f40.b(bArr, bArr.length + ((this.a.length + 1) * g40.b));
        f40.a(b, g40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            h40[] h40VarArr = this.a;
            if (i >= h40VarArr.length) {
                return Arrays.copyOf(g40Var.b(), g40.b);
            }
            h40 h40Var = h40VarArr[i];
            i++;
            int length = bArr.length + (g40.b * i);
            g40Var.a(h40Var.b(b, 0, length), h40Var.a(), h40Var.c(), h40Var.d());
            f40.a(b, g40Var.b(), length);
        }
    }
}
