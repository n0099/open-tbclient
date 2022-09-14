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
/* loaded from: classes3.dex */
public class ck0 {
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
    public ak0 k;

    public ck0() {
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
    public static ck0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = kz0.c(str);
            ck0 ck0Var = new ck0();
            ck0Var.a = c.optString("als_ext");
            ck0Var.b = c.optString("cmd");
            ck0Var.c = c.optString("defer_cmd");
            ck0Var.d = c.optString("init_text");
            ck0Var.e = c.optString("opt_icon");
            ck0Var.f = c.optString("opt_text");
            ck0Var.g = c.optString("app_icon_url");
            ck0Var.h = c.optString("app_name");
            ck0Var.i = c.optString("version_code");
            ck0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return ck0Var;
        }
        return (ck0) invokeL.objValue;
    }

    public static String b(@NonNull ck0 ck0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ck0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ck0Var.a);
                jSONObject.put("cmd", ck0Var.b);
                jSONObject.put("defer_cmd", ck0Var.c);
                jSONObject.put("init_text", ck0Var.d);
                jSONObject.put("opt_icon", ck0Var.e);
                jSONObject.put("opt_text", ck0Var.f);
                jSONObject.put("app_icon_url", ck0Var.g);
                jSONObject.put("app_name", ck0Var.h);
                jSONObject.put("version_code", ck0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ck0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
