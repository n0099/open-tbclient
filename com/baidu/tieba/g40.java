package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class g40 {
    public static /* synthetic */ Interceptable $ic = null;
    public static int b = 5;
    public static int c = 40;
    public transient /* synthetic */ FieldHolder $fh;
    public com.baidu.helios.common.cc.a a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947743814, "Lcom/baidu/tieba/g40;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947743814, "Lcom/baidu/tieba/g40;");
        }
    }

    public g40() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        com.baidu.helios.common.cc.a aVar = new com.baidu.helios.common.cc.a(c);
        this.a = aVar;
        aVar.a(0, c, true);
    }

    public void a(com.baidu.helios.common.cc.a aVar, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIII(1048576, this, aVar, i, i2, i3) == null) {
            com.baidu.helios.common.cc.a d = this.a.d(i, i + i2);
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        d.e(aVar);
                    } else if (i3 == 3) {
                        d.c(aVar);
                    }
                }
                d.d(aVar);
            } else {
                d.b(aVar);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                this.a.a(i + i4, d.d(i4));
            }
        }
    }

    public byte[] b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.a() : (byte[]) invokeV.objValue;
    }
}
