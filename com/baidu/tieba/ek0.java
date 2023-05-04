package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class ek0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public ck0 k;

    public ek0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @NonNull
    public static ek0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = z01.c(str);
            ek0 ek0Var = new ek0();
            ek0Var.a = c.optString("als_ext");
            ek0Var.b = c.optString("cmd");
            ek0Var.c = c.optString("defer_cmd");
            ek0Var.d = c.optString("init_text");
            ek0Var.e = c.optString("opt_icon");
            ek0Var.f = c.optString("opt_text");
            ek0Var.g = c.optString("app_icon_url");
            ek0Var.h = c.optString("app_name");
            ek0Var.i = c.optString("version_code");
            ek0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return ek0Var;
        }
        return (ek0) invokeL.objValue;
    }

    public static String b(@NonNull ek0 ek0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ek0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ek0Var.a);
                jSONObject.put("cmd", ek0Var.b);
                jSONObject.put("defer_cmd", ek0Var.c);
                jSONObject.put("init_text", ek0Var.d);
                jSONObject.put("opt_icon", ek0Var.e);
                jSONObject.put("opt_text", ek0Var.f);
                jSONObject.put("app_icon_url", ek0Var.g);
                jSONObject.put("app_name", ek0Var.h);
                jSONObject.put("version_code", ek0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ek0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
