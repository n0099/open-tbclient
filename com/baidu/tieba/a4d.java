package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.IconUrlInfo;
/* loaded from: classes5.dex */
public class a4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull IconUrlInfo iconUrlInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iconUrlInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "day", iconUrlInfo.day);
            ltc.a(jSONObject, "night", iconUrlInfo.night);
            ltc.a(jSONObject, "dark", iconUrlInfo.dark);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
