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
public class gg4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947792949, "Lcom/baidu/tieba/gg4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947792949, "Lcom/baidu/tieba/gg4;");
        }
    }

    public gg4() {
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

    public static boolean b(ck4 ck4Var, rg4 rg4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ck4Var, rg4Var)) == null) {
            if (rg4Var == null) {
                return true;
            }
            if (ck4Var == null) {
                rg4Var.C(new qh4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable gk4<JSONArray> gk4Var, @Nullable gk4<JSONObject> gk4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, gk4Var, gk4Var2)) == null) {
            return jk4.a(gk4Var, gk4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(dk4 dk4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, dk4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                m(dk4Var, rg4Var, null);
            }
        }
    }

    public static synchronized void c(yj4 yj4Var, rg4 rg4Var) {
        fi4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, yj4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                if (b(yj4Var, rg4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(yj4Var.g())) {
                    rg4Var.C(new qh4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = ai4.i(yj4Var);
                if (rg4Var.B() != null) {
                    i.putAll(rg4Var.B());
                }
                rg4Var.D();
                if (yj4Var.n() == 1 && yj4Var.h() == 2101) {
                    M = hg4.b().n();
                } else {
                    M = hg4.b().M();
                }
                M.z(ei4.e(), i, rg4Var.t(), new lj4(yj4Var.g(), rg4Var, yj4Var));
            }
        }
    }

    public static synchronized void d(vj4 vj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, vj4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                if (b(vj4Var, rg4Var)) {
                    return;
                }
                if (vj4Var.f() != null && !vj4Var.f().isEmpty()) {
                    HashMap<String, String> f = ai4.f(vj4Var);
                    if (rg4Var.B() != null && f != null) {
                        f.putAll(rg4Var.B());
                    }
                    JSONObject d = ai4.d(vj4Var);
                    if (d == null) {
                        rg4Var.C(new qh4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, rg4Var.y());
                    rg4Var.D();
                    hg4.b().M().b(ei4.d(), f, rg4Var.t(), d, new jj4(rg4Var, vj4Var));
                    return;
                }
                rg4Var.C(new qh4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(bk4 bk4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, bk4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                if (b(bk4Var, rg4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(bk4Var.f())) {
                    rg4Var.C(new qh4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(bk4Var.k())) {
                    rg4Var.C(new qh4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = ai4.k(bk4Var);
                    if (rg4Var.B() != null) {
                        k.putAll(rg4Var.B());
                    }
                    rg4Var.D();
                    hg4.b().M().z(ei4.e(), k, rg4Var.t(), new nj4(bk4Var.f(), rg4Var, bk4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable lg4 lg4Var) {
        fg4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, lg4Var) != null) || (b = hg4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ll4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(ei4.c(), hashMap, null, jSONObject, new mg4(lg4Var));
    }

    public static synchronized void f(xj4 xj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, xj4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                if (b(xj4Var, rg4Var)) {
                    return;
                }
                if (xj4Var.f() != null && !xj4Var.f().isEmpty()) {
                    HashMap<String, String> f = ai4.f(xj4Var);
                    if (rg4Var.B() != null && f != null) {
                        f.putAll(rg4Var.B());
                    }
                    JSONObject e = ai4.e(xj4Var);
                    if (e == null) {
                        rg4Var.C(new qh4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(hg4.b())) {
                        ll4.e().f();
                    }
                    a(e, rg4Var.y());
                    rg4Var.D();
                    hg4.b().M().b(ei4.d(), f, rg4Var.t(), e, new kj4(rg4Var, xj4Var));
                    return;
                }
                rg4Var.C(new qh4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(zj4 zj4Var, rg4 rg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, zj4Var, rg4Var) == null) {
            synchronized (gg4.class) {
                if (b(zj4Var, rg4Var)) {
                    return;
                }
                HashMap<String, String> j = ai4.j(zj4Var);
                if (rg4Var.B() != null) {
                    j.putAll(rg4Var.B());
                }
                rg4Var.D();
                hg4.b().M().z(ei4.f(), j, rg4Var.t(), new mj4(rg4Var, zj4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (gg4.class) {
                c = wi4.b().c(str);
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
            synchronized (gg4.class) {
                d = wi4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(dk4 dk4Var, rg4 rg4Var, rg4 rg4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, dk4Var, rg4Var, rg4Var2) == null) {
            synchronized (gg4.class) {
                n(dk4Var, rg4Var, rg4Var2, null);
            }
        }
    }

    public static synchronized void n(dk4 dk4Var, rg4 rg4Var, rg4 rg4Var2, @Nullable tl4 tl4Var) {
        gk4<JSONArray> g;
        rg4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, dk4Var, rg4Var, rg4Var2, tl4Var) == null) {
            synchronized (gg4.class) {
                if (b(dk4Var, rg4Var)) {
                    return;
                }
                if (PMSConstants.a(hg4.b())) {
                    ll4.e().f();
                }
                if (tl4Var == null) {
                    g = null;
                } else {
                    g = tl4Var.g();
                }
                if (tl4Var == null) {
                    callback = null;
                } else {
                    callback = tl4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (rg4Var.B() != null) {
                    hashMap.putAll(rg4Var.B());
                }
                rg4Var.D();
                hg4.b().M().b(ei4.g(), hashMap, rg4Var.t(), i(g, null), new oj4(rg4Var, dk4Var, rg4Var2, callback));
            }
        }
    }

    public static synchronized void o(tl4 tl4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, tl4Var) == null) {
            synchronized (gg4.class) {
                if (tl4Var == null) {
                    return;
                }
                rg4 callback = tl4Var.getCallback();
                if (callback == null) {
                    return;
                }
                ck4 request = tl4Var.getRequest();
                if (request == null) {
                    callback.C(new qh4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                hg4.b().M().b(ei4.g(), B, callback.t(), i(tl4Var.g(), null), new oj4(callback, request, null, callback));
            }
        }
    }
}
