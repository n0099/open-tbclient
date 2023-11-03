package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RecomTagInfo;
/* loaded from: classes6.dex */
public class h2d extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTagInfo recomTagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "id", recomTagInfo.id);
            poc.a(jSONObject, "name", recomTagInfo.name);
            poc.a(jSONObject, "pic", recomTagInfo.pic);
            poc.a(jSONObject, "first_class", recomTagInfo.first_class);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
