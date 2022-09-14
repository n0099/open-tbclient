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
public class ia4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947846765, "Lcom/baidu/tieba/ia4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947846765, "Lcom/baidu/tieba/ia4;");
        }
    }

    public ia4() {
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

    public static boolean b(ee4 ee4Var, ta4 ta4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, ee4Var, ta4Var)) == null) {
            if (ta4Var == null) {
                return true;
            }
            if (ee4Var == null) {
                ta4Var.C(new sb4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static synchronized void c(ae4 ae4Var, ta4 ta4Var) {
        hc4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, ae4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                if (b(ae4Var, ta4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(ae4Var.g())) {
                    ta4Var.C(new sb4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = cc4.i(ae4Var);
                if (ta4Var.B() != null) {
                    i.putAll(ta4Var.B());
                }
                ta4Var.D();
                if (ae4Var.n() == 1 && ae4Var.h() == 2101) {
                    M = ja4.b().n();
                } else {
                    M = ja4.b().M();
                }
                M.z(gc4.e(), i, ta4Var.t(), new nd4(ae4Var.g(), ta4Var, ae4Var));
            }
        }
    }

    public static synchronized void d(xd4 xd4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xd4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                if (b(xd4Var, ta4Var)) {
                    return;
                }
                if (xd4Var.f() != null && !xd4Var.f().isEmpty()) {
                    HashMap<String, String> f = cc4.f(xd4Var);
                    if (ta4Var.B() != null && f != null) {
                        f.putAll(ta4Var.B());
                    }
                    JSONObject d = cc4.d(xd4Var);
                    if (d == null) {
                        ta4Var.C(new sb4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, ta4Var.y());
                    ta4Var.D();
                    ja4.b().M().b(gc4.d(), f, ta4Var.t(), d, new ld4(ta4Var, xd4Var));
                    return;
                }
                ta4Var.C(new sb4(2100, "pkg List为空"));
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable na4 na4Var) {
        ha4 b;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65542, null, list, str, na4Var) == null) || (b = ja4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            nf4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(gc4.c(), hashMap, null, jSONObject, new oa4(na4Var));
    }

    public static synchronized void f(zd4 zd4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, zd4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                if (b(zd4Var, ta4Var)) {
                    return;
                }
                if (zd4Var.f() != null && !zd4Var.f().isEmpty()) {
                    HashMap<String, String> f = cc4.f(zd4Var);
                    if (ta4Var.B() != null && f != null) {
                        f.putAll(ta4Var.B());
                    }
                    JSONObject e = cc4.e(zd4Var);
                    if (e == null) {
                        ta4Var.C(new sb4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ja4.b())) {
                        nf4.e().f();
                    }
                    a(e, ta4Var.y());
                    ta4Var.D();
                    ja4.b().M().b(gc4.d(), f, ta4Var.t(), e, new md4(ta4Var, zd4Var));
                    return;
                }
                ta4Var.C(new sb4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(be4 be4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, be4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                if (b(be4Var, ta4Var)) {
                    return;
                }
                HashMap<String, String> j = cc4.j(be4Var);
                if (ta4Var.B() != null) {
                    j.putAll(ta4Var.B());
                }
                ta4Var.D();
                ja4.b().M().z(gc4.f(), j, ta4Var.t(), new od4(ta4Var, be4Var));
            }
        }
    }

    public static synchronized void h(de4 de4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, de4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                if (b(de4Var, ta4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(de4Var.f())) {
                    ta4Var.C(new sb4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(de4Var.k())) {
                    ta4Var.C(new sb4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = cc4.k(de4Var);
                    if (ta4Var.B() != null) {
                        k.putAll(ta4Var.B());
                    }
                    ta4Var.D();
                    ja4.b().M().z(gc4.e(), k, ta4Var.t(), new pd4(de4Var.f(), ta4Var, de4Var));
                }
            }
        }
    }

    public static JSONObject i(@Nullable ie4<JSONArray> ie4Var, @Nullable ie4<JSONObject> ie4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, ie4Var, ie4Var2)) == null) ? le4.a(ie4Var, ie4Var2) : (JSONObject) invokeLL.objValue;
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ia4.class) {
                c = yc4.b().c(str);
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
            synchronized (ia4.class) {
                d = yc4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void l(fe4 fe4Var, ta4 ta4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, fe4Var, ta4Var) == null) {
            synchronized (ia4.class) {
                m(fe4Var, ta4Var, null);
            }
        }
    }

    public static synchronized void m(fe4 fe4Var, ta4 ta4Var, ta4 ta4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, fe4Var, ta4Var, ta4Var2) == null) {
            synchronized (ia4.class) {
                n(fe4Var, ta4Var, ta4Var2, null);
            }
        }
    }

    public static synchronized void n(fe4 fe4Var, ta4 ta4Var, ta4 ta4Var2, @Nullable vf4 vf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, fe4Var, ta4Var, ta4Var2, vf4Var) == null) {
            synchronized (ia4.class) {
                if (b(fe4Var, ta4Var)) {
                    return;
                }
                if (PMSConstants.a(ja4.b())) {
                    nf4.e().f();
                }
                ie4<JSONArray> g = vf4Var == null ? null : vf4Var.g();
                ta4 callback = vf4Var == null ? null : vf4Var.getCallback();
                HashMap hashMap = new HashMap();
                if (ta4Var.B() != null) {
                    hashMap.putAll(ta4Var.B());
                }
                ta4Var.D();
                ja4.b().M().b(gc4.g(), hashMap, ta4Var.t(), i(g, null), new qd4(ta4Var, fe4Var, ta4Var2, callback));
            }
        }
    }

    public static synchronized void o(vf4 vf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, vf4Var) == null) {
            synchronized (ia4.class) {
                if (vf4Var == null) {
                    return;
                }
                ta4 callback = vf4Var.getCallback();
                if (callback == null) {
                    return;
                }
                ee4 request = vf4Var.getRequest();
                if (request == null) {
                    callback.C(new sb4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ja4.b().M().b(gc4.g(), B, callback.t(), i(vf4Var.g(), null), new qd4(callback, request, null, callback));
            }
        }
    }
}
