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
/* loaded from: classes5.dex */
public class eg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile eg4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<by1, dg4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947733367, "Lcom/baidu/tieba/eg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947733367, "Lcom/baidu/tieba/eg4;");
                return;
            }
        }
        b = fs1.a;
        c = eg4.class.getSimpleName();
    }

    public eg4() {
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
        cg4.a();
        this.a = new HashMap();
    }

    public static eg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (eg4.class) {
                    if (d == null) {
                        d = new eg4();
                    }
                }
            }
            return d;
        }
        return (eg4) invokeV.objValue;
    }

    public static void d(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, by1Var) == null) {
            synchronized (eg4.class) {
                if (d != null) {
                    d.c(by1Var).h();
                }
            }
        }
    }

    public static void e(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, by1Var) == null) {
            synchronized (eg4.class) {
                if (d != null) {
                    d.f(by1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, by1Var) == null) {
            synchronized (eg4.class) {
                if (d != null) {
                    d.c(by1Var).k();
                }
            }
        }
    }

    public synchronized dg4 c(by1 by1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, by1Var)) == null) {
            synchronized (this) {
                if (by1Var == null) {
                    return null;
                }
                dg4 dg4Var = this.a.get(by1Var);
                if (dg4Var == null) {
                    dg4Var = new dg4();
                    this.a.put(by1Var, dg4Var);
                }
                return dg4Var;
            }
        }
        return (dg4) invokeL.objValue;
    }

    public final synchronized void f(by1 by1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, by1Var) == null) {
            synchronized (this) {
                if (by1Var == null) {
                    return;
                }
                dg4 remove = this.a.remove(by1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, hy2 hy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, hy2Var)) == null) {
            v82.i("map", "map create start");
            if (pp3.m(hy2Var.c) != null && hy2Var.isValid()) {
                dy1 A = ix2.T().A(hy2Var.c);
                if (!(A instanceof by1)) {
                    v82.c("map", "WebViewManager is null");
                    return false;
                }
                dg4 c2 = c((by1) A);
                if (c2.d(hy2Var.b) != null) {
                    v82.c("map", "map with id " + hy2Var.b + " exist");
                    return false;
                }
                fh4 K = fh4.K(context, hy2Var);
                if (K == null) {
                    v82.c("map", "map with id " + hy2Var.b + " model is invalid");
                    return false;
                }
                m72 insert = K.insert();
                if (!insert.a()) {
                    v82.c("map", "map with id " + hy2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    v82.i("map", "map with id " + hy2Var.b + " init start");
                    yg4.a(context, K, hy2Var, c2);
                    v82.i("map", "map with id " + hy2Var.b + " init end");
                    v82.i("map", "map create end");
                    return true;
                }
            }
            v82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(hy2 hy2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, hy2Var)) == null) {
            v82.i("map", "map remove start");
            if (pp3.m(hy2Var.c) == null) {
                v82.c("map", "webView is null or mapModel is null");
                return false;
            }
            dy1 A = ix2.T().A(hy2Var.c);
            if (!(A instanceof by1)) {
                v82.c("map", "WebViewManager is null");
                return false;
            }
            dg4 c2 = c((by1) A);
            fh4 d2 = c2.d(hy2Var.b);
            if (d2 == null) {
                v82.c("map", "remove map with id " + hy2Var.b + " not exist");
                return false;
            } else if (!c2.j(hy2Var.b)) {
                return false;
            } else {
                v82.i("map", "map remove end");
                if (i82.a(hy2Var) == null) {
                    o82.a("map", "remove with a null map component");
                }
                m72 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    v82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, hy2 hy2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, hy2Var)) == null) {
            v82.i("map", "map update start");
            if (pp3.m(hy2Var.c) == null) {
                v82.c("map", "webView is null or mapModel is null");
                return false;
            }
            dy1 A = ix2.T().A(hy2Var.c);
            if (A != null && (A instanceof by1)) {
                dg4 c2 = c((by1) A);
                fh4 d2 = c2.d(hy2Var.b);
                if (d2 == null) {
                    v82.c("map", "remove map with id " + hy2Var.b + " not exist");
                    return false;
                }
                d2.F();
                yg4.b(context, d2, hy2Var, c2, true);
                v82.i("map", "map update end");
                if (i82.a(hy2Var) == null) {
                    o82.a("map", "update with a null map component");
                }
                m72 update = d2.update((fh4) hy2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    v82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            v82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
