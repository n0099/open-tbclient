package com.baidu.tieba;

import android.util.Log;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ht2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Integer num, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, num, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PollingModel.LEVEL, String.valueOf(num));
            hashMap.put("percentage", str + "%");
            zo2.U().u(new nd2("text-size-adjust", hashMap));
            wu1.d(num.intValue());
        }
    }

    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            sd2 sd2Var = new sd2();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "text-size-adjust");
                jSONObject.put("percentage", str3 + "%");
                jSONObject.put(PollingModel.LEVEL, str2);
            } catch (JSONException e) {
                ez2.b(Log.getStackTraceString(e));
            }
            sd2Var.c = jSONObject;
            zo2.U().m(str, sd2Var);
        }
    }
}
