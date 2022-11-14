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
public final class b0a {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<b0a> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final uz9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947592534, "Lcom/baidu/tieba/b0a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947592534, "Lcom/baidu/tieba/b0a;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static b0a a() {
        b0a b0aVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                b0a b0aVar2 = b.get();
                if (b0aVar2 != null) {
                    return b0aVar2;
                }
                b0aVar = new b0a();
            } while (!b.compareAndSet(null, b0aVar));
            return b0aVar;
        }
        return (b0a) invokeV.objValue;
    }

    public static uz9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (uz9) invokeV.objValue;
    }

    public b0a() {
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
        uz9 b2 = zz9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new c0a(Looper.getMainLooper());
        }
    }
}
