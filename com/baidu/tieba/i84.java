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
public class i84 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947807364, "Lcom/baidu/tieba/i84;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947807364, "Lcom/baidu/tieba/i84;");
        }
    }

    public i84() {
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
        if (!(interceptable == null || interceptable.invokeLL(65538, null, jSONObject, map) == null) || map == null) {
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

    public static boolean b(ec4 ec4Var, t84 t84Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ec4Var, t84Var)) == null) {
            if (t84Var == null) {
                return true;
            }
            if (ec4Var == null) {
                t84Var.C(new s94(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ac4 ac4Var, t84 t84Var) {
        ha4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ac4Var, t84Var) == null) {
            synchronized (i84.class) {
                if (b(ac4Var, t84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ac4Var.g())) {
                    t84Var.C(new s94(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = ca4.i(ac4Var);
                if (t84Var.B() != null) {
                    i.putAll(t84Var.B());
                }
                t84Var.D();
                if (ac4Var.n() == 1 && ac4Var.h() == 2101) {
                    M = j84.b().n();
                } else {
                    M = j84.b().M();
                }
                M.z(ga4.e(), i, t84Var.t(), new nb4(ac4Var.g(), t84Var, ac4Var));
            }
        }
    }

    public static synchronized void d(xb4 xb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xb4Var, t84Var) == null) {
            synchronized (i84.class) {
                if (b(xb4Var, t84Var)) {
                    return;
                }
                if (xb4Var.f() != null && !xb4Var.f().isEmpty()) {
                    HashMap<String, String> f = ca4.f(xb4Var);
                    if (t84Var.B() != null && f != null) {
                        f.putAll(t84Var.B());
                    }
                    JSONObject d = ca4.d(xb4Var);
                    if (d == null) {
                        t84Var.C(new s94(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, t84Var.y());
                    t84Var.D();
                    j84.b().M().b(ga4.d(), f, t84Var.t(), d, new lb4(t84Var, xb4Var));
                    return;
                }
                t84Var.C(new s94(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable n84 n84Var) {
        h84 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, n84Var) == null) || (b = j84.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            nd4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(ga4.c(), hashMap, null, jSONObject, new o84(n84Var));
    }

    public static synchronized void f(zb4 zb4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, zb4Var, t84Var) == null) {
            synchronized (i84.class) {
                if (b(zb4Var, t84Var)) {
                    return;
                }
                if (zb4Var.f() != null && !zb4Var.f().isEmpty()) {
                    HashMap<String, String> f = ca4.f(zb4Var);
                    if (t84Var.B() != null && f != null) {
                        f.putAll(t84Var.B());
                    }
                    JSONObject e = ca4.e(zb4Var);
                    if (e == null) {
                        t84Var.C(new s94(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(j84.b())) {
                        nd4.e().f();
                    }
                    a(e, t84Var.y());
                    t84Var.D();
                    j84.b().M().b(ga4.d(), f, t84Var.t(), e, new mb4(t84Var, zb4Var));
                    return;
                }
                t84Var.C(new s94(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(bc4 bc4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, bc4Var, t84Var) == null) {
            synchronized (i84.class) {
                if (b(bc4Var, t84Var)) {
                    return;
                }
                HashMap<String, String> j = ca4.j(bc4Var);
                if (t84Var.B() != null) {
                    j.putAll(t84Var.B());
                }
                t84Var.D();
                j84.b().M().z(ga4.f(), j, t84Var.t(), new ob4(t84Var, bc4Var));
            }
        }
    }

    public static synchronized void h(dc4 dc4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, dc4Var, t84Var) == null) {
            synchronized (i84.class) {
                if (b(dc4Var, t84Var)) {
                    return;
                }
                if (TextUtils.isEmpty(dc4Var.f())) {
                    t84Var.C(new s94(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(dc4Var.k())) {
                    t84Var.C(new s94(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = ca4.k(dc4Var);
                    if (t84Var.B() != null) {
                        k.putAll(t84Var.B());
                    }
                    t84Var.D();
                    j84.b().M().z(ga4.e(), k, t84Var.t(), new pb4(dc4Var.f(), t84Var, dc4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable ic4<JSONArray> ic4Var, @Nullable ic4<JSONObject> ic4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ic4Var, ic4Var2)) == null) ? lc4.a(ic4Var, ic4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (i84.class) {
                c = ya4.b().c(str);
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
            synchronized (i84.class) {
                d = ya4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(fc4 fc4Var, t84 t84Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, fc4Var, t84Var) == null) {
            synchronized (i84.class) {
                m(fc4Var, t84Var, null);
            }
        }
    }

    public static synchronized void m(fc4 fc4Var, t84 t84Var, t84 t84Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, fc4Var, t84Var, t84Var2) == null) {
            synchronized (i84.class) {
                n(fc4Var, t84Var, t84Var2, null);
            }
        }
    }

    public static synchronized void n(fc4 fc4Var, t84 t84Var, t84 t84Var2, @Nullable vd4 vd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, fc4Var, t84Var, t84Var2, vd4Var) == null) {
            synchronized (i84.class) {
                if (b(fc4Var, t84Var)) {
                    return;
                }
                if (PMSConstants.a(j84.b())) {
                    nd4.e().f();
                }
                ic4<JSONArray> g = vd4Var == null ? null : vd4Var.g();
                t84 callback = vd4Var == null ? null : vd4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (t84Var.B() != null) {
                    hashMap.putAll(t84Var.B());
                }
                t84Var.D();
                j84.b().M().b(ga4.g(), hashMap, t84Var.t(), i(g, null), new qb4(t84Var, fc4Var, t84Var2, callback));
            }
        }
    }

    public static synchronized void o(vd4 vd4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, vd4Var) == null) {
            synchronized (i84.class) {
                if (vd4Var == null) {
                    return;
                }
                t84 callback = vd4Var.getCallback();
                if (callback == null) {
                    return;
                }
                ec4 request = vd4Var.getRequest();
                if (request == null) {
                    callback.C(new s94(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                j84.b().M().b(ga4.g(), B, callback.t(), i(vd4Var.g(), null), new qb4(callback, request, null, callback));
            }
        }
    }
}
