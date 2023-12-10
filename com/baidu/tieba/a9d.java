package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.SubBottomMenu;
/* loaded from: classes5.dex */
public class a9d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull SubBottomMenu subBottomMenu) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, subBottomMenu)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", subBottomMenu.name);
            ltc.a(jSONObject, "url", subBottomMenu.url);
            ltc.a(jSONObject, "type", subBottomMenu.type);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
