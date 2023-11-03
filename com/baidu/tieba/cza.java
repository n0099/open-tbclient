package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class cza {
    public static /* synthetic */ Interceptable $ic;
    public static final cza a;
    public static final Map<String, dza> b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947693439, "Lcom/baidu/tieba/cza;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947693439, "Lcom/baidu/tieba/cza;");
                return;
            }
        }
        a = new cza();
        b = new LinkedHashMap();
    }

    public cza() {
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

    public final boolean a(String tid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            return b.containsKey(tid);
        }
        return invokeL.booleanValue;
    }

    public final dza b(String tid) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tid)) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            dza dzaVar = b.get(tid);
            if (dzaVar == null) {
                dzaVar = new dza();
            }
            b.put(tid, dzaVar);
            return dzaVar;
        }
        return (dza) invokeL.objValue;
    }

    public final void c(String tid) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tid) == null) {
            Intrinsics.checkNotNullParameter(tid, "tid");
            dza remove = b.remove(tid);
            if (remove != null) {
                remove.a();
            }
        }
    }
}
