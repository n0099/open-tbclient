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
/* loaded from: classes6.dex */
public class ij4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947855414, "Lcom/baidu/tieba/ij4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947855414, "Lcom/baidu/tieba/ij4;");
        }
    }

    public ij4() {
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

    public static boolean b(en4 en4Var, tj4 tj4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, en4Var, tj4Var)) == null) {
            if (tj4Var == null) {
                return true;
            }
            if (en4Var == null) {
                tj4Var.C(new sk4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable in4<JSONArray> in4Var, @Nullable in4<JSONObject> in4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, in4Var, in4Var2)) == null) {
            return ln4.a(in4Var, in4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(fn4 fn4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, fn4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                m(fn4Var, tj4Var, null);
            }
        }
    }

    public static synchronized void c(an4 an4Var, tj4 tj4Var) {
        hl4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, an4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                if (b(an4Var, tj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(an4Var.g())) {
                    tj4Var.C(new sk4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = cl4.i(an4Var);
                if (tj4Var.B() != null) {
                    i.putAll(tj4Var.B());
                }
                tj4Var.D();
                if (an4Var.n() == 1 && an4Var.h() == 2101) {
                    M = jj4.b().n();
                } else {
                    M = jj4.b().M();
                }
                M.z(gl4.e(), i, tj4Var.t(), new nm4(an4Var.g(), tj4Var, an4Var));
            }
        }
    }

    public static synchronized void d(xm4 xm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xm4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                if (b(xm4Var, tj4Var)) {
                    return;
                }
                if (xm4Var.f() != null && !xm4Var.f().isEmpty()) {
                    HashMap<String, String> f = cl4.f(xm4Var);
                    if (tj4Var.B() != null && f != null) {
                        f.putAll(tj4Var.B());
                    }
                    JSONObject d = cl4.d(xm4Var);
                    if (d == null) {
                        tj4Var.C(new sk4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, tj4Var.y());
                    tj4Var.D();
                    jj4.b().M().b(gl4.d(), f, tj4Var.t(), d, new lm4(tj4Var, xm4Var));
                    return;
                }
                tj4Var.C(new sk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(dn4 dn4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, dn4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                if (b(dn4Var, tj4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(dn4Var.f())) {
                    tj4Var.C(new sk4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(dn4Var.k())) {
                    tj4Var.C(new sk4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = cl4.k(dn4Var);
                    if (tj4Var.B() != null) {
                        k.putAll(tj4Var.B());
                    }
                    tj4Var.D();
                    jj4.b().M().z(gl4.e(), k, tj4Var.t(), new pm4(dn4Var.f(), tj4Var, dn4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable nj4 nj4Var) {
        hj4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, nj4Var) != null) || (b = jj4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            no4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(gl4.c(), hashMap, null, jSONObject, new oj4(nj4Var));
    }

    public static synchronized void f(zm4 zm4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, zm4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                if (b(zm4Var, tj4Var)) {
                    return;
                }
                if (zm4Var.f() != null && !zm4Var.f().isEmpty()) {
                    HashMap<String, String> f = cl4.f(zm4Var);
                    if (tj4Var.B() != null && f != null) {
                        f.putAll(tj4Var.B());
                    }
                    JSONObject e = cl4.e(zm4Var);
                    if (e == null) {
                        tj4Var.C(new sk4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(jj4.b())) {
                        no4.e().f();
                    }
                    a(e, tj4Var.y());
                    tj4Var.D();
                    jj4.b().M().b(gl4.d(), f, tj4Var.t(), e, new mm4(tj4Var, zm4Var));
                    return;
                }
                tj4Var.C(new sk4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(bn4 bn4Var, tj4 tj4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, bn4Var, tj4Var) == null) {
            synchronized (ij4.class) {
                if (b(bn4Var, tj4Var)) {
                    return;
                }
                HashMap<String, String> j = cl4.j(bn4Var);
                if (tj4Var.B() != null) {
                    j.putAll(tj4Var.B());
                }
                tj4Var.D();
                jj4.b().M().z(gl4.f(), j, tj4Var.t(), new om4(tj4Var, bn4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ij4.class) {
                c = yl4.b().c(str);
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
            synchronized (ij4.class) {
                d = yl4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(fn4 fn4Var, tj4 tj4Var, tj4 tj4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, fn4Var, tj4Var, tj4Var2) == null) {
            synchronized (ij4.class) {
                n(fn4Var, tj4Var, tj4Var2, null);
            }
        }
    }

    public static synchronized void n(fn4 fn4Var, tj4 tj4Var, tj4 tj4Var2, @Nullable vo4 vo4Var) {
        in4<JSONArray> g;
        tj4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, fn4Var, tj4Var, tj4Var2, vo4Var) == null) {
            synchronized (ij4.class) {
                if (b(fn4Var, tj4Var)) {
                    return;
                }
                if (PMSConstants.a(jj4.b())) {
                    no4.e().f();
                }
                if (vo4Var == null) {
                    g = null;
                } else {
                    g = vo4Var.g();
                }
                if (vo4Var == null) {
                    callback = null;
                } else {
                    callback = vo4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (tj4Var.B() != null) {
                    hashMap.putAll(tj4Var.B());
                }
                tj4Var.D();
                jj4.b().M().b(gl4.g(), hashMap, tj4Var.t(), i(g, null), new qm4(tj4Var, fn4Var, tj4Var2, callback));
            }
        }
    }

    public static synchronized void o(vo4 vo4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, vo4Var) == null) {
            synchronized (ij4.class) {
                if (vo4Var == null) {
                    return;
                }
                tj4 callback = vo4Var.getCallback();
                if (callback == null) {
                    return;
                }
                en4 request = vo4Var.getRequest();
                if (request == null) {
                    callback.C(new sk4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                jj4.b().M().b(gl4.g(), B, callback.t(), i(vo4Var.g(), null), new qm4(callback, request, null, callback));
            }
        }
    }
}
