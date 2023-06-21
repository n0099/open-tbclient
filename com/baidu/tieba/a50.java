package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class a50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public d50[] a;

    public a50() {
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
        this.a = new d50[]{new e50(8, 0), new f50(0, 1), new f50(1, 1), new e50(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        c50 c50Var = new c50();
        byte[] b = b50.b(bArr, bArr.length + ((this.a.length + 1) * c50.b));
        b50.a(b, c50Var.b(), bArr.length);
        int i = 0;
        while (true) {
            d50[] d50VarArr = this.a;
            if (i >= d50VarArr.length) {
                return Arrays.copyOf(c50Var.b(), c50.b);
            }
            d50 d50Var = d50VarArr[i];
            i++;
            int length = bArr.length + (c50.b * i);
            c50Var.a(d50Var.b(b, 0, length), d50Var.a(), d50Var.c(), d50Var.d());
            b50.a(b, c50Var.b(), length);
        }
    }
}
