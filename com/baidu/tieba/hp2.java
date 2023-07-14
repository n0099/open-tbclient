package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class hp2 {
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

    public hp2() {
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
    public static hp2 a(@NonNull sw2 sw2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, sw2Var)) == null) {
            hp2 hp2Var = new hp2();
            hp2Var.a = sw2Var.H();
            hp2Var.c = sw2Var.K();
            hp2Var.d = sw2Var.Q();
            hp2Var.f = sw2Var.G();
            hp2Var.i = sw2Var.T();
            hp2Var.h = sw2Var.p1();
            hp2Var.e = System.currentTimeMillis();
            hp2Var.g = String.valueOf(sw2Var.getType());
            hp2Var.b = sw2Var.I();
            hp2Var.j = sw2Var.v1();
            return hp2Var;
        }
        return (hp2) invokeL.objValue;
    }

    public static hp2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            hp2 hp2Var = new hp2();
            hp2Var.a = jSONObject.optString("bundle_id");
            hp2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                hp2Var.b = optJSONObject.optString("appkey");
                hp2Var.g = optJSONObject.optString("pkg_type");
                hp2Var.c = optJSONObject.optString("app_name");
                hp2Var.d = optJSONObject.optString("app_icon");
                hp2Var.j = optJSONObject.optString("version_code");
                hp2Var.f = optJSONObject.optInt("frame_type");
                hp2Var.h = optJSONObject.optInt("pay_protected");
            }
            return hp2Var;
        }
        return (hp2) invokeL.objValue;
    }
}
