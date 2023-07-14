package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.pms.PMSConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fj4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947766041, "Lcom/baidu/tieba/fj4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947766041, "Lcom/baidu/tieba/fj4;");
        }
    }

    public fj4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void a(@NonNull JSONObject jSONObject, @Nullable Map<String, String> map) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65538, null, jSONObject, map) != null) || map == null) {
            return;
        }
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean b(bn4 bn4Var, qj4 qj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bn4Var, qj4Var)) == null) {
            if (qj4Var == null) {
                return true;
            }
            if (bn4Var == null) {
                qj4Var.C(new pk4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable fn4<JSONArray> fn4Var, @Nullable fn4<JSONObject> fn4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, fn4Var, fn4Var2)) == null) {
            return in4.a(fn4Var, fn4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(cn4 cn4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, cn4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                m(cn4Var, qj4Var, null);
            }
        }
    }

    public static synchronized void c(xm4 xm4Var, qj4 qj4Var) {
        el4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xm4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                if (b(xm4Var, qj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(xm4Var.g())) {
                    qj4Var.C(new pk4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = zk4.i(xm4Var);
                if (qj4Var.B() != null) {
                    i.putAll(qj4Var.B());
                }
                qj4Var.D();
                if (xm4Var.n() == 1 && xm4Var.h() == 2101) {
                    M = gj4.b().n();
                } else {
                    M = gj4.b().M();
                }
                M.z(dl4.e(), i, qj4Var.t(), new km4(xm4Var.g(), qj4Var, xm4Var));
            }
        }
    }

    public static synchronized void d(um4 um4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, um4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                if (b(um4Var, qj4Var)) {
                    return;
                }
                if (um4Var.f() != null && !um4Var.f().isEmpty()) {
                    HashMap<String, String> f = zk4.f(um4Var);
                    if (qj4Var.B() != null && f != null) {
                        f.putAll(qj4Var.B());
                    }
                    JSONObject d = zk4.d(um4Var);
                    if (d == null) {
                        qj4Var.C(new pk4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, qj4Var.y());
                    qj4Var.D();
                    gj4.b().M().b(dl4.d(), f, qj4Var.t(), d, new im4(qj4Var, um4Var));
                    return;
                }
                qj4Var.C(new pk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(an4 an4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, an4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                if (b(an4Var, qj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(an4Var.f())) {
                    qj4Var.C(new pk4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(an4Var.k())) {
                    qj4Var.C(new pk4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = zk4.k(an4Var);
                    if (qj4Var.B() != null) {
                        k.putAll(qj4Var.B());
                    }
                    qj4Var.D();
                    gj4.b().M().z(dl4.e(), k, qj4Var.t(), new mm4(an4Var.f(), qj4Var, an4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable kj4 kj4Var) {
        ej4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, kj4Var) != null) || (b = gj4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ko4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(dl4.c(), hashMap, null, jSONObject, new lj4(kj4Var));
    }

    public static synchronized void f(wm4 wm4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, wm4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                if (b(wm4Var, qj4Var)) {
                    return;
                }
                if (wm4Var.f() != null && !wm4Var.f().isEmpty()) {
                    HashMap<String, String> f = zk4.f(wm4Var);
                    if (qj4Var.B() != null && f != null) {
                        f.putAll(qj4Var.B());
                    }
                    JSONObject e = zk4.e(wm4Var);
                    if (e == null) {
                        qj4Var.C(new pk4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(gj4.b())) {
                        ko4.e().f();
                    }
                    a(e, qj4Var.y());
                    qj4Var.D();
                    gj4.b().M().b(dl4.d(), f, qj4Var.t(), e, new jm4(qj4Var, wm4Var));
                    return;
                }
                qj4Var.C(new pk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(ym4 ym4Var, qj4 qj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, ym4Var, qj4Var) == null) {
            synchronized (fj4.class) {
                if (b(ym4Var, qj4Var)) {
                    return;
                }
                HashMap<String, String> j = zk4.j(ym4Var);
                if (qj4Var.B() != null) {
                    j.putAll(qj4Var.B());
                }
                qj4Var.D();
                gj4.b().M().z(dl4.f(), j, qj4Var.t(), new lm4(qj4Var, ym4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (fj4.class) {
                c = vl4.b().c(str);
            }
            return c;
        }
        return invokeL.booleanValue;
    }

    public static synchronized boolean k(String str) {
        InterceptResult invokeL;
        boolean d;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, str)) == null) {
            synchronized (fj4.class) {
                d = vl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(cn4 cn4Var, qj4 qj4Var, qj4 qj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, cn4Var, qj4Var, qj4Var2) == null) {
            synchronized (fj4.class) {
                n(cn4Var, qj4Var, qj4Var2, null);
            }
        }
    }

    public static synchronized void n(cn4 cn4Var, qj4 qj4Var, qj4 qj4Var2, @Nullable so4 so4Var) {
        fn4<JSONArray> g;
        qj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, cn4Var, qj4Var, qj4Var2, so4Var) == null) {
            synchronized (fj4.class) {
                if (b(cn4Var, qj4Var)) {
                    return;
                }
                if (PMSConstants.a(gj4.b())) {
                    ko4.e().f();
                }
                if (so4Var == null) {
                    g = null;
                } else {
                    g = so4Var.g();
                }
                if (so4Var == null) {
                    callback = null;
                } else {
                    callback = so4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (qj4Var.B() != null) {
                    hashMap.putAll(qj4Var.B());
                }
                qj4Var.D();
                gj4.b().M().b(dl4.g(), hashMap, qj4Var.t(), i(g, null), new nm4(qj4Var, cn4Var, qj4Var2, callback));
            }
        }
    }

    public static synchronized void o(so4 so4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, so4Var) == null) {
            synchronized (fj4.class) {
                if (so4Var == null) {
                    return;
                }
                qj4 callback = so4Var.getCallback();
                if (callback == null) {
                    return;
                }
                bn4 request = so4Var.getRequest();
                if (request == null) {
                    callback.C(new pk4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                gj4.b().M().b(dl4.g(), B, callback.t(), i(so4Var.g(), null), new nm4(callback, request, null, callback));
            }
        }
    }
}
