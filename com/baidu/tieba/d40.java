package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class d40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public g40[] a;

    public d40() {
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
        this.a = new g40[]{new h40(8, 0), new i40(0, 1), new i40(1, 1), new h40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        f40 f40Var = new f40();
        byte[] b = e40.b(bArr, bArr.length + ((this.a.length + 1) * f40.b));
        e40.a(b, f40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            g40[] g40VarArr = this.a;
            if (i >= g40VarArr.length) {
                return Arrays.copyOf(f40Var.b(), f40.b);
            }
            g40 g40Var = g40VarArr[i];
            i++;
            int length = bArr.length + (f40.b * i);
            f40Var.a(g40Var.b(b, 0, length), g40Var.a(), g40Var.c(), g40Var.d());
            e40.a(b, f40Var.b(), length);
        }
    }
}
