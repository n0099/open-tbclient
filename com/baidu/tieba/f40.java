package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class f40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public i40[] a;

    public f40() {
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
        this.a = new i40[]{new j40(8, 0), new k40(0, 1), new k40(1, 1), new j40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        h40 h40Var = new h40();
        byte[] b = g40.b(bArr, bArr.length + ((this.a.length + 1) * h40.b));
        g40.a(b, h40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            i40[] i40VarArr = this.a;
            if (i >= i40VarArr.length) {
                return Arrays.copyOf(h40Var.b(), h40.b);
            }
            i40 i40Var = i40VarArr[i];
            i++;
            int length = bArr.length + (h40.b * i);
            h40Var.a(i40Var.b(b, 0, length), i40Var.a(), i40Var.c(), i40Var.d());
            g40.a(b, h40Var.b(), length);
        }
    }
}
