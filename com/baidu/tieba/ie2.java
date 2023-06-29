package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes6.dex */
public class ie2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static AtomicInteger b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947850547, "Lcom/baidu/tieba/ie2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947850547, "Lcom/baidu/tieba/ie2;");
                return;
            }
        }
        a = ms1.a;
        b = new AtomicInteger(0);
    }

    public static boolean a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (str != null && str.startsWith("master")) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            String str = "master";
            if (!cg2.h()) {
                return "master";
            }
            int andIncrement = b.getAndIncrement();
            if (andIncrement >= 1) {
                str = "master" + andIncrement;
            }
            if (a) {
                Log.i("MasterIdGenerator", "next master id - " + str);
            }
            return str;
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            int andSet = b.getAndSet(0);
            if (a) {
                Log.i("MasterIdGenerator", "last master id - " + andSet);
            }
            return andSet;
        }
        return invokeV.intValue;
    }
}
