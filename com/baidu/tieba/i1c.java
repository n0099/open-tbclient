package com.baidu.tieba;

import android.os.Looper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes6.dex */
public final class i1c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<i1c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final b1c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947802094, "Lcom/baidu/tieba/i1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947802094, "Lcom/baidu/tieba/i1c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static i1c a() {
        i1c i1cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                i1c i1cVar2 = b.get();
                if (i1cVar2 != null) {
                    return i1cVar2;
                }
                i1cVar = new i1c();
            } while (!b.compareAndSet(null, i1cVar));
            return i1cVar;
        }
        return (i1c) invokeV.objValue;
    }

    public static b1c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (b1c) invokeV.objValue;
    }

    public i1c() {
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
        b1c b2 = g1c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new j1c(Looper.getMainLooper());
        }
    }
}
