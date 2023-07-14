package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class d90 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static volatile d90 c;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, c90> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947659246, "Lcom/baidu/tieba/d90;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947659246, "Lcom/baidu/tieba/d90;");
                return;
            }
        }
        b = AppConfig.isDebug();
        c = null;
    }

    public d90() {
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
        this.a = new HashMap(10);
    }

    public static d90 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (c == null) {
                synchronized (d90.class) {
                    if (c == null) {
                        c = new d90();
                    }
                }
            }
            return c;
        }
        return (d90) invokeV.objValue;
    }

    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            c(str, System.currentTimeMillis());
        }
    }

    public void d(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            e(str, System.currentTimeMillis());
        }
    }

    public void c(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, j) == null) {
            if (!a90.a()) {
                if (b) {
                    Log.e("PlainEventMonitor", "keyevent is disable!");
                    return;
                }
                return;
            }
            c90 remove = this.a.remove(str);
            if (remove != null) {
                remove.d = j;
                b90.c().d(remove);
                return;
            }
            Log.e("PlainEventMonitor", "plain end event do not start:" + str);
        }
    }

    public void e(String str, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(1048579, this, str, j) == null) {
            if (!a90.a()) {
                if (b) {
                    Log.e("PlainEventMonitor", "keyevent is disable!");
                }
            } else if (!TextUtils.isEmpty(str) && j > 0) {
                c90 c90Var = new c90(str);
                c90Var.c = j;
                this.a.put(str, c90Var);
            } else {
                Log.e("PlainEventMonitor", "name and timestamps error!");
            }
        }
    }
}
