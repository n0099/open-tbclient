package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class h3d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleUser simpleUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "user_id", simpleUser.user_id);
            poc.a(jSONObject, "user_status", simpleUser.user_status);
            poc.a(jSONObject, "secureemail", simpleUser.secureemail);
            poc.a(jSONObject, "securemobil", simpleUser.securemobil);
            poc.a(jSONObject, "user_name", simpleUser.user_name);
            poc.a(jSONObject, "user_nickname", simpleUser.user_nickname);
            poc.a(jSONObject, "incomplete_user", simpleUser.incomplete_user);
            poc.a(jSONObject, "portrait", simpleUser.portrait);
            poc.a(jSONObject, "agree_type", simpleUser.agree_type);
            poc.a(jSONObject, "ahead_url", simpleUser.ahead_url);
            poc.a(jSONObject, "block_msg", simpleUser.block_msg);
            poc.a(jSONObject, "show_onlyme", simpleUser.show_onlyme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
