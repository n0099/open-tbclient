package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.AwardUser;
/* loaded from: classes5.dex */
public class bqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull AwardUser awardUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, awardUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", awardUser.user_id);
            qoc.a(jSONObject, "user_name", awardUser.user_name);
            qoc.a(jSONObject, "award_name", awardUser.award_name);
            qoc.a(jSONObject, "award_time", awardUser.award_time);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
