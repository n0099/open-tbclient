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
/* loaded from: classes3.dex */
public final class c0a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<c0a> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final vz9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947622325, "Lcom/baidu/tieba/c0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947622325, "Lcom/baidu/tieba/c0a;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static c0a a() {
        c0a c0aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                c0a c0aVar2 = b.get();
                if (c0aVar2 != null) {
                    return c0aVar2;
                }
                c0aVar = new c0a();
            } while (!b.compareAndSet(null, c0aVar));
            return c0aVar;
        }
        return (c0a) invokeV.objValue;
    }

    public static vz9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (vz9) invokeV.objValue;
    }

    public c0a() {
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
        vz9 b2 = a0a.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new d0a(Looper.getMainLooper());
        }
    }
}
