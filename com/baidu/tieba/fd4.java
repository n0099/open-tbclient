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
public class fd4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile fd4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<cv1, ed4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947760275, "Lcom/baidu/tieba/fd4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947760275, "Lcom/baidu/tieba/fd4;");
                return;
            }
        }
        b = gp1.a;
        c = fd4.class.getSimpleName();
    }

    public fd4() {
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
        dd4.a();
        this.a = new HashMap();
    }

    public static fd4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (fd4.class) {
                    if (d == null) {
                        d = new fd4();
                    }
                }
            }
            return d;
        }
        return (fd4) invokeV.objValue;
    }

    public static void d(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, cv1Var) == null) {
            synchronized (fd4.class) {
                if (d != null) {
                    d.c(cv1Var).h();
                }
            }
        }
    }

    public static void e(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, cv1Var) == null) {
            synchronized (fd4.class) {
                if (d != null) {
                    d.f(cv1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, cv1Var) == null) {
            synchronized (fd4.class) {
                if (d != null) {
                    d.c(cv1Var).k();
                }
            }
        }
    }

    public synchronized ed4 c(cv1 cv1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cv1Var)) == null) {
            synchronized (this) {
                if (cv1Var == null) {
                    return null;
                }
                ed4 ed4Var = this.a.get(cv1Var);
                if (ed4Var == null) {
                    ed4Var = new ed4();
                    this.a.put(cv1Var, ed4Var);
                }
                return ed4Var;
            }
        }
        return (ed4) invokeL.objValue;
    }

    public final synchronized void f(cv1 cv1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cv1Var) == null) {
            synchronized (this) {
                if (cv1Var == null) {
                    return;
                }
                ed4 remove = this.a.remove(cv1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, iv2 iv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, iv2Var)) == null) {
            w52.i("map", "map create start");
            if (qm3.m(iv2Var.c) != null && iv2Var.isValid()) {
                ev1 A = ju2.U().A(iv2Var.c);
                if (!(A instanceof cv1)) {
                    w52.c("map", "WebViewManager is null");
                    return false;
                }
                ed4 c2 = c((cv1) A);
                if (c2.d(iv2Var.b) != null) {
                    w52.c("map", "map with id " + iv2Var.b + " exist");
                    return false;
                }
                ge4 K = ge4.K(context, iv2Var);
                if (K == null) {
                    w52.c("map", "map with id " + iv2Var.b + " model is invalid");
                    return false;
                }
                n42 insert = K.insert();
                if (!insert.a()) {
                    w52.c("map", "map with id " + iv2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    w52.i("map", "map with id " + iv2Var.b + " init start");
                    zd4.a(context, K, iv2Var, c2);
                    w52.i("map", "map with id " + iv2Var.b + " init end");
                    w52.i("map", "map create end");
                    return true;
                }
            }
            w52.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(iv2 iv2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, iv2Var)) == null) {
            w52.i("map", "map remove start");
            if (qm3.m(iv2Var.c) == null) {
                w52.c("map", "webView is null or mapModel is null");
                return false;
            }
            ev1 A = ju2.U().A(iv2Var.c);
            if (!(A instanceof cv1)) {
                w52.c("map", "WebViewManager is null");
                return false;
            }
            ed4 c2 = c((cv1) A);
            ge4 d2 = c2.d(iv2Var.b);
            if (d2 == null) {
                w52.c("map", "remove map with id " + iv2Var.b + " not exist");
                return false;
            } else if (!c2.j(iv2Var.b)) {
                return false;
            } else {
                w52.i("map", "map remove end");
                if (j52.a(iv2Var) == null) {
                    p52.a("map", "remove with a null map component");
                }
                n42 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    w52.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, iv2 iv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, iv2Var)) == null) {
            w52.i("map", "map update start");
            if (qm3.m(iv2Var.c) == null) {
                w52.c("map", "webView is null or mapModel is null");
                return false;
            }
            ev1 A = ju2.U().A(iv2Var.c);
            if (A != null && (A instanceof cv1)) {
                ed4 c2 = c((cv1) A);
                ge4 d2 = c2.d(iv2Var.b);
                if (d2 == null) {
                    w52.c("map", "remove map with id " + iv2Var.b + " not exist");
                    return false;
                }
                d2.F();
                zd4.b(context, d2, iv2Var, c2, true);
                w52.i("map", "map update end");
                if (j52.a(iv2Var) == null) {
                    p52.a("map", "update with a null map component");
                }
                n42 update = d2.update((ge4) iv2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    w52.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            w52.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
