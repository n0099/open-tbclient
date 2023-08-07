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
public class hf4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile hf4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<ex1, gf4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947821779, "Lcom/baidu/tieba/hf4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947821779, "Lcom/baidu/tieba/hf4;");
                return;
            }
        }
        b = ir1.a;
        c = hf4.class.getSimpleName();
    }

    public hf4() {
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
        ff4.a();
        this.a = new HashMap();
    }

    public static hf4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (hf4.class) {
                    if (d == null) {
                        d = new hf4();
                    }
                }
            }
            return d;
        }
        return (hf4) invokeV.objValue;
    }

    public static void d(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, ex1Var) == null) {
            synchronized (hf4.class) {
                if (d != null) {
                    d.c(ex1Var).h();
                }
            }
        }
    }

    public static void e(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, ex1Var) == null) {
            synchronized (hf4.class) {
                if (d != null) {
                    d.f(ex1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, ex1Var) == null) {
            synchronized (hf4.class) {
                if (d != null) {
                    d.c(ex1Var).k();
                }
            }
        }
    }

    public synchronized gf4 c(ex1 ex1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ex1Var)) == null) {
            synchronized (this) {
                if (ex1Var == null) {
                    return null;
                }
                gf4 gf4Var = this.a.get(ex1Var);
                if (gf4Var == null) {
                    gf4Var = new gf4();
                    this.a.put(ex1Var, gf4Var);
                }
                return gf4Var;
            }
        }
        return (gf4) invokeL.objValue;
    }

    public final synchronized void f(ex1 ex1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ex1Var) == null) {
            synchronized (this) {
                if (ex1Var == null) {
                    return;
                }
                gf4 remove = this.a.remove(ex1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, kx2 kx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, kx2Var)) == null) {
            y72.i("map", "map create start");
            if (so3.m(kx2Var.c) != null && kx2Var.isValid()) {
                gx1 A = lw2.T().A(kx2Var.c);
                if (!(A instanceof ex1)) {
                    y72.c("map", "WebViewManager is null");
                    return false;
                }
                gf4 c2 = c((ex1) A);
                if (c2.d(kx2Var.b) != null) {
                    y72.c("map", "map with id " + kx2Var.b + " exist");
                    return false;
                }
                ig4 K = ig4.K(context, kx2Var);
                if (K == null) {
                    y72.c("map", "map with id " + kx2Var.b + " model is invalid");
                    return false;
                }
                p62 insert = K.insert();
                if (!insert.a()) {
                    y72.c("map", "map with id " + kx2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    y72.i("map", "map with id " + kx2Var.b + " init start");
                    bg4.a(context, K, kx2Var, c2);
                    y72.i("map", "map with id " + kx2Var.b + " init end");
                    y72.i("map", "map create end");
                    return true;
                }
            }
            y72.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(kx2 kx2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, kx2Var)) == null) {
            y72.i("map", "map remove start");
            if (so3.m(kx2Var.c) == null) {
                y72.c("map", "webView is null or mapModel is null");
                return false;
            }
            gx1 A = lw2.T().A(kx2Var.c);
            if (!(A instanceof ex1)) {
                y72.c("map", "WebViewManager is null");
                return false;
            }
            gf4 c2 = c((ex1) A);
            ig4 d2 = c2.d(kx2Var.b);
            if (d2 == null) {
                y72.c("map", "remove map with id " + kx2Var.b + " not exist");
                return false;
            } else if (!c2.j(kx2Var.b)) {
                return false;
            } else {
                y72.i("map", "map remove end");
                if (l72.a(kx2Var) == null) {
                    r72.a("map", "remove with a null map component");
                }
                p62 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    y72.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, kx2 kx2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, kx2Var)) == null) {
            y72.i("map", "map update start");
            if (so3.m(kx2Var.c) == null) {
                y72.c("map", "webView is null or mapModel is null");
                return false;
            }
            gx1 A = lw2.T().A(kx2Var.c);
            if (A != null && (A instanceof ex1)) {
                gf4 c2 = c((ex1) A);
                ig4 d2 = c2.d(kx2Var.b);
                if (d2 == null) {
                    y72.c("map", "remove map with id " + kx2Var.b + " not exist");
                    return false;
                }
                d2.F();
                bg4.b(context, d2, kx2Var, c2, true);
                y72.i("map", "map update end");
                if (l72.a(kx2Var) == null) {
                    r72.a("map", "update with a null map component");
                }
                p62 update = d2.update((ig4) kx2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    y72.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            y72.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
