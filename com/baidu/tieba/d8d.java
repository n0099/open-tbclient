package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ShortUserInfo;
/* loaded from: classes5.dex */
public class d8d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ShortUserInfo shortUserInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, shortUserInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "user_id", shortUserInfo.user_id);
            ltc.a(jSONObject, "portrait", shortUserInfo.portrait);
            ltc.a(jSONObject, "user_name", shortUserInfo.user_name);
            ltc.a(jSONObject, "gender", shortUserInfo.gender);
            ltc.a(jSONObject, "intro", shortUserInfo.intro);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
