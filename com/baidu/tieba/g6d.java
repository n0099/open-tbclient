package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.VoteSchema;
/* loaded from: classes6.dex */
public class g6d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull VoteSchema voteSchema) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, voteSchema)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "text_before_vote", voteSchema.text_before_vote);
            poc.a(jSONObject, "text_after_vote", voteSchema.text_after_vote);
            poc.a(jSONObject, BigdayActivityConfig.JUMP_URL, voteSchema.jump_url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
