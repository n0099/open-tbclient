package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class cz {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gz[] a;

    public cz() {
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
        this.a = new gz[]{new hz(8, 0), new iz(0, 1), new iz(1, 1), new hz(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        fz fzVar = new fz();
        byte[] b = dz.b(bArr, bArr.length + ((this.a.length + 1) * fz.b));
        dz.a(b, fzVar.b(), bArr.length);
        int i = 0;
        while (true) {
            gz[] gzVarArr = this.a;
            if (i >= gzVarArr.length) {
                return Arrays.copyOf(fzVar.b(), fz.b);
            }
            gz gzVar = gzVarArr[i];
            i++;
            int length = bArr.length + (fz.b * i);
            fzVar.a(gzVar.b(b, 0, length), gzVar.a(), gzVar.c(), gzVar.d());
            dz.a(b, fzVar.b(), length);
        }
    }
}
