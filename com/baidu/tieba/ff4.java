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
public class ff4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947762197, "Lcom/baidu/tieba/ff4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947762197, "Lcom/baidu/tieba/ff4;");
        }
    }

    public ff4() {
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

    public static boolean b(bj4 bj4Var, qf4 qf4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, bj4Var, qf4Var)) == null) {
            if (qf4Var == null) {
                return true;
            }
            if (bj4Var == null) {
                qf4Var.C(new pg4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable fj4<JSONArray> fj4Var, @Nullable fj4<JSONObject> fj4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, fj4Var, fj4Var2)) == null) {
            return ij4.a(fj4Var, fj4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(cj4 cj4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, cj4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                m(cj4Var, qf4Var, null);
            }
        }
    }

    public static synchronized void c(xi4 xi4Var, qf4 qf4Var) {
        eh4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, xi4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                if (b(xi4Var, qf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(xi4Var.g())) {
                    qf4Var.C(new pg4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = zg4.i(xi4Var);
                if (qf4Var.B() != null) {
                    i.putAll(qf4Var.B());
                }
                qf4Var.D();
                if (xi4Var.n() == 1 && xi4Var.h() == 2101) {
                    M = gf4.b().n();
                } else {
                    M = gf4.b().M();
                }
                M.z(dh4.e(), i, qf4Var.t(), new ki4(xi4Var.g(), qf4Var, xi4Var));
            }
        }
    }

    public static synchronized void d(ui4 ui4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, ui4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                if (b(ui4Var, qf4Var)) {
                    return;
                }
                if (ui4Var.f() != null && !ui4Var.f().isEmpty()) {
                    HashMap<String, String> f = zg4.f(ui4Var);
                    if (qf4Var.B() != null && f != null) {
                        f.putAll(qf4Var.B());
                    }
                    JSONObject d = zg4.d(ui4Var);
                    if (d == null) {
                        qf4Var.C(new pg4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, qf4Var.y());
                    qf4Var.D();
                    gf4.b().M().b(dh4.d(), f, qf4Var.t(), d, new ii4(qf4Var, ui4Var));
                    return;
                }
                qf4Var.C(new pg4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(aj4 aj4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, aj4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                if (b(aj4Var, qf4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(aj4Var.f())) {
                    qf4Var.C(new pg4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(aj4Var.k())) {
                    qf4Var.C(new pg4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = zg4.k(aj4Var);
                    if (qf4Var.B() != null) {
                        k.putAll(qf4Var.B());
                    }
                    qf4Var.D();
                    gf4.b().M().z(dh4.e(), k, qf4Var.t(), new mi4(aj4Var.f(), qf4Var, aj4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable kf4 kf4Var) {
        ef4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, kf4Var) != null) || (b = gf4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            kk4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(dh4.c(), hashMap, null, jSONObject, new lf4(kf4Var));
    }

    public static synchronized void f(wi4 wi4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, wi4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                if (b(wi4Var, qf4Var)) {
                    return;
                }
                if (wi4Var.f() != null && !wi4Var.f().isEmpty()) {
                    HashMap<String, String> f = zg4.f(wi4Var);
                    if (qf4Var.B() != null && f != null) {
                        f.putAll(qf4Var.B());
                    }
                    JSONObject e = zg4.e(wi4Var);
                    if (e == null) {
                        qf4Var.C(new pg4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(gf4.b())) {
                        kk4.e().f();
                    }
                    a(e, qf4Var.y());
                    qf4Var.D();
                    gf4.b().M().b(dh4.d(), f, qf4Var.t(), e, new ji4(qf4Var, wi4Var));
                    return;
                }
                qf4Var.C(new pg4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(yi4 yi4Var, qf4 qf4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, yi4Var, qf4Var) == null) {
            synchronized (ff4.class) {
                if (b(yi4Var, qf4Var)) {
                    return;
                }
                HashMap<String, String> j = zg4.j(yi4Var);
                if (qf4Var.B() != null) {
                    j.putAll(qf4Var.B());
                }
                qf4Var.D();
                gf4.b().M().z(dh4.f(), j, qf4Var.t(), new li4(qf4Var, yi4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (ff4.class) {
                c = vh4.b().c(str);
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
            synchronized (ff4.class) {
                d = vh4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(cj4 cj4Var, qf4 qf4Var, qf4 qf4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, cj4Var, qf4Var, qf4Var2) == null) {
            synchronized (ff4.class) {
                n(cj4Var, qf4Var, qf4Var2, null);
            }
        }
    }

    public static synchronized void n(cj4 cj4Var, qf4 qf4Var, qf4 qf4Var2, @Nullable sk4 sk4Var) {
        fj4<JSONArray> g;
        qf4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, cj4Var, qf4Var, qf4Var2, sk4Var) == null) {
            synchronized (ff4.class) {
                if (b(cj4Var, qf4Var)) {
                    return;
                }
                if (PMSConstants.a(gf4.b())) {
                    kk4.e().f();
                }
                if (sk4Var == null) {
                    g = null;
                } else {
                    g = sk4Var.g();
                }
                if (sk4Var == null) {
                    callback = null;
                } else {
                    callback = sk4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (qf4Var.B() != null) {
                    hashMap.putAll(qf4Var.B());
                }
                qf4Var.D();
                gf4.b().M().b(dh4.g(), hashMap, qf4Var.t(), i(g, null), new ni4(qf4Var, cj4Var, qf4Var2, callback));
            }
        }
    }

    public static synchronized void o(sk4 sk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, sk4Var) == null) {
            synchronized (ff4.class) {
                if (sk4Var == null) {
                    return;
                }
                qf4 callback = sk4Var.getCallback();
                if (callback == null) {
                    return;
                }
                bj4 request = sk4Var.getRequest();
                if (request == null) {
                    callback.C(new pg4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                gf4.b().M().b(dh4.g(), B, callback.t(), i(sk4Var.g(), null), new ni4(callback, request, null, callback));
            }
        }
    }
}
