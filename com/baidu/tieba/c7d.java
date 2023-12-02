package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PushType;
/* loaded from: classes5.dex */
public class c7d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushType pushType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushType)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "type", pushType.type);
            ktc.a(jSONObject, "name", pushType.name);
            ktc.a(jSONObject, "icon", pushType.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
