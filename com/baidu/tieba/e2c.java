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
/* loaded from: classes5.dex */
public final class e2c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<e2c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final x1c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947683891, "Lcom/baidu/tieba/e2c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947683891, "Lcom/baidu/tieba/e2c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static e2c a() {
        e2c e2cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                e2c e2cVar2 = b.get();
                if (e2cVar2 != null) {
                    return e2cVar2;
                }
                e2cVar = new e2c();
            } while (!b.compareAndSet(null, e2cVar));
            return e2cVar;
        }
        return (e2c) invokeV.objValue;
    }

    public static x1c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (x1c) invokeV.objValue;
    }

    public e2c() {
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
        x1c b2 = c2c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new f2c(Looper.getMainLooper());
        }
    }
}
