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
public class dm0 {
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
    public bm0 k;

    public dm0() {
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
    public static dm0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = y21.c(str);
            dm0 dm0Var = new dm0();
            dm0Var.a = c.optString("als_ext");
            dm0Var.b = c.optString("cmd");
            dm0Var.c = c.optString("defer_cmd");
            dm0Var.d = c.optString("init_text");
            dm0Var.e = c.optString("opt_icon");
            dm0Var.f = c.optString("opt_text");
            dm0Var.g = c.optString("app_icon_url");
            dm0Var.h = c.optString("app_name");
            dm0Var.i = c.optString("version_code");
            dm0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return dm0Var;
        }
        return (dm0) invokeL.objValue;
    }

    public static String b(@NonNull dm0 dm0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, dm0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", dm0Var.a);
                jSONObject.put("cmd", dm0Var.b);
                jSONObject.put("defer_cmd", dm0Var.c);
                jSONObject.put("init_text", dm0Var.d);
                jSONObject.put("opt_icon", dm0Var.e);
                jSONObject.put("opt_text", dm0Var.f);
                jSONObject.put("app_icon_url", dm0Var.g);
                jSONObject.put("app_name", dm0Var.h);
                jSONObject.put("version_code", dm0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, dm0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
