package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SimpleUser;
/* loaded from: classes6.dex */
public class i3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SimpleUser simpleUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, simpleUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", simpleUser.user_id);
            qoc.a(jSONObject, "user_status", simpleUser.user_status);
            qoc.a(jSONObject, "secureemail", simpleUser.secureemail);
            qoc.a(jSONObject, "securemobil", simpleUser.securemobil);
            qoc.a(jSONObject, "user_name", simpleUser.user_name);
            qoc.a(jSONObject, "user_nickname", simpleUser.user_nickname);
            qoc.a(jSONObject, "incomplete_user", simpleUser.incomplete_user);
            qoc.a(jSONObject, "portrait", simpleUser.portrait);
            qoc.a(jSONObject, "agree_type", simpleUser.agree_type);
            qoc.a(jSONObject, "ahead_url", simpleUser.ahead_url);
            qoc.a(jSONObject, "block_msg", simpleUser.block_msg);
            qoc.a(jSONObject, "show_onlyme", simpleUser.show_onlyme);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
