package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemService;
/* loaded from: classes5.dex */
public class dzc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemService itemService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemService)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "icon", itemService.icon);
            poc.a(jSONObject, "client_type", itemService.client_type);
            poc.a(jSONObject, "type", itemService.type);
            poc.a(jSONObject, "name", itemService.name);
            poc.a(jSONObject, "url", itemService.url);
            poc.a(jSONObject, "app_id", itemService.app_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
