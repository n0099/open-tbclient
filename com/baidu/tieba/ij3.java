package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.chatmessage.messages.gfh.GfhKeyValue;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class ij3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1947855383, "Lcom/baidu/tieba/ij3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1947855383, "Lcom/baidu/tieba/ij3;");
                return;
            }
        }
        a = am1.a;
    }

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (p53.M() != null) {
                return p53.M().b;
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    public static String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return di3.b(di3.a(), "yyyy-MM-dd");
        }
        return (String) invokeV.objValue;
    }

    public static int c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            JSONObject d = d(a());
            if (d == null) {
                return 0;
            }
            return d.optInt("launch_count", 0);
        }
        return invokeV.intValue;
    }

    public static void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            i(a(), "visit_duration", Long.valueOf(e()));
        }
    }

    public static JSONObject d(String str) {
        InterceptResult invokeL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, str)) == null) {
            String string = de3.a().getString("dailyInfo", "");
            if (a) {
                Log.i("SwanAppUserVisitInfoUtils", "dailyInfo:" + string);
            }
            JSONObject jSONObject2 = null;
            try {
                if (TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(string);
                }
                if (f(jSONObject)) {
                    jSONObject.put(GfhKeyValue.TYPE_DATE, b());
                }
                jSONObject2 = jSONObject.optJSONObject(str);
                if (jSONObject2 == null) {
                    jSONObject.put(str, new JSONObject());
                    de3.a().putString("dailyInfo", jSONObject.toString());
                    return jSONObject2;
                }
            } catch (JSONException e) {
                if (a) {
                    Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
                }
            }
            return jSONObject2;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static long e() {
        InterceptResult invokeV;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject d = d(a());
            if (d != null) {
                j = d.optLong("foreground_aiapp_last_time_local", 0L);
            } else {
                j = 0;
            }
            if (d == null) {
                return 0L;
            }
            return d.optLong("visit_duration", 0L) + (currentTimeMillis - j);
        }
        return invokeV.longValue;
    }

    public static boolean f(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, jSONObject)) == null) {
            String b = b();
            String optString = jSONObject.optString(GfhKeyValue.TYPE_DATE, "");
            if (!TextUtils.isEmpty(optString) && optString.equals(b)) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static void g(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(65543, null, j) == null) {
            i(a(), "foreground_aiapp_last_time_local", Long.valueOf(j));
        }
    }

    public static void i(String str, String str2, Object obj) {
        JSONObject jSONObject;
        String str3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, str, str2, obj) == null) {
            String string = de3.a().getString("dailyInfo", "");
            if (a) {
                if (TextUtils.isEmpty(string)) {
                    str3 = "dailyinfo is null";
                } else {
                    str3 = string;
                }
                Log.i("SwanAppUserVisitInfoUtils", str3);
            }
            try {
                if (TextUtils.isEmpty(string)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(string);
                }
                JSONObject optJSONObject = jSONObject.optJSONObject(str);
                if (optJSONObject != null) {
                    optJSONObject.put(str2, obj);
                } else {
                    jSONObject.put(str, new JSONObject());
                }
                de3.a().putString("dailyInfo", jSONObject.toString());
            } catch (JSONException e) {
                if (a) {
                    Log.e("SwanAppUserVisitInfoUtils", e.getMessage());
                }
            }
        }
    }
}
