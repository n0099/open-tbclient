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
public class hg4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile hg4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<ey1, gg4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947822740, "Lcom/baidu/tieba/hg4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947822740, "Lcom/baidu/tieba/hg4;");
                return;
            }
        }
        b = is1.a;
        c = hg4.class.getSimpleName();
    }

    public hg4() {
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
        fg4.a();
        this.a = new HashMap();
    }

    public static hg4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (hg4.class) {
                    if (d == null) {
                        d = new hg4();
                    }
                }
            }
            return d;
        }
        return (hg4) invokeV.objValue;
    }

    public static void d(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ey1Var) == null) {
            synchronized (hg4.class) {
                if (d != null) {
                    d.c(ey1Var).h();
                }
            }
        }
    }

    public static void e(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ey1Var) == null) {
            synchronized (hg4.class) {
                if (d != null) {
                    d.f(ey1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ey1Var) == null) {
            synchronized (hg4.class) {
                if (d != null) {
                    d.c(ey1Var).k();
                }
            }
        }
    }

    public synchronized gg4 c(ey1 ey1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ey1Var)) == null) {
            synchronized (this) {
                if (ey1Var == null) {
                    return null;
                }
                gg4 gg4Var = this.a.get(ey1Var);
                if (gg4Var == null) {
                    gg4Var = new gg4();
                    this.a.put(ey1Var, gg4Var);
                }
                return gg4Var;
            }
        }
        return (gg4) invokeL.objValue;
    }

    public final synchronized void f(ey1 ey1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ey1Var) == null) {
            synchronized (this) {
                if (ey1Var == null) {
                    return;
                }
                gg4 remove = this.a.remove(ey1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, ky2 ky2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, ky2Var)) == null) {
            y82.i("map", "map create start");
            if (sp3.m(ky2Var.c) != null && ky2Var.isValid()) {
                gy1 A = lx2.T().A(ky2Var.c);
                if (!(A instanceof ey1)) {
                    y82.c("map", "WebViewManager is null");
                    return false;
                }
                gg4 c2 = c((ey1) A);
                if (c2.d(ky2Var.b) != null) {
                    y82.c("map", "map with id " + ky2Var.b + " exist");
                    return false;
                }
                ih4 K = ih4.K(context, ky2Var);
                if (K == null) {
                    y82.c("map", "map with id " + ky2Var.b + " model is invalid");
                    return false;
                }
                p72 insert = K.insert();
                if (!insert.a()) {
                    y82.c("map", "map with id " + ky2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    y82.i("map", "map with id " + ky2Var.b + " init start");
                    bh4.a(context, K, ky2Var, c2);
                    y82.i("map", "map with id " + ky2Var.b + " init end");
                    y82.i("map", "map create end");
                    return true;
                }
            }
            y82.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(ky2 ky2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, ky2Var)) == null) {
            y82.i("map", "map remove start");
            if (sp3.m(ky2Var.c) == null) {
                y82.c("map", "webView is null or mapModel is null");
                return false;
            }
            gy1 A = lx2.T().A(ky2Var.c);
            if (!(A instanceof ey1)) {
                y82.c("map", "WebViewManager is null");
                return false;
            }
            gg4 c2 = c((ey1) A);
            ih4 d2 = c2.d(ky2Var.b);
            if (d2 == null) {
                y82.c("map", "remove map with id " + ky2Var.b + " not exist");
                return false;
            } else if (!c2.j(ky2Var.b)) {
                return false;
            } else {
                y82.i("map", "map remove end");
                if (l82.a(ky2Var) == null) {
                    r82.a("map", "remove with a null map component");
                }
                p72 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    y82.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, ky2 ky2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, ky2Var)) == null) {
            y82.i("map", "map update start");
            if (sp3.m(ky2Var.c) == null) {
                y82.c("map", "webView is null or mapModel is null");
                return false;
            }
            gy1 A = lx2.T().A(ky2Var.c);
            if (A != null && (A instanceof ey1)) {
                gg4 c2 = c((ey1) A);
                ih4 d2 = c2.d(ky2Var.b);
                if (d2 == null) {
                    y82.c("map", "remove map with id " + ky2Var.b + " not exist");
                    return false;
                }
                d2.F();
                bh4.b(context, d2, ky2Var, c2, true);
                y82.i("map", "map update end");
                if (l82.a(ky2Var) == null) {
                    r82.a("map", "update with a null map component");
                }
                p72 update = d2.update((ih4) ky2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    y82.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            y82.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
