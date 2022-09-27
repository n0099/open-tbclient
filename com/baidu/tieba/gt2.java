package com.baidu.tieba;

import android.util.Log;
import com.baidu.tbadk.core.leveiconlivepolling.PollingModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gt2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Integer num, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, num, str) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(PollingModel.LEVEL, String.valueOf(num));
            hashMap.put("percentage", str + "%");
            yo2.U().u(new md2("text-size-adjust", hashMap));
            vu1.d(num.intValue());
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [org.json.JSONObject, T] */
    public static void b(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65537, null, str, str2, str3) == null) {
            rd2 rd2Var = new rd2();
            ?? jSONObject = new JSONObject();
            try {
                jSONObject.put("type", "text-size-adjust");
                jSONObject.put("percentage", str3 + "%");
                jSONObject.put(PollingModel.LEVEL, str2);
            } catch (JSONException e) {
                dz2.b(Log.getStackTraceString(e));
            }
            rd2Var.c = jSONObject;
            yo2.U().m(str, rd2Var);
        }
    }
}
