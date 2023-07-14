package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class c50 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f50[] a;

    public c50() {
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
        this.a = new f50[]{new g50(8, 0), new h50(0, 1), new h50(1, 1), new g50(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        e50 e50Var = new e50();
        byte[] b = d50.b(bArr, bArr.length + ((this.a.length + 1) * e50.b));
        d50.a(b, e50Var.b(), bArr.length);
        int i = 0;
        while (true) {
            f50[] f50VarArr = this.a;
            if (i >= f50VarArr.length) {
                return Arrays.copyOf(e50Var.b(), e50.b);
            }
            f50 f50Var = f50VarArr[i];
            i++;
            int length = bArr.length + (e50.b * i);
            e50Var.a(f50Var.b(b, 0, length), f50Var.a(), f50Var.c(), f50Var.d());
            d50.a(b, e50Var.b(), length);
        }
    }
}
