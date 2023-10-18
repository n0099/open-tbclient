package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class bj2 {
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

    public bj2() {
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
    public static bj2 a(@NonNull mq2 mq2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, mq2Var)) == null) {
            bj2 bj2Var = new bj2();
            bj2Var.a = mq2Var.I();
            bj2Var.c = mq2Var.L();
            bj2Var.d = mq2Var.R();
            bj2Var.f = mq2Var.H();
            bj2Var.i = mq2Var.U();
            bj2Var.h = mq2Var.q1();
            bj2Var.e = System.currentTimeMillis();
            bj2Var.g = String.valueOf(mq2Var.w1());
            bj2Var.b = mq2Var.J();
            bj2Var.j = mq2Var.x1();
            return bj2Var;
        }
        return (bj2) invokeL.objValue;
    }

    public static bj2 b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            bj2 bj2Var = new bj2();
            bj2Var.a = jSONObject.optString("bundle_id");
            bj2Var.e = jSONObject.optLong("time");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                bj2Var.b = optJSONObject.optString("appkey");
                bj2Var.g = optJSONObject.optString("pkg_type");
                bj2Var.c = optJSONObject.optString("app_name");
                bj2Var.d = optJSONObject.optString("app_icon");
                bj2Var.j = optJSONObject.optString("version_code");
                bj2Var.f = optJSONObject.optInt("frame_type");
                bj2Var.h = optJSONObject.optInt("pay_protected");
            }
            return bj2Var;
        }
        return (bj2) invokeL.objValue;
    }
}
