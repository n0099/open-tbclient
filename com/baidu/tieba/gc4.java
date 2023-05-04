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
public class gc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile gc4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<du1, fc4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947789105, "Lcom/baidu/tieba/gc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947789105, "Lcom/baidu/tieba/gc4;");
                return;
            }
        }
        b = ho1.a;
        c = gc4.class.getSimpleName();
    }

    public gc4() {
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
        ec4.a();
        this.a = new HashMap();
    }

    public static gc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (gc4.class) {
                    if (d == null) {
                        d = new gc4();
                    }
                }
            }
            return d;
        }
        return (gc4) invokeV.objValue;
    }

    public static void d(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, du1Var) == null) {
            synchronized (gc4.class) {
                if (d != null) {
                    d.c(du1Var).h();
                }
            }
        }
    }

    public static void e(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, du1Var) == null) {
            synchronized (gc4.class) {
                if (d != null) {
                    d.f(du1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, du1Var) == null) {
            synchronized (gc4.class) {
                if (d != null) {
                    d.c(du1Var).k();
                }
            }
        }
    }

    public synchronized fc4 c(du1 du1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du1Var)) == null) {
            synchronized (this) {
                if (du1Var == null) {
                    return null;
                }
                fc4 fc4Var = this.a.get(du1Var);
                if (fc4Var == null) {
                    fc4Var = new fc4();
                    this.a.put(du1Var, fc4Var);
                }
                return fc4Var;
            }
        }
        return (fc4) invokeL.objValue;
    }

    public final synchronized void f(du1 du1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, du1Var) == null) {
            synchronized (this) {
                if (du1Var == null) {
                    return;
                }
                fc4 remove = this.a.remove(du1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, ju2 ju2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ju2Var)) == null) {
            x42.i("map", "map create start");
            if (rl3.m(ju2Var.c) != null && ju2Var.isValid()) {
                fu1 A = kt2.U().A(ju2Var.c);
                if (!(A instanceof du1)) {
                    x42.c("map", "WebViewManager is null");
                    return false;
                }
                fc4 c2 = c((du1) A);
                if (c2.d(ju2Var.b) != null) {
                    x42.c("map", "map with id " + ju2Var.b + " exist");
                    return false;
                }
                hd4 K = hd4.K(context, ju2Var);
                if (K == null) {
                    x42.c("map", "map with id " + ju2Var.b + " model is invalid");
                    return false;
                }
                o32 insert = K.insert();
                if (!insert.a()) {
                    x42.c("map", "map with id " + ju2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    x42.i("map", "map with id " + ju2Var.b + " init start");
                    ad4.a(context, K, ju2Var, c2);
                    x42.i("map", "map with id " + ju2Var.b + " init end");
                    x42.i("map", "map create end");
                    return true;
                }
            }
            x42.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ju2 ju2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ju2Var)) == null) {
            x42.i("map", "map remove start");
            if (rl3.m(ju2Var.c) == null) {
                x42.c("map", "webView is null or mapModel is null");
                return false;
            }
            fu1 A = kt2.U().A(ju2Var.c);
            if (!(A instanceof du1)) {
                x42.c("map", "WebViewManager is null");
                return false;
            }
            fc4 c2 = c((du1) A);
            hd4 d2 = c2.d(ju2Var.b);
            if (d2 == null) {
                x42.c("map", "remove map with id " + ju2Var.b + " not exist");
                return false;
            } else if (!c2.j(ju2Var.b)) {
                return false;
            } else {
                x42.i("map", "map remove end");
                if (k42.a(ju2Var) == null) {
                    q42.a("map", "remove with a null map component");
                }
                o32 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    x42.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, ju2 ju2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ju2Var)) == null) {
            x42.i("map", "map update start");
            if (rl3.m(ju2Var.c) == null) {
                x42.c("map", "webView is null or mapModel is null");
                return false;
            }
            fu1 A = kt2.U().A(ju2Var.c);
            if (A != null && (A instanceof du1)) {
                fc4 c2 = c((du1) A);
                hd4 d2 = c2.d(ju2Var.b);
                if (d2 == null) {
                    x42.c("map", "remove map with id " + ju2Var.b + " not exist");
                    return false;
                }
                d2.F();
                ad4.b(context, d2, ju2Var, c2, true);
                x42.i("map", "map update end");
                if (k42.a(ju2Var) == null) {
                    q42.a("map", "update with a null map component");
                }
                o32 update = d2.update((hd4) ju2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    x42.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            x42.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
