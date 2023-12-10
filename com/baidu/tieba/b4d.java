package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemDetail;
/* loaded from: classes5.dex */
public class b4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemDetail itemDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemDetail)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "name", itemDetail.name);
            ltc.a(jSONObject, "value", itemDetail.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
