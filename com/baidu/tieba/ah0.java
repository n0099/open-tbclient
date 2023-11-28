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
/* loaded from: classes5.dex */
public class ah0 {
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
    public yg0 k;
    public String l;
    public WeakReference<Context> m;
    public Long n;
    public String o;
    public boolean p;

    public ah0() {
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
    public static ah0 a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            JSONObject c = my0.c(str);
            ah0 ah0Var = new ah0();
            ah0Var.a = c.optString("als_ext");
            ah0Var.b = c.optString("cmd");
            ah0Var.c = c.optString("defer_cmd");
            ah0Var.d = c.optString("init_text");
            ah0Var.e = c.optString("opt_icon");
            ah0Var.f = c.optString("opt_text");
            ah0Var.g = c.optString("app_icon_url");
            ah0Var.h = c.optString("app_name");
            ah0Var.i = c.optString("version_code");
            ah0Var.j = c.optString(LegoListActivityConfig.AD_ID);
            ah0Var.n = Long.valueOf(c.optLong("schedule_time"));
            ah0Var.o = c.optString("request_url");
            ah0Var.p = c.optBoolean("auto_download");
            return ah0Var;
        }
        return (ah0) invokeL.objValue;
    }

    public static String b(@NonNull ah0 ah0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ah0Var)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("als_ext", ah0Var.a);
                jSONObject.put("cmd", ah0Var.b);
                jSONObject.put("defer_cmd", ah0Var.c);
                jSONObject.put("init_text", ah0Var.d);
                jSONObject.put("opt_icon", ah0Var.e);
                jSONObject.put("opt_text", ah0Var.f);
                jSONObject.put("app_icon_url", ah0Var.g);
                jSONObject.put("app_name", ah0Var.h);
                jSONObject.put("version_code", ah0Var.i);
                jSONObject.put(LegoListActivityConfig.AD_ID, ah0Var.j);
                jSONObject.put("schedule_time", ah0Var.n);
                jSONObject.put("request_url", ah0Var.o);
                jSONObject.put("auto_download", ah0Var.p);
            } catch (JSONException unused) {
            }
            return jSONObject.toString();
        }
        return (String) invokeL.objValue;
    }
}
