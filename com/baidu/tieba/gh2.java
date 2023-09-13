package com.baidu.tieba;

import android.preference.PreferenceManager;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class gh2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean c;
    public transient /* synthetic */ FieldHolder $fh;
    public ch2 a;
    public HashMap<String, dh2> b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static final gh2 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-775872134, "Lcom/baidu/tieba/gh2$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-775872134, "Lcom/baidu/tieba/gh2$b;");
                    return;
                }
            }
            a = new gh2(null);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947793848, "Lcom/baidu/tieba/gh2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947793848, "Lcom/baidu/tieba/gh2;");
                return;
            }
        }
        c = rr1.a;
    }

    public static gh2 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return b.a;
        }
        return (gh2) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getBoolean("sp_swan_sdcard_preset", false);
        }
        return invokeV.booleanValue;
    }

    public final ch2 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (c && d()) {
                return new fh2();
            }
            return new bh2();
        }
        return (ch2) invokeV.objValue;
    }

    public gh2() {
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
        long currentTimeMillis = System.currentTimeMillis();
        ch2 a2 = a();
        this.a = a2;
        this.b = a2.h();
        if (c) {
            Log.d("SwanAppPresetManager", "构造PresetMap耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public /* synthetic */ gh2(a aVar) {
        this();
    }

    @Nullable
    public dh2 c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            HashMap<String, dh2> hashMap = this.b;
            if (hashMap != null) {
                return hashMap.get(str);
            }
            return null;
        }
        return (dh2) invokeL.objValue;
    }

    public void e(dh2 dh2Var, eh2 eh2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dh2Var, eh2Var) == null) {
            this.a.k(dh2Var, eh2Var);
        }
    }
}
