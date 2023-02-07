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
public class gl0 {
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
    public el0 k;

    public gl0() {
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
    public static gl0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = y11.c(str);
            gl0 gl0Var = new gl0();
            gl0Var.a = c.optString("als_ext");
            gl0Var.b = c.optString("cmd");
            gl0Var.c = c.optString("defer_cmd");
            gl0Var.d = c.optString("init_text");
            gl0Var.e = c.optString("opt_icon");
            gl0Var.f = c.optString("opt_text");
            gl0Var.g = c.optString("app_icon_url");
            gl0Var.h = c.optString("app_name");
            gl0Var.i = c.optString("version_code");
            gl0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return gl0Var;
        }
        return (gl0) invokeL.objValue;
    }

    public static String b(@NonNull gl0 gl0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gl0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", gl0Var.a);
                jSONObject.put("cmd", gl0Var.b);
                jSONObject.put("defer_cmd", gl0Var.c);
                jSONObject.put("init_text", gl0Var.d);
                jSONObject.put("opt_icon", gl0Var.e);
                jSONObject.put("opt_text", gl0Var.f);
                jSONObject.put("app_icon_url", gl0Var.g);
                jSONObject.put("app_name", gl0Var.h);
                jSONObject.put("version_code", gl0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, gl0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
