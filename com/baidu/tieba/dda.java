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
/* loaded from: classes4.dex */
public final class dda {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<dda> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final wca a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947702088, "Lcom/baidu/tieba/dda;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947702088, "Lcom/baidu/tieba/dda;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static dda a() {
        dda ddaVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                dda ddaVar2 = b.get();
                if (ddaVar2 != null) {
                    return ddaVar2;
                }
                ddaVar = new dda();
            } while (!b.compareAndSet(null, ddaVar));
            return ddaVar;
        }
        return (dda) invokeV.objValue;
    }

    public static wca b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (wca) invokeV.objValue;
    }

    public dda() {
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
        wca b2 = bda.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new eda(Looper.getMainLooper());
        }
    }
}
