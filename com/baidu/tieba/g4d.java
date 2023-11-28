package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemPoint;
/* loaded from: classes6.dex */
public class g4d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemPoint itemPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemPoint)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "time_intval", itemPoint.time_intval);
            ltc.a(jSONObject, Config.EVENT_HEAT_POINT, itemPoint.point);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
