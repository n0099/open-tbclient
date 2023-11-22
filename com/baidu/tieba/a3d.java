package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ShortUserInfo;
/* loaded from: classes5.dex */
public class a3d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShortUserInfo shortUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, shortUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "user_id", shortUserInfo.user_id);
            qoc.a(jSONObject, "portrait", shortUserInfo.portrait);
            qoc.a(jSONObject, "user_name", shortUserInfo.user_name);
            qoc.a(jSONObject, "gender", shortUserInfo.gender);
            qoc.a(jSONObject, "intro", shortUserInfo.intro);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
