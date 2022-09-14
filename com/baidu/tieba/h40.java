package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class h40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k40[] a;

    public h40() {
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
        this.a = new k40[]{new l40(8, 0), new m40(0, 1), new m40(1, 1), new l40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        j40 j40Var = new j40();
        byte[] b = i40.b(bArr, bArr.length + ((this.a.length + 1) * j40.b));
        i40.a(b, j40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            k40[] k40VarArr = this.a;
            if (i >= k40VarArr.length) {
                return Arrays.copyOf(j40Var.b(), j40.b);
            }
            k40 k40Var = k40VarArr[i];
            i++;
            int length = bArr.length + (j40.b * i);
            j40Var.a(k40Var.b(b, 0, length), k40Var.a(), k40Var.c(), k40Var.d());
            i40.a(b, j40Var.b(), length);
        }
    }
}
