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
public final class cbc {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<cbc> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final vac a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947670437, "Lcom/baidu/tieba/cbc;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947670437, "Lcom/baidu/tieba/cbc;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static cbc a() {
        cbc cbcVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                cbc cbcVar2 = b.get();
                if (cbcVar2 != null) {
                    return cbcVar2;
                }
                cbcVar = new cbc();
            } while (!b.compareAndSet(null, cbcVar));
            return cbcVar;
        }
        return (cbc) invokeV.objValue;
    }

    public static vac b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (vac) invokeV.objValue;
    }

    public cbc() {
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
        vac b2 = abc.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new dbc(Looper.getMainLooper());
        }
    }
}
