package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class gl2 {
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

    public gl2() {
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
    public static gl2 a(@NonNull rs2 rs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, rs2Var)) == null) {
            gl2 gl2Var = new gl2();
            gl2Var.a = rs2Var.H();
            gl2Var.c = rs2Var.K();
            gl2Var.d = rs2Var.Q();
            gl2Var.f = rs2Var.G();
            gl2Var.i = rs2Var.T();
            gl2Var.h = rs2Var.p1();
            gl2Var.e = System.currentTimeMillis();
            gl2Var.g = String.valueOf(rs2Var.getType());
            gl2Var.b = rs2Var.I();
            gl2Var.j = rs2Var.v1();
            return gl2Var;
        }
        return (gl2) invokeL.objValue;
    }

    public static gl2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            gl2 gl2Var = new gl2();
            gl2Var.a = jSONObject.optString("bundle_id");
            gl2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                gl2Var.b = optJSONObject.optString("appkey");
                gl2Var.g = optJSONObject.optString("pkg_type");
                gl2Var.c = optJSONObject.optString("app_name");
                gl2Var.d = optJSONObject.optString("app_icon");
                gl2Var.j = optJSONObject.optString("version_code");
                gl2Var.f = optJSONObject.optInt("frame_type");
                gl2Var.h = optJSONObject.optInt("pay_protected");
            }
            return gl2Var;
        }
        return (gl2) invokeL.objValue;
    }
}
