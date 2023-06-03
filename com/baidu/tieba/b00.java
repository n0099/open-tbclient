package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class b00 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public f00[] a;

    public b00() {
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
        this.a = new f00[]{new g00(8, 0), new h00(0, 1), new h00(1, 1), new g00(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        e00 e00Var = new e00();
        byte[] b = c00.b(bArr, bArr.length + ((this.a.length + 1) * e00.b));
        c00.a(b, e00Var.b(), bArr.length);
        int i = 0;
        while (true) {
            f00[] f00VarArr = this.a;
            if (i >= f00VarArr.length) {
                return Arrays.copyOf(e00Var.b(), e00.b);
            }
            f00 f00Var = f00VarArr[i];
            i++;
            int length = bArr.length + (e00.b * i);
            e00Var.a(f00Var.b(b, 0, length), f00Var.a(), f00Var.c(), f00Var.d());
            c00.a(b, e00Var.b(), length);
        }
    }
}
