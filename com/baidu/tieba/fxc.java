package com.baidu.tieba;

import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import org.json.JSONObject;
import tbclient.FrsPage.StarSchedule;
/* loaded from: classes6.dex */
public class fxc extends poc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @NonNull
    public static JSONObject b(@NonNull StarSchedule starSchedule) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, starSchedule)) == null) {
            JSONObject jSONObject = new JSONObject();
            poc.a(jSONObject, "time", starSchedule.time);
            poc.a(jSONObject, "type", starSchedule.type);
            poc.a(jSONObject, "desc", starSchedule.desc);
            poc.a(jSONObject, "url", starSchedule.url);
            return jSONObject;
        }
        return (JSONObject) invokeL.objValue;
    }
}
