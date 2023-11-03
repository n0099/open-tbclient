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
public class e23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947682403, "Lcom/baidu/tieba/e23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947682403, "Lcom/baidu/tieba/e23;");
                return;
            }
        }
        a = rm1.a;
    }

    public static void j() {
        p52 W;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65546, null) == null) && (W = tr2.V().W()) != null && (W.m() instanceof q52)) {
            tr2.V().getActivity().onBackPressed();
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
            y13.b(str + ", dynamicLibPath = " + b + "; dynamicLibConfig = " + b2 + "; pluginPath = " + b3 + "; dependenciesPath = " + b4 + "; dependenciesConfig = " + b5);
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
            g63 M = g63.M();
            if (M != null) {
                str2 = M.V().e(str, null);
            } else {
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                map.put(str, str2);
                return str2;
            }
            if (M != null) {
                swanAppConfigData = M.R();
            } else {
                swanAppConfigData = null;
            }
            if (i == 3) {
                n13.m(swanAppConfigData, false);
                str2 = i(str, null);
            } else if (i == 4) {
                str2 = l(swanAppConfigData);
            } else if (i == 6) {
                l13.a(swanAppConfigData);
                str2 = i(str, null);
            }
            map.put(str, str2);
            return str2;
        }
        return (String) invokeLLI.objValue;
    }

    public static void c(String str, String str2) {
        g63 M;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65539, null, str, str2) == null) && !TextUtils.isEmpty(str) && (M = g63.M()) != null) {
            M.V().j(str, str2);
        }
    }

    public static String i(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, str, str2)) == null) {
            g63 M = g63.M();
            if (M != null && !TextUtils.isEmpty(str)) {
                return M.V().e(str, str2);
            }
            return null;
        }
        return (String) invokeLL.objValue;
    }

    public static String d(List<c23> list) {
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
            hf4 g = g(str);
            if (g != null && !TextUtils.isEmpty(g.r)) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return g.r;
            }
            y13.b("get plugin appKey form db, but empty, plugin appId = " + str);
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static hf4 h(String str) {
        InterceptResult invokeL;
        SwanAppConfigData R;
        List<hf4> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!x32.d() && !f23.H() && !f23.D()) {
                return g(str);
            }
            g63 M = g63.M();
            if (M != null && (R = M.R()) != null && (list = R.l) != null) {
                for (hf4 hf4Var : list) {
                    if (TextUtils.equals(str, hf4Var.g)) {
                        return hf4Var;
                    }
                }
            }
            return null;
        }
        return (hf4) invokeL.objValue;
    }

    public static String e(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, str2)) == null) {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return null;
            }
            SwanAppConfigData b = s63.b(str);
            if (b == null) {
                y13.b("getDownloadKey, app.json is null");
                return null;
            }
            SwanAppConfigData.m mVar = b.d;
            if (mVar == null) {
                y13.b("getDownloadKey, sub pkg obj is null");
                return null;
            }
            Map<String, String> map = mVar.a;
            if (map == null) {
                y13.b("getDownloadKey, sub pkg map is null");
                return null;
            }
            return map.get(str2);
        }
        return (String) invokeLL.objValue;
    }

    public static hf4 g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return n13.p(str, com.kuaishou.weapon.p0.q1.e, 0L);
        }
        return (hf4) invokeL.objValue;
    }

    public static List<hf4> k(String str, boolean z) {
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
                            hf4 hf4Var = new hf4();
                            hf4Var.g = optString;
                            hf4Var.i = optJSONObject.optLong("version_code", 0L);
                            hf4Var.j = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, com.kuaishou.weapon.p0.q1.e);
                            hf4Var.p = optJSONObject.optString("token");
                            hf4Var.q = optJSONObject.optString("domains");
                            hf4Var.h = 4;
                            hf4Var.r = optJSONObject.optString(GameGuideConfigInfo.KEY_APP_KEY);
                            hf4Var.s = optJSONObject.optString("app_name");
                            hf4Var.l = "";
                            hf4Var.m = "";
                            hf4Var.n = "";
                            arrayList.add(hf4Var);
                            if (z) {
                                de4.i().m(hf4Var);
                            }
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e) {
                y13.b(Log.getStackTraceString(e));
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
                y13.b("parse app.json is null");
                return null;
            }
            List<c23> i = swanAppConfigData.i(4);
            if (i != null && !i.isEmpty()) {
                JSONObject jSONObject = new JSONObject();
                for (c23 c23Var : i) {
                    if (c23Var != null && c23Var.a()) {
                        gj3.f(jSONObject, c23Var.a, c23Var.e);
                    }
                }
                String jSONObject2 = jSONObject.toString();
                c("pluginPath", jSONObject2);
                return jSONObject2;
            }
            c("pluginPath", null);
            y13.b("this swan app not apply on someone plugin");
            return null;
        }
        return (String) invokeL.objValue;
    }
}
