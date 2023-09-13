package com.baidu.tieba;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class d84 implements u84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public d84() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.u84
    public byte[] a(String str, byte[] bArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, str, bArr)) == null) {
            if (str != null && bArr != null) {
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != 76158) {
                    if (hashCode == 1952093519 && str.equals("BASE64")) {
                        c = 1;
                    }
                } else if (str.equals("MD5")) {
                    c = 0;
                }
                if (c != 0) {
                    if (c != 1) {
                        return bArr;
                    }
                    return Base64.encode(bArr, 2);
                }
                return nr4.d(bArr, false).getBytes();
            }
            return bArr;
        }
        return (byte[]) invokeLL.objValue;
    }
}
