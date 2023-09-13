package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes6.dex */
public class gz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kz[] a;

    public gz() {
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
        this.a = new kz[]{new lz(8, 0), new mz(0, 1), new mz(1, 1), new lz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        jz jzVar = new jz();
        byte[] b = hz.b(bArr, bArr.length + ((this.a.length + 1) * jz.b));
        hz.a(b, jzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            kz[] kzVarArr = this.a;
            if (i >= kzVarArr.length) {
                return Arrays.copyOf(jzVar.b(), jz.b);
            }
            kz kzVar = kzVarArr[i];
            i++;
            int length = bArr.length + (jz.b * i);
            jzVar.a(kzVar.b(b, 0, length), kzVar.a(), kzVar.c(), kzVar.d());
            hz.a(b, jzVar.b(), length);
        }
    }
}
