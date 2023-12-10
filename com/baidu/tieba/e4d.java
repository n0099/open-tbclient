package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemOptions;
/* loaded from: classes5.dex */
public class e4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemOptions itemOptions) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemOptions)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "key", itemOptions.key);
            ltc.a(jSONObject, "value", itemOptions.value);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
