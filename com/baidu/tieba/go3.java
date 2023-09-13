package com.baidu.tieba;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class go3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947800606, "Lcom/baidu/tieba/go3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947800606, "Lcom/baidu/tieba/go3;");
                return;
            }
        }
        a = rr1.a;
    }

    public static boolean a(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, activity)) == null) {
            if (activity != null && b(activity.getIntent())) {
                try {
                    qn3.j(activity);
                } catch (Exception unused) {
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, intent)) == null) {
            if (intent != null) {
                try {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        extras.isEmpty();
                        return false;
                    }
                    return false;
                } catch (Throwable unused) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static boolean c(Bundle bundle, String str, boolean z) {
        InterceptResult invokeLLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLZ = interceptable.invokeLLZ(65539, null, bundle, str, z)) == null) {
            try {
                return bundle.getBoolean(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getBoolean failed on bundle " + bundle);
                }
                return z;
            }
        }
        return invokeLLZ.booleanValue;
    }

    public static int f(Bundle bundle, String str, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65542, null, bundle, str, i)) == null) {
            try {
                return bundle.getInt(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getInt failed on bundle " + bundle);
                }
                return i;
            }
        }
        return invokeLLI.intValue;
    }

    public static Bundle d(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, bundle, str)) == null) {
            try {
                return bundle.getBundle(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getBundle failed on bundle " + bundle);
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static Bundle e(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, intent, str)) == null) {
            try {
                return intent.getBundleExtra(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getBundleExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (Bundle) invokeLL.objValue;
    }

    public static String g(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getString failed on bundle " + bundle);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String h(Intent intent, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, intent, str)) == null) {
            try {
                return intent.getStringExtra(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getStringExtra failed on intent " + intent);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }

    public static String i(Bundle bundle, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, bundle, str)) == null) {
            try {
                return bundle.getString(str);
            } catch (Throwable unused) {
                if (a) {
                    Log.e("IntentUtils", "getStringExtra failed on bundle " + bundle);
                    return null;
                }
                return null;
            }
        }
        return (String) invokeLL.objValue;
    }
}
