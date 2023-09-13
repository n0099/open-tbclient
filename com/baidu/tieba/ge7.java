package com.baidu.tieba;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.elementsMaven.EMABTest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class ge7 {
    public static /* synthetic */ Interceptable $ic;
    public static final ge7 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947791120, "Lcom/baidu/tieba/ge7;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947791120, "Lcom/baidu/tieba/ge7;");
                return;
            }
        }
        a = new ge7();
    }

    public ge7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final int a(String resName) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, resName)) == null) {
            Intrinsics.checkNotNullParameter(resName, "resName");
            try {
                return a67.a.getResources().getIdentifier(resName, EMABTest.TYPE_STRING, a67.a.getPackageName());
            } catch (Exception e) {
                BdLog.e(e);
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
