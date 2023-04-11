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
public class dc4 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean b;
    public static final String c;
    public static volatile dc4 d;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<au1, cc4> a;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947699732, "Lcom/baidu/tieba/dc4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947699732, "Lcom/baidu/tieba/dc4;");
                return;
            }
        }
        b = eo1.a;
        c = dc4.class.getSimpleName();
    }

    public dc4() {
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
        bc4.a();
        this.a = new HashMap();
    }

    public static dc4 b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (d == null) {
                synchronized (dc4.class) {
                    if (d == null) {
                        d = new dc4();
                    }
                }
            }
            return d;
        }
        return (dc4) invokeV.objValue;
    }

    public static void d(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, au1Var) == null) {
            synchronized (dc4.class) {
                if (d != null) {
                    d.c(au1Var).h();
                }
            }
        }
    }

    public static void e(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, au1Var) == null) {
            synchronized (dc4.class) {
                if (d != null) {
                    d.f(au1Var);
                } else if (b) {
                    Log.v(c, "未初始化，无需执行release");
                }
            }
        }
    }

    public static void h(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, au1Var) == null) {
            synchronized (dc4.class) {
                if (d != null) {
                    d.c(au1Var).k();
                }
            }
        }
    }

    public synchronized cc4 c(au1 au1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, au1Var)) == null) {
            synchronized (this) {
                if (au1Var == null) {
                    return null;
                }
                cc4 cc4Var = this.a.get(au1Var);
                if (cc4Var == null) {
                    cc4Var = new cc4();
                    this.a.put(au1Var, cc4Var);
                }
                return cc4Var;
            }
        }
        return (cc4) invokeL.objValue;
    }

    public final synchronized void f(au1 au1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, au1Var) == null) {
            synchronized (this) {
                if (au1Var == null) {
                    return;
                }
                cc4 remove = this.a.remove(au1Var);
                if (remove != null) {
                    remove.i();
                }
            }
        }
    }

    public boolean a(Context context, gu2 gu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, context, gu2Var)) == null) {
            u42.i("map", "map create start");
            if (ol3.m(gu2Var.c) != null && gu2Var.isValid()) {
                cu1 A = ht2.U().A(gu2Var.c);
                if (!(A instanceof au1)) {
                    u42.c("map", "WebViewManager is null");
                    return false;
                }
                cc4 c2 = c((au1) A);
                if (c2.d(gu2Var.b) != null) {
                    u42.c("map", "map with id " + gu2Var.b + " exist");
                    return false;
                }
                ed4 K = ed4.K(context, gu2Var);
                if (K == null) {
                    u42.c("map", "map with id " + gu2Var.b + " model is invalid");
                    return false;
                }
                l32 insert = K.insert();
                if (!insert.a()) {
                    u42.c("map", "map with id " + gu2Var.b + " create fail: " + insert.b);
                    return false;
                } else if (!c2.insert(K)) {
                    return false;
                } else {
                    u42.i("map", "map with id " + gu2Var.b + " init start");
                    xc4.a(context, K, gu2Var, c2);
                    u42.i("map", "map with id " + gu2Var.b + " init end");
                    u42.i("map", "map create end");
                    return true;
                }
            }
            u42.c("map", "model data is invalid");
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean g(gu2 gu2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, gu2Var)) == null) {
            u42.i("map", "map remove start");
            if (ol3.m(gu2Var.c) == null) {
                u42.c("map", "webView is null or mapModel is null");
                return false;
            }
            cu1 A = ht2.U().A(gu2Var.c);
            if (!(A instanceof au1)) {
                u42.c("map", "WebViewManager is null");
                return false;
            }
            cc4 c2 = c((au1) A);
            ed4 d2 = c2.d(gu2Var.b);
            if (d2 == null) {
                u42.c("map", "remove map with id " + gu2Var.b + " not exist");
                return false;
            } else if (!c2.j(gu2Var.b)) {
                return false;
            } else {
                u42.i("map", "map remove end");
                if (h42.a(gu2Var) == null) {
                    n42.a("map", "remove with a null map component");
                }
                l32 B = d2.B();
                boolean a = B.a();
                if (!a) {
                    String str = c;
                    u42.c(str, "map remove fail: " + B.b);
                }
                return a;
            }
        }
        return invokeL.booleanValue;
    }

    public boolean update(Context context, gu2 gu2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, context, gu2Var)) == null) {
            u42.i("map", "map update start");
            if (ol3.m(gu2Var.c) == null) {
                u42.c("map", "webView is null or mapModel is null");
                return false;
            }
            cu1 A = ht2.U().A(gu2Var.c);
            if (A != null && (A instanceof au1)) {
                cc4 c2 = c((au1) A);
                ed4 d2 = c2.d(gu2Var.b);
                if (d2 == null) {
                    u42.c("map", "remove map with id " + gu2Var.b + " not exist");
                    return false;
                }
                d2.F();
                xc4.b(context, d2, gu2Var, c2, true);
                u42.i("map", "map update end");
                if (h42.a(gu2Var) == null) {
                    n42.a("map", "update with a null map component");
                }
                l32 update = d2.update((ed4) gu2Var);
                boolean a = update.a();
                if (!a) {
                    String str = c;
                    u42.c(str, "map update fail: " + update.b);
                }
                return a;
            }
            u42.c("map", "WebViewManager is null");
            return false;
        }
        return invokeLL.booleanValue;
    }
}
