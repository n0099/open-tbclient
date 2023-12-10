package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.PushStatus;
import tbclient.PushType;
/* loaded from: classes5.dex */
public class c7d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull PushStatus pushStatus) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pushStatus)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "status", pushStatus.status);
            if (pushStatus.types != null) {
                JSONArray jSONArray = new JSONArray();
                for (PushType pushType : pushStatus.types) {
                    jSONArray.put(d7d.b(pushType));
                }
                ltc.a(jSONObject, "types", jSONArray);
            }
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
