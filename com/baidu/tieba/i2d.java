package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.RecomTagInfo;
/* loaded from: classes6.dex */
public class i2d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull RecomTagInfo recomTagInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, recomTagInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "id", recomTagInfo.id);
            qoc.a(jSONObject, "name", recomTagInfo.name);
            qoc.a(jSONObject, "pic", recomTagInfo.pic);
            qoc.a(jSONObject, "first_class", recomTagInfo.first_class);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
