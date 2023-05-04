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
public class hf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947821779, "Lcom/baidu/tieba/hf4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947821779, "Lcom/baidu/tieba/hf4;");
        }
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

    public static boolean b(dj4 dj4Var, sf4 sf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, dj4Var, sf4Var)) == null) {
            if (sf4Var == null) {
                return true;
            }
            if (dj4Var == null) {
                sf4Var.C(new rg4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable hj4<JSONArray> hj4Var, @Nullable hj4<JSONObject> hj4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, hj4Var, hj4Var2)) == null) {
            return kj4.a(hj4Var, hj4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(ej4 ej4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, ej4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                m(ej4Var, sf4Var, null);
            }
        }
    }

    public static synchronized void c(zi4 zi4Var, sf4 sf4Var) {
        gh4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, zi4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                if (b(zi4Var, sf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(zi4Var.g())) {
                    sf4Var.C(new rg4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = bh4.i(zi4Var);
                if (sf4Var.B() != null) {
                    i.putAll(sf4Var.B());
                }
                sf4Var.D();
                if (zi4Var.n() == 1 && zi4Var.h() == 2101) {
                    M = if4.b().n();
                } else {
                    M = if4.b().M();
                }
                M.z(fh4.e(), i, sf4Var.t(), new mi4(zi4Var.g(), sf4Var, zi4Var));
            }
        }
    }

    public static synchronized void d(wi4 wi4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, wi4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                if (b(wi4Var, sf4Var)) {
                    return;
                }
                if (wi4Var.f() != null && !wi4Var.f().isEmpty()) {
                    HashMap<String, String> f = bh4.f(wi4Var);
                    if (sf4Var.B() != null && f != null) {
                        f.putAll(sf4Var.B());
                    }
                    JSONObject d = bh4.d(wi4Var);
                    if (d == null) {
                        sf4Var.C(new rg4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, sf4Var.y());
                    sf4Var.D();
                    if4.b().M().b(fh4.d(), f, sf4Var.t(), d, new ki4(sf4Var, wi4Var));
                    return;
                }
                sf4Var.C(new rg4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(cj4 cj4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, cj4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                if (b(cj4Var, sf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(cj4Var.f())) {
                    sf4Var.C(new rg4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(cj4Var.k())) {
                    sf4Var.C(new rg4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = bh4.k(cj4Var);
                    if (sf4Var.B() != null) {
                        k.putAll(sf4Var.B());
                    }
                    sf4Var.D();
                    if4.b().M().z(fh4.e(), k, sf4Var.t(), new oi4(cj4Var.f(), sf4Var, cj4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable mf4 mf4Var) {
        gf4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, mf4Var) != null) || (b = if4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            mk4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(fh4.c(), hashMap, null, jSONObject, new nf4(mf4Var));
    }

    public static synchronized void f(yi4 yi4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, yi4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                if (b(yi4Var, sf4Var)) {
                    return;
                }
                if (yi4Var.f() != null && !yi4Var.f().isEmpty()) {
                    HashMap<String, String> f = bh4.f(yi4Var);
                    if (sf4Var.B() != null && f != null) {
                        f.putAll(sf4Var.B());
                    }
                    JSONObject e = bh4.e(yi4Var);
                    if (e == null) {
                        sf4Var.C(new rg4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(if4.b())) {
                        mk4.e().f();
                    }
                    a(e, sf4Var.y());
                    sf4Var.D();
                    if4.b().M().b(fh4.d(), f, sf4Var.t(), e, new li4(sf4Var, yi4Var));
                    return;
                }
                sf4Var.C(new rg4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(aj4 aj4Var, sf4 sf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, aj4Var, sf4Var) == null) {
            synchronized (hf4.class) {
                if (b(aj4Var, sf4Var)) {
                    return;
                }
                HashMap<String, String> j = bh4.j(aj4Var);
                if (sf4Var.B() != null) {
                    j.putAll(sf4Var.B());
                }
                sf4Var.D();
                if4.b().M().z(fh4.f(), j, sf4Var.t(), new ni4(sf4Var, aj4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (hf4.class) {
                c = xh4.b().c(str);
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
            synchronized (hf4.class) {
                d = xh4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(ej4 ej4Var, sf4 sf4Var, sf4 sf4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, ej4Var, sf4Var, sf4Var2) == null) {
            synchronized (hf4.class) {
                n(ej4Var, sf4Var, sf4Var2, null);
            }
        }
    }

    public static synchronized void n(ej4 ej4Var, sf4 sf4Var, sf4 sf4Var2, @Nullable uk4 uk4Var) {
        hj4<JSONArray> g;
        sf4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, ej4Var, sf4Var, sf4Var2, uk4Var) == null) {
            synchronized (hf4.class) {
                if (b(ej4Var, sf4Var)) {
                    return;
                }
                if (PMSConstants.a(if4.b())) {
                    mk4.e().f();
                }
                if (uk4Var == null) {
                    g = null;
                } else {
                    g = uk4Var.g();
                }
                if (uk4Var == null) {
                    callback = null;
                } else {
                    callback = uk4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (sf4Var.B() != null) {
                    hashMap.putAll(sf4Var.B());
                }
                sf4Var.D();
                if4.b().M().b(fh4.g(), hashMap, sf4Var.t(), i(g, null), new pi4(sf4Var, ej4Var, sf4Var2, callback));
            }
        }
    }

    public static synchronized void o(uk4 uk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, uk4Var) == null) {
            synchronized (hf4.class) {
                if (uk4Var == null) {
                    return;
                }
                sf4 callback = uk4Var.getCallback();
                if (callback == null) {
                    return;
                }
                dj4 request = uk4Var.getRequest();
                if (request == null) {
                    callback.C(new rg4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                if4.b().M().b(fh4.g(), B, callback.t(), i(uk4Var.g(), null), new pi4(callback, request, null, callback));
            }
        }
    }
}
