package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.BlockPopInfo;
/* loaded from: classes6.dex */
public class hvc extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull BlockPopInfo blockPopInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, blockPopInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "can_post", blockPopInfo.can_post);
            ktc.a(jSONObject, "block_info", blockPopInfo.block_info);
            ktc.a(jSONObject, "ahead_info", blockPopInfo.ahead_info);
            ktc.a(jSONObject, "ahead_url", blockPopInfo.ahead_url);
            ktc.a(jSONObject, "ok_info", blockPopInfo.ok_info);
            ktc.a(jSONObject, "ahead_type", blockPopInfo.ahead_type);
            ktc.a(jSONObject, "appeal_status", blockPopInfo.appeal_status);
            ktc.a(jSONObject, "appeal_msg", blockPopInfo.appeal_msg);
            ktc.a(jSONObject, "sub_block_info", blockPopInfo.sub_block_info);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
