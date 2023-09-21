package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class fh6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public fh6() {
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

    public void a(JSONObject jSONObject) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, jSONObject) != null) || jSONObject == null) {
            return;
        }
        jSONObject.optString("user_id");
        jSONObject.optString("user_name");
        jSONObject.optString("sex");
        jSONObject.optString("description");
        jSONObject.optString("portrait");
        jSONObject.optString("level_id");
        jSONObject.optString("location");
        jSONObject.optString(DI.FOLLOW_STATUS);
        jSONObject.optString("follow_count");
        jSONObject.optString("fans_count");
        jSONObject.optString("live_count");
        jSONObject.optString("record_count");
        jSONObject.optInt("yy_level_id");
        jSONObject.optLong("yy_levelup_exp");
        jSONObject.optLong("yy_level_exp");
        jSONObject.optString("yy_level_name");
        jSONObject.optString("yy_level_next_name");
    }
}
