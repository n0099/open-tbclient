package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarSchedule;
/* loaded from: classes6.dex */
public class h2d extends ltc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarSchedule starSchedule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starSchedule)) == null) {
            JSONObject jSONObject = new JSONObject();
            ltc.a(jSONObject, "time", starSchedule.time);
            ltc.a(jSONObject, "type", starSchedule.type);
            ltc.a(jSONObject, "desc", starSchedule.desc);
            ltc.a(jSONObject, "url", starSchedule.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
