package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes5.dex */
public class f0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MyGroupInfo myGroupInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, myGroupInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "group_id", myGroupInfo.group_id);
            qoc.a(jSONObject, "group_name", myGroupInfo.group_name);
            qoc.a(jSONObject, "portrait", myGroupInfo.portrait);
            qoc.a(jSONObject, "member_num", myGroupInfo.member_num);
            qoc.a(jSONObject, "max_member_num", myGroupInfo.max_member_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
