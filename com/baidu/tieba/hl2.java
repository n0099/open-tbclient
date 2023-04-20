package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class hl2 {
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

    public hl2() {
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
    public static hl2 a(@NonNull ss2 ss2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ss2Var)) == null) {
            hl2 hl2Var = new hl2();
            hl2Var.a = ss2Var.H();
            hl2Var.c = ss2Var.K();
            hl2Var.d = ss2Var.Q();
            hl2Var.f = ss2Var.G();
            hl2Var.i = ss2Var.T();
            hl2Var.h = ss2Var.p1();
            hl2Var.e = System.currentTimeMillis();
            hl2Var.g = String.valueOf(ss2Var.getType());
            hl2Var.b = ss2Var.I();
            hl2Var.j = ss2Var.v1();
            return hl2Var;
        }
        return (hl2) invokeL.objValue;
    }

    public static hl2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            hl2 hl2Var = new hl2();
            hl2Var.a = jSONObject.optString("bundle_id");
            hl2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                hl2Var.b = optJSONObject.optString("appkey");
                hl2Var.g = optJSONObject.optString("pkg_type");
                hl2Var.c = optJSONObject.optString("app_name");
                hl2Var.d = optJSONObject.optString("app_icon");
                hl2Var.j = optJSONObject.optString("version_code");
                hl2Var.f = optJSONObject.optInt("frame_type");
                hl2Var.h = optJSONObject.optInt("pay_protected");
            }
            return hl2Var;
        }
        return (hl2) invokeL.objValue;
    }
}
