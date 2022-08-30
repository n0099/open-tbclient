package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f30 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i30[] a;

    public f30() {
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
        this.a = new i30[]{new j30(8, 0), new k30(0, 1), new k30(1, 1), new j30(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        h30 h30Var = new h30();
        byte[] b = g30.b(bArr, bArr.length + ((this.a.length + 1) * h30.b));
        g30.a(b, h30Var.b(), bArr.length);
        int i = 0;
        while (true) {
            i30[] i30VarArr = this.a;
            if (i >= i30VarArr.length) {
                return Arrays.copyOf(h30Var.b(), h30.b);
            }
            i30 i30Var = i30VarArr[i];
            i++;
            int length = bArr.length + (h30.b * i);
            h30Var.a(i30Var.b(b, 0, length), i30Var.a(), i30Var.c(), i30Var.d());
            g30.a(b, h30Var.b(), length);
        }
    }
}
