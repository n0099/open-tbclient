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
/* loaded from: classes6.dex */
public class ig4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile ig4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<fy1, hg4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947852531, "Lcom/baidu/tieba/ig4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947852531, "Lcom/baidu/tieba/ig4;");
                return;
            }
        }
        b = js1.a;
        c = ig4.class.getSimpleName();
    }

    public ig4() {
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
        gg4.a();
        this.a = new HashMap();
    }

    public static ig4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (ig4.class) {
                    if (d == null) {
                        d = new ig4();
                    }
                }
            }
            return d;
        }
        return (ig4) invokeV.objValue;
    }

    public static void d(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, fy1Var) == null) {
            synchronized (ig4.class) {
                if (d != null) {
                    d.c(fy1Var).h();
                }
            }
        }
    }

    public static void e(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, fy1Var) == null) {
            synchronized (ig4.class) {
                if (d != null) {
                    d.f(fy1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, fy1Var) == null) {
            synchronized (ig4.class) {
                if (d != null) {
                    d.c(fy1Var).k();
                }
            }
        }
    }

    public synchronized hg4 c(fy1 fy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, fy1Var)) == null) {
            synchronized (this) {
                if (fy1Var == null) {
                    return null;
                }
                hg4 hg4Var = this.a.get(fy1Var);
                if (hg4Var == null) {
                    hg4Var = new hg4();
                    this.a.put(fy1Var, hg4Var);
                }
                return hg4Var;
            }
        }
        return (hg4) invokeL.objValue;
    }

    public final synchronized void f(fy1 fy1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, fy1Var) == null) {
            synchronized (this) {
                if (fy1Var == null) {
                    return;
                }
                hg4 remove = this.a.remove(fy1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, ly2 ly2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ly2Var)) == null) {
            z82.i("map", "map create start");
            if (tp3.m(ly2Var.c) != null && ly2Var.isValid()) {
                hy1 A = mx2.T().A(ly2Var.c);
                if (!(A instanceof fy1)) {
                    z82.c("map", "WebViewManager is null");
                    return false;
                }
                hg4 c2 = c((fy1) A);
                if (c2.d(ly2Var.b) != null) {
                    z82.c("map", "map with id " + ly2Var.b + " exist");
                    return false;
                }
                jh4 K = jh4.K(context, ly2Var);
                if (K == null) {
                    z82.c("map", "map with id " + ly2Var.b + " model is invalid");
                    return false;
                }
                q72 insert = K.insert();
                if (!insert.a()) {
                    z82.c("map", "map with id " + ly2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    z82.i("map", "map with id " + ly2Var.b + " init start");
                    ch4.a(context, K, ly2Var, c2);
                    z82.i("map", "map with id " + ly2Var.b + " init end");
                    z82.i("map", "map create end");
                    return true;
                }
            }
            z82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ly2 ly2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ly2Var)) == null) {
            z82.i("map", "map remove start");
            if (tp3.m(ly2Var.c) == null) {
                z82.c("map", "webView is null or mapModel is null");
                return false;
            }
            hy1 A = mx2.T().A(ly2Var.c);
            if (!(A instanceof fy1)) {
                z82.c("map", "WebViewManager is null");
                return false;
            }
            hg4 c2 = c((fy1) A);
            jh4 d2 = c2.d(ly2Var.b);
            if (d2 == null) {
                z82.c("map", "remove map with id " + ly2Var.b + " not exist");
                return false;
            } else if (!c2.j(ly2Var.b)) {
                return false;
            } else {
                z82.i("map", "map remove end");
                if (m82.a(ly2Var) == null) {
                    s82.a("map", "remove with a null map component");
                }
                q72 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    z82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, ly2 ly2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ly2Var)) == null) {
            z82.i("map", "map update start");
            if (tp3.m(ly2Var.c) == null) {
                z82.c("map", "webView is null or mapModel is null");
                return false;
            }
            hy1 A = mx2.T().A(ly2Var.c);
            if (A != null && (A instanceof fy1)) {
                hg4 c2 = c((fy1) A);
                jh4 d2 = c2.d(ly2Var.b);
                if (d2 == null) {
                    z82.c("map", "remove map with id " + ly2Var.b + " not exist");
                    return false;
                }
                d2.F();
                ch4.b(context, d2, ly2Var, c2, true);
                z82.i("map", "map update end");
                if (m82.a(ly2Var) == null) {
                    s82.a("map", "update with a null map component");
                }
                q72 update = d2.update((jh4) ly2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    z82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            z82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
