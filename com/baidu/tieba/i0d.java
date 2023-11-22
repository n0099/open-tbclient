package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.NewGodInfo;
/* loaded from: classes6.dex */
public class i0d extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull NewGodInfo newGodInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, newGodInfo)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "status", newGodInfo.status);
            qoc.a(jSONObject, "field_id", newGodInfo.field_id);
            qoc.a(jSONObject, "field_name", newGodInfo.field_name);
            qoc.a(jSONObject, "type", newGodInfo.type);
            qoc.a(jSONObject, "type_name", newGodInfo.type_name);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
