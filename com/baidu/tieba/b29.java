package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public b29() {
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

    public static b29 a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            b29 b29Var = new b29();
            jSONObject.optString("brand_name");
            b29Var.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            b29Var.b = jSONObject.optString("button_scheme");
            b29Var.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            b29Var.d = jSONObject.optString("operate_recommend_reason");
            b29Var.e = jSONObject.optLong("trans_animation_delay", 0L);
            b29Var.f = jSONObject.optInt("layout_upgrade", 0);
            return b29Var;
        }
        return (b29) invokeL.objValue;
    }
}
