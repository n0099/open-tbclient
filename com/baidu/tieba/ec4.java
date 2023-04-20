package com.baidu.tieba;

import android.content.Context;
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
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class ec4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile ec4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<bu1, dc4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947729523, "Lcom/baidu/tieba/ec4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947729523, "Lcom/baidu/tieba/ec4;");
                return;
            }
        }
        b = fo1.a;
        c = ec4.class.getSimpleName();
    }

    public ec4() {
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
        cc4.a();
        this.a = new HashMap();
    }

    public static ec4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ec4.class) {
                    if (d == null) {
                        d = new ec4();
                    }
                }
            }
            return d;
        }
        return (ec4) invokeV.objValue;
    }

    public static void d(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, bu1Var) == null) {
            synchronized (ec4.class) {
                if (d != null) {
                    d.c(bu1Var).h();
                }
            }
        }
    }

    public static void e(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bu1Var) == null) {
            synchronized (ec4.class) {
                if (d != null) {
                    d.f(bu1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, bu1Var) == null) {
            synchronized (ec4.class) {
                if (d != null) {
                    d.c(bu1Var).k();
                }
            }
        }
    }

    public synchronized dc4 c(bu1 bu1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bu1Var)) == null) {
            synchronized (this) {
                if (bu1Var == null) {
                    return null;
                }
                dc4 dc4Var = this.a.get(bu1Var);
                if (dc4Var == null) {
                    dc4Var = new dc4();
                    this.a.put(bu1Var, dc4Var);
                }
                return dc4Var;
            }
        }
        return (dc4) invokeL.objValue;
    }

    public final synchronized void f(bu1 bu1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bu1Var) == null) {
            synchronized (this) {
                if (bu1Var == null) {
                    return;
                }
                dc4 remove = this.a.remove(bu1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, hu2 hu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, hu2Var)) == null) {
            v42.i("map", "map create start");
            if (pl3.m(hu2Var.c) != null && hu2Var.isValid()) {
                du1 A = it2.U().A(hu2Var.c);
                if (!(A instanceof bu1)) {
                    v42.c("map", "WebViewManager is null");
                    return false;
                }
                dc4 c2 = c((bu1) A);
                if (c2.d(hu2Var.b) != null) {
                    v42.c("map", "map with id " + hu2Var.b + " exist");
                    return false;
                }
                fd4 K = fd4.K(context, hu2Var);
                if (K == null) {
                    v42.c("map", "map with id " + hu2Var.b + " model is invalid");
                    return false;
                }
                m32 insert = K.insert();
                if (!insert.a()) {
                    v42.c("map", "map with id " + hu2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    v42.i("map", "map with id " + hu2Var.b + " init start");
                    yc4.a(context, K, hu2Var, c2);
                    v42.i("map", "map with id " + hu2Var.b + " init end");
                    v42.i("map", "map create end");
                    return true;
                }
            }
            v42.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(hu2 hu2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hu2Var)) == null) {
            v42.i("map", "map remove start");
            if (pl3.m(hu2Var.c) == null) {
                v42.c("map", "webView is null or mapModel is null");
                return false;
            }
            du1 A = it2.U().A(hu2Var.c);
            if (!(A instanceof bu1)) {
                v42.c("map", "WebViewManager is null");
                return false;
            }
            dc4 c2 = c((bu1) A);
            fd4 d2 = c2.d(hu2Var.b);
            if (d2 == null) {
                v42.c("map", "remove map with id " + hu2Var.b + " not exist");
                return false;
            } else if (!c2.j(hu2Var.b)) {
                return false;
            } else {
                v42.i("map", "map remove end");
                if (i42.a(hu2Var) == null) {
                    o42.a("map", "remove with a null map component");
                }
                m32 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    v42.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, hu2 hu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, hu2Var)) == null) {
            v42.i("map", "map update start");
            if (pl3.m(hu2Var.c) == null) {
                v42.c("map", "webView is null or mapModel is null");
                return false;
            }
            du1 A = it2.U().A(hu2Var.c);
            if (A != null && (A instanceof bu1)) {
                dc4 c2 = c((bu1) A);
                fd4 d2 = c2.d(hu2Var.b);
                if (d2 == null) {
                    v42.c("map", "remove map with id " + hu2Var.b + " not exist");
                    return false;
                }
                d2.F();
                yc4.b(context, d2, hu2Var, c2, true);
                v42.i("map", "map update end");
                if (i42.a(hu2Var) == null) {
                    o42.a("map", "update with a null map component");
                }
                m32 update = d2.update((fd4) hu2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    v42.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            v42.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
