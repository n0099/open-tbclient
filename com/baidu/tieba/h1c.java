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
public final class h1c {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<h1c> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final a1c a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947772303, "Lcom/baidu/tieba/h1c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947772303, "Lcom/baidu/tieba/h1c;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static h1c a() {
        h1c h1cVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                h1c h1cVar2 = b.get();
                if (h1cVar2 != null) {
                    return h1cVar2;
                }
                h1cVar = new h1c();
            } while (!b.compareAndSet(null, h1cVar));
            return h1cVar;
        }
        return (h1c) invokeV.objValue;
    }

    public static a1c b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (a1c) invokeV.objValue;
    }

    public h1c() {
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
        a1c b2 = f1c.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new i1c(Looper.getMainLooper());
        }
    }
}
