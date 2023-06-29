package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class b50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public e50[] a;

    public b50() {
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
        this.a = new e50[]{new f50(8, 0), new g50(0, 1), new g50(1, 1), new f50(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        d50 d50Var = new d50();
        byte[] b = c50.b(bArr, bArr.length + ((this.a.length + 1) * d50.b));
        c50.a(b, d50Var.b(), bArr.length);
        int i = 0;
        while (true) {
            e50[] e50VarArr = this.a;
            if (i >= e50VarArr.length) {
                return Arrays.copyOf(d50Var.b(), d50.b);
            }
            e50 e50Var = e50VarArr[i];
            i++;
            int length = bArr.length + (d50.b * i);
            d50Var.a(e50Var.b(b, 0, length), e50Var.a(), e50Var.c(), e50Var.d());
            c50.a(b, d50Var.b(), length);
        }
    }
}
