package com.baidu.tieba;

import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ah2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947615102, "Lcom/baidu/tieba/ah2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947615102, "Lcom/baidu/tieba/ah2;");
                return;
            }
        }
        a = rr1.a;
    }

    @NonNull
    public static yg2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            yg2 b = b(c());
            if (a) {
                Log.d("PrelinkStrategyFactory", "prelink strategy - " + b.getClass().getSimpleName());
            }
            return b;
        }
        return (yg2) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            ou2.g0().getSwitch("swan_prelink_policy_when_prefetch", 0);
            if (a) {
                Log.d("PrelinkStrategyFactory", "swan_prelink_policy_when_prefetch = 0");
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public static yg2 b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i)) == null) {
            if (i == 0) {
                return new wg2();
            }
            if (i > 0) {
                return new zg2(i);
            }
            if (i == -1) {
                return new xg2();
            }
            return new wg2();
        }
        return (yg2) invokeI.objValue;
    }
}
