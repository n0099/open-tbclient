package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.CustomState;
/* loaded from: classes6.dex */
public class gwc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull CustomState customState) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, customState)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", customState.icon);
            ltc.a(jSONObject, "content", customState.content);
            ltc.a(jSONObject, "icon_type", customState.icon_type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
