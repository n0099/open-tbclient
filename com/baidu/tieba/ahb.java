package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class ahb {
    public static /* synthetic */ Interceptable $ic;
    public static final AtomicBoolean a;
    public static HashMap<Integer, Boolean> b;
    public static HashMap<Integer, Long> c;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947616590, "Lcom/baidu/tieba/ahb;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947616590, "Lcom/baidu/tieba/ahb;");
                return;
            }
        }
        a = new AtomicBoolean(false);
        b = new HashMap<>();
        c = new HashMap<>();
    }

    public static long a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, null, i)) == null) {
            if (c.containsKey(Integer.valueOf(i))) {
                return c.get(Integer.valueOf(i)).longValue();
            }
            return Long.MAX_VALUE;
        }
        return invokeI.longValue;
    }

    public static SharedPreferences b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            return context.getSharedPreferences("CONFIG_RUNTIME", 0);
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static boolean d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            if (b.containsKey(Integer.valueOf(i))) {
                return b.get(Integer.valueOf(i)).booleanValue();
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public static synchronized void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (ahb.class) {
                if (!a.get()) {
                    SharedPreferences b2 = b(context);
                    Iterator<Integer> it = bhb.a.iterator();
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        HashMap<Integer, Long> hashMap = c;
                        Integer valueOf = Integer.valueOf(intValue);
                        hashMap.put(valueOf, Long.valueOf(b2.getLong("cache_" + intValue, 10080L)));
                        HashMap<Integer, Boolean> hashMap2 = b;
                        Integer valueOf2 = Integer.valueOf(intValue);
                        hashMap2.put(valueOf2, Boolean.valueOf(b2.getBoolean("close_" + intValue, false)));
                    }
                    c.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Long.MAX_VALUE);
                    b.put(Integer.valueOf((int) ShareCallPacking.REQUEST_CODE_V2_SHARE_ACCOUNT), Boolean.TRUE);
                    a.set(true);
                }
            }
        }
    }
}
