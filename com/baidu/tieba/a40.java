package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class a40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d40[] a;

    public a40() {
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
        this.a = new d40[]{new e40(8, 0), new f40(0, 1), new f40(1, 1), new e40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c40 c40Var = new c40();
        byte[] b = b40.b(bArr, bArr.length + ((this.a.length + 1) * c40.b));
        b40.a(b, c40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            d40[] d40VarArr = this.a;
            if (i >= d40VarArr.length) {
                return Arrays.copyOf(c40Var.b(), c40.b);
            }
            d40 d40Var = d40VarArr[i];
            i++;
            int length = bArr.length + (c40.b * i);
            c40Var.a(d40Var.b(b, 0, length), d40Var.a(), d40Var.c(), d40Var.d());
            b40.a(b, c40Var.b(), length);
        }
    }
}
