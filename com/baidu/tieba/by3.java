package com.baidu.tieba;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class by3 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String b = "by3";
    public static final boolean c;
    public static SharedPreferences d;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public final void e(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2) == null) {
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947661261, "Lcom/baidu/tieba/by3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947661261, "Lcom/baidu/tieba/by3;");
                return;
            }
        }
        c = ms1.a;
        d = null;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && c) {
            String str = b;
            Log.d(str, "新旧版本一样:" + b(this.a));
        }
    }

    public by3(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = context;
    }

    public static int a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e) {
                if (c) {
                    String str = b;
                    Log.e(str, "error:" + e.getMessage());
                    return -1;
                }
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public final int b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            int i = c(context).getInt("old_versioncode_key", 0);
            if (c) {
                String str = b;
                Log.d(str, "get old versioncode:" + i);
            }
            return i;
        }
        return invokeL.intValue;
    }

    public static SharedPreferences c(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (d == null) {
                d = context.getSharedPreferences("downgradefile", 0);
            }
            return d;
        }
        return (SharedPreferences) invokeL.objValue;
    }

    public static by3 d(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            return new by3(context);
        }
        return (by3) invokeL.objValue;
    }

    public final void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            do3.d(0, i);
        }
    }

    public static void j(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65541, null, context, i) == null) {
            if (c) {
                String str = b;
                Log.d(str, "set last version code:" + i);
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("last_versioncode_key", i);
            edit.apply();
        }
    }

    public final void k(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048582, this, context, i) == null) {
            if (c) {
                String str = b;
                Log.d(str, "set new versioncode:" + i);
            }
            SharedPreferences.Editor edit = c(context).edit();
            edit.putInt("old_versioncode_key", i);
            edit.apply();
        }
    }

    public final void h(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            do3.d(i2, i);
            rl2.d.u();
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            int a = a(this.a);
            int b2 = b(this.a);
            if (c) {
                String str = b;
                Log.d(str, "处理升级逻辑：newVersionCode=" + a + " /oldVersionCode=" + b2);
            }
            if (b2 == 0) {
                f(a);
                k(this.a, a);
                j(this.a, b2);
            } else if (a > b2) {
                h(a, b2);
                k(this.a, a);
                j(this.a, b2);
            } else if (a < b2) {
                e(a, b2);
                k(this.a, a);
                j(this.a, b2);
            } else {
                g();
            }
        }
    }
}
