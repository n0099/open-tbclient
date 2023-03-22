package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class fl2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;
    public String g;
    public int h;
    public String i;
    public String j;

    public fl2() {
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
    public static fl2 a(@NonNull qs2 qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, qs2Var)) == null) {
            fl2 fl2Var = new fl2();
            fl2Var.a = qs2Var.H();
            fl2Var.c = qs2Var.K();
            fl2Var.d = qs2Var.Q();
            fl2Var.f = qs2Var.G();
            fl2Var.i = qs2Var.T();
            fl2Var.h = qs2Var.p1();
            fl2Var.e = System.currentTimeMillis();
            fl2Var.g = String.valueOf(qs2Var.getType());
            fl2Var.b = qs2Var.I();
            fl2Var.j = qs2Var.v1();
            return fl2Var;
        }
        return (fl2) invokeL.objValue;
    }

    public static fl2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            fl2 fl2Var = new fl2();
            fl2Var.a = jSONObject.optString("bundle_id");
            fl2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                fl2Var.b = optJSONObject.optString("appkey");
                fl2Var.g = optJSONObject.optString("pkg_type");
                fl2Var.c = optJSONObject.optString("app_name");
                fl2Var.d = optJSONObject.optString("app_icon");
                fl2Var.j = optJSONObject.optString("version_code");
                fl2Var.f = optJSONObject.optInt("frame_type");
                fl2Var.h = optJSONObject.optInt("pay_protected");
            }
            return fl2Var;
        }
        return (fl2) invokeL.objValue;
    }
}
