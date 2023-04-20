package com.baidu.tieba;

import android.content.Context;
import android.content.Intent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes4.dex */
public final class cp0 {
    public static /* synthetic */ Interceptable $ic;
    public static final cp0 a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682310, "Lcom/baidu/tieba/cp0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682310, "Lcom/baidu/tieba/cp0;");
                return;
            }
        }
        a = new cp0();
    }

    public cp0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public final boolean a(dp0 dp0Var, Context context, Intent intent) {
        InterceptResult invokeLLL;
        int i;
        int b;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, dp0Var, context, intent)) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (dp0Var != null) {
                i = dp0Var.b();
            } else {
                i = -1;
            }
            if (i == 1) {
                int b2 = g71.b(context.getApplicationContext(), null);
                if (b2 == 0) {
                    return false;
                }
                if ((2 == b2 || 1 == b2 || 4 == b2) && intent != null) {
                    intent.putExtra("downgrade_to_native", "1");
                }
                return true;
            } else if (i != 0 || 4 == (b = j91.b(context.getApplicationContext(), null)) || b == 0 || 2 == b || 1 == b) {
                return false;
            } else {
                return true;
            }
        }
        return invokeLLL.booleanValue;
    }
}
