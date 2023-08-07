package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class il0 {
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
    public gl0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public il0() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1L;
        this.p = false;
    }

    @NonNull
    public static il0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = b31.c(str);
            il0 il0Var = new il0();
            il0Var.a = c.optString("als_ext");
            il0Var.b = c.optString("cmd");
            il0Var.c = c.optString("defer_cmd");
            il0Var.d = c.optString("init_text");
            il0Var.e = c.optString("opt_icon");
            il0Var.f = c.optString("opt_text");
            il0Var.g = c.optString("app_icon_url");
            il0Var.h = c.optString("app_name");
            il0Var.i = c.optString("version_code");
            il0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            il0Var.n = Long.valueOf(c.optLong("schedule_time"));
            il0Var.o = c.optString("request_url");
            il0Var.p = c.optBoolean("auto_download");
            return il0Var;
        }
        return (il0) invokeL.objValue;
    }

    public static String b(@NonNull il0 il0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, il0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", il0Var.a);
                jSONObject.put("cmd", il0Var.b);
                jSONObject.put("defer_cmd", il0Var.c);
                jSONObject.put("init_text", il0Var.d);
                jSONObject.put("opt_icon", il0Var.e);
                jSONObject.put("opt_text", il0Var.f);
                jSONObject.put("app_icon_url", il0Var.g);
                jSONObject.put("app_name", il0Var.h);
                jSONObject.put("version_code", il0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, il0Var.j);
                jSONObject.put("schedule_time", il0Var.n);
                jSONObject.put("request_url", il0Var.o);
                jSONObject.put("auto_download", il0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
