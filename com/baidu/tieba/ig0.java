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
public class ig0 {
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
    public gg0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public ig0() {
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
    public static ig0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = ux0.c(str);
            ig0 ig0Var = new ig0();
            ig0Var.a = c.optString("als_ext");
            ig0Var.b = c.optString("cmd");
            ig0Var.c = c.optString("defer_cmd");
            ig0Var.d = c.optString("init_text");
            ig0Var.e = c.optString("opt_icon");
            ig0Var.f = c.optString("opt_text");
            ig0Var.g = c.optString("app_icon_url");
            ig0Var.h = c.optString("app_name");
            ig0Var.i = c.optString("version_code");
            ig0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            ig0Var.n = Long.valueOf(c.optLong("schedule_time"));
            ig0Var.o = c.optString("request_url");
            ig0Var.p = c.optBoolean("auto_download");
            return ig0Var;
        }
        return (ig0) invokeL.objValue;
    }

    public static String b(@NonNull ig0 ig0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ig0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ig0Var.a);
                jSONObject.put("cmd", ig0Var.b);
                jSONObject.put("defer_cmd", ig0Var.c);
                jSONObject.put("init_text", ig0Var.d);
                jSONObject.put("opt_icon", ig0Var.e);
                jSONObject.put("opt_text", ig0Var.f);
                jSONObject.put("app_icon_url", ig0Var.g);
                jSONObject.put("app_name", ig0Var.h);
                jSONObject.put("version_code", ig0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ig0Var.j);
                jSONObject.put("schedule_time", ig0Var.n);
                jSONObject.put("request_url", ig0Var.o);
                jSONObject.put("auto_download", ig0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
