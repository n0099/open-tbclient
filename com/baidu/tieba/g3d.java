package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes6.dex */
public class g3d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsPageUserExtend frsPageUserExtend) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsPageUserExtend)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "user_extend_storey", frsPageUserExtend.user_extend_storey);
            ktc.a(jSONObject, "tips", frsPageUserExtend.tips);
            if (frsPageUserExtend.data != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frsPageUserExtend.data) {
                    jSONArray.put(pad.b(user));
                }
                ktc.a(jSONObject, "data", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
