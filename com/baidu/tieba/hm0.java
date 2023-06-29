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
/* loaded from: classes6.dex */
public class hm0 {
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
    public fm0 k;

    public hm0() {
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
    public static hm0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = c31.c(str);
            hm0 hm0Var = new hm0();
            hm0Var.a = c.optString("als_ext");
            hm0Var.b = c.optString("cmd");
            hm0Var.c = c.optString("defer_cmd");
            hm0Var.d = c.optString("init_text");
            hm0Var.e = c.optString("opt_icon");
            hm0Var.f = c.optString("opt_text");
            hm0Var.g = c.optString("app_icon_url");
            hm0Var.h = c.optString("app_name");
            hm0Var.i = c.optString("version_code");
            hm0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return hm0Var;
        }
        return (hm0) invokeL.objValue;
    }

    public static String b(@NonNull hm0 hm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, hm0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", hm0Var.a);
                jSONObject.put("cmd", hm0Var.b);
                jSONObject.put("defer_cmd", hm0Var.c);
                jSONObject.put("init_text", hm0Var.d);
                jSONObject.put("opt_icon", hm0Var.e);
                jSONObject.put("opt_text", hm0Var.f);
                jSONObject.put("app_icon_url", hm0Var.g);
                jSONObject.put("app_name", hm0Var.h);
                jSONObject.put("version_code", hm0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, hm0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
