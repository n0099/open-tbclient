package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class hz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public lz[] a;

    public hz() {
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
        this.a = new lz[]{new mz(8, 0), new nz(0, 1), new nz(1, 1), new mz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        kz kzVar = new kz();
        byte[] b = iz.b(bArr, bArr.length + ((this.a.length + 1) * kz.b));
        iz.a(b, kzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            lz[] lzVarArr = this.a;
            if (i >= lzVarArr.length) {
                return Arrays.copyOf(kzVar.b(), kz.b);
            }
            lz lzVar = lzVarArr[i];
            i++;
            int length = bArr.length + (kz.b * i);
            kzVar.a(lzVar.b(b, 0, length), lzVar.a(), lzVar.c(), lzVar.d());
            iz.a(b, kzVar.b(), length);
        }
    }
}
