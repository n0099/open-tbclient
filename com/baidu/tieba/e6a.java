package com.baidu.tieba;

import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e6a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public String d;
    public long e;
    public int f;

    public e6a() {
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

    public static e6a a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            e6a e6aVar = new e6a();
            jSONObject.optString("brand_name");
            e6aVar.a = jSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            e6aVar.b = jSONObject.optString("button_scheme");
            e6aVar.c = jSONObject.optString("cmd_scheme");
            jSONObject.optString("icon");
            e6aVar.d = jSONObject.optString("operate_recommend_reason");
            e6aVar.e = jSONObject.optLong("trans_animation_delay", 0L);
            e6aVar.f = jSONObject.optInt("layout_upgrade", 0);
            return e6aVar;
        }
        return (e6a) invokeL.objValue;
    }
}
