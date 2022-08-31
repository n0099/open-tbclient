package com.baidu.tieba;

import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.McnAdInfo;
/* loaded from: classes3.dex */
public class cq4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static McnAdInfo a(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONObject)) == null) {
            McnAdInfo.Builder builder = new McnAdInfo.Builder();
            if (jSONObject != null) {
                builder.ad_start_time = Long.valueOf(jSONObject.optLong("ad_start_time"));
                builder.ad_end_time = Long.valueOf(jSONObject.optLong("ad_end_time"));
                builder.pic_url = jSONObject.optString("pic_url");
                builder.jump_url = jSONObject.optString(BigdayActivityConfig.JUMP_URL);
                builder.card_title = jSONObject.optString("card_title");
                builder.button_title = jSONObject.optString("button_title");
                builder.effect_time = Long.valueOf(jSONObject.optLong("effect_time"));
                builder.expire_time = Long.valueOf(jSONObject.optLong("expire_time"));
            }
            return builder.build(true);
        }
        return (McnAdInfo) invokeL.objValue;
    }
}
