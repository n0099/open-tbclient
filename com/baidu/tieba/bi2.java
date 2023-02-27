package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes3.dex */
public class bi2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final Map<String, Integer> b;
    public static final Object c;
    public static boolean d;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947645854, "Lcom/baidu/tieba/bi2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947645854, "Lcom/baidu/tieba/bi2;");
                return;
            }
        }
        a = wp1.a;
        b = new HashMap();
        c = new Object();
        d = ci2.a();
    }

    @NonNull
    public static Set<String> b() {
        InterceptResult invokeV;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!d) {
                return Collections.emptySet();
            }
            synchronized (c) {
                strArr = (String[]) b.keySet().toArray(new String[0]);
            }
            return qn3.a(strArr);
        }
        return (Set) invokeV.objValue;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65537, null) != null) || !d) {
            return;
        }
        if (a) {
            Log.d("ExcludeRecorder", "remove all exclude appIds");
        }
        synchronized (c) {
            b.clear();
        }
    }

    public static boolean c(String str) {
        InterceptResult invokeL;
        boolean containsKey;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (!d || TextUtils.isEmpty(str)) {
                return false;
            }
            synchronized (c) {
                containsKey = b.containsKey(str);
            }
            if (a) {
                Log.d("ExcludeRecorder", "appId - " + str + " needExclude - " + containsKey);
            }
            return containsKey;
        }
        return invokeL.booleanValue;
    }

    public static void d(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str) != null) || !d) {
            return;
        }
        if (a) {
            Log.d("ExcludeRecorder", "record one appId for exclude - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (c) {
            Integer num = b.get(str);
            if (num == null) {
                b.put(str, 1);
            } else {
                b.put(str, Integer.valueOf(num.intValue() + 1));
            }
        }
    }

    public static void f(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65542, null, str) != null) || !d) {
            return;
        }
        if (a) {
            Log.d("ExcludeRecorder", "remove one appId for exclude - " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (c) {
            Integer num = b.get(str);
            if (num != null) {
                int intValue = num.intValue() - 1;
                if (intValue <= 0) {
                    b.remove(str);
                } else {
                    b.put(str, Integer.valueOf(intValue));
                }
            }
        }
    }

    public static void e(um4 um4Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65541, null, um4Var) == null) && d && um4Var != null) {
            for (ki4 ki4Var : um4Var.j()) {
                if (ki4Var instanceof li4) {
                    d(ki4Var.g);
                } else if (ki4Var instanceof mi4) {
                    d(((mi4) ki4Var).o);
                }
            }
        }
    }
}
