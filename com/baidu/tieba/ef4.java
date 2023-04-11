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
/* loaded from: classes4.dex */
public class ef4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947732406, "Lcom/baidu/tieba/ef4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947732406, "Lcom/baidu/tieba/ef4;");
        }
    }

    public ef4() {
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

    public static boolean b(aj4 aj4Var, pf4 pf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, aj4Var, pf4Var)) == null) {
            if (pf4Var == null) {
                return true;
            }
            if (aj4Var == null) {
                pf4Var.C(new og4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable ej4<JSONArray> ej4Var, @Nullable ej4<JSONObject> ej4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ej4Var, ej4Var2)) == null) {
            return hj4.a(ej4Var, ej4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(bj4 bj4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, bj4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                m(bj4Var, pf4Var, null);
            }
        }
    }

    public static synchronized void c(wi4 wi4Var, pf4 pf4Var) {
        dh4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, wi4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                if (b(wi4Var, pf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(wi4Var.g())) {
                    pf4Var.C(new og4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = yg4.i(wi4Var);
                if (pf4Var.B() != null) {
                    i.putAll(pf4Var.B());
                }
                pf4Var.D();
                if (wi4Var.n() == 1 && wi4Var.h() == 2101) {
                    M = ff4.b().n();
                } else {
                    M = ff4.b().M();
                }
                M.z(ch4.e(), i, pf4Var.t(), new ji4(wi4Var.g(), pf4Var, wi4Var));
            }
        }
    }

    public static synchronized void d(ti4 ti4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ti4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                if (b(ti4Var, pf4Var)) {
                    return;
                }
                if (ti4Var.f() != null && !ti4Var.f().isEmpty()) {
                    HashMap<String, String> f = yg4.f(ti4Var);
                    if (pf4Var.B() != null && f != null) {
                        f.putAll(pf4Var.B());
                    }
                    JSONObject d = yg4.d(ti4Var);
                    if (d == null) {
                        pf4Var.C(new og4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, pf4Var.y());
                    pf4Var.D();
                    ff4.b().M().b(ch4.d(), f, pf4Var.t(), d, new hi4(pf4Var, ti4Var));
                    return;
                }
                pf4Var.C(new og4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(zi4 zi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, zi4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                if (b(zi4Var, pf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(zi4Var.f())) {
                    pf4Var.C(new og4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(zi4Var.k())) {
                    pf4Var.C(new og4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = yg4.k(zi4Var);
                    if (pf4Var.B() != null) {
                        k.putAll(pf4Var.B());
                    }
                    pf4Var.D();
                    ff4.b().M().z(ch4.e(), k, pf4Var.t(), new li4(zi4Var.f(), pf4Var, zi4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable jf4 jf4Var) {
        df4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, jf4Var) != null) || (b = ff4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            jk4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(ch4.c(), hashMap, null, jSONObject, new kf4(jf4Var));
    }

    public static synchronized void f(vi4 vi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, vi4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                if (b(vi4Var, pf4Var)) {
                    return;
                }
                if (vi4Var.f() != null && !vi4Var.f().isEmpty()) {
                    HashMap<String, String> f = yg4.f(vi4Var);
                    if (pf4Var.B() != null && f != null) {
                        f.putAll(pf4Var.B());
                    }
                    JSONObject e = yg4.e(vi4Var);
                    if (e == null) {
                        pf4Var.C(new og4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ff4.b())) {
                        jk4.e().f();
                    }
                    a(e, pf4Var.y());
                    pf4Var.D();
                    ff4.b().M().b(ch4.d(), f, pf4Var.t(), e, new ii4(pf4Var, vi4Var));
                    return;
                }
                pf4Var.C(new og4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(xi4 xi4Var, pf4 pf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, xi4Var, pf4Var) == null) {
            synchronized (ef4.class) {
                if (b(xi4Var, pf4Var)) {
                    return;
                }
                HashMap<String, String> j = yg4.j(xi4Var);
                if (pf4Var.B() != null) {
                    j.putAll(pf4Var.B());
                }
                pf4Var.D();
                ff4.b().M().z(ch4.f(), j, pf4Var.t(), new ki4(pf4Var, xi4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ef4.class) {
                c = uh4.b().c(str);
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
            synchronized (ef4.class) {
                d = uh4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(bj4 bj4Var, pf4 pf4Var, pf4 pf4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, bj4Var, pf4Var, pf4Var2) == null) {
            synchronized (ef4.class) {
                n(bj4Var, pf4Var, pf4Var2, null);
            }
        }
    }

    public static synchronized void n(bj4 bj4Var, pf4 pf4Var, pf4 pf4Var2, @Nullable rk4 rk4Var) {
        ej4<JSONArray> g;
        pf4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, bj4Var, pf4Var, pf4Var2, rk4Var) == null) {
            synchronized (ef4.class) {
                if (b(bj4Var, pf4Var)) {
                    return;
                }
                if (PMSConstants.a(ff4.b())) {
                    jk4.e().f();
                }
                if (rk4Var == null) {
                    g = null;
                } else {
                    g = rk4Var.g();
                }
                if (rk4Var == null) {
                    callback = null;
                } else {
                    callback = rk4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (pf4Var.B() != null) {
                    hashMap.putAll(pf4Var.B());
                }
                pf4Var.D();
                ff4.b().M().b(ch4.g(), hashMap, pf4Var.t(), i(g, null), new mi4(pf4Var, bj4Var, pf4Var2, callback));
            }
        }
    }

    public static synchronized void o(rk4 rk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, rk4Var) == null) {
            synchronized (ef4.class) {
                if (rk4Var == null) {
                    return;
                }
                pf4 callback = rk4Var.getCallback();
                if (callback == null) {
                    return;
                }
                aj4 request = rk4Var.getRequest();
                if (request == null) {
                    callback.C(new og4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ff4.b().M().b(ch4.g(), B, callback.t(), i(rk4Var.g(), null), new mi4(callback, request, null, callback));
            }
        }
    }
}
