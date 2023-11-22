package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.ItemPoint;
/* loaded from: classes5.dex */
public class dzc extends qoc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull ItemPoint itemPoint) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, itemPoint)) == null) {
            JSONObject jSONObject = new JSONObject();
            qoc.a(jSONObject, "time_intval", itemPoint.time_intval);
            qoc.a(jSONObject, Config.EVENT_HEAT_POINT, itemPoint.point);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
