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
public class i54 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile i54 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<gn1, h54> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947804481, "Lcom/baidu/tieba/i54;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947804481, "Lcom/baidu/tieba/i54;");
                return;
            }
        }
        b = kh1.a;
        c = i54.class.getSimpleName();
    }

    public i54() {
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
        g54.a();
        this.a = new HashMap();
    }

    public static i54 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (i54.class) {
                    if (d == null) {
                        d = new i54();
                    }
                }
            }
            return d;
        }
        return (i54) invokeV.objValue;
    }

    public static void d(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, gn1Var) == null) {
            synchronized (i54.class) {
                if (d != null) {
                    d.c(gn1Var).h();
                }
            }
        }
    }

    public static void e(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, gn1Var) == null) {
            synchronized (i54.class) {
                if (d != null) {
                    d.f(gn1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, gn1Var) == null) {
            synchronized (i54.class) {
                if (d != null) {
                    d.c(gn1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, mn2 mn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, mn2Var)) == null) {
            ay1.i("map", "map create start");
            if (ue3.m(mn2Var.c) != null && mn2Var.isValid()) {
                in1 A = nm2.U().A(mn2Var.c);
                if (!(A instanceof gn1)) {
                    ay1.c("map", "WebViewManager is null");
                    return false;
                }
                h54 c2 = c((gn1) A);
                if (c2.d(mn2Var.b) != null) {
                    ay1.c("map", "map with id " + mn2Var.b + " exist");
                    return false;
                }
                j64 K = j64.K(context, mn2Var);
                if (K == null) {
                    ay1.c("map", "map with id " + mn2Var.b + " model is invalid");
                    return false;
                }
                rw1 insert = K.insert();
                if (!insert.a()) {
                    ay1.c("map", "map with id " + mn2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    ay1.i("map", "map with id " + mn2Var.b + " init start");
                    c64.a(context, K, mn2Var, c2);
                    ay1.i("map", "map with id " + mn2Var.b + " init end");
                    ay1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            ay1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized h54 c(gn1 gn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gn1Var)) == null) {
            synchronized (this) {
                if (gn1Var == null) {
                    return null;
                }
                h54 h54Var = this.a.get(gn1Var);
                if (h54Var == null) {
                    h54Var = new h54();
                    this.a.put(gn1Var, h54Var);
                }
                return h54Var;
            }
        }
        return (h54) invokeL.objValue;
    }

    public final synchronized void f(gn1 gn1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gn1Var) == null) {
            synchronized (this) {
                if (gn1Var == null) {
                    return;
                }
                h54 remove = this.a.remove(gn1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(mn2 mn2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, mn2Var)) == null) {
            ay1.i("map", "map remove start");
            if (ue3.m(mn2Var.c) == null) {
                ay1.c("map", "webView is null or mapModel is null");
                return false;
            }
            in1 A = nm2.U().A(mn2Var.c);
            if (!(A instanceof gn1)) {
                ay1.c("map", "WebViewManager is null");
                return false;
            }
            h54 c2 = c((gn1) A);
            j64 d2 = c2.d(mn2Var.b);
            if (d2 == null) {
                ay1.c("map", "remove map with id " + mn2Var.b + " not exist");
                return false;
            } else if (c2.j(mn2Var.b)) {
                ay1.i("map", "map remove end");
                if (nx1.a(mn2Var) == null) {
                    tx1.a("map", "remove with a null map component");
                }
                rw1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    ay1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, mn2 mn2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, mn2Var)) == null) {
            ay1.i("map", "map update start");
            if (ue3.m(mn2Var.c) == null) {
                ay1.c("map", "webView is null or mapModel is null");
                return false;
            }
            in1 A = nm2.U().A(mn2Var.c);
            if (A != null && (A instanceof gn1)) {
                h54 c2 = c((gn1) A);
                j64 d2 = c2.d(mn2Var.b);
                if (d2 == null) {
                    ay1.c("map", "remove map with id " + mn2Var.b + " not exist");
                    return false;
                }
                d2.F();
                c64.b(context, d2, mn2Var, c2, true);
                ay1.i("map", "map update end");
                if (nx1.a(mn2Var) == null) {
                    tx1.a("map", "update with a null map component");
                }
                rw1 update = d2.update((j64) mn2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    ay1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            ay1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
