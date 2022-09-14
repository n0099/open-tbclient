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
public class h74 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile h74 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<ep1, g74> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947776612, "Lcom/baidu/tieba/h74;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947776612, "Lcom/baidu/tieba/h74;");
                return;
            }
        }
        b = ij1.a;
        c = h74.class.getSimpleName();
    }

    public h74() {
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
        f74.a();
        this.a = new HashMap();
    }

    public static h74 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (h74.class) {
                    if (d == null) {
                        d = new h74();
                    }
                }
            }
            return d;
        }
        return (h74) invokeV.objValue;
    }

    public static void d(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ep1Var) == null) {
            synchronized (h74.class) {
                if (d != null) {
                    d.c(ep1Var).h();
                }
            }
        }
    }

    public static void e(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ep1Var) == null) {
            synchronized (h74.class) {
                if (d != null) {
                    d.f(ep1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ep1Var) == null) {
            synchronized (h74.class) {
                if (d != null) {
                    d.c(ep1Var).k();
                }
            }
        }
    }

    public boolean a(Context context, kp2 kp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, kp2Var)) == null) {
            yz1.i("map", "map create start");
            if (sg3.m(kp2Var.c) != null && kp2Var.isValid()) {
                gp1 A = lo2.U().A(kp2Var.c);
                if (!(A instanceof ep1)) {
                    yz1.c("map", "WebViewManager is null");
                    return false;
                }
                g74 c2 = c((ep1) A);
                if (c2.d(kp2Var.b) != null) {
                    yz1.c("map", "map with id " + kp2Var.b + " exist");
                    return false;
                }
                i84 K = i84.K(context, kp2Var);
                if (K == null) {
                    yz1.c("map", "map with id " + kp2Var.b + " model is invalid");
                    return false;
                }
                py1 insert = K.insert();
                if (!insert.a()) {
                    yz1.c("map", "map with id " + kp2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (c2.insert(K)) {
                    yz1.i("map", "map with id " + kp2Var.b + " init start");
                    b84.a(context, K, kp2Var, c2);
                    yz1.i("map", "map with id " + kp2Var.b + " init end");
                    yz1.i("map", "map create end");
                    return true;
                } else {
                    return false;
                }
            }
            yz1.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public synchronized g74 c(ep1 ep1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ep1Var)) == null) {
            synchronized (this) {
                if (ep1Var == null) {
                    return null;
                }
                g74 g74Var = this.a.get(ep1Var);
                if (g74Var == null) {
                    g74Var = new g74();
                    this.a.put(ep1Var, g74Var);
                }
                return g74Var;
            }
        }
        return (g74) invokeL.objValue;
    }

    public final synchronized void f(ep1 ep1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ep1Var) == null) {
            synchronized (this) {
                if (ep1Var == null) {
                    return;
                }
                g74 remove = this.a.remove(ep1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean g(kp2 kp2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kp2Var)) == null) {
            yz1.i("map", "map remove start");
            if (sg3.m(kp2Var.c) == null) {
                yz1.c("map", "webView is null or mapModel is null");
                return false;
            }
            gp1 A = lo2.U().A(kp2Var.c);
            if (!(A instanceof ep1)) {
                yz1.c("map", "WebViewManager is null");
                return false;
            }
            g74 c2 = c((ep1) A);
            i84 d2 = c2.d(kp2Var.b);
            if (d2 == null) {
                yz1.c("map", "remove map with id " + kp2Var.b + " not exist");
                return false;
            } else if (c2.j(kp2Var.b)) {
                yz1.i("map", "map remove end");
                if (lz1.a(kp2Var) == null) {
                    rz1.a("map", "remove with a null map component");
                }
                py1 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    yz1.c(str, "map remove fail: " + B.b);
                }
                return a;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, kp2 kp2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, kp2Var)) == null) {
            yz1.i("map", "map update start");
            if (sg3.m(kp2Var.c) == null) {
                yz1.c("map", "webView is null or mapModel is null");
                return false;
            }
            gp1 A = lo2.U().A(kp2Var.c);
            if (A != null && (A instanceof ep1)) {
                g74 c2 = c((ep1) A);
                i84 d2 = c2.d(kp2Var.b);
                if (d2 == null) {
                    yz1.c("map", "remove map with id " + kp2Var.b + " not exist");
                    return false;
                }
                d2.F();
                b84.b(context, d2, kp2Var, c2, true);
                yz1.i("map", "map update end");
                if (lz1.a(kp2Var) == null) {
                    rz1.a("map", "update with a null map component");
                }
                py1 update = d2.update((i84) kp2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    yz1.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            yz1.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
