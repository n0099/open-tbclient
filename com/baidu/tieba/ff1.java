package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class ff1 {
    public static /* synthetic */ Interceptable $ic;
    public static cf1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("process_name", ze1.b());
                jSONObject.put(CrashHianalyticsData.STACK_TRACE, Log.getStackTraceString(exc));
                jSONObject.put("process_info", ze1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        cf1 cf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65537, null, exc) == null) && (cf1Var = a) != null) {
            cf1Var.a(a(exc).toString());
        }
    }

    public static void c(String str) {
        cf1 cf1Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65538, null, str) == null) && (cf1Var = a) != null) {
            cf1Var.a(str);
        }
    }
}
