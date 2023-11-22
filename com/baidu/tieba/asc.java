package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.EsportUser;
/* loaded from: classes5.dex */
public class asc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull EsportUser esportUser) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, esportUser)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "steam_name", esportUser.steam_name);
            qoc.a(jSONObject, "steam_portrait", esportUser.steam_portrait);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
