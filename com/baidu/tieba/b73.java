package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.yy.hiidostatis.defs.obj.ParamableElem;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b73 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947597835, "Lcom/baidu/tieba/b73;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947597835, "Lcom/baidu/tieba/b73;");
                return;
            }
        }
        a = nr1.a;
    }

    public static void j() {
        ma2 U;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (U = qw2.T().U()) != null && (U.m() instanceof na2)) {
            qw2.T().getActivity().onBackPressed();
        }
    }

    public static void a(Map<String, String> map, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65537, null, map, str) != null) || map == null) {
            return;
        }
        String b = b(map, "dynamicLibPath", 3);
        String b2 = b(map, "dynamicLibConfig", 3);
        String b3 = b(map, "pluginPath", 4);
        String b4 = b(map, "dependenciesPath", 6);
        String b5 = b(map, "dependenciesConfig", 6);
        if (!TextUtils.isEmpty(str) && a) {
            v63.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
        }
    }

    public static String b(Map<String, String> map, String str, int i) {
        InterceptResult invokeLLI;
        String str2;
        SwanAppConfigData swanAppConfigData;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65538, null, map, str, i)) == null) {
            if (map == null || TextUtils.isEmpty(str)) {
                return null;
            }
            db3 M = db3.M();
            if (M != null) {
                str2 = M.U().e(str, null);
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
                return str2;
            }
            if (M != null) {
                swanAppConfigData = M.Q();
            } else {
                swanAppConfigData = null;
            }
            if (i == 3) {
                k63.m(swanAppConfigData, false);
                str2 = i(str, null);
            } else if (i == 4) {
                str2 = l(swanAppConfigData);
            } else if (i == 6) {
                i63.a(swanAppConfigData);
                str2 = i(str, null);
            }
            map.put(str, str2);
            return str2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        db3 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !TextUtils.isEmpty(str) && (M = db3.M()) != null) {
            M.U().j(str, str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            db3 M = db3.M();
            if (M != null && !TextUtils.isEmpty(str)) {
                return M.U().e(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(List<z63> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            int size = list.size();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from (SELECT * from ");
            sb.append("swan_plugin");
            sb.append(" ORDER BY update_time) group by bundle_id having bundle_id in ");
            sb.append("(");
            for (int i = 0; i < size; i++) {
                sb.append("'");
                sb.append(list.get(i).a);
                sb.append("'");
                if (i == size - 1) {
                    sb.append(SmallTailInfo.EMOTION_SUFFIX);
                } else {
                    sb.append(",");
                }
            }
            sb.append(ParamableElem.DIVIDE_PARAM);
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }

    public static String f(String str) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ek4 g = g(str);
            if (g != null && !TextUtils.isEmpty(g.r)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return g.r;
            }
            v63.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static ek4 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData Q;
        List<ek4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!u82.d() && !c73.H() && !c73.D()) {
                return g(str);
            }
            db3 M = db3.M();
            if (M != null && (Q = M.Q()) != null && (list = Q.l) != null) {
                for (ek4 ek4Var : list) {
                    if (TextUtils.equals(str, ek4Var.g)) {
                        return ek4Var;
                    }
                }
            }
            return null;
        }
        return (ek4) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = pb3.b(str);
            if (b == null) {
                v63.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                v63.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                v63.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static ek4 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return k63.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (ek4) invokeL.objValue;
    }

    public static List<ek4> k(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                JSONArray jSONArray = new JSONArray(str);
                int length = jSONArray.length();
                if (length == 0) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("plugin_id");
                        if (!TextUtils.isEmpty(optString)) {
                            ek4 ek4Var = new ek4();
                            ek4Var.g = optString;
                            ek4Var.i = optJSONObject.optLong("version_code", 0L);
                            ek4Var.j = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.kuaishou.weapon.p0.q1.e);
                            ek4Var.p = optJSONObject.optString("token");
                            ek4Var.q = optJSONObject.optString("domains");
                            ek4Var.h = 4;
                            ek4Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            ek4Var.s = optJSONObject.optString("app_name");
                            ek4Var.l = "";
                            ek4Var.m = "";
                            ek4Var.n = "";
                            arrayList.add(ek4Var);
                            if (z) {
                                aj4.i().m(ek4Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                v63.b(Log.getStackTraceString(e));
                return null;
            }
        }
        return (List) invokeLZ.objValue;
    }

    public static String l(SwanAppConfigData swanAppConfigData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, null, swanAppConfigData)) == null) {
            if (swanAppConfigData == null) {
                v63.b("parse app.json is null");
                return null;
            }
            List<z63> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (z63 z63Var : i) {
                    if (z63Var != null && z63Var.a()) {
                        do3.f(jSONObject, z63Var.a, z63Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            v63.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
