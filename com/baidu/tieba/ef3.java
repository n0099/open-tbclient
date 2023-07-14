package com.baidu.tieba;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.tieba.eb2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class ef3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;

        public a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            eb2 U;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (U = ix2.T().U()) != null) {
                eb2.b i = U.i(this.a);
                i.f();
                i.b();
                v82.k("ActionUtils", "popAllFragment: finish");
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947732375, "Lcom/baidu/tieba/ef3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947732375, "Lcom/baidu/tieba/ef3;");
                return;
            }
        }
        a = fs1.a;
    }

    public static String h() {
        InterceptResult invokeV;
        by1 q3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) {
            db2 H = ix2.T().H();
            if (H == null || (q3 = H.q3()) == null) {
                return null;
            }
            return q3.l();
        }
        return (String) invokeV.objValue;
    }

    public static mi2 a(by1<?> by1Var, v13 v13Var, String str) {
        InterceptResult invokeLLL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65537, null, by1Var, v13Var, str)) == null) {
            kc3 f = ix2.T().f(v13Var.d);
            mi2 mi2Var = new mi2();
            mi2Var.i = by1Var.I();
            mi2Var.a = v13Var.c;
            if (vb3.M() != null) {
                mi2Var.c = vb3.M().d0(v13Var.d);
            }
            mi2Var.k = ji2.c(vb3.M(), v13Var.a);
            mi2Var.b = v13.b(v13Var);
            mi2Var.d = f.g;
            mi2Var.e = String.valueOf(s82.a());
            if (vb3.M() != null) {
                String X = vb3.M().X(v13Var.d);
                if (!TextUtils.isEmpty(X)) {
                    if (a) {
                        Log.d("ActionUtils", "add initData: " + X);
                    }
                    mi2Var.f = X;
                }
            }
            if (!a && !ix2.T().M()) {
                z = false;
            } else {
                z = true;
            }
            mi2Var.g = z;
            mi2Var.h = str;
            if (u73.H()) {
                mi2Var.j = y82.d();
            }
            if (a) {
                Log.i("ActionUtils", "buildPageEvent: " + Arrays.toString(new Exception().getStackTrace()));
            }
            xl3.b(mi2Var.a, mi2Var.b);
            return mi2Var;
        }
        return (mi2) invokeLLL.objValue;
    }

    public static JSONObject b(@NonNull vb3 vb3Var, String str, String str2, List<String> list) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65538, null, vb3Var, str, str2, list)) == null) {
            String f = np3.f(str);
            String o = np3.o(str);
            String b = nf3.b(f);
            String c0 = vb3Var.c0(f);
            String d0 = vb3Var.d0(f);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str2);
                jSONObject.put("root", c0);
                jSONObject.put("pageType", d0);
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str);
                }
                if (!TextUtils.equals(f, b)) {
                    if (!TextUtils.isEmpty(o)) {
                        b = b + "?" + o;
                    }
                    jSONObject.put("pageRoutePath", b);
                }
                if (list != null && !list.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (String str3 : list) {
                        jSONArray.put(str3);
                    }
                    jSONObject.put("removedSlaveIDs", jSONArray);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLLLL.objValue;
    }

    public static JSONObject c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            return d(str, "");
        }
        return (JSONObject) invokeL.objValue;
    }

    @Nullable
    public static String p(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.optString("url");
        }
        return (String) invokeL.objValue;
    }

    public static void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, null, str) == null) {
            v82.k("ActionUtils", "popAllFragment: routeType=" + str);
            pp3.e0(new a(str));
        }
    }

    public static JSONObject d(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, str2)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_DATA_WEBVIEW_ID, str);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(PrefetchEvent.EVENT_KEY_PAGE_URL, str2);
                }
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
            }
            return jSONObject;
        }
        return (JSONObject) invokeLL.objValue;
    }

    /* JADX WARN: Type inference failed for: r7v2, types: [com.baidu.tieba.cy1] */
    public static void e(by1<?> by1Var, v13 v13Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, by1Var, v13Var, str) == null) {
            z43.a("route", "createAndLoadPage start.");
            String a2 = pp3.a(v13Var.c, v13Var.a, v13Var.b);
            mi2 a3 = a(by1Var, v13Var, str);
            a53.q("route", str).F(new UbcFlowEvent("slave_dispatch_start"));
            cp3.d();
            by1Var.r().setDefaultViewSize(Integer.MIN_VALUE, Integer.MIN_VALUE, v13Var.e());
            by1Var.Q(a3.b);
            ix2.T().m(by1Var.a(), mi2.a(a3));
            if (ni2.b()) {
                ni2 ni2Var = new ni2();
                ni2Var.a = by1Var.a();
                ix2.T().u(ni2.a(ni2Var));
            }
            fi3.F(by1Var.a(), a3.b);
            ai2.o(a2, by1Var);
            z43.a("route", "createAndLoadPage end.");
        }
    }

    public static void f(String str, String str2, @NonNull String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, str, str2, str3) == null) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("from", str2);
            }
            hashMap.put("url", str3);
            wl2 wl2Var = new wl2(str, hashMap);
            PrefetchEvent.c createFromReLaunch = PrefetchEvent.createFromReLaunch(str2);
            if (createFromReLaunch == null) {
                ix2.T().u(wl2Var);
                return;
            }
            li2 li2Var = new li2();
            li2Var.t(createFromReLaunch);
            li2Var.t(wl2Var);
            ix2.T().u(li2Var);
        }
    }

    public static List<String> g(eb2 eb2Var) {
        InterceptResult invokeL;
        bb2 j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, eb2Var)) == null) {
            if (eb2Var == null || eb2Var.k() < o12.g || (j = eb2Var.j(0)) == null || !(j instanceof db2)) {
                return null;
            }
            return ((db2) j).w3();
        }
        return (List) invokeL.objValue;
    }

    public static boolean i(@NonNull String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, str)) == null) {
            String h = h();
            if (a) {
                Log.i("ActionUtils", "lastPageUrl: " + h + "\ncurPageUrl: " + str);
            }
            if (h != null && str != null) {
                String x1 = sw2.x1(h);
                String x12 = sw2.x1(str);
                if (TextUtils.equals(x1, x12) || TextUtils.equals(Uri.decode(x1), x12) || TextUtils.equals(x1, Uri.decode(x12))) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void j(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65546, null, unitedSchemeEntity, callbackHandler, str) == null) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(1001, "No Package").toString(), str);
        }
    }

    public static void k(vz1 vz1Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65547, null, vz1Var, str) != null) || vz1Var == null) {
            return;
        }
        vz1Var.d(str, new v32(1001, "No Package"));
    }

    public static String o(UnitedSchemeEntity unitedSchemeEntity, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65551, null, unitedSchemeEntity, str)) == null) {
            return n(unitedSchemeEntity, str, "url");
        }
        return (String) invokeLL.objValue;
    }

    public static void l(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, vb3 vb3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65548, null, new Object[]{unitedSchemeEntity, callbackHandler, vb3Var, str, str2, list, str3}) == null) && vb3Var != null && !TextUtils.isEmpty(str3)) {
            UnitedSchemeUtility.safeCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(b(vb3Var, str2, str, list), 0).toString(), str3);
        }
    }

    public static void m(vz1 vz1Var, vb3 vb3Var, String str, String str2, List<String> list, String str3) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65549, null, new Object[]{vz1Var, vb3Var, str, str2, list, str3}) == null) && vz1Var != null && vb3Var != null && !TextUtils.isEmpty(str3)) {
            vz1Var.d(str3, new v32(0, b(vb3Var, str2, str, list)));
        }
    }

    public static String n(UnitedSchemeEntity unitedSchemeEntity, String str, String str2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65550, null, unitedSchemeEntity, str, str2)) == null) {
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            String str3 = unitedSchemeEntity.getParams().get(str);
            if (TextUtils.isEmpty(str3)) {
                return null;
            }
            try {
                return new JSONObject(str3).optString(str2);
            } catch (JSONException e) {
                if (a) {
                    e.printStackTrace();
                }
                return null;
            }
        }
        return (String) invokeLLL.objValue;
    }
}
