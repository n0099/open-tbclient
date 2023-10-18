package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.tieba.bc2;
import com.baidu.tieba.lo2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ac2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    public static void d(@NonNull PMSAppInfo pMSAppInfo, @Nullable bc2.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, pMSAppInfo, aVar) == null) {
        }
    }

    public static bc2.a e(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, pMSAppInfo)) == null) {
            return null;
        }
        return (bc2.a) invokeL.objValue;
    }

    public static void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, null) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wr1 a;

        public a(wr1 wr1Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wr1Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wr1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                ac2.i(this.a);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947610297, "Lcom/baidu/tieba/ac2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947610297, "Lcom/baidu/tieba/ac2;");
                return;
            }
        }
        a = am1.a;
        wo2.g0().getSwitch("swan_next_page_res_load", 0);
        b = false;
        p22.k("SwanAppSlaveTopPages", "swan_top_page_res_load - " + b);
        l();
    }

    public static boolean a(@NonNull wr1<?> wr1Var, @NonNull pv2 pv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, wr1Var, pv2Var)) == null) {
            e63 f = cr2.V().f(pv2Var.d);
            if (a) {
                Log.d("SwanAppSlaveTopPages", "page path - " + pv2Var.a);
                Log.d("SwanAppSlaveTopPages", "page route path - " + pv2Var.d);
            }
            return jj3.S(wr1Var, f.r);
        }
        return invokeLL.booleanValue;
    }

    public static bc2.a b(@NonNull p53 p53Var, @NonNull wr1<?> wr1Var, @NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, p53Var, wr1Var, pMSAppInfo)) == null) {
            Set<String> m = m(pMSAppInfo);
            if (m != null && m.size() > 0) {
                String str = pMSAppInfo.appId;
                String valueOf = String.valueOf(pMSAppInfo.versionCode);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(valueOf)) {
                    String str2 = lo2.e.i(str, valueOf).getPath() + File.separator;
                    bc2 bc2Var = new bc2();
                    for (String str3 : m) {
                        if (h(str2, str3)) {
                            pv2 d = pv2.d(hj3.g(str3), str2);
                            if (jj3.b(p53Var.R(), d, true) && a(wr1Var, d)) {
                                bc2Var.a(f(wr1Var, d));
                            }
                        }
                    }
                    return bc2Var.b();
                }
            }
            return null;
        }
        return (bc2.a) invokeLLL.objValue;
    }

    public static pv2 c() {
        InterceptResult invokeV;
        SwanAppActivity w;
        x42 J;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            p53 c0 = p53.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || w.isDestroyed() || (J = cr2.V().J()) == null) {
                return null;
            }
            return J.t3();
        }
        return (pv2) invokeV.objValue;
    }

    public static qf2 f(wr1<?> wr1Var, pv2 pv2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, wr1Var, pv2Var)) == null) {
            return gc2.a(y83.a(wr1Var, pv2Var, ""));
        }
        return (qf2) invokeLL.objValue;
    }

    public static boolean h(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, str, str2)) == null) {
            return lo2.C(str, str2);
        }
        return invokeLL.booleanValue;
    }

    public static JSONObject g(PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, pMSAppInfo)) == null) {
            return uv2.g().k(pMSAppInfo);
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void i(wr1<?> wr1Var) {
        long j;
        PMSAppInfo g0;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, null, wr1Var) != null) || !b || wr1Var == null) {
            return;
        }
        if (a) {
            j = System.currentTimeMillis();
        } else {
            j = 0;
        }
        p53 c0 = p53.c0();
        if (c0 == null || (g0 = c0.X().g0()) == null) {
            return;
        }
        bc2.a e = e(g0);
        if (e == null) {
            e = b(c0, wr1Var, g0);
            d(g0, e);
        }
        if (e != null) {
            jc2.V().W0(wr1Var.a(), e);
        }
        if (a) {
            long currentTimeMillis = System.currentTimeMillis();
            Log.d("SwanAppSlaveTopPages", "sendTopPageMsg cost - " + (currentTimeMillis - j) + "ms");
        }
    }

    public static void j(wr1<?> wr1Var) {
        long j;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65546, null, wr1Var) == null) && b && wr1Var != null) {
            if (a) {
                j = System.currentTimeMillis();
            } else {
                j = 0;
            }
            ExecutorUtilsExt.postOnElastic(new a(wr1Var), "SwanAppSlaveTopPages", 2);
            if (a) {
                long currentTimeMillis = System.currentTimeMillis();
                Log.d("SwanAppSlaveTopPages", "sendTopPageMsg async cost - " + (currentTimeMillis - j) + "ms");
            }
        }
    }

    public static Set<String> k(@NonNull JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, jSONObject)) == null) {
            if (jSONObject.length() <= 0) {
                return null;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!TextUtils.isEmpty(next)) {
                    linkedHashSet.add(next);
                }
            }
            if (a) {
                Log.d("SwanAppSlaveTopPages", "get top pages - " + linkedHashSet);
            }
            return linkedHashSet;
        }
        return (Set) invokeL.objValue;
    }

    public static Set<String> m(@NonNull PMSAppInfo pMSAppInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65549, null, pMSAppInfo)) == null) {
            if (a) {
                pv2 c = c();
                Log.d("SwanAppSlaveTopPages", "current page - " + c);
            }
            JSONObject g = g(pMSAppInfo);
            if (g != null && g.length() > 0) {
                if (a) {
                    Log.d("SwanAppSlaveTopPages", "pages info - " + g);
                }
                return k(g);
            }
            return null;
        }
        return (Set) invokeL.objValue;
    }
}
