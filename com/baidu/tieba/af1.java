package com.baidu.tieba;

import android.util.Log;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.provider.ContentProviderManager;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class af1 {
    public static /* synthetic */ Interceptable $ic;
    public static xe1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static JSONObject a(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, exc)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContentProviderManager.PLUGIN_PROCESS_NAME, ue1.b());
                jSONObject.put("stack_trace", Log.getStackTraceString(exc));
                jSONObject.put("process_info", ue1.a());
                jSONObject.put("report_time", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }

    public static void b(Exception exc) {
        xe1 xe1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65537, null, exc) == null) || (xe1Var = a) == null) {
            return;
        }
        xe1Var.a(a(exc).toString());
    }

    public static void c(String str) {
        xe1 xe1Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65538, null, str) == null) || (xe1Var = a) == null) {
            return;
        }
        xe1Var.a(str);
    }
}
