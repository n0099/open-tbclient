package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarSchedule;
/* loaded from: classes6.dex */
public class g2d extends ktc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarSchedule starSchedule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starSchedule)) == null) {
            JSONObject jSONObject = new JSONObject();
            ktc.a(jSONObject, "time", starSchedule.time);
            ktc.a(jSONObject, "type", starSchedule.type);
            ktc.a(jSONObject, "desc", starSchedule.desc);
            ktc.a(jSONObject, "url", starSchedule.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
