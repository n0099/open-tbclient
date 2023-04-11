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
public class bk0 {
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
    public zj0 k;

    public bk0() {
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
    public static bk0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = w01.c(str);
            bk0 bk0Var = new bk0();
            bk0Var.a = c.optString("als_ext");
            bk0Var.b = c.optString("cmd");
            bk0Var.c = c.optString("defer_cmd");
            bk0Var.d = c.optString("init_text");
            bk0Var.e = c.optString("opt_icon");
            bk0Var.f = c.optString("opt_text");
            bk0Var.g = c.optString("app_icon_url");
            bk0Var.h = c.optString("app_name");
            bk0Var.i = c.optString("version_code");
            bk0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            return bk0Var;
        }
        return (bk0) invokeL.objValue;
    }

    public static String b(@NonNull bk0 bk0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bk0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", bk0Var.a);
                jSONObject.put("cmd", bk0Var.b);
                jSONObject.put("defer_cmd", bk0Var.c);
                jSONObject.put("init_text", bk0Var.d);
                jSONObject.put("opt_icon", bk0Var.e);
                jSONObject.put("opt_text", bk0Var.f);
                jSONObject.put("app_icon_url", bk0Var.g);
                jSONObject.put("app_name", bk0Var.h);
                jSONObject.put("version_code", bk0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, bk0Var.j);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
