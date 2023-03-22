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
/* loaded from: classes3.dex */
public class cc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile cc4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<zt1, bc4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947669941, "Lcom/baidu/tieba/cc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947669941, "Lcom/baidu/tieba/cc4;");
                return;
            }
        }
        b = do1.a;
        c = cc4.class.getSimpleName();
    }

    public cc4() {
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
        ac4.a();
        this.a = new HashMap();
    }

    public static cc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (cc4.class) {
                    if (d == null) {
                        d = new cc4();
                    }
                }
            }
            return d;
        }
        return (cc4) invokeV.objValue;
    }

    public static void d(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, zt1Var) == null) {
            synchronized (cc4.class) {
                if (d != null) {
                    d.c(zt1Var).h();
                }
            }
        }
    }

    public static void e(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, zt1Var) == null) {
            synchronized (cc4.class) {
                if (d != null) {
                    d.f(zt1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, zt1Var) == null) {
            synchronized (cc4.class) {
                if (d != null) {
                    d.c(zt1Var).k();
                }
            }
        }
    }

    public synchronized bc4 c(zt1 zt1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zt1Var)) == null) {
            synchronized (this) {
                if (zt1Var == null) {
                    return null;
                }
                bc4 bc4Var = this.a.get(zt1Var);
                if (bc4Var == null) {
                    bc4Var = new bc4();
                    this.a.put(zt1Var, bc4Var);
                }
                return bc4Var;
            }
        }
        return (bc4) invokeL.objValue;
    }

    public final synchronized void f(zt1 zt1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, zt1Var) == null) {
            synchronized (this) {
                if (zt1Var == null) {
                    return;
                }
                bc4 remove = this.a.remove(zt1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, fu2 fu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, fu2Var)) == null) {
            t42.i("map", "map create start");
            if (nl3.m(fu2Var.c) != null && fu2Var.isValid()) {
                bu1 A = gt2.U().A(fu2Var.c);
                if (!(A instanceof zt1)) {
                    t42.c("map", "WebViewManager is null");
                    return false;
                }
                bc4 c2 = c((zt1) A);
                if (c2.d(fu2Var.b) != null) {
                    t42.c("map", "map with id " + fu2Var.b + " exist");
                    return false;
                }
                dd4 K = dd4.K(context, fu2Var);
                if (K == null) {
                    t42.c("map", "map with id " + fu2Var.b + " model is invalid");
                    return false;
                }
                k32 insert = K.insert();
                if (!insert.a()) {
                    t42.c("map", "map with id " + fu2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    t42.i("map", "map with id " + fu2Var.b + " init start");
                    wc4.a(context, K, fu2Var, c2);
                    t42.i("map", "map with id " + fu2Var.b + " init end");
                    t42.i("map", "map create end");
                    return true;
                }
            }
            t42.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(fu2 fu2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, fu2Var)) == null) {
            t42.i("map", "map remove start");
            if (nl3.m(fu2Var.c) == null) {
                t42.c("map", "webView is null or mapModel is null");
                return false;
            }
            bu1 A = gt2.U().A(fu2Var.c);
            if (!(A instanceof zt1)) {
                t42.c("map", "WebViewManager is null");
                return false;
            }
            bc4 c2 = c((zt1) A);
            dd4 d2 = c2.d(fu2Var.b);
            if (d2 == null) {
                t42.c("map", "remove map with id " + fu2Var.b + " not exist");
                return false;
            } else if (!c2.j(fu2Var.b)) {
                return false;
            } else {
                t42.i("map", "map remove end");
                if (g42.a(fu2Var) == null) {
                    m42.a("map", "remove with a null map component");
                }
                k32 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    t42.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, fu2 fu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, fu2Var)) == null) {
            t42.i("map", "map update start");
            if (nl3.m(fu2Var.c) == null) {
                t42.c("map", "webView is null or mapModel is null");
                return false;
            }
            bu1 A = gt2.U().A(fu2Var.c);
            if (A != null && (A instanceof zt1)) {
                bc4 c2 = c((zt1) A);
                dd4 d2 = c2.d(fu2Var.b);
                if (d2 == null) {
                    t42.c("map", "remove map with id " + fu2Var.b + " not exist");
                    return false;
                }
                d2.F();
                wc4.b(context, d2, fu2Var, c2, true);
                t42.i("map", "map update end");
                if (g42.a(fu2Var) == null) {
                    m42.a("map", "update with a null map component");
                }
                k32 update = d2.update((dd4) fu2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    t42.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            t42.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
