package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Balv;
/* loaded from: classes5.dex */
public class bvc extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Balv balv) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, balv)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "is_black", balv.is_black);
            ltc.a(jSONObject, "is_block", balv.is_block);
            ltc.a(jSONObject, "days_tofree", balv.days_tofree);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
