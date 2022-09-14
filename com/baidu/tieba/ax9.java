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
public final class ax9 {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicReference<ax9> b;
    public transient /* synthetic */ FieldHolder $fh;
    public final tw9 a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947630695, "Lcom/baidu/tieba/ax9;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947630695, "Lcom/baidu/tieba/ax9;");
                return;
            }
        }
        b = new AtomicReference<>();
    }

    public ax9() {
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
        tw9 b2 = yw9.a().b().b();
        if (b2 != null) {
            this.a = b2;
        } else {
            this.a = new bx9(Looper.getMainLooper());
        }
    }

    public static ax9 a() {
        ax9 ax9Var;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            do {
                ax9 ax9Var2 = b.get();
                if (ax9Var2 != null) {
                    return ax9Var2;
                }
                ax9Var = new ax9();
            } while (!b.compareAndSet(null, ax9Var));
            return ax9Var;
        }
        return (ax9) invokeV.objValue;
    }

    public static tw9 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? a().a : (tw9) invokeV.objValue;
    }
}
