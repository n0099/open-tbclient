package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemService;
/* loaded from: classes6.dex */
public class g4d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemService itemService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemService)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "icon", itemService.icon);
            ktc.a(jSONObject, "client_type", itemService.client_type);
            ktc.a(jSONObject, "type", itemService.type);
            ktc.a(jSONObject, "name", itemService.name);
            ktc.a(jSONObject, "url", itemService.url);
            ktc.a(jSONObject, "app_id", itemService.app_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
