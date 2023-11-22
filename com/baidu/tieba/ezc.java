package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemService;
/* loaded from: classes5.dex */
public class ezc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemService itemService) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemService)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "icon", itemService.icon);
            qoc.a(jSONObject, "client_type", itemService.client_type);
            qoc.a(jSONObject, "type", itemService.type);
            qoc.a(jSONObject, "name", itemService.name);
            qoc.a(jSONObject, "url", itemService.url);
            qoc.a(jSONObject, "app_id", itemService.app_id);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
