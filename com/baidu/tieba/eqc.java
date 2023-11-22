package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.Balv;
/* loaded from: classes5.dex */
public class eqc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull Balv balv) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, balv)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "is_black", balv.is_black);
            qoc.a(jSONObject, "is_block", balv.is_block);
            qoc.a(jSONObject, "days_tofree", balv.days_tofree);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
