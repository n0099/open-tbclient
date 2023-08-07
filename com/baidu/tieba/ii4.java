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
public class ii4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947854453, "Lcom/baidu/tieba/ii4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947854453, "Lcom/baidu/tieba/ii4;");
        }
    }

    public ii4() {
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

    public static boolean b(em4 em4Var, ti4 ti4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, em4Var, ti4Var)) == null) {
            if (ti4Var == null) {
                return true;
            }
            if (em4Var == null) {
                ti4Var.C(new sj4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable im4<JSONArray> im4Var, @Nullable im4<JSONObject> im4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, im4Var, im4Var2)) == null) {
            return lm4.a(im4Var, im4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(fm4 fm4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, fm4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                m(fm4Var, ti4Var, null);
            }
        }
    }

    public static synchronized void c(am4 am4Var, ti4 ti4Var) {
        hk4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, am4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                if (b(am4Var, ti4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(am4Var.g())) {
                    ti4Var.C(new sj4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = ck4.i(am4Var);
                if (ti4Var.B() != null) {
                    i.putAll(ti4Var.B());
                }
                ti4Var.D();
                if (am4Var.n() == 1 && am4Var.h() == 2101) {
                    M = ji4.b().n();
                } else {
                    M = ji4.b().M();
                }
                M.z(gk4.e(), i, ti4Var.t(), new nl4(am4Var.g(), ti4Var, am4Var));
            }
        }
    }

    public static synchronized void d(xl4 xl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, xl4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                if (b(xl4Var, ti4Var)) {
                    return;
                }
                if (xl4Var.f() != null && !xl4Var.f().isEmpty()) {
                    HashMap<String, String> f = ck4.f(xl4Var);
                    if (ti4Var.B() != null && f != null) {
                        f.putAll(ti4Var.B());
                    }
                    JSONObject d = ck4.d(xl4Var);
                    if (d == null) {
                        ti4Var.C(new sj4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, ti4Var.y());
                    ti4Var.D();
                    ji4.b().M().b(gk4.d(), f, ti4Var.t(), d, new ll4(ti4Var, xl4Var));
                    return;
                }
                ti4Var.C(new sj4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(dm4 dm4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, dm4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                if (b(dm4Var, ti4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(dm4Var.f())) {
                    ti4Var.C(new sj4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(dm4Var.k())) {
                    ti4Var.C(new sj4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = ck4.k(dm4Var);
                    if (ti4Var.B() != null) {
                        k.putAll(ti4Var.B());
                    }
                    ti4Var.D();
                    ji4.b().M().z(gk4.e(), k, ti4Var.t(), new pl4(dm4Var.f(), ti4Var, dm4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable ni4 ni4Var) {
        hi4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, ni4Var) != null) || (b = ji4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            nn4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(gk4.c(), hashMap, null, jSONObject, new oi4(ni4Var));
    }

    public static synchronized void f(zl4 zl4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, zl4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                if (b(zl4Var, ti4Var)) {
                    return;
                }
                if (zl4Var.f() != null && !zl4Var.f().isEmpty()) {
                    HashMap<String, String> f = ck4.f(zl4Var);
                    if (ti4Var.B() != null && f != null) {
                        f.putAll(ti4Var.B());
                    }
                    JSONObject e = ck4.e(zl4Var);
                    if (e == null) {
                        ti4Var.C(new sj4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ji4.b())) {
                        nn4.e().f();
                    }
                    a(e, ti4Var.y());
                    ti4Var.D();
                    ji4.b().M().b(gk4.d(), f, ti4Var.t(), e, new ml4(ti4Var, zl4Var));
                    return;
                }
                ti4Var.C(new sj4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(bm4 bm4Var, ti4 ti4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, bm4Var, ti4Var) == null) {
            synchronized (ii4.class) {
                if (b(bm4Var, ti4Var)) {
                    return;
                }
                HashMap<String, String> j = ck4.j(bm4Var);
                if (ti4Var.B() != null) {
                    j.putAll(ti4Var.B());
                }
                ti4Var.D();
                ji4.b().M().z(gk4.f(), j, ti4Var.t(), new ol4(ti4Var, bm4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ii4.class) {
                c = yk4.b().c(str);
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
            synchronized (ii4.class) {
                d = yk4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(fm4 fm4Var, ti4 ti4Var, ti4 ti4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, fm4Var, ti4Var, ti4Var2) == null) {
            synchronized (ii4.class) {
                n(fm4Var, ti4Var, ti4Var2, null);
            }
        }
    }

    public static synchronized void n(fm4 fm4Var, ti4 ti4Var, ti4 ti4Var2, @Nullable vn4 vn4Var) {
        im4<JSONArray> g;
        ti4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, fm4Var, ti4Var, ti4Var2, vn4Var) == null) {
            synchronized (ii4.class) {
                if (b(fm4Var, ti4Var)) {
                    return;
                }
                if (PMSConstants.a(ji4.b())) {
                    nn4.e().f();
                }
                if (vn4Var == null) {
                    g = null;
                } else {
                    g = vn4Var.g();
                }
                if (vn4Var == null) {
                    callback = null;
                } else {
                    callback = vn4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (ti4Var.B() != null) {
                    hashMap.putAll(ti4Var.B());
                }
                ti4Var.D();
                ji4.b().M().b(gk4.g(), hashMap, ti4Var.t(), i(g, null), new ql4(ti4Var, fm4Var, ti4Var2, callback));
            }
        }
    }

    public static synchronized void o(vn4 vn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, vn4Var) == null) {
            synchronized (ii4.class) {
                if (vn4Var == null) {
                    return;
                }
                ti4 callback = vn4Var.getCallback();
                if (callback == null) {
                    return;
                }
                em4 request = vn4Var.getRequest();
                if (request == null) {
                    callback.C(new sj4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ji4.b().M().b(gk4.g(), B, callback.t(), i(vn4Var.g(), null), new ql4(callback, request, null, callback));
            }
        }
    }
}
