package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class fz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public jz[] a;

    public fz() {
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
        this.a = new jz[]{new kz(8, 0), new lz(0, 1), new lz(1, 1), new kz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        iz izVar = new iz();
        byte[] b = gz.b(bArr, bArr.length + ((this.a.length + 1) * iz.b));
        gz.a(b, izVar.b(), bArr.length);
        int i = 0;
        while (true) {
            jz[] jzVarArr = this.a;
            if (i >= jzVarArr.length) {
                return Arrays.copyOf(izVar.b(), iz.b);
            }
            jz jzVar = jzVarArr[i];
            i++;
            int length = bArr.length + (iz.b * i);
            izVar.a(jzVar.b(b, 0, length), jzVar.a(), jzVar.c(), jzVar.d());
            gz.a(b, izVar.b(), length);
        }
    }
}
