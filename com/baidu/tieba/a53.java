package com.baidu.tieba;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.SavedStateHandle;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.live.ubc.FlowInfoHelper;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a53 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static final File b;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947566122, "Lcom/baidu/tieba/a53;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947566122, "Lcom/baidu/tieba/a53;");
                return;
            }
        }
        a = nr1.a;
        b = AppRuntime.getAppContext().getExternalCacheDir();
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return b + File.separator + "swan_perf";
        }
        return (String) invokeV.objValue;
    }

    public static JSONObject a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            JSONObject jSONObject = new JSONObject();
            JSONObject C = ku2.g0().C();
            String k = ku2.g0().k();
            try {
                jSONObject.put("switch", C);
                JSONArray jSONArray = null;
                if (!TextUtils.isEmpty(k)) {
                    jSONArray = new JSONArray();
                    for (String str : k.split("-")) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("sid", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public static JSONObject c(List<UbcFlowEvent> list, JSONObject jSONObject) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, list, jSONObject)) == null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (UbcFlowEvent ubcFlowEvent : list) {
                if (!ubcFlowEvent.b()) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("id", ubcFlowEvent.a);
                        jSONObject3.put("time", ubcFlowEvent.g());
                        jSONObject3.put("value", ubcFlowEvent.j());
                        jSONArray.put(jSONObject3);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            try {
                jSONObject2.put(FlowInfoHelper.KEY_EVENTLIST, jSONArray);
                jSONObject2.put(SavedStateHandle.VALUES, jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject2;
        }
        return (JSONObject) invokeLL.objValue;
    }

    public static void d(List<UbcFlowEvent> list, JSONObject jSONObject) {
        db3 b0;
        Map<String, String> t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, list, jSONObject) == null) {
            if (a) {
                cq4.b().f();
            }
            if (!c73.E() || (b0 = db3.b0()) == null || (t = vo3.t(vo3.o(b0.W().W()))) == null || !TextUtils.equals(t.get("_SwanStartupPerf_"), "1")) {
                return;
            }
            ArrayList arrayList = new ArrayList(list);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("670", c(arrayList, jSONObject));
                jSONObject2.put(DI.AB_NAME, a());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            File file = new File(b, "swan_perf");
            if (!file.exists() && !file.mkdirs()) {
                return;
            }
            hr4.N(jSONObject2.toString(), new File(file, String.format(Locale.getDefault(), "perf_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }

    public static void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, str) == null) {
            File file = new File(b, "swan_stability");
            if (!hr4.m(file)) {
                d82.k("StartupPerf", "创建目录失败 path" + file);
                return;
            }
            hr4.N(str, new File(file, String.format(Locale.getDefault(), "stability_%s.json", Long.valueOf(System.currentTimeMillis() / 1000))));
        }
    }
}
