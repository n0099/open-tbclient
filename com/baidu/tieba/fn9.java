package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fn9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public fn9() {
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

    public static fn9 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            fn9 fn9Var = new fn9();
            jSONObject.optString("brand_name");
            fn9Var.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            fn9Var.b = jSONObject.optString("button_scheme");
            fn9Var.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            fn9Var.d = jSONObject.optString("operate_recommend_reason");
            fn9Var.e = jSONObject.optLong("trans_animation_delay", 0L);
            fn9Var.f = jSONObject.optInt("layout_upgrade", 0);
            return fn9Var;
        }
        return (fn9) invokeL.objValue;
    }
}
