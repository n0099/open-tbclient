package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemService;
/* loaded from: classes6.dex */
public class h4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemService itemService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemService)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "icon", itemService.icon);
            ltc.a(jSONObject, "client_type", itemService.client_type);
            ltc.a(jSONObject, "type", itemService.type);
            ltc.a(jSONObject, "name", itemService.name);
            ltc.a(jSONObject, "url", itemService.url);
            ltc.a(jSONObject, "app_id", itemService.app_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
