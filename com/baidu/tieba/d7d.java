package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.PushType;
/* loaded from: classes5.dex */
public class d7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushType pushType) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushType)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "type", pushType.type);
            ltc.a(jSONObject, "name", pushType.name);
            ltc.a(jSONObject, "icon", pushType.icon);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
