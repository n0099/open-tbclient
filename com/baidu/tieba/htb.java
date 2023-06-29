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
public final class htb {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<htb> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final atb a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947836659, "Lcom/baidu/tieba/htb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947836659, "Lcom/baidu/tieba/htb;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public static htb a() {
        htb htbVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                htb htbVar2 = b.get();
                if (htbVar2 != null) {
                    return htbVar2;
                }
                htbVar = new htb();
            } while (!b.compareAndSet(null, htbVar));
            return htbVar;
        }
        return (htb) invokeV.objValue;
    }

    public static atb b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (atb) invokeV.objValue;
    }

    public htb() {
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
        atb b2 = ftb.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new itb(Looper.getMainLooper());
        }
    }
}
