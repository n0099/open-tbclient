package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.FrsPageUserExtend;
import tbclient.User;
/* loaded from: classes5.dex */
public class eyc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull FrsPageUserExtend frsPageUserExtend) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, frsPageUserExtend)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_extend_storey", frsPageUserExtend.user_extend_storey);
            qoc.a(jSONObject, "tips", frsPageUserExtend.tips);
            if (frsPageUserExtend.data != null) {
                JSONArray jSONArray = new JSONArray();
                for (User user : frsPageUserExtend.data) {
                    jSONArray.put(n5d.b(user));
                }
                qoc.a(jSONObject, "data", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
