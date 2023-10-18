package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes5.dex */
public class cu {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public gu[] a;

    public cu() {
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
        this.a = new gu[]{new hu(8, 0), new iu(0, 1), new iu(1, 1), new hu(7, 1)};
    }

    public byte[] a(byte[] bArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(1048576, this, bArr)) != null) {
            return (byte[]) invokeL.objValue;
        }
        fu fuVar = new fu();
        byte[] b = du.b(bArr, bArr.length + ((this.a.length + 1) * fu.b));
        du.a(b, fuVar.b(), bArr.length);
        int i = 0;
        while (true) {
            gu[] guVarArr = this.a;
            if (i >= guVarArr.length) {
                return Arrays.copyOf(fuVar.b(), fu.b);
            }
            gu guVar = guVarArr[i];
            i++;
            int length = bArr.length + (fu.b * i);
            fuVar.a(guVar.b(b, 0, length), guVar.a(), guVar.c(), guVar.d());
            du.a(b, fuVar.b(), length);
        }
    }
}
