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
public class df4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947702615, "Lcom/baidu/tieba/df4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947702615, "Lcom/baidu/tieba/df4;");
        }
    }

    public df4() {
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

    public static boolean b(zi4 zi4Var, of4 of4Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, zi4Var, of4Var)) == null) {
            if (of4Var == null) {
                return true;
            }
            if (zi4Var == null) {
                of4Var.C(new ng4(2100, "request对象为空"));
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject i(@Nullable dj4<JSONArray> dj4Var, @Nullable dj4<JSONObject> dj4Var2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, dj4Var, dj4Var2)) == null) {
            return gj4.a(dj4Var, dj4Var2);
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static synchronized void l(aj4 aj4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, aj4Var, of4Var) == null) {
            synchronized (df4.class) {
                m(aj4Var, of4Var, null);
            }
        }
    }

    public static synchronized void c(vi4 vi4Var, of4 of4Var) {
        ch4 M;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, vi4Var, of4Var) == null) {
            synchronized (df4.class) {
                if (b(vi4Var, of4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(vi4Var.g())) {
                    of4Var.C(new ng4(2100, "bundleId为空"));
                    return;
                }
                HashMap<String, String> i = xg4.i(vi4Var);
                if (of4Var.B() != null) {
                    i.putAll(of4Var.B());
                }
                of4Var.D();
                if (vi4Var.n() == 1 && vi4Var.h() == 2101) {
                    M = ef4.b().n();
                } else {
                    M = ef4.b().M();
                }
                M.z(bh4.e(), i, of4Var.t(), new ii4(vi4Var.g(), of4Var, vi4Var));
            }
        }
    }

    public static synchronized void d(si4 si4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, si4Var, of4Var) == null) {
            synchronized (df4.class) {
                if (b(si4Var, of4Var)) {
                    return;
                }
                if (si4Var.f() != null && !si4Var.f().isEmpty()) {
                    HashMap<String, String> f = xg4.f(si4Var);
                    if (of4Var.B() != null && f != null) {
                        f.putAll(of4Var.B());
                    }
                    JSONObject d = xg4.d(si4Var);
                    if (d == null) {
                        of4Var.C(new ng4(2100, "构造请求body失败"));
                        return;
                    }
                    a(d, of4Var.y());
                    of4Var.D();
                    ef4.b().M().b(bh4.d(), f, of4Var.t(), d, new gi4(of4Var, si4Var));
                    return;
                }
                of4Var.C(new ng4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void h(yi4 yi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, yi4Var, of4Var) == null) {
            synchronized (df4.class) {
                if (b(yi4Var, of4Var)) {
                    return;
                }
                if (TextUtils.isEmpty(yi4Var.f())) {
                    of4Var.C(new ng4(2100, "bundleId为空"));
                } else if (TextUtils.isEmpty(yi4Var.k())) {
                    of4Var.C(new ng4(2100, "分包名为空"));
                } else {
                    HashMap<String, String> k = xg4.k(yi4Var);
                    if (of4Var.B() != null) {
                        k.putAll(of4Var.B());
                    }
                    of4Var.D();
                    ef4.b().M().z(bh4.e(), k, of4Var.t(), new ki4(yi4Var.f(), of4Var, yi4Var));
                }
            }
        }
    }

    public static void e(List<String> list, @Nullable String str, @Nullable if4 if4Var) {
        cf4 b;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLL(65542, null, list, str, if4Var) != null) || (b = ef4.b()) == null) {
            return;
        }
        if (PMSConstants.a(b)) {
            ik4.e().f();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appkeys", new JSONArray((Collection) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("src_app", str);
        b.M().b(bh4.c(), hashMap, null, jSONObject, new jf4(if4Var));
    }

    public static synchronized void f(ui4 ui4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, ui4Var, of4Var) == null) {
            synchronized (df4.class) {
                if (b(ui4Var, of4Var)) {
                    return;
                }
                if (ui4Var.f() != null && !ui4Var.f().isEmpty()) {
                    HashMap<String, String> f = xg4.f(ui4Var);
                    if (of4Var.B() != null && f != null) {
                        f.putAll(of4Var.B());
                    }
                    JSONObject e = xg4.e(ui4Var);
                    if (e == null) {
                        of4Var.C(new ng4(2100, "构造请求body失败"));
                        return;
                    }
                    if (PMSConstants.a(ef4.b())) {
                        ik4.e().f();
                    }
                    a(e, of4Var.y());
                    of4Var.D();
                    ef4.b().M().b(bh4.d(), f, of4Var.t(), e, new hi4(of4Var, ui4Var));
                    return;
                }
                of4Var.C(new ng4(2100, "pkg List为空"));
            }
        }
    }

    public static synchronized void g(wi4 wi4Var, of4 of4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, wi4Var, of4Var) == null) {
            synchronized (df4.class) {
                if (b(wi4Var, of4Var)) {
                    return;
                }
                HashMap<String, String> j = xg4.j(wi4Var);
                if (of4Var.B() != null) {
                    j.putAll(of4Var.B());
                }
                of4Var.D();
                ef4.b().M().z(bh4.f(), j, of4Var.t(), new ji4(of4Var, wi4Var));
            }
        }
    }

    public static synchronized boolean j(String str) {
        InterceptResult invokeL;
        boolean c;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, str)) == null) {
            synchronized (df4.class) {
                c = th4.b().c(str);
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
            synchronized (df4.class) {
                d = th4.b().d(str);
            }
            return d;
        }
        return invokeL.booleanValue;
    }

    public static synchronized void m(aj4 aj4Var, of4 of4Var, of4 of4Var2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65550, null, aj4Var, of4Var, of4Var2) == null) {
            synchronized (df4.class) {
                n(aj4Var, of4Var, of4Var2, null);
            }
        }
    }

    public static synchronized void n(aj4 aj4Var, of4 of4Var, of4 of4Var2, @Nullable qk4 qk4Var) {
        dj4<JSONArray> g;
        of4 callback;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65551, null, aj4Var, of4Var, of4Var2, qk4Var) == null) {
            synchronized (df4.class) {
                if (b(aj4Var, of4Var)) {
                    return;
                }
                if (PMSConstants.a(ef4.b())) {
                    ik4.e().f();
                }
                if (qk4Var == null) {
                    g = null;
                } else {
                    g = qk4Var.g();
                }
                if (qk4Var == null) {
                    callback = null;
                } else {
                    callback = qk4Var.getCallback();
                }
                HashMap hashMap = new HashMap();
                if (of4Var.B() != null) {
                    hashMap.putAll(of4Var.B());
                }
                of4Var.D();
                ef4.b().M().b(bh4.g(), hashMap, of4Var.t(), i(g, null), new li4(of4Var, aj4Var, of4Var2, callback));
            }
        }
    }

    public static synchronized void o(qk4 qk4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65552, null, qk4Var) == null) {
            synchronized (df4.class) {
                if (qk4Var == null) {
                    return;
                }
                of4 callback = qk4Var.getCallback();
                if (callback == null) {
                    return;
                }
                zi4 request = qk4Var.getRequest();
                if (request == null) {
                    callback.C(new ng4(2100, "request对象为空"));
                    return;
                }
                Map<String, String> B = callback.B();
                if (callback.B() != null) {
                    B = new HashMap(B);
                }
                callback.D();
                ef4.b().M().b(bh4.g(), B, callback.t(), i(qk4Var.g(), null), new li4(callback, request, null, callback));
            }
        }
    }
}
