package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.MyGroupInfo;
/* loaded from: classes6.dex */
public class h5d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull MyGroupInfo myGroupInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, myGroupInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "group_id", myGroupInfo.group_id);
            ktc.a(jSONObject, "group_name", myGroupInfo.group_name);
            ktc.a(jSONObject, "portrait", myGroupInfo.portrait);
            ktc.a(jSONObject, "member_num", myGroupInfo.member_num);
            ktc.a(jSONObject, "max_member_num", myGroupInfo.max_member_num);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
