package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g4a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public g4a() {
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

    public static g4a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            g4a g4aVar = new g4a();
            jSONObject.optString("brand_name");
            g4aVar.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            g4aVar.b = jSONObject.optString("button_scheme");
            g4aVar.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            g4aVar.d = jSONObject.optString("operate_recommend_reason");
            g4aVar.e = jSONObject.optLong("trans_animation_delay", 0L);
            g4aVar.f = jSONObject.optInt("layout_upgrade", 0);
            return g4aVar;
        }
        return (g4a) invokeL.objValue;
    }
}
