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
/* loaded from: classes5.dex */
public class em0 {
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
    public cm0 k;

    public em0() {
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
    public static em0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = z21.c(str);
            em0 em0Var = new em0();
            em0Var.a = c.optString("als_ext");
            em0Var.b = c.optString("cmd");
            em0Var.c = c.optString("defer_cmd");
            em0Var.d = c.optString("init_text");
            em0Var.e = c.optString("opt_icon");
            em0Var.f = c.optString("opt_text");
            em0Var.g = c.optString("app_icon_url");
            em0Var.h = c.optString("app_name");
            em0Var.i = c.optString("version_code");
            em0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return em0Var;
        }
        return (em0) invokeL.objValue;
    }

    public static String b(@NonNull em0 em0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, em0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", em0Var.a);
                jSONObject.put("cmd", em0Var.b);
                jSONObject.put("defer_cmd", em0Var.c);
                jSONObject.put("init_text", em0Var.d);
                jSONObject.put("opt_icon", em0Var.e);
                jSONObject.put("opt_text", em0Var.f);
                jSONObject.put("app_icon_url", em0Var.g);
                jSONObject.put("app_name", em0Var.h);
                jSONObject.put("version_code", em0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, em0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
