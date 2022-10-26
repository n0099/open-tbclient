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
public final class hy9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference b;
    public transient /* synthetic */ FieldHolder $fh;
    public final ay9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947840193, "Lcom/baidu/tieba/hy9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947840193, "Lcom/baidu/tieba/hy9;");
                return;
            }
        }
        b = new AtomicReference();
    }

    public static hy9 a() {
        hy9 hy9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                hy9 hy9Var2 = (hy9) b.get();
                if (hy9Var2 != null) {
                    return hy9Var2;
                }
                hy9Var = new hy9();
            } while (!b.compareAndSet(null, hy9Var));
            return hy9Var;
        }
        return (hy9) invokeV.objValue;
    }

    public static ay9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return a().a;
        }
        return (ay9) invokeV.objValue;
    }

    public hy9() {
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
        ay9 b2 = fy9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new iy9(Looper.getMainLooper());
        }
    }
}
