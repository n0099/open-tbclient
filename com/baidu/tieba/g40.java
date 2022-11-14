package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class g40 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public j40[] a;

    public g40() {
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
        this.a = new j40[]{new k40(8, 0), new l40(0, 1), new l40(1, 1), new k40(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        i40 i40Var = new i40();
        byte[] b = h40.b(bArr, bArr.length + ((this.a.length + 1) * i40.b));
        h40.a(b, i40Var.b(), bArr.length);
        int i = 0;
        while (true) {
            j40[] j40VarArr = this.a;
            if (i >= j40VarArr.length) {
                return Arrays.copyOf(i40Var.b(), i40.b);
            }
            j40 j40Var = j40VarArr[i];
            i++;
            int length = bArr.length + (i40.b * i);
            i40Var.a(j40Var.b(b, 0, length), j40Var.a(), j40Var.c(), j40Var.d());
            h40.a(b, i40Var.b(), length);
        }
    }
}
